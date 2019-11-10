package com.zoohackathon.sunflower.commons;

import java.text.Normalizer;

public class NormalizeData {

    public static String normalize(final String str){
        String normalized = str;
        normalized = normalized.toLowerCase();
        normalized = normalized.replaceAll("-", " ");
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        return normalized;
    }
}
