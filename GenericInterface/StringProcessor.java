package GenericInterface;

public class StringProcessor implements Processor<String> {

    @Override
    public String
    Process(String value) {
        return value.toUpperCase();
    }

    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
