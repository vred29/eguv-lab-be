package egov.lab.lab01.service;

import egov.lab.lab01.domain.dtos.CourseDto;
import egov.lab.lab01.repository.CourseRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseDto> getCoursesByDomainId(UUID domainId) {
        return courseRepository.findAllByDomainId(domainId)
                .stream().map(course -> new CourseDto(course.getId(), course.getName(), course.getDuration(),
                        course.getNumberOfPersons(), course.getPrice()))
                .collect(Collectors.toList());

    }

    public List<CourseDto> getCoursesByDomainName(String name) {
        return courseRepository.findAllByDomainName(name)
                .stream().map(course -> new CourseDto(course.getId(), course.getName(), course.getDuration(),
                        course.getNumberOfPersons(), course.getPrice()))
                .collect(Collectors.toList());

    }
}
