package GenericBounded;

public class NumBox<T extends Number>{

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
