package com.hazavao.dev.model;

import lombok.Getter;
import lombok.SneakyThrows;
import okhttp3.*;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Getter
public class GptModel {
    private final String prompt = "Tu es un pure malgache, explique moi ce mot en malgache";
    private final String API_URL = "https://api.openai.com/v1/completions";


    @SneakyThrows
    public String hazavao(String teny) {
        OkHttpClient client = new OkHttpClient();

        String prompt = "My name is";
        String api_key = System.getenv("API_KEY");

        HttpURLConnection con = (HttpURLConnection) new URL(this.API_URL).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + api_key);

        JSONObject data = new JSONObject();
        data.put("model", "gpt-3.5-turbo");


        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();

        String res = new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");

        return res;
    }
}
