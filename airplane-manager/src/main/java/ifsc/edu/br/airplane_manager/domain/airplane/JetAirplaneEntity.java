package ifsc.edu.br.airplane_manager.domain.airplane;

import ifsc.edu.br.airplane_manager.domain.airtrafficcontrol.airtrafficconditions.ConditionIntensity;

public class JetAirplaneEntity extends AbstractAirplaneEntity{


    @Override
    public boolean verifyEngine() {
        return false;
    }

    @Override
    public boolean verifyFlaps() {
        return false;
    }

    @Override
    public boolean verifyFuel() {
        return false;
    }

    @Override
    public boolean checkRunwayClearance() {
        return false;
    }

    @Override
    public void rainCondition(ConditionIntensity intensity) {

    }

    @Override
    public void windCondition(ConditionIntensity intensity) {

    }

    @Override
    public void unableToLand(Long delayTime) {

    }
}
