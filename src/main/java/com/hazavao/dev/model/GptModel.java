package com.hazavao.dev.model;

import lombok.Getter;
import lombok.SneakyThrows;
import okhttp3.*;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Getter
public class GptModel {
    private final String prompt = "Tu es un pure malgache, explique moi ce mot en malgache";
    private final String API_URL = "https://api.openai.com/v1/chat/completions";


    @SneakyThrows
    public String hazavao(String teny) {
        OkHttpClient client = new OkHttpClient();

        String apiKey = System.getenv("API_KEY");

        MediaType mediaType = MediaType.parse("application/json");
        List<String> messages = new ArrayList<>();
        messages.add(this.prompt);

        JSONObject data = new JSONObject();
        data.put("model", "gpt-3.5-turbo");
        data.put("messages", messages);


        RequestBody body = RequestBody.create(mediaType, data.toString());

        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        System.out.println(responseBody);
        return responseBody;
    }
}
