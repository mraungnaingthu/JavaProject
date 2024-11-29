package GenericBounded;

public class StringBox<T extends String> {

    private T name;

    public void setValue(T name) {
        this.name = name;
    }

    public T getValue() {
        return name;
    }
}
