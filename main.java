import java.util.Random;

public class main {
    public main(String[] args) {
        Random rand = new Random();
        int n = 10;
        for (int i = 0; i < n; i++) {
            int randomNum = rand.nextInt(100); // Generates a random number between 0 and 99
            System.out.println(randomNum);
        }
        System.out.println("Random number generation completed.");
    }
}