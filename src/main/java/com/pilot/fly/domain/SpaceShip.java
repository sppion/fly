package com.pilot.fly.domain;

import lombok.Getter;

@Getter
public class SpaceShip implements Navigator{

    private static final Reactor reactor = new  Reactor();
    private static final AimedReactor aimedReactor = new  AimedReactor();
    private  int horizontalPosition = 0, altitude=0;

    @Override
    public void move(Direction action, int amount) {
        reactor.move(action,amount);
        horizontalPosition= reactor.getHorizontalPosition();
        altitude=reactor.getAltitude();
    }

    @Override
    public void moveWithAim(Direction action, int amount) {
        aimedReactor.move(action,amount);
        horizontalPosition= aimedReactor.getHorizontalPosition();
        altitude=aimedReactor.getAltitude();
    }
}
