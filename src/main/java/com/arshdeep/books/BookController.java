package com.arshdeep.books;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class BookController {

    @GetMapping("/")
    public String home() throws Exception {

        var apiKey = System.getenv("GEMINI_API_KEY");

        var body = """
        {
          "contents": [{
            "parts": [{
              "text": "Recommend a book on AI and coding in 100 words"
            }]
          }]
        }
        """;

        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=" + apiKey))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        var json = response.body();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);

        String text = root
                .path("candidates")
                .get(0)
                .path("content")
                .path("parts")
                .get(0)
                .path("text")
                .asText();

        return text;
    }
}