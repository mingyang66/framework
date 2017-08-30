package controllers;

import java.io.FileWriter;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyGson {
	public static void main(String[] args) throws Exception {
		 Writer writer = new FileWriter("D:\\a.json");
		
		 Gson gson = new GsonBuilder().create();
		 gson.toJson("asdf", writer);
		 gson.toJson(123, writer);
		 
		 writer.close();
	}
}
