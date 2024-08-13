package ifsc.edu.br.airplane_manager.domain.airtrafficcontrol;

import ifsc.edu.br.airplane_manager.domain.airtrafficcontrol.airtrafficconditions.ConditionIntensity;
import ifsc.edu.br.airplane_manager.domain.airtrafficcontrol.airtrafficconditions.IAirplaneSubscriber;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AirTrafficService {

    private Map<AirTrafficControl, List<IAirplaneSubscriber>> airplaneSubscribers;

    public AirTrafficService() {
        this.airplaneSubscribers = new HashMap<>();
    }

    public void subscribe(AirTrafficControl airTrafficControl, IAirplaneSubscriber airplaneSubscriber) {
        Optional.ofNullable(airplaneSubscribers.get(airTrafficControl))
                .ifPresentOrElse(
                        subscribers -> subscribers.add(airplaneSubscriber),
                        () -> airplaneSubscribers.put(airTrafficControl, List.of(airplaneSubscriber)));
    }

    public void unsubscribe(AirTrafficControl airTrafficControl, IAirplaneSubscriber airplaneSubscriber) {
        Optional.ofNullable(airplaneSubscribers.get(airTrafficControl))
                .ifPresent(subscribers -> subscribers.remove(airplaneSubscriber));
    }

    public void rainCondition(AirTrafficControl airTrafficControl, ConditionIntensity intensity) {
        Optional.ofNullable(airplaneSubscribers.get(airTrafficControl))
                .ifPresent(subscribers -> subscribers.forEach(s -> s.rainCondition(intensity)));
    }

    public void windCondition(AirTrafficControl airTrafficControl, ConditionIntensity intensity) {
        Optional.ofNullable(airplaneSubscribers.get(airTrafficControl))
                .ifPresent(subscribers -> subscribers.forEach(s -> s.windCondition(intensity)));
    }

    public void unableToLand(AirTrafficControl airTrafficControl, Long delayTime) {
        Optional.ofNullable(airplaneSubscribers.get(airTrafficControl))
                .ifPresent(subscribers -> subscribers.forEach(s -> s.unableToLand(delayTime)));
    }

}
