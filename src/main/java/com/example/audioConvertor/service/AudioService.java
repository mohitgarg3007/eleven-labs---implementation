package com.example.audioConvertor.service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest; // ✅ Add this
import java.net.http.HttpResponse;

@Service
public class AudioService {
    private static final String API_URL = "https://api.elevenlabs.io/v1/text-to-speech/21m00Tcm4TlvDq8ikWAM";
    private static final String API_KEY = "sk_9fb49305b4b6bd9fc367a0baa7614aeaef8ef4ff7fa4b9f1";

    public byte[] convertTextToSpeech(String text) {
        try {

            HttpClient client = HttpClient.newHttpClient();
            String json = """
                {
                  "text": "%s",
                  "model_id": "eleven_monolingual_v1",
                  "voice_settings": {
                    "stability": 0.5,
                    "similarity_boost": 0.5
                  }
                }
                """.formatted(text);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .header("xi-api-key", API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert text to speech", e);
        }
    }

}
