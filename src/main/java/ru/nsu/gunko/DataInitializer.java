package ru.nsu.gunko;

import java.net.*;
import java.util.*;

public class DataInitializer {
    public static PageStates initializeData() {
        HashMap<URL, String> yesterdayPages = new HashMap<>();
        HashMap<URL, String> todayPages = new HashMap<>();

        SafePut("https://example.com", "<html><body><h1>Example Domain</h1></body></html>", yesterdayPages);
        SafePut("https://example2.com", "<html><body><h1>Example Domain2</h1></body></html>", yesterdayPages);

        SafePut("https://example1.com", "<html><body><h1>Example Domain1</h1></body></html>", todayPages);
        SafePut("https://example2.com", "<html><body><h1>Example Another Domain2</h1></body></html>", todayPages);

        return new PageStates(yesterdayPages, todayPages);
    }

    private static void SafePut(String url, String html, Map<URL, String> map) {
        try {
            map.put(new URI(url).toURL(), html);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
