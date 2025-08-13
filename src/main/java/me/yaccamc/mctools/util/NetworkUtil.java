package me.yaccamc.mctools.util;

import me.yaccamc.mctools.api.Catcher;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class NetworkUtil {
    public static String requestFile(String urlStr, Catcher catcher) {
        try(HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStr))
                    .build();

            HttpResponse<byte[]> response = client.send(
                    request, HttpResponse.BodyHandlers.ofByteArray());

            return new String(response.body(), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            throw catcher.catches(ex);
        }
    }
}
