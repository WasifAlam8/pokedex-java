package dev.pokedex;

import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String [] args) throws Exception {
        // Now uses PokeAPIClient to get info
        PokeApiClient api = new PokeApiClient();
        JsonObject pikachu = api.get(PokeApiClient.BASE + "pokemon/pikachu");

        // Prints pokemon number from the id value in the JSON object
        // Uses .getAsInt to get the value as int
        System.out.println("ID: " + pikachu.get("id").getAsInt());
        // Prints pokemon name from name value in JSON object and gets it as a String
        System.out.println("NAME: " + pikachu.get("name").getAsString());
    }
}
