package com.roadmap.url_shortener.util;

import java.util.Random;

public class ShortenURL {
    private static final String CHARSET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(String longURL) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(CHARSET.charAt(new Random().nextInt(CHARSET.length())));
        }

        return sb.toString();
    }
}
