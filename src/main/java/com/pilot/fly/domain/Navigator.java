package com.pilot.fly.domain;

public interface Navigator {
    void move(Direction action, int amount);
    void moveWithAim(Direction action, int amount);
}
