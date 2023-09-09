package com.pilot.fly.application;
import com.pilot.fly.domain.Movement;
import com.pilot.fly.infraestructure.ports.InputPort;
import com.pilot.fly.domain.SpaceShip;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpaceShipPilotPartOneUseCase implements CommandLineRunner {

    private final InputPort inputPort;
    private final SpaceShip spaceShip=new SpaceShip();

    @Override
    public void run(String... args) throws Exception {

        List<Movement> movementList = inputPort.getInputMovement();
        movementList.forEach(movement -> spaceShip.move(movement.direction(),movement.value()));
        int result = spaceShip.getHorizontalPosition() * spaceShip.getAltitude();
        log.info("What do you get if you multiply your final horizontal position by your final altitude?: ("
                +spaceShip.getHorizontalPosition()+")*("+spaceShip.getAltitude()+ ")="+ result);
     }

}
