package GenericInterface;

public class IntegerProcessor implements Processor<Integer>{

    @Override
    public Integer Process(Integer value) {
        return value * 2;
    }

    @Override
    public void print(Integer value) {
        System.out.println(value);
    }
}
