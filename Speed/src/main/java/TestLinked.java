import java.util.*;

public class TestLinked {

    private LinkedList<Integer> linkedList = new LinkedList<Integer>();
    private final int iter;

    public TestLinked(int iter, int size) {
        this.iter = iter;
        init(size);
    }

    private void init(int size) {
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
    }

    public long[] add() {
        //System.out.println("==============Add==============");
        long[] rez = {0, 0, 0};

        rez[0] = addTo(0);
        rez[1] = addTo(linkedList.size() / 2);
        rez[2] = addTo(linkedList.size() - 1);

        return rez;
    }

    private long addTo(int pos) {
        Date startLink = new Date();
        for(int i = 0; i < iter; i++) linkedList.add(pos, i);
        Date finishLink = new Date();
        long LinkedTime = finishLink.getTime() - startLink.getTime();
        return LinkedTime;
    }
}
