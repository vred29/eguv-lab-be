package egov.lab.lab01.service;

import egov.lab.lab01.domain.dtos.DiscountDto;
import egov.lab.lab01.repository.DiscountRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class DiscountService {
    private final DiscountRepository discountRepository;

    public List<DiscountDto> getAllDiscounts() {
        return discountRepository.findAll()
                .stream().map(discountCategory -> new DiscountDto(discountCategory.getId(), discountCategory.getName(), discountCategory.getPercentage()))
                .collect(Collectors.toList());
    }
}
