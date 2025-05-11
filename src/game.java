import java.util.Random;
import java.util.Scanner;

public class game {
    public static maps[] cards = new maps[5];
    public static maps[] cards1 = new maps[5];
    public  static void main() {
    String[] element = {"Лед","Огонь","Вода"};
     Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomLevel = random.nextInt(3);
           int randomNum = random.nextInt(5);
           cards1[i] = new maps(element[randomLevel], randomNum);
           System.out.println(cards1[i].toString());
        }
        System.out.println("1 ход");
        System.out.println("Сделайте выбор");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

    }
}