package com.campusnet.hangman_app;

public class Characters {
    public static SpecialCharacters[] specialCharacters = new SpecialCharacters[]
    {
        new SpecialCharacters("a", new String[]{"á","à","ä","â","ã"}),
        new SpecialCharacters("e", new String[]{"é","è","ë","ê"}),
        new SpecialCharacters("i", new String[]{"í","ì","ï","î"}),
        new SpecialCharacters("o", new String[]{"ó","ò","ö","ô","õ"}),
        new SpecialCharacters("u", new String[]{"ú","ù","ü","û"}),
        new SpecialCharacters("n", new String[]{"ñ"}),
        new SpecialCharacters("c", new String[]{"ç"}),
    };

    public static SpecialCharacters GetSpecialChar (String letter)
    {
        for (int i = 0; i < specialCharacters.length; i++)
        {
            if (specialCharacters[i].value.equals(letter))
            {
                return specialCharacters[i];
            }
        }
        return null;
    }
}

class SpecialCharacters {
    public String value;
    public String[] result;

    public SpecialCharacters(String value, String[] result) {
        this.value = value;
        this.result = result;
    }
}
