package com.campusnet.hangman_app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Hangman {
    //Variables
    static private List<String> letters;
    static public String currentWord;
    static public int errorCount;

    static public void GetRandomWord()
    {
        Random random = new Random();
        int indexRand = random.nextInt(Words.wordList.length);
        GetWordByIndex(indexRand);
        //GetWordByIndex(1);
    }

    static public void GetWordByIndex(int index)
    {
        letters = new ArrayList<>();
        currentWord = Words.wordList[index];
    }

    //Funcion para generar el simbolo '_' dependiendo de la palabra
    static public String GetWordInGame()
    {
        String finalWord = "";
        for (int i = 0; i < currentWord.length(); i++)
        {
            String lowerLetter = String.valueOf(currentWord.charAt(i)).toLowerCase();

            boolean hasLetter = letters.contains(lowerLetter);
            if (hasLetter)
            {
                finalWord += String.valueOf(currentWord.charAt(i));
            }
            else
            {
                finalWord += "_";
            }
        }
        return finalWord;
    }


    private static Set<String> usedLetters;
    static {
        usedLetters = new HashSet<>();
    }

    public static boolean isUsed(String letter) {
        return usedLetters.contains(letter.toLowerCase());
    }
    private static void addUsedLetter(String letter) {
        usedLetters.add(letter.toLowerCase());
    }

    //Añade las letras que escriba el usuario
    static public void AddLetter(String letter)
    {
        String lowerLetter = letter.toLowerCase();
        String lowerWord = currentWord.toLowerCase();
        if (letters.contains(lowerLetter))
        {
            //Esta letra ya la habias utilizado
        }
        else
        {
            letters.add(lowerLetter);
            SpecialCharacters getChars = Characters.GetSpecialChar(lowerLetter);
            if (getChars != null)
            {
                for (int i = 0; i < getChars.result.length; i++)
                {
                    letters.add(getChars.result[i]);
                }
            }

            boolean hasLetter = lowerWord.contains(lowerLetter);
            if (hasLetter)
            {
                //Se ha ganado
            }
            else
            {
                errorCount++;
                if (errorCount >= Words.imageError.length)
                {
                    //Se ha perdido
                    ShowLooseScreen();
                }
            }
            addUsedLetter(lowerLetter);
        }
    }
    private static MainActivity mainActivity;

    public static void setMainActivity(MainActivity activity) {
        mainActivity = activity;
    }

    static public void ShowWinScreen() {
        if (mainActivity != null) {
            mainActivity.showWinScreen();
        }
    }

    static public void ShowLooseScreen() {
        if (mainActivity != null) {
            mainActivity.showLooseScreen();
        }
    }

    static public void Win(String actualWord) {
        if(currentWord.equals(actualWord)) {
            ShowWinScreen();
        }
    }
}
