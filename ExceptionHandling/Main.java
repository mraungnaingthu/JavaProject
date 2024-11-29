package ExceptionHandling;

public class Main{
    public static void main(String[] args) {
        try {
            int[] mainArr = test(new int[] {1, 2, 3});
        } catch (MyException e) {
            System.err.println(e.getMessage());;
        }
        System.out.println("Program Complete");

    }

    static int[] test(int[] number) throws MyException {
        for (int i=0; i<number.length+1; i++) {
            System.out.println(number[i]);
            throw new MyException("Error: Array index out of range");
        }
        System.out.println("Test method work");
        return number;
    }
}
