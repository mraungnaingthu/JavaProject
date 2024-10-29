package com.mm.aungnaingthu.practice;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        TrafficLight light = TrafficLight.YELLOW;
        System.out.println();
        System.out.println(STR."Current light: \{light}");
        System.out.printf(STR."Duration: \{light.getDuration()} seconds%n");

        light = light.next();
        System.out.printf(STR."Next Light: \{light}");
        System.out.println();
    }
}
