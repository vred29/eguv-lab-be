package egov.lab.lab01.repository;

import egov.lab.lab01.domain.DiscountCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountCategory, UUID> {
    Optional<DiscountCategory> findByPercentage(Long percentage);

    Optional<DiscountCategory> findByName(String name);
}
