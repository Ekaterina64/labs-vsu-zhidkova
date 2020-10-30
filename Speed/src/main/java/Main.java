import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во итераций от 1000: ");
        int val = scanner.nextInt();
        TestArList test1 = new TestArList(val, 50000);
        TestLinked test2 = new TestLinked(val, 50000);

        System.out.println("==============Add==============");
        long[] time1 = test1.add();
        long[] time2 = test2.add();
        System.out.println("--Begin");
        System.out.println("ArrayList: " + time1[0] + " ms");
        System.out.println("LinkedList: " + time2[0] + " ms");
        System.out.println((time1[0] < time2[0])?"ArrayList is faster":"LinkedList is faster");

        System.out.println("--Middle");
        System.out.println("ArrayList: " + time1[1] + " ms");
        System.out.println("LinkedList: " + time2[1] + " ms");
        System.out.println((time1[1]  < time2[1] )?"ArrayList is faster":"LinkedList is faster");

        System.out.println("--End");
        System.out.println("ArrayList: " + time1[2] + " ms");
        System.out.println("LinkedList: " + time2[2] + " ms");
        System.out.println((time1[2]  < time2[2] )?"ArrayList is faster":"LinkedList is faster");



    }
}
