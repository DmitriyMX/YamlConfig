package ru.dmitriymx.yaml;

public class Convert {

	public static int toInt(Object object) {
		if (object instanceof Number) {
			return ((Number) object).intValue();
		}

		try {
			return Integer.valueOf(object.toString());
		} catch (NumberFormatException e) {
		} catch (NullPointerException e) {
		}
		return 0;
	}

	public static float toFloat(Object object) {
		if (object instanceof Number) {
			return ((Number) object).floatValue();
		}

		try {
			return Float.valueOf(object.toString());
		} catch (NumberFormatException e) {
		} catch (NullPointerException e) {
		}
		return 0;
	}

	public static double toDouble(Object object) {
		if (object instanceof Number) {
			return ((Number) object).doubleValue();
		}

		try {
			return Double.valueOf(object.toString());
		} catch (NumberFormatException e) {
		} catch (NullPointerException e) {
		}
		return 0;
	}

	public static long toLong(Object object) {
		if (object instanceof Number) {
			return ((Number) object).longValue();
		}

		try {
			return Long.valueOf(object.toString());
		} catch (NumberFormatException e) {
		} catch (NullPointerException e) {
		}
		return 0;
	}

	public static short toShort(Object object) {
		if (object instanceof Number) {
			return ((Number) object).shortValue();
		}

		try {
			return Short.valueOf(object.toString());
		} catch (NumberFormatException e) {
		} catch (NullPointerException e) {
		}
		return 0;
	}

	public static byte toByte(Object object) {
		if (object instanceof Number) {
			return ((Number) object).byteValue();
		}

		try {
			return Byte.valueOf(object.toString());
		} catch (NumberFormatException e) {
		} catch (NullPointerException e) {
		}
		return 0;
	}

	/**
	 * <p>Convert path to array implement.</p>
	 * <p>{@code /path/to/file/123.txt -> [/path, /to, /file, /123.txt]}</p>
	 * @param path
	 * @return
	 */
	public static String[] toPathArray(String path) {
		// /123.txt
		// /path/to/file/
		// /path/to/file/123.txt

		int arrSize = 0;
		int i = -1;
		while ((i = path.indexOf("/", i+1)) != -1) {
			arrSize++;
		}

		String[] result = new String[arrSize];

		int j = -1;
		for (int f = 0; f < arrSize; f++) {
			j = path.indexOf("/", j+1);
			int l = path.indexOf("/", j + 1);
			if (l == -1) {
				l = path.length();
			}
			
			result[f] = path.substring(j, l);
		}

		return result;
	}
}
