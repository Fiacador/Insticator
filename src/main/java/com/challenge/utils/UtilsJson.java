package com.challenge.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UtilsJson {
	
	public static String create(Object obj) {
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(obj);
	}

}
