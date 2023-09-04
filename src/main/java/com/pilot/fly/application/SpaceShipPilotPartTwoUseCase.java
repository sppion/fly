package com.pilot.fly.application;

import com.pilot.fly.infraestructure.ports.InputPort;
import com.pilot.fly.domain.SpaceShip;
import com.pilot.fly.domain.Direction;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
@Slf4j
@Getter
public class SpaceShipPilotPartTwoUseCase implements CommandLineRunner {

    private static final int DIRECTION=0;
    private static final int VALUE=1;
    private static final char FILE_DELIMITER=' ';

    private final InputPort inputPort;
    private final SpaceShip spaceShip=new SpaceShip();

    @Override
    public void run(String... args) throws Exception {


        try (InputStream inputStream = inputPort.getInputMovement();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             CSVParser csvParser = CSVFormat.newFormat(FILE_DELIMITER).parse(reader)) {

            for (CSVRecord record : csvParser) {
                Direction action = Direction.fromValue(record.get(DIRECTION));
                int value = Integer.parseInt(record.get(VALUE));
                moveSpaceShip(spaceShip,action,value);
            }

            int result =spaceShip.getHorizontalPosition() * spaceShip.getAltitude();
            log.info("What do you get if you multiply your final horizontal position by your final altitude?: ("
                    +spaceShip.getHorizontalPosition()+")*("+spaceShip.getAltitude()+ ")="+ result);
        }

    }
    public SpaceShip moveSpaceShip(SpaceShip spaceShip, Direction action, int amount) {
        switch (action) {
            case FORWARD -> {
                spaceShip.setHorizontalPosition(spaceShip.getHorizontalPosition() + amount);
                spaceShip.setAltitude(spaceShip.getAltitude() + spaceShip.getAim() * amount);
            }
            case UP -> spaceShip.setAim(spaceShip.getAim() - amount);
            case DOWN -> spaceShip.setAim(spaceShip.getAim() + amount);
            default -> {
            }
        }
        return spaceShip;
    }
}
