class Circle {
    private double centerX;
    private double centerY;
    private double radius;

    Circle() {
        this.centerX = 0;
        this.centerY = 0;
        this.radius = 1;
    }

    Circle(double centerX, double centerY, double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be non-negative. Got: " + radius);
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }

    // Area = π * r²
    public double area() {
        return Math.PI * radius * radius;
    }

    // Perimeter (circumference) = 2 * π * r
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    // Returns true if (x, y) is inside or on the circle
    // A point is inside/on when distance from center <= radius
    public boolean contains(double x, double y) {
        double dx = x - centerX;
        double dy = y - centerY;
        return (dx * dx + dy * dy) <= (radius * radius);
    }

    @Override
    public String toString() {
        return String.format("C(%.2f, %.2f, %.2f)", centerX, centerY, radius);
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        // Circle 1: Default unit circle at origin
        Circle c1 = new Circle();
        System.out.println("Circle 1 (unit circle): " + c1 + "");
        System.out.printf("  Area      = %.4f%n", c1.area());
        System.out.printf("  Perimeter = %.4f%n", c1.perimeter());
        testPoint(c1, 0, 0); // center → inside
        testPoint(c1, 1, 0); // on edge → inside
        testPoint(c1, 1, 1); // outside

        // Circle 2: C(3, 4, 5)
        Circle c2 = new Circle(3, 4, 5);
        System.out.println("\n Circle 2: " + c2 + "");
        System.out.printf("  Area      = %.4f%n", c2.area());
        System.out.printf("  Perimeter = %.4f%n", c2.perimeter());
        testPoint(c2, 3, 4); // center → inside
        testPoint(c2, 8, 4); // on edge (3+5, 4) → inside
        testPoint(c2, 0, 0); // distance=5 → on edge
        testPoint(c2, -3, -2); // outside

        // Circle 3: C(-2, 1, 3.5)
        Circle c3 = new Circle(-2, 1, 3.5);
        System.out.println("\n Circle 3: " + c3 + "");
        System.out.printf("  Area      = %.4f%n", c3.area());
        System.out.printf("  Perimeter = %.4f%n", c3.perimeter());
        testPoint(c3, -2, 1); // center → inside
        testPoint(c3, 0, 0); // inside
        testPoint(c3, 2, 4); // outside
    }

    // Helper to test and print whether a point is inside a circle
    private static void testPoint(Circle c, double x, double y) {
        boolean inside = c.contains(x, y);
        System.out.printf("  contains(%.2f, %.2f) = %s%n", x, y, inside);
    }
}
