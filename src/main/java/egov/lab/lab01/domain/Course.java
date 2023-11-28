package egov.lab.lab01.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Course extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "domain_id", referencedColumnName = "id")
    private Domain domain;

    private Long price;
    private Long duration;
    private Long numberOfPersons;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
