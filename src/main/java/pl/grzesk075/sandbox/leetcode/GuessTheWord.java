package pl.grzesk075.sandbox.leetcode;

public class GuessTheWord {

    public static final int WORD_LENGTH = 6;
    public static final int IS_SECRET_WORD = WORD_LENGTH;
    public static final int NO_ONE_LETTER_METCHES = 0;

    interface Master {
        int guess(String word);
    }

    public void findSecretWord(String[] wordlist, Master master) {
        String wordToCheck = null;
        for (int i = 0; i < wordlist.length; i++) {
            wordToCheck = wordlist[i];
            if (wordToCheck != null) {
                wordlist[i] = null;
                break;
            }
        }
        if (wordToCheck == null) {
            return;
        }
        final int guess = master.guess(wordToCheck);
        System.out.println("Guess " + guess);
        if (guess == IS_SECRET_WORD) {
            System.out.println("Secret word is: " + wordToCheck);
            return;
        } else {
            removeNotMatchingWords(wordlist, wordToCheck, guess);
        }
        findSecretWord(wordlist, master);
    }

    private void removeNotMatchingWords(String[] wordlist, String wordToCheck, int guess) {
        final boolean noOneLetterMatches = guess == NO_ONE_LETTER_METCHES;
        for (int i = 0; i < wordlist.length; i++) {
            final String word = wordlist[i];
            if (word == null) {
                continue;
            }
            final int match = match(word, wordToCheck);
            final boolean removeWord = noOneLetterMatches ? match > 0 : match != guess;
            if (removeWord) {
                wordlist[i] = null;
            }
        }
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