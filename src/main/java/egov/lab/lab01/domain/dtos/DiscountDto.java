package egov.lab.lab01.domain.dtos;

import java.util.UUID;

public record DiscountDto(UUID id, String name,Long percentage) {
}
