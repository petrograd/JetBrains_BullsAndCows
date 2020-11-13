package bullscows;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        System.out.print("> ");
        int length;
        try {
            length = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: isn't a valid number.");
            return;
        }
        if (length <= 0 || length > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique symbols.");
            return;
        }
        System.out.println("Input the number of possible symbols in the code:");
        System.out.print("> ");
        int range;
        try {
            range = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: isn't a valid number.");
            return;
        }
        if (range < length) {
            System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + range + " unique symbols.");
            return;
        }
        if (range > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }

        String secretWord = generateSecretWord(length, range);
//        String secretWord = generateSecretWord(length);
        System.out.print("The secret is prepared " + secretWord + " ");
        printRange(length, range);

//
        System.out.println("Okay, let's start a game!");
        int cnt = 1;
        while (true) {
            System.out.printf("Turn %d:\n", cnt++);
            System.out.print("> ");
            String userInput = scanner.next();

            if (passGrader(userInput, secretWord)) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }

        }

    }

    private static void printRange(int length, int range) {
        for (int i = 0; i < length; i++) {
            System.out.print('*');
        }
        System.out.print(" (");
        for (int i = 0; i < range; i++) {
            if (i < 10) {
                System.out.print((char) (48 + i));
            } else {
                System.out.print((char) (97 + i - 10));
            }
            if (i < (range - 1))
                System.out.print(",");

        }
        System.out.println(").");
    }

    private static String generateSecretWord(int length, int range) {
        char pseudoRandomChar = getRandomChar(range);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // every symbol must be unique
            while (sb.indexOf(String.valueOf(pseudoRandomChar)) > -1) {
                 pseudoRandomChar = getRandomChar(range);
            }

            sb.append(pseudoRandomChar);

        }
        return sb.toString();
    }

    private static char getRandomChar(int range) {
        Random random = new Random();
        int d = random.nextInt(range);
        if (d < 10) {
            return (char) (48 + d);
        } else {
            return (char) (97 + d - 10);
        }
    }


    private static String generateSecretWord(int len) {
        long pseudoRandomNumber = getRandomNumber();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            // first symbol cannot be 0
            while (i == 0 && pseudoRandomNumber % 10 == 0) {
                pseudoRandomNumber /= 10;
            }

            String challenger = Long.toString(pseudoRandomNumber % 10);
            // every symbol must be unique
            while (sb.indexOf(challenger) > -1) {
                pseudoRandomNumber /= 10;
                if (pseudoRandomNumber == 0) {
                    pseudoRandomNumber = getRandomNumber();
                }
                challenger = Long.toString(pseudoRandomNumber % 10);
            }

            sb.append(challenger);
            pseudoRandomNumber /= 10;
            if (pseudoRandomNumber == 0) {
                pseudoRandomNumber = getRandomNumber();
            }
        }
        return sb.toString();
    }

    private static long getRandomNumber() {
        double d = Math.random();
        for (int i = 0; i < 16; i++) {
            d *= 10;
        }
        return  (long)d;
    }

    private static long getNanoTime() {
        //System.out.println("nanoTime: " + pseudo);
        return System.nanoTime();
    }

    private static boolean passGrader(String userInput, String secretWord) {
        String ans = "Grade: ";
        int bulls = 0;
        int cows = 0;


        for (int i = 0; i < secretWord.length(); i++) {
            for (int j = 0; j < userInput.length(); j++) {
                if (secretWord.charAt(i) == userInput.charAt(j)) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }
        if (bulls == 0 && cows == 0) {
            ans += "None";
        }
        if (bulls > 0) {
            ans += bulls + " bull(s)";
        }
        if (cows > 0) {
            if (bulls > 0) {
                ans += " and ";
            }
            ans += cows + " cow(s)";
        }
        System.out.println(ans);
        //ans = ans + ". The secret code is " + secretWord;
        return bulls == secretWord.length();
    }
}
