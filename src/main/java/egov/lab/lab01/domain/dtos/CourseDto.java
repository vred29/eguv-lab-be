package egov.lab.lab01.domain.dtos;

import java.util.UUID;

public record CourseDto(UUID id, String name, Long duration, Long numberOfPersons, Long price) {
}
