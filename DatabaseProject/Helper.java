package DatabaseProject;

public class Helper {

    public static void showTitle(String name) {
        printStar(name, name.length());
    }

    public static void printStar(String name, int length) {
        System.out.println(name);
        for (int i=0; i<length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
