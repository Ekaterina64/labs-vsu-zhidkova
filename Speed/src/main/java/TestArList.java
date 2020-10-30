import java.util.*;

public class TestArList {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private final int iter;

    public TestArList(int k, int size){
        this.iter = k;
        init(size);

    }

    private void init(int size) {
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
    }
    //private LinkedList<Integer> linkedList = new LinkedList<Integer>();

    public long[] add() {
        //System.out.println("==============Add==============");
       long[] rez = {0, 0, 0};

        rez[0] = addTo(0);
        rez[1] = addTo(arrayList.size()/2);
        rez[2] = addTo(arrayList.size() - 1);

        //System.out.println("--Add elements in ArrayList");
        //System.out.println("Begin: " + addTo(0) + " ms");
        //System.out.println("Middle: " + addTo(arrayList.size()/2) + " ms");
        //System.out.println("End: " + addTo(arrayList.size() - 1) + " ms");

        //System.out.println((ArrayTime < LinkedTime)?"ArrayList is faster":"LinkedList is faster");
        return rez;

    }

//    public void insert(int iter) {
//        System.out.println("==============Insert==============");
//
//        Date startArray = new Date();
//        for(int i = 0; i < iter; i++) arrayList.add(0, i);
//        Date finishArray = new Date();
//        long ArrayTime = finishArray.getTime() - startArray.getTime();
//
//        Date startLinked = new Date();
//        for(int i = 0; i < iter; i++) linkedList.add(0, i);
//        Date finishLinked = new Date();
//        long LinkedTime = finishLinked.getTime() - startLinked.getTime();
//
//        System.out.println("--Insert elements to begin");
//        System.out.println("ArrayList: " + ArrayTime + " ms");
//        System.out.println("LinkedList: " + LinkedTime + " ms");
//
//        System.out.println((ArrayTime < LinkedTime)?"ArrayList is faster":"LinkedList is faster");
//
//    }

    private long addTo(int pos) {
        Date startArray = new Date();
        for(int i = 0; i < iter; i++) arrayList.add(pos, i);
        Date finishArray = new Date();
        long ArrayTime = finishArray.getTime() - startArray.getTime();
        return ArrayTime;
    }



}
