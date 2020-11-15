import java.util.*;

public class TestLinked {

    private LinkedList<Integer> linkedList = new LinkedList<Integer>();
    private final int iter;

    public TestLinked(int iter, int size) {
        this.iter = iter;
        init(size);
    }

    private void init(int size) {
        for (int i = 1; i <= size; i++) {
            linkedList.add(i);
        }
    }

    public long[] add() {

        long[] rez = {0, 0, 0};

        rez[0] = addTo(0);
        rez[1] = addTo(linkedList.size() / 2);
        rez[2] = addTo(linkedList.size() - 1);

        return rez;
    }

    public long[] remove() {

        long[] rez = {0, 0, 0};

        rez[0] = removeFrom(0);
        rez[1] = removeFrom(linkedList.size()/2);
        rez[2] = removeFrom(linkedList.size() - 1);

        return rez;
    }

    public long[] get() {

        long[] rez = {0, 0, 0};

        rez[0] = getFrom(0);
        rez[1] = getFrom(linkedList.size()/2);
        rez[2] = getFrom(linkedList.size() - 1);

        return rez;
    }

    private long addTo(int pos) {
        Date startLink = new Date();
        if (pos == 0) for(int i = 0; i < iter; i++) linkedList.addFirst(i);
        else {
            if(pos == linkedList.size()-1) for(int i = 0; i < iter; i++) linkedList.addLast(i);
            else for(int i = 0; i < iter; i++) linkedList.add(linkedList.size()/2, i);
        }
        Date finishLink = new Date();
        long LinkedTime = finishLink.getTime() - startLink.getTime();
        return LinkedTime;
    }

    private long removeFrom(int pos) {
        Date startLink = new Date();
        if (pos == 0) for(int i = 0; i < iter; i++) linkedList.removeFirst();
        else {
            if(pos == linkedList.size()-1) for(int i = 0; i < iter; i++) linkedList.removeLast();
            else for(int i = 0; i < iter; i++) linkedList.remove(linkedList.size()/2);
        }
        Date finishLink = new Date();
        long LinkedTime = finishLink.getTime() - startLink.getTime();
        return LinkedTime;
    }

    private long getFrom(int pos) {
        Date startLink = new Date();
        int curr;
        if (pos == 0) for(int i = 0; i < iter; i++) curr = linkedList.getFirst();
        else {
            if (pos == linkedList.size() - 1) for(int i = 0; i < iter; i++) curr = linkedList.getLast();
            else for(int i = 0; i < iter; i++) curr = linkedList.get(linkedList.size() / 2);
        }
        Date finishLink = new Date();
        long LinkedTime = finishLink.getTime() - startLink.getTime();
        return LinkedTime;
    }
}
