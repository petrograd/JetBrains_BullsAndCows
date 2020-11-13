import java.util.Scanner;

class Main {
    private boolean completed;
    private int cnt;

    public static void main(String[] args) {
        System.out.println(solve());

    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private static Double solve() {
        double a;
        double b;
        double c;
        double r;
        Scanner in = new Scanner(System.in);
        String figure = in.next();
        switch (figure) {
            case "triangle":
                a = in.nextDouble();
                b = in.nextDouble();
                c = in.nextDouble();
                double p = (a + b + c) / 2;
                return Math.sqrt(p * (p - a) * (p - b) * (p - c));
            case "rectangle":
                a = in.nextDouble();
                b = in.nextDouble();
                return a * b;
            case "circle":
                r = in.nextDouble();
                return 3.14 * r * r;
            default:
                return 0.0;
        }

    }
}
