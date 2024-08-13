package ifsc.edu.br.airplane_manager.domain.airplane.airplaneVerifications;

public interface IAirplaneVerification {
    boolean verifyEngine();

    boolean verifyFlaps();

    boolean verifyFuel();

    boolean checkRunwayClearance();
}
