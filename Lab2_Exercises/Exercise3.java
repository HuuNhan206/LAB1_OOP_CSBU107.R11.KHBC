class Time {
    private int hour;
    private int minute;
    private int second;

    Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    Time(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be in [0, 23]. Got: " + hour);
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be in [0, 59]. Got: " + minute);
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be in [0, 59]. Got: " + second);
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void display() {
        System.out.printf("%02d:%02d:%02d%n", hour, minute, second);
    }

    // Helper: normalize any total-seconds value into valid h/m/s within a 24-hour
    // day
    private void normalize(int totalSeconds) {
        // Java % can return negative, so use Math.floorMod to always get [0, 86400)
        totalSeconds = Math.floorMod(totalSeconds, 86400); // 86400 = 24 * 60 * 60
        this.hour = totalSeconds / 3600;
        this.minute = (totalSeconds % 3600) / 60;
        this.second = totalSeconds % 60;
    }

    // Convert current time to total seconds
    private int toTotalSeconds() {
        return hour * 3600 + minute * 60 + second;
    }

    public void addSeconds(int seconds) {
        normalize(toTotalSeconds() + seconds);
    }

    public void subtractSeconds(int seconds) {
        normalize(toTotalSeconds() - seconds);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("Default Constructor");
        Time t0 = new Time();
        System.out.print("Default time: ");
        t0.display();

        // 23:59:50 + 20 seconds => 00:00:10 (wraps past midnight)
        System.out.println("\n Case: 23:59:50 + 20 seconds");
        Time t1 = new Time(23, 59, 50);
        System.out.print("Before: ");
        t1.display();
        t1.addSeconds(20);
        System.out.print("After:  ");
        t1.display();

        // 00:00:10 - 20 seconds => 23:59:50 (wraps before midnight)
        System.out.println("\n Case: 00:00:10 - 20 seconds");
        Time t2 = new Time(0, 0, 10);
        System.out.print("Before: ");
        t2.display();
        t2.subtractSeconds(20);
        System.out.print("After:  ");
        t2.display();

        // Larger additions
        System.out.println("\n Case: 12:30:00 + 5000 seconds");
        Time t3 = new Time(12, 30, 0);
        System.out.print("Before: ");
        t3.display();
        t3.addSeconds(5000);
        System.out.print("After:  ");
        t3.display();

        // Larger subtractions
        System.out.println("\n Case: 01:00:00 - 7200 seconds");
        Time t4 = new Time(1, 0, 0);
        System.out.print("Before: ");
        t4.display();
        t4.subtractSeconds(7200);
        System.out.print("After:  ");
        t4.display();
    }
}
