package com.pilot.fly.spaceship;

import com.pilot.fly.application.SpaceShipPilotPartOneUseCase;
import com.pilot.fly.infraestructure.ports.InputPort;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceShipPilotPartOneUseCaseTest {

    @Mock
    private InputPort inputPort;

    private SpaceShipPilotPartOneUseCase spaceShipPilotPartOneUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        spaceShipPilotPartOneUseCase = new SpaceShipPilotPartOneUseCase(inputPort);
    }
    @SneakyThrows
    @Test
    public void testMoveSpaceShipForward() {
        String input = "forward 5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        when(inputPort.getInputMovement()).thenReturn(inputStream);
        spaceShipPilotPartOneUseCase.run();
        assertEquals(5, spaceShipPilotPartOneUseCase.getSpaceShip().getHorizontalPosition());
        assertEquals(0, spaceShipPilotPartOneUseCase.getSpaceShip().getAltitude());
    }
    @SneakyThrows
    @Test
    public void testMoveSpaceShipUp() {
        String input = "up 3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        when(inputPort.getInputMovement()).thenReturn(inputStream);
        spaceShipPilotPartOneUseCase.run();
        assertEquals(0, spaceShipPilotPartOneUseCase.getSpaceShip().getHorizontalPosition());
        assertEquals(-3, spaceShipPilotPartOneUseCase.getSpaceShip().getAltitude());
    }

    @SneakyThrows
    @Test
    public void testMoveSpaceShipDown() {
        String input = "down 8\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        when(inputPort.getInputMovement()).thenReturn(inputStream);
        spaceShipPilotPartOneUseCase.run();
        assertEquals(0, spaceShipPilotPartOneUseCase.getSpaceShip().getHorizontalPosition());
        assertEquals(8, spaceShipPilotPartOneUseCase.getSpaceShip().getAltitude());
    }
    @SneakyThrows
    @Test
    public void testSpaceShipPilotPartOneUseCase()  {
        String input = "forward 5\ndown 5\nforward 8\nup 3\ndown 8\nforward 2\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        when(inputPort.getInputMovement()).thenReturn(inputStream);
        spaceShipPilotPartOneUseCase.run();
        assertEquals(15, spaceShipPilotPartOneUseCase.getSpaceShip().getHorizontalPosition());
        assertEquals(10, spaceShipPilotPartOneUseCase.getSpaceShip().getAltitude());
        assertEquals(150,spaceShipPilotPartOneUseCase.getSpaceShip().getHorizontalPosition()*spaceShipPilotPartOneUseCase.getSpaceShip().getAltitude());
    }
}