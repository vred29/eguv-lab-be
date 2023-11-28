package egov.lab.lab01.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DiscountCategory extends BaseEntity{
    private Long percentage;

    @OneToMany(mappedBy = "discountCategory", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
