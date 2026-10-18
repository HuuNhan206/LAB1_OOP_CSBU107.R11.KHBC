import java.util.Scanner;

class Rectangle {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    };

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double area() {
        return height * width;
    }

    public double perimeter() {
        return 2 * (height + width);
    }

    public void displayInfo(int number) {
        System.out.println("\nRectangle " + number + ":");
        System.out.println("Height = " + getHeight());
        System.out.println("Width = " + getWidth());
        System.out.println("Area = " + area());
        System.out.println("Perimeter = " + perimeter());
    }
};

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectangle[] rectangles = new Rectangle[3];

        for (int i = 0; i < rectangles.length; i++) {
            double height = readDimension(scanner, "Enter height for rectangle " + (i + 1) + ": ");
            double width = readDimension(scanner, "Enter width for rectangle " + (i + 1) + ": ");
            rectangles[i] = new Rectangle(height, width);
        }

        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i].displayInfo(i + 1);
        }

        scanner.close();
    }

    private static double readDimension(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                if (Double.isFinite(value) && value > 0) {
                    return value;
                }
            } else {
                scanner.next();
            }

            System.out.println("Please enter a positive numeric value.");
        }
    }
};
