package ifsc.edu.br.airplane_manager.domain.airtrafficcontrol.airtrafficconditions;

public interface IAirplaneSubscriber {

    void rainCondition(ConditionIntensity intensity);

    void windCondition(ConditionIntensity intensity);

    void unableToLand(Long delayTime);
}
