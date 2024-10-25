public enum TrafficLight {
    RED(30), YELLOW(5), GREEN(25);

    private final int duration;

    TrafficLight(int duration){
        this.duration = duration;
    }

    public int getDuration(){
        return duration;
    }

    public TrafficLight next() throws IllegalAccessException {
        switch (this){
            case RED -> {
                return GREEN;
            }
            case YELLOW -> {
                return RED;
            }
            case GREEN -> {
                return YELLOW;
            }
            default -> throw new IllegalAccessException("Unexpected value: " +this);
        }
    }
}
