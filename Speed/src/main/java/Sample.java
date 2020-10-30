import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Sample {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private LinkedList<Integer> linkedList = new LinkedList<Integer>();

    public void add(int iter) {
        System.out.println("==============Add==============");

        Date startArray = new Date();
        for(int i = 0; i < iter; i++) arrayList.add(i);
        Date finishArray = new Date();
        long ArrayTime = finishArray.getTime() - startArray.getTime();

        Date startLinked = new Date();
        for(int i = 0; i < iter; i++) linkedList.add(i);
        Date finishLinked = new Date();
        long LinkedTime = finishLinked.getTime() - startLinked.getTime();

        System.out.println("--Add elements");
        System.out.println("ArrayList: " + ArrayTime + " ms");
        System.out.println("LinkedList: " + LinkedTime + " ms");

        System.out.println((ArrayTime < LinkedTime)?"ArrayList is faster":"LinkedList is faster");

    }

    public void insert(int iter) {
        System.out.println("==============Insert==============");

        Date startArray = new Date();
        for(int i = 0; i < iter; i++) arrayList.add(0, i);
        Date finishArray = new Date();
        long ArrayTime = finishArray.getTime() - startArray.getTime();

        Date startLinked = new Date();
        for(int i = 0; i < iter; i++) linkedList.add(0, i);
        Date finishLinked = new Date();
        long LinkedTime = finishLinked.getTime() - startLinked.getTime();

        System.out.println("--Insert elements to begin");
        System.out.println("ArrayList: " + ArrayTime + " ms");
        System.out.println("LinkedList: " + LinkedTime + " ms");

        System.out.println((ArrayTime < LinkedTime)?"ArrayList is faster":"LinkedList is faster");

    }



}
