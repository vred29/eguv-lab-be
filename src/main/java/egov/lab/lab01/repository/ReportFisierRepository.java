package egov.lab.lab01.repository;

import egov.lab.lab01.domain.ReportFisier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportFisierRepository extends JpaRepository<ReportFisier, UUID> {
}
