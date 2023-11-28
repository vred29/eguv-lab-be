package egov.lab.lab01.repository;

import egov.lab.lab01.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    List<Course> findAllByDomainId(UUID id);
    List<Course> findAllByDomainName(String name);
    Optional<Course> findByName(String name);
}
