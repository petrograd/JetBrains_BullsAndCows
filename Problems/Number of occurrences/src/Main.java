import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String sub = scanner.nextLine();

        String[] words = (" " + str + " ").split(sub);
        System.out.println(words.length-1);
    }
}