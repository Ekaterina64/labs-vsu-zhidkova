public class Main {
    public static void main(String[] args) {
        Container<String> arrString = new Container<>();
        arrString.add_el("I");
        arrString.add_el("like");
        arrString.add_el("Java");
        arrString.Show();
        arrString.set_el(1, "love");
        System.out.println(arrString.remove("3"));
        arrString.add_el(1,"very");
        arrString.Show();
        arrString.clear();

        Container<Integer> arrInteger = new Container<>();
        arrInteger.add_el(1);
        arrInteger.add_el(2);
        arrInteger.add_el(3);
        arrInteger.Show();
        arrInteger.remove(3);
        arrInteger.set_el(1, 5);
        arrInteger.Show();
        arrInteger.clear();
    }
}
