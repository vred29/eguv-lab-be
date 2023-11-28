package egov.lab.lab01.service;

import egov.lab.lab01.repository.DomainRepository;
import egov.lab.lab01.domain.dtos.DomainDto;
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
public class DomainService {
    private final DomainRepository domainRepository;

    public List<DomainDto> getAllDomains() {
        return domainRepository.findAll()
                .stream().map(domain -> new DomainDto(domain.getId(), domain.getName()))
                .collect(Collectors.toList());
    }
}
