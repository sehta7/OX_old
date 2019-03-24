package com.firm.OX;

import java.util.Locale;
import java.util.ResourceBundle;

class Language {

    private String language;
    private static final String PATH = "language";
    private ResourceBundle bundle;

    Language(String language) {
        this.language = language;
    }

    void loadLanguage(){
        Locale locale = new Locale(language.toLowerCase(), language.toUpperCase());
        bundle = ResourceBundle.getBundle(PATH, locale);
    }

    String getSentence(String key){
        return bundle.getString(key);
    }
}
