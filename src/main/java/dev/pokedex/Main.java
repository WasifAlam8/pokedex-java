package dev.pokedex;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String [] args) throws Exception {
        // Initialize client
        HttpClient client = HttpClient.newHttpClient();
        // Make a request to PokeAPI
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://pokeapi.co/api/v2/pokemon/pikachu")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode()); // Return status code of the request, 200 if ok and 404 if not found
        System.out.println(response.body().substring(0,300)); // First 300 characters of Pikachu's info
    }
}
