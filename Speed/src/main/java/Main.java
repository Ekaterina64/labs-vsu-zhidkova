import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sample primer = new Sample();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во итераций от 1000: ");
        int val = scanner.nextInt();

        primer.add(val);
        primer.insert(val);

    }
}
