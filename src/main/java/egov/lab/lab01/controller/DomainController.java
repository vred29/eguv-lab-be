package egov.lab.lab01.controller;

import egov.lab.lab01.domain.dtos.DomainDto;
import egov.lab.lab01.service.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/domains")
public class DomainController {
    private final DomainService domainService;

    @GetMapping
    public List<DomainDto> getAllDomains() {
        return domainService.getAllDomains();
    }
}
