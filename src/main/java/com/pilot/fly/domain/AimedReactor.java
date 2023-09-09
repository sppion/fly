package com.pilot.fly.domain;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AimedReactor {
    private int horizontalPosition = 0, altitude=0, aim=0;

    public void move(Direction action, int amount) {
        switch (action) {
            case FORWARD -> {
                horizontalPosition = horizontalPosition + amount;
                altitude = altitude + aim * amount;
            }
            case UP -> aim= aim - amount;
            case DOWN -> aim = aim + amount;
            default -> {
            }
        }
    }
}
