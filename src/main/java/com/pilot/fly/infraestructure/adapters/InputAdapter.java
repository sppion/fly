package com.pilot.fly.infraestructure.adapters;

import com.pilot.fly.domain.Direction;
import com.pilot.fly.domain.Movement;
import com.pilot.fly.infraestructure.ports.InputPort;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class InputAdapter implements InputPort {
    private static final int DIRECTION=0;
    private static final int VALUE=1;
    private static final char FILE_DELIMITER=' ';

    private final Resource inputMovement;

    public InputAdapter(@Value("${input.file}") Resource inputMovement) {
        this.inputMovement = inputMovement;
    }

    @Override
    public List<Movement> getInputMovement() throws IOException {
        List<Movement> movementList = new ArrayList<>();
        try (InputStream inputStream = inputMovement.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             CSVParser csvParser = CSVFormat.newFormat(FILE_DELIMITER).parse(reader)) {

            for (CSVRecord record : csvParser) {
                Direction action = Direction.fromValue(record.get(DIRECTION));
                int value = Integer.parseInt(record.get(VALUE));
                Movement movement=new Movement(action,value);
                movementList.add(movement);
            }
        }
       return movementList;
    }
}
