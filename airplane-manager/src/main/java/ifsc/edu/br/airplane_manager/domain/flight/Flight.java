package ifsc.edu.br.airplane_manager.domain.flight;

import ifsc.edu.br.airplane_manager.domain.airplane.AbstractAirplaneEntity;
import ifsc.edu.br.airplane_manager.domain.pilot.Pilot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Flight {

    @Id
    private UUID id;

    private AbstractAirplaneEntity airplane;

    private Pilot pilot;
}
