package com.pilot.fly.spaceship;

import com.pilot.fly.application.SpaceShipPilotPartTwoUseCase;
import com.pilot.fly.domain.Direction;
import com.pilot.fly.domain.Movement;

import com.pilot.fly.infraestructure.ports.InputPort;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class SpaceShipPilotPartTwoUseCaseTest {
    @Mock
    private InputPort inputPort;

    @InjectMocks
    private SpaceShipPilotPartTwoUseCase spaceShipPilotPartTwoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @SneakyThrows
    @Test
    void testRun() {
        List<Movement> movementList = new ArrayList<>();
        movementList.add(new Movement(Direction.FORWARD, 10));
        when(inputPort.getInputMovement()).thenReturn(movementList);
        spaceShipPilotPartTwoUseCase.run();

        verify(inputPort, times(1)).getInputMovement();
    }
}
