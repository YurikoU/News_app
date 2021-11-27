package com.example.f21comp1011s1assignment2.Utilities;

import com.example.f21comp1011s1assignment2.Models.ApiResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtility {
    //Header parameters of HttpRequest
    private static final String apiHost = "newscatcher.p.rapidapi.com";
    private static final String apiKey = "723127a008msh5f0756979223977p1cc23djsnf7870823e43b";

    /*
     * This method will call the API with the specific search term
     * */
    public static ApiResponse getArticlesFromApi(String searchTerm, String language) {
        //Once the search term contains white spaces, replace them with "%20"
        searchTerm = searchTerm.trim().replace(" ", "%20");

        //Store the uri to retrieve the raw data
        String uri;
        if(language == null || language == "All")
        {
            uri = "https://newscatcher.p.rapidapi.com/v1/search_free?"
                    + "q=" + searchTerm
                    + "&lang=en"
                    + "&page=1&media=True";
        } else
        {
            uri = "https://newscatcher.p.rapidapi.com/v1/search_free?"
                    + "q=" + searchTerm
                    + "&lang=" + language
                    + "&page=1&media=True";
        }

        HttpClient client = HttpClient.newHttpClient();

        //Pass the URI and form the http request object
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(uri))
                .header("x-rapidapi-host", apiHost)
                .header("x-rapidapi-key", apiKey)
                //.method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;
        ApiResponse apiResponse = null;

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

        //Return the ApiResponse object without using file system
        apiResponse = gson.fromJson(jsonString, ApiResponse.class);

        return apiResponse;
    }

}
