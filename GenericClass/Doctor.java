package GenericClass;

public class Doctor<T> {
    private T name;
    private T age;
    private T[] people;

    public Doctor(T name, T age) {
        this.name = name;
        this.age = age;
        this.people = (T[]) new Object[4];
    }

    public T getName() {
        return name;
    }

    public void setName(T name, T index) {
        this.name = name;
        this.people[(int) index] = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age, T index) {
        this.age = age;
        this.people[(int) index] = age;
    }

    public void display() {
        /*for (int i=0; i<people.length; i++){
            System.out.printf("Item at index %d: %s%n", i, people[i]);
        }*/
        for (T element : people) {
            System.out.println(element);
        }
    }


}
