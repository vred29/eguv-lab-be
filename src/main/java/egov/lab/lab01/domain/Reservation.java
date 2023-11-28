package egov.lab.lab01.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation extends BaseEntity{
    private LocalDate startingDate;
    private Long cost;
    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private DiscountCategory discountCategory;


    @Embedded
    private ContactData contactData;
    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    private String observatii;

}
