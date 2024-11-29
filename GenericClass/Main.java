package GenericClass;

public class Main {
    public static void main(String[] args) {

        Doctor d = new Doctor("Robin", 22);

        d.setName("Robert", 0);
        d.setAge(33, 1);

        d.setName("Snew", 2);
        d.setAge(22, 3);

        d.display();
    }
}
