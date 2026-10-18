import java.util.Random;

class Dice {
    private int value;
    private Random random;

    Dice() {
        this.value = 1;
        this.random = new Random();
    }

    public int roll() {
        this.value = random.nextInt(6) + 1; // nextInt(6) returns [0,5], +1 gives [1,6]
        return this.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Dice [value=" + value + "]";
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        Dice dice = new Dice();
        int n = 1000000; // number of rolls

        // Frequency array: index 0 unused, indices 1-6 for each face
        int[] frequency = new int[7];

        // Roll n times and count frequencies
        for (int i = 0; i < n; i++) {
            int result = dice.roll();
            frequency[result]++;
        }

        System.out.println("Total rolls: " + n);
        System.out.printf("%-8s %-12s %-12s%n", "Face", "Frequency", "Probability");

        for (int face = 1; face <= 6; face++) {
            double probability = (double) frequency[face] / n;
            System.out.printf("%-8d %-12d %-12.4f%n", face, frequency[face], probability);
        }

        System.out.printf("Expected probability for each face: %.4f%n", 1.0 / 6);
    }
}
