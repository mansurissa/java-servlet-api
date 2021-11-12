package com.issa;

import java.util.LinkedHashMap;
import java.util.Map;

public class VolatileDB {

	static Map<String, User> db = new LinkedHashMap<String, User>();

	public static void insert(String id, User row) {

		db.put(id, row);
	}

	public static User fetch(String id) {

		return db.get(id);

	}

}
