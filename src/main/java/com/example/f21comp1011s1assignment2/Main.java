package com.example.f21comp1011s1assignment2;

public class Main {
    public static void main(String[] args) {
        ApiResponse result = ApiUtility.getArticlesFromApi("COVID");
        System.out.println(result);
    }
}
