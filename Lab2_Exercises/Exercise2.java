import static java.lang.Math.abs;

class Fraction {
    private int numerator;
    private int denominator;

    Fraction() {
        this(0, 1);
    };

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    };

    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    };

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    };

    public Fraction simplify() {
        int gcd = gcd(abs(numerator), abs(denominator));
        return new Fraction(numerator / gcd, denominator / gcd);
    };

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator).simplify();
    };

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator).simplify();
    };

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator).simplify();
    };

    public Fraction divide(Fraction other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator).simplify();
    };

    public void display() {
        System.out.println(numerator + "/" + denominator);
    };

    public class Exercise2 {
        public static void main(String[] args) {
            Fraction fraction1 = new Fraction(1, 2);
            Fraction fraction2 = new Fraction(3, 4);

            System.out.print("Fraction 1: ");
            fraction1.display();

            System.out.print("Fraction 2: ");
            fraction2.display();

            Fraction sum = fraction1.add(fraction2);
            System.out.print("Sum: ");
            sum.display();

            Fraction Substract = fraction1.subtract(fraction2);
            System.out.print("Substract: ");
            Substract.display();

            Fraction Multiply = fraction1.multiply(fraction2);
            System.out.print("Multiply: ");
            Multiply.display();

            Fraction Devide = fraction1.divide(fraction2);
            System.out.print("Divide: ");
            Devide.display();
        }
    }
};
