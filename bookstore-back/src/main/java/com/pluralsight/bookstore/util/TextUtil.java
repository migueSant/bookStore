package com.pluralsight.bookstore.util;

public class TextUtil {
    public String sanatize(String texto){
        return texto.replaceAll("\\s+", " ");
    }
}
