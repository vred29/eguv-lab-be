package egov.lab.lab01.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ReportFisier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    private String numeFisier;

    private String caleFisier;
}
