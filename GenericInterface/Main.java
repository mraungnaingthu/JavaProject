package GenericInterface;

public class Main {
    public static void main(String[] args) {

        Processor<String> stringProcessor = new StringProcessor();
        String resultStr = stringProcessor.Process("hello java programming");
        stringProcessor.print(resultStr);

        Processor<Integer> integerProcessor = new IntegerProcessor();
        Integer resultInt = integerProcessor.Process(22);
        integerProcessor.print(resultInt);
    }
}
