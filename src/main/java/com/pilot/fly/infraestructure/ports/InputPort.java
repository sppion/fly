package com.pilot.fly.infraestructure.ports;

import com.pilot.fly.domain.Movement;

import java.io.IOException;
import java.util.List;

public interface InputPort {
    List<Movement> getInputMovement() throws IOException;
}
