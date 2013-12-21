package ru.dmitriymx.yaml;

import java.util.Map;

/**
 * This is a {@link ru.dmitriymx.yaml.Configuration} implementation that does not save or load
 * from any source, and stores all values in memory only.
 * This is useful for temporary Configurations for providing defaults.
 */
public class MemoryConfiguration extends MemorySection implements Configuration {
    protected Configuration defaults;
    protected MemoryConfigurationOptions options;

    /**
     * Creates an empty {@link ru.dmitriymx.yaml.MemoryConfiguration} with no default values.
     */
    public MemoryConfiguration() {}
    
    /**
     * Creates an empty {@link ru.dmitriymx.yaml.MemoryConfiguration} using the specified {@link ru.dmitriymx.yaml.Configuration}
     * as a source for all default values.
     *
     * @param defaults Default value provider
     * @throws IllegalArgumentException Thrown if defaults is null
     */
    public MemoryConfiguration(Configuration defaults) {
        this.defaults = defaults;
    }
    
    @Override
    public void addDefault(String path, Object value) {
        Validate.notNull(path, "Path may not be null");

        if (defaults == null) {
            defaults = new MemoryConfiguration();
        }

        defaults.set(path, value);
    }
    
	@Override
	public void addDefaults(Map<String, Object> defaults) {
        Validate.notNull(defaults, "Defaults may not be null");

        for (Map.Entry<String, Object> entry : defaults.entrySet()) {
            addDefault(entry.getKey(), entry.getValue());
        }
	}

	@Override
	public void addDefaults(Configuration defaults) {
        Validate.notNull(defaults, "Defaults may not be null");

        addDefaults(defaults.getValues(true));
	}

	@Override
	public void setDefaults(Configuration defaults) {
		Validate.notNull(defaults, "Defaults may not be null");

        this.defaults = defaults;
	}

	@Override
	public Configuration getDefaults() {
		return defaults;
	}
	
	@Override
    public ConfigurationSection getParent() {
        return null;
    }

	@Override
	public ConfigurationOptions options() {
		if (options == null) {
            options = new MemoryConfigurationOptions(this);
        }

        return options;
	}

}
