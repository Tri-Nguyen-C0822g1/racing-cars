package RacingCars;

public class Main {
    public static int DISTANCE = 100;

    public static int STEP = 2;
    public static void main(String[] args) {

        Cars carA = new Cars("A");
        Cars carB = new Cars("B");
        Cars carC = new Cars("C");

        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);

        System.out.println("Distance: 100KM");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

