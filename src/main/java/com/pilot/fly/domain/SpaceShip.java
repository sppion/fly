package com.pilot.fly.domain;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SpaceShip {
    private int horizontalPosition = 0, altitude=0, aim=0;
}
