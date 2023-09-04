package com.pilot.fly.infraestructure.ports;

import java.io.IOException;
import java.io.InputStream;

public interface InputPort {
    InputStream getInputMovement() throws IOException;
}
