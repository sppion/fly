package com.pilot.fly.spaceship;

import com.pilot.fly.application.SpaceShipPilotPartTwoUseCase;
import com.pilot.fly.domain.SpaceShip;
import com.pilot.fly.infraestructure.ports.InputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SpaceShipPilotPartTwoUseCaseTest {
    @Mock
    private InputPort inputPort;

    private SpaceShipPilotPartTwoUseCase spaceShipPilotPartTwoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        spaceShipPilotPartTwoUseCase = new SpaceShipPilotPartTwoUseCase(inputPort);
    }

    @Test
    public void testForwardAddsToHorizontalPositionNoChangeInAltitude() throws Exception {
        String input = "forward 5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        when(inputPort.getInputMovement()).thenReturn(inputStream);
        spaceShipPilotPartTwoUseCase.run();
        SpaceShip spaceShip = spaceShipPilotPartTwoUseCase.getSpaceShip();
        assertEquals(5, spaceShip.getHorizontalPosition());
        assertEquals(0, spaceShip.getAltitude());
    }

    @Test
    public void testDownAddsToAim() throws Exception {
        String input = "down 5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        when(inputPort.getInputMovement()).thenReturn(inputStream);

        spaceShipPilotPartTwoUseCase.run();

        SpaceShip spaceShip = spaceShipPilotPartTwoUseCase.getSpaceShip();
        assertEquals(5, spaceShip.getAim());
    }
    @Test
    public void testForwardAddsToHorizontalPositionAndAltitude() throws Exception {
        String input = "down 5\nforward 8\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        when(inputPort.getInputMovement()).thenReturn(inputStream);
        spaceShipPilotPartTwoUseCase.run();
        SpaceShip spaceShip = spaceShipPilotPartTwoUseCase.getSpaceShip();
        assertEquals(8, spaceShip.getHorizontalPosition());
        assertEquals(40, spaceShip.getAltitude());
    }

    @Test
    public void testSpaceShipPilotPartTwoUseCase() throws Exception {
        String input = "forward 5\ndown 5\nforward 8\nup 3\ndown 8\nforward 2\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        when(inputPort.getInputMovement()).thenReturn(inputStream);
        spaceShipPilotPartTwoUseCase.run();
        SpaceShip spaceShip = spaceShipPilotPartTwoUseCase.getSpaceShip();
        assertEquals(15, spaceShip.getHorizontalPosition());
        assertEquals(60, spaceShip.getAltitude());
        assertEquals(900,spaceShip.getHorizontalPosition() * spaceShip.getAltitude());
    }
}
