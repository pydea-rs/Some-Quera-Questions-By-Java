package StringCalculator;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class StringCalculator {
    private String text;
    public StringCalculator(String text) {
        this.text = text;
    }

    public String toUpper() {
        return this.text.toUpperCase();
    }

    public String toLower() {
        return this.text.toLowerCase();
    }

    public String toCamelCase() {
        char[] characters = this.text.toCharArray();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < characters.length; i++) {
            if((characters[i] >= 'A' && characters[i] <= 'z') || (characters[i] >= '0' && characters[i] <= '9')){
                if(i == 0)
                    result.append(characters[i] >= 'A' && characters[i] <= 'Z'
                        ? (char) (characters[i] + ('a' - 'A'))
                        : characters[i]);

                else if(characters[i - 1] < 'A' || characters[i - 1] > 'z')
                    result.append((characters[i] >= 'a' && characters[i] <= 'z')
                        ? (char) (characters[i] + ('A' - 'a'))
                        : characters[i]);
                else if(characters[i] >= 'A' && characters[i] <= 'Z')
                    result.append((char) (characters[i] + ('a' - 'A')));
                else
                    result.append(characters[i]);
            }

        }
        return result.toString();
    }

    public String toCapitalCase() {
        char[] characters = this.text.toCharArray();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < characters.length; i++) {
            if(i == 0 || characters[i - 1] < 'A' || characters[i - 1] > 'z')
                result.append(characters[i] >= 'a' && characters[i] <= 'z'
                        ? (char) (characters[i] + ('A' - 'a'))
                        : characters[i]);
            else
                result.append(characters[i]);
        }
        return result.toString();
    }

    public String encode() {
        char[] characters = this.text.toCharArray();
        StringBuilder odd = new StringBuilder(), even = new StringBuilder();

        for(int i = characters.length - 1; i >= 0; i--) {
            if((i - characters.length - 1) % 2 == 0)
                even.append(characters[i]);
            else
                odd.append(characters[i]);
        }

        return String.format("%s#-#%s", even.toString(), odd.toString());
    }

    public String decode() throws UnsupportedEncodingException {
        String[] parts = this.text.split("#-#");
        if(parts.length != 2)
            throw new UnsupportedEncodingException("ERROR: This input is not in the supported encoding format!");
        char[] text = new char[parts[0].length() + parts[1].length()];
        for(int i = 0; i < text.length; i++) {
            final int index = i / 2;
            text[i] = parts[i % 2].charAt(index);
        }
        StringBuilder result = new StringBuilder();
        for(int i = text.length - 1; i >= 0; i--)
            result.append(text[i]);
        return result.toString();
    }
}
