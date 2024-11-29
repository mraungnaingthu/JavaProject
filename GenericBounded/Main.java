package GenericBounded;

public class Main {
    public static void main(String[] args) {

        NumBox<Integer> intBox = new NumBox<>();
        intBox.setValue(10);
        Integer intResult = intBox.getValue();
        System.out.println(intResult);

        StringBox<String> strBox = new StringBox<>();
        strBox.setValue("Robert");
        String strResult = strBox.getValue();
        System.out.println(strResult);
    }
}
