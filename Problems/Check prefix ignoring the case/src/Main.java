import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().toLowerCase().charAt(0) == 'j') {
            System.out.println("true");
        } else {
            System.out.println("false");

        }
    }
}