package egov.lab.lab01.controller;

import egov.lab.lab01.domain.dtos.CourseDto;
import egov.lab.lab01.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/byId")
    public List<CourseDto> getCoursesByDomainId(@RequestParam UUID domainId) {
        return courseService.getCoursesByDomainId(domainId);
    }

    @GetMapping("/byName")
    public List<CourseDto> getCoursesByDomainName(@RequestParam String domainName) {
        return courseService.getCoursesByDomainName(domainName);
    }
}
