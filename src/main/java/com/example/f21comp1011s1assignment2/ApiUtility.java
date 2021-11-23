package com.example.f21comp1011s1assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class ApiUtility {
    /*
    * This method will read the file called "jsonData.json" in the root of the project
    * and create an ApiResponse object.
    * */
    public static ApiResponse getArticlesJsonFile()
    {
        //Create a GSON object
        Gson gson = new Gson();
        ApiResponse response = null;

        try (
                //Access the JSON file attaching it
                FileReader fileReader = new FileReader("jsonData.json");
                //Parse the JSON file into readable chunks for the JSON library
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            //Once it finishes parsing the JSON file for the JSON library,
            //      it'll ask the JSON library to pull JSON,
            //      and create an instance of ApiResponse class
            response = gson.fromJson(jsonReader, ApiResponse.class);
        }
        catch (Exception e)
        {
            //Once it finds any exception, print it
            e.printStackTrace();
        }

        return response;
    }

}
