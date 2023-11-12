package com.jobfinder.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class LocationUtil {
	public Map<String, String> getLocation() {
		Map<String, String> result = new HashMap<>();
		
        try {
        	HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://provinces.open-api.vn/api/");

            HttpResponse httpResponse = httpClient.execute(httpGet);

            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                String jsonData = EntityUtils.toString(httpResponse.getEntity());
                
                Gson gson = new Gson();
                JsonArray jsonArray = gson.fromJson(jsonData, JsonArray.class);

                for (JsonElement jsonElement : jsonArray) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    result.put(jsonObject.get("codename").getAsString(), jsonObject.get("name").getAsString());
                }
            } else {
                System.out.println("Error: " + httpResponse.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}
}
