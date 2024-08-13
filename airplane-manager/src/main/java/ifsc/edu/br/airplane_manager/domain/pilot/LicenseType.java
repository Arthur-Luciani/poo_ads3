package ifsc.edu.br.airplane_manager.domain.pilot;

import ifsc.edu.br.airplane_manager.domain.airplane.AirplaneType;

public enum LicenseType {
    A {
        @Override
        public boolean canPilot(AirplaneType airplaneType) {
            return airplaneType == AirplaneType.AIRLINER;
        }
    },
    B {
        @Override
        public boolean canPilot(AirplaneType airplaneType) {
            return switch (airplaneType) {
                case AIRLINER, JET -> true;
                default -> false;
            };
        }
    },
    C {
        @Override
        public boolean canPilot(AirplaneType airplaneType) {
            return switch (airplaneType) {
                case AIRLINER, JET, CARGO -> true;
                default -> false;
            };
        }
    };

    public abstract boolean canPilot(AirplaneType airplaneType);
}

