class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    public double max(double a, double b) {
        return (a >= b) ? a : b;
    }
}

public class Exercise6 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Call 1: add(int, int) — both arguments are int literals
        int r1 = calc.add(3, 5);
        System.out.println("calc.add(3, 5) = " + r1);
        System.out.println("  → Selected: add(int, int)");
        System.out.println();

        // Call 2: add(double, double) — both arguments are double literals
        double r2 = calc.add(2.5, 3.7);
        System.out.println("calc.add(2.5, 3.7) = " + r2);
        System.out.println("  → Selected: add(double, double)");
        System.out.println();

        // Call 3: add(int, int, int) — three int arguments, matched by parameter count
        int r3 = calc.add(1, 2, 3);
        System.out.println("calc.add(1, 2, 3) = " + r3);
        System.out.println("  → Selected: add(int, int, int)");
        System.out.println();

        // Call 4: add(double, double) — one int and one double
        // The int is widened to double, so add(double, double) is selected
        double r4 = calc.add(5, 2.5);
        System.out.println("calc.add(5, 2.5) = " + r4);
        System.out.println("  → Selected: add(double, double) — int 5 is widened to 5.0");
        System.out.println();

        // Call 5: max(int, int) — both arguments are int literals
        int r5 = calc.max(10, 20);
        System.out.println("calc.max(10, 20) = " + r5);
        System.out.println("  → Selected: max(int, int)");
        System.out.println();

        // Call 6: max(double, double) — both arguments are double literals
        double r6 = calc.max(3.14, 2.71);
        System.out.println("calc.max(3.14, 2.71) = " + r6);
        System.out.println("  → Selected: max(double, double)");
        System.out.println();

        // Call 7: max(double, double) — one int and one double
        // The int is widened to double, so max(double, double) is selected
        double r7 = calc.max(7, 4.5);
        System.out.println("calc.max(7, 4.5) = " + r7);
        System.out.println("  → Selected: max(double, double) — int 7 is widened to 7.0");
    }
}
