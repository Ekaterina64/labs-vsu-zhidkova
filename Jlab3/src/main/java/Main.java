import java.util.Scanner;

import static java.lang.StrictMath.abs;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во итераций от 1000: ");
        int val = scanner.nextInt();
        TestArList test1 = new TestArList(val, 100000);
        TestLinked test2 = new TestLinked(val, 100000);

        System.out.println("==============Add==============");
        long[] time1 = test1.add();
        long[] time2 = test2.add();
        System.out.println("--Begin");
        System.out.println("ArrayList: " + time1[0] + " ms");
        System.out.println("LinkedList: " + time2[0] + " ms");
        System.out.println((abs(time1[0] - time2[0]) < 60 )?"They are similar":(time2[0]<time1[0])?"LinkedList is faster":"ArrayList is faster");

        System.out.println("--Middle");
        System.out.println("ArrayList: " + time1[1] + " ms");
        System.out.println("LinkedList: " + time2[1] + " ms");
        System.out.println((abs(time1[1] - time2[1]) < 60 )?"They are similar":(time2[1]<time1[1])?"LinkedList is faster":"ArrayList is faster");

        System.out.println("--End");
        System.out.println("ArrayList: " + time1[2] + " ms");
        System.out.println("LinkedList: " + time2[2] + " ms");
        System.out.println((abs(time1[2] - time2[2]) < 60 )?"They are similar":(time2[2]<time1[2])?"LinkedList is faster":"ArrayList is faster");

        System.out.println("==============Remove==============");
        time1 = test1.remove();
        time2 = test2.remove();
        System.out.println("--Begin");
        System.out.println("ArrayList: " + time1[0] + " ms");
        System.out.println("LinkedList: " + time2[0] + " ms");
        System.out.println((abs(time1[0] - time2[0]) < 60 )?"They are similar":(time2[0]<time1[0])?"LinkedList is faster":"ArrayList is faster");

        System.out.println("--Middle");
        System.out.println("ArrayList: " + time1[1] + " ms");
        System.out.println("LinkedList: " + time2[1] + " ms");
        System.out.println((abs(time1[1] - time2[1]) < 60 )?"They are similar":(time2[1]<time1[1])?"LinkedList is faster":"ArrayList is faster");

        System.out.println("--End");
        System.out.println("ArrayList: " + time1[2] + " ms");
        System.out.println("LinkedList: " + time2[2] + " ms");
        System.out.println((abs(time1[2] - time2[2]) < 60 )?"They are similar":(time2[2]<time1[2])?"LinkedList is faster":"ArrayList is faster");


        System.out.println("==============Get==============");
        time1 = test1.get();
        time2 = test2.get();
        System.out.println("--Begin");
        System.out.println("ArrayList: " + time1[0] + " ms");
        System.out.println("LinkedList: " + time2[0] + " ms");
        System.out.println((abs(time1[0] - time2[0]) < 60 )?"They are similar":(time2[0]<time1[0])?"LinkedList is faster":"ArrayList is faster");

        System.out.println("--Middle");
        System.out.println("ArrayList: " + time1[1] + " ms");
        System.out.println("LinkedList: " + time2[1] + " ms");
        System.out.println((abs(time1[1] - time2[1]) < 60 )?"They are similar":(time2[1]<time1[1])?"LinkedList is faster":"ArrayList is faster");

        System.out.println("--End");
        System.out.println("ArrayList: " + time1[2] + " ms");
        System.out.println("LinkedList: " + time2[2] + " ms");
        System.out.println((abs(time1[2] - time2[2]) < 60 )?"They are similar":(time2[2]<time1[2])?"LinkedList is faster":"ArrayList is faster");


    }
}
