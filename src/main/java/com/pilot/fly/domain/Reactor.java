package com.pilot.fly.domain;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Reactor {
    private int horizontalPosition = 0, altitude=0;

    public void move(Direction action, int amount){
        switch (action) {
            case FORWARD -> horizontalPosition=horizontalPosition+amount;
            case UP -> altitude=altitude-amount;
            case DOWN -> altitude=altitude+amount;
            default -> {

            }
        }
    }
}
