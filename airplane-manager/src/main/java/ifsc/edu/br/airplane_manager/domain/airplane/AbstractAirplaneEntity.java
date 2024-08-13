package ifsc.edu.br.airplane_manager.domain.airplane;

import ifsc.edu.br.airplane_manager.domain.airplane.airplaneVerifications.IAirplaneVerification;
import ifsc.edu.br.airplane_manager.domain.airtrafficcontrol.airtrafficconditions.IAirplaneSubscriber;
import jakarta.persistence.Entity;

@Entity
public abstract class AbstractAirplaneEntity implements IAirplaneVerification, IAirplaneSubscriber {
}
