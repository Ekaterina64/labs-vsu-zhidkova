import java.util.HashSet;
import java.util.Set;

public class Division_build {
    private final Set<Division> divisionSet = new HashSet<>();
    public Division Find_Division(String name) {
        for (Division division: divisionSet) {
            if (division.getName().equals(name)) {
                return division;
            }
        }
        Division division = new Division(name);
        divisionSet.add(division);
        return division;
    }
}
