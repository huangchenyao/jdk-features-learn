package com.abc.jdk11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http2Client {
    public static void main(String[] args) {
        var uri = URI.create("http://www.baidu.com");
        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder().uri(uri).build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException ignore) {
        }
    }
}
