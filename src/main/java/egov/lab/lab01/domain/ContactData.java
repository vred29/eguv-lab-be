package egov.lab.lab01.domain;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ContactData{
    private String surname;
    private String cnp;
    private String cui;
    private String seriesAndNumber;
    private String email;
    private String phone;
}
