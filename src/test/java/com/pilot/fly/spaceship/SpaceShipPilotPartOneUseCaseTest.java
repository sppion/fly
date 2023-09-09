package com.pilot.fly.spaceship;

import com.pilot.fly.application.SpaceShipPilotPartOneUseCase;
import com.pilot.fly.domain.Direction;
import com.pilot.fly.domain.Movement;
import com.pilot.fly.infraestructure.ports.InputPort;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class SpaceShipPilotPartOneUseCaseTest {

    @Mock
    private InputPort inputPort;

    @InjectMocks
    private SpaceShipPilotPartOneUseCase spaceShipPilotPartOneUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @SneakyThrows
    @Test
    void testSpaceShipMovingForward() {
        List<Movement> movementList = new ArrayList<>();
        movementList.add(new Movement(Direction.FORWARD, 10));
        when(inputPort.getInputMovement()).thenReturn(movementList);
        spaceShipPilotPartOneUseCase.run();

        verify(inputPort, times(1)).getInputMovement();
    }
}