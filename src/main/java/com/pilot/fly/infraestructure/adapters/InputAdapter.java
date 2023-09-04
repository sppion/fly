package com.pilot.fly.infraestructure.adapters;

import com.pilot.fly.infraestructure.ports.InputPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class InputAdapter implements InputPort {

    private final Resource inputMovement;

    public InputAdapter(@Value("${input.file}") Resource inputMovement) {
        this.inputMovement = inputMovement;
    }

    @Override
    public InputStream getInputMovement() throws IOException {
        return inputMovement.getInputStream();
    }
}
