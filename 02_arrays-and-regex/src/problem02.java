import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class problem02 {
    public static String reverseFromTo(String raw, final int from, final int to) {
        char[] charRaw = raw.toCharArray(), result = charRaw.clone();
        final int wordLength = to - from;
        for(int i = 0; i <= wordLength; i++)
            result[from + i] = charRaw[to - i];

        return String.valueOf(result);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentence = input.nextLine();
        int m = input.nextInt(), n = input.nextInt();
        String modifiedSentence = sentence;

        // first reverse the wanted words
        final Matcher wordMatcher = Pattern.compile(String.format("\\w{%d,}+", m)).matcher(sentence);
        while(wordMatcher.find()) {
            int matcherEnd = wordMatcher.end();
            if(matcherEnd < sentence.length() && sentence.charAt(matcherEnd) != ' ') // for reversing repetitive non word characters
                // like: test... , test2!!!
                for(; matcherEnd < sentence.length() - 1 && Pattern.matches("[^a-zA-Z]", "" + sentence.charAt(matcherEnd)); matcherEnd++);
            modifiedSentence = reverseFromTo(modifiedSentence, wordMatcher.start(), matcherEnd >= sentence.length() || sentence.charAt(matcherEnd) == ' ' ? matcherEnd - 1 : matcherEnd);
        }

        // count and store vowels
        String fullReverseSentence = reverseFromTo(sentence, 0, sentence.length() - 1);
        final Matcher vowelMatcher = Pattern.compile("[aeiou]").matcher(fullReverseSentence.toLowerCase());
        String last_nVowels = "";
        int numberOfVowels = 0;
        while(vowelMatcher.find()) {
            final int current = vowelMatcher.start();
            if(numberOfVowels++ < n) // first compare numberOfVowels with n (because only the last n vowels of the string must be printed
                                        // then increment numberOfVowels
                last_nVowels = fullReverseSentence.charAt(current) + last_nVowels;
        }

        System.out.printf("%s\n%s\n%d\n", modifiedSentence,
                (numberOfVowels >= n ? last_nVowels : "Number of vowels is less than this!"),
                numberOfVowels);

    }
}
