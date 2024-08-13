package ifsc.edu.br.airplane_manager.domain.pilot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Pilot {

    @Id
    private UUID id;

    private LicenseType license;
}
