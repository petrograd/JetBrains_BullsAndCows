import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (!"0".equals(s)) {
            try {
                System.out.println(Integer.parseInt(s) * 10);
            } catch (Exception ex) {
                System.out.println("Invalid user input: " + s);
            }
            s = scanner.nextLine();
        }
    }
}