import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String sex;
    private int salary;
    private String birthDay;
    private Division division;

    public Employee(int ID, String name, String sex, String birthDay, Division division, int salary) {
        this.id = ID;
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.division = division;
        this.salary = salary;

    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public boolean Equals(Object obj) {
        if (this == obj) return true;
        //https://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html#axzz6dseTXbSd
        if((obj == null) || (obj.getClass() != this.getClass())) return false;
        Employee tmp = (Employee) obj;
        return id == tmp.id && salary == tmp.salary
                && (name != null && name.equalsIgnoreCase(tmp.getName()))
                && (sex != null && sex.equalsIgnoreCase(tmp.getSex()))
                && Objects.equals(birthDay, tmp.birthDay)//?
                && Objects.equals(division, tmp.division);
    }

    public String ToString() {
        return "id: " + id + ", name '" + name
                + "', sex '" + sex + "', birthDay " + birthDay
                + ',' + division + ", salary " + salary + ';';
    }

    public int HashCode() {
        return Objects.hash(id, name, sex, birthDay, division, salary);
    }
}
