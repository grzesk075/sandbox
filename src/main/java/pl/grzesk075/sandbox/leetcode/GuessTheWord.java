package pl.grzesk075.sandbox.leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GuessTheWord {

    public static final int WORD_LENGTH = 6;
    public static final int IS_SECRET_WORD = WORD_LENGTH;
    public static final int NO_ONE_LETTER_METCHES = 0;

    interface Master {
        int guess(String word);
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = new LinkedList<>();
        Collections.addAll(words, wordlist);
        findSecretWord(words, master);
    }

    public void findSecretWord(List<String> wordlist, Master master) {
        final String wordToCheck = getMinMaxWord(wordlist);
        if (wordToCheck == null) {
            return;
        }
        final int guess = master.guess(wordToCheck);
        System.out.println("Guess " + guess);  // 0 is most likely
        if (guess == IS_SECRET_WORD) {
            System.out.println("Secret word is: " + wordToCheck);
            return;
        } else {
            removeNotMatchingWords(wordlist, wordToCheck, guess);
        }
        findSecretWord(wordlist, master);
    }

    private String getMinMaxWord(List<String> wordlist) {
        final int length = wordlist.size();
        if (length == 0) {
            return null;
        }
        if (length < 3) {
            return wordlist.get(0);
        }
        //final int[][] matchMatrix = new int[length][length];
        final int[] minmaxScore = new int[length];
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                final int match = match(wordlist.get(i), wordlist.get(j));
                //matchMatrix[i][j] = match;
                minmaxScore[i] += match;
                minmaxScore[j] += match;
            }
        }
        final int indexOfMinMaxWord = getIndexOfLargest(minmaxScore);
        return wordlist.remove(indexOfMinMaxWord);
    }

    private void removeNotMatchingWords(List<String> wordlist, String wordToCheck, int guess) {
        final boolean noOneLetterMatches = guess == NO_ONE_LETTER_METCHES;
        final Iterator<String> iterator = wordlist.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            final int match = match(word, wordToCheck);
            final boolean removeWord = noOneLetterMatches ? match > 0 : match != guess;
            if (removeWord) {
                iterator.remove();
            }
        }
    }

    static int getIndexOfLargest(int[] array) {
        int maxAt = 0;
        for (int i = 0; i < array.length; i++) {
            maxAt = array[i] > array[maxAt] ? i : maxAt;
        }
        return maxAt;
    }

    static int match(String word, String wordToCheck) {
        int match = 0;
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (word.charAt(i) == wordToCheck.charAt(i)) {
                match++;
            }
        }
        return match;
    }
}