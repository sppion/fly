package com.pilot.fly.domain;

public enum Direction {
    FORWARD("forward"),
    UP("up"),
    DOWN("down");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public static Direction fromValue(String value) {
        for (Direction direction : Direction.values()) {
            if (direction.value.equalsIgnoreCase(value)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Invalid Direction value: " + value);
    }
}