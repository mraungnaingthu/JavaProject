package GenericInterface;

public interface Processor<T> {

    T Process(T value);
    void print(T value);
}
