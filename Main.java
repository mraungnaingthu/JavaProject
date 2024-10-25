public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        TrafficLight light = TrafficLight.YELLOW;
        System.out.println();
        System.out.println("Current light: " + light);
        System.out.printf("Duration: "+ light.getDuration() + " seconds%n");

        light = light.next();
        System.out.printf("Next Light: " + light);
        System.out.println();
    }
}
