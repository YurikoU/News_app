package com.example.f21comp1011s1assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtility {
    //Header parameters of HttpRequest
    private static final String apiHost = "google-news1.p.rapidapi.com";
    private static final String apiKey = "723127a008msh5f0756979223977p1cc23djsnf7870823e43b";

    /*
     * This method will read the file called "jsonData.json" in the root of the project
     * and create an ApiResponse object.
     * */
    public static ApiResponse getArticlesJsonFile() {
        //Create a GSON object
        Gson gson = new Gson();
        ApiResponse response = null;

        try (
                //Access the JSON file attaching it
                FileReader fileReader = new FileReader("jsonData.json");
                //Parse the JSON file into readable chunks for the JSON library
                JsonReader jsonReader = new JsonReader(fileReader)
        ) {
            //Once it finishes parsing the JSON file for the JSON library,
            //      it'll ask the JSON library to pull JSON,
            //      and create an instance of ApiResponse class
            response = gson.fromJson(jsonReader, ApiResponse.class);
        } catch (Exception e) {
            //Once it finds any exception, print it
            e.printStackTrace();
        }

        return response;
    }

    /*
     * This method will call the API with the specific search term
     * */
    public static ApiResponse getArticlesFromApi(String searchTerm) {
        //Once the search term contains white spaces, replace them with "%20"
        searchTerm = searchTerm.trim().replace(" ", "%20");

        //Store the uri, host and key to retrieve the raw data
        String uri = "https://google-news1.p.rapidapi.com/search?q="
                + searchTerm
                + "&country=CA&lang=en&source=cnn.com&limit=50&when=1m";

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;

        //Pass the URI and form the http request object
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(uri))
                .header("x-rapidapi-host", apiHost)
                .header("x-rapidapi-key", apiKey)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            //This approach stores the API response to a string and then creates objects
            //Write the response to a string called "response", which is an HttpResponse object
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Store the API reply
        String jsonString = response.body();

        Gson gson = new Gson();

        ApiResponse apiResponse = null;

        //Return the ApiResponse object without using file system
        apiResponse = gson.fromJson(jsonString, ApiResponse.class);

        return apiResponse;
    }

}
