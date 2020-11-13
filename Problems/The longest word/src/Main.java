import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        int longest = 0;
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            int curLength = words[i].length();
            if (longest < curLength) {
                longest = curLength;
                index = i;
            }
        }
        System.out.println(words[index]);
    }
}