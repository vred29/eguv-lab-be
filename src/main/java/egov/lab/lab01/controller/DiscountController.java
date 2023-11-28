package egov.lab.lab01.controller;

import egov.lab.lab01.domain.dtos.DiscountDto;
import egov.lab.lab01.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService discountService;
    @GetMapping
    public List<DiscountDto> getAllDomains() {
        return discountService.getAllDiscounts();
    }

}
