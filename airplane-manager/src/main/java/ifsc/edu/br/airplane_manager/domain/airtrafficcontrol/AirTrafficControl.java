package ifsc.edu.br.airplane_manager.domain.airtrafficcontrol;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class AirTrafficControl {

    @Id
    private UUID id;

}
