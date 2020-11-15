import java.util.Objects;

public class Division {
    private int id;
    private String name;
    private static int ID = 1;


    public Division(String name) {
        this.id = ID++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int HashCode() {return Objects.hash(id, name);}

     public String ToString() {
        return " Division {id: " + id + ", name: '" + name + "'}";
    }

    public boolean Equals(Object obj) {
        if (this == obj) return true;
        //https://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html#axzz6dseTXbSd
        if((obj == null) || (obj.getClass() != this.getClass())) return false;
        Division tmp = (Division) obj;
        return id == tmp.id
                && (name != null && name.equalsIgnoreCase(tmp.getName()));
    }
}
