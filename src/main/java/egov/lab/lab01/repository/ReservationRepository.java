package egov.lab.lab01.repository;

import egov.lab.lab01.domain.DiscountCategory;
import egov.lab.lab01.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    List<Reservation> findAllByDiscountCategory(DiscountCategory discountCategory);
}
