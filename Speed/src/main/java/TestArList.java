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

    public long[] add() {

       long[] rez = {0, 0, 0};

        rez[0] = addTo(0);
        rez[1] = addTo(arrayList.size()/2);
        rez[2] = addTo(arrayList.size() - 1);

        return rez;

    }

    public long[] remove() {

        long[] rez = {0, 0, 0};

        rez[0] = removeFrom(0);
        rez[1] = removeFrom(arrayList.size()/2);
        rez[2] = removeFrom(arrayList.size() - 1);

        return rez;
    }

    public long[] get() {

        long[] rez = {0, 0, 0};

        rez[0] = getFrom(0);
        rez[1] = getFrom(arrayList.size()/2);
        rez[2] = getFrom(arrayList.size() - 1);

        return rez;
    }

    private long addTo(int pos) {
        Date startArray = new Date();
        for(int i = 0; i < iter; i++) arrayList.add(pos, i);
        Date finishArray = new Date();
        long ArrayTime = finishArray.getTime() - startArray.getTime();
        return ArrayTime;
    }

    private long removeFrom(int pos) {
        Date startArray = new Date();
        if(pos==arrayList.size()-1) for(int i = 0; i < iter; i++) arrayList.remove(pos--);
        else for(int i = 0; i < iter; i++) arrayList.remove(pos);
        Date finishArray = new Date();
        long ArrayTime = finishArray.getTime() - startArray.getTime();
        return ArrayTime;
    }

    private long getFrom(int pos) {
        int curr;
        Date startArray = new Date();
        for(int i = 0; i < iter; i++) curr = arrayList.get(pos);
        Date finishArray = new Date();
        long ArrayTime = finishArray.getTime() - startArray.getTime();
        return ArrayTime;
    }



}
