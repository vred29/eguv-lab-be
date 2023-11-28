package egov.lab.lab01.controller;

import egov.lab.lab01.domain.ReportFisier;
import egov.lab.lab01.domain.dtos.ReportFisierDto;
import egov.lab.lab01.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.nio.file.Paths.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

//    @GetMapping("/{id}/pdf")
//    public ResponseEntity<byte[]> generareRaportPDF() {
//
//    }

    @GetMapping
    public List<ReportFisierDto> toateFisierelePDF() {
        List<ReportFisier> rapoarte = reportService.getAll();

        return rapoarte.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{reportId}/pdf")
    public ResponseEntity<Resource> downloadPDF(@PathVariable UUID reportId) throws IOException {
        Optional<ReportFisier> optionalRaport = reportService.getById(reportId);

        if (optionalRaport.isPresent()) {
            ReportFisier raport = optionalRaport.get();
            Path filePath = get(raport.getCaleFisier());

            InputStream inputStream = new FileInputStream(filePath.toFile());
            InputStreamResource resource = new InputStreamResource(inputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + raport.getNumeFisier());

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    private ReportFisierDto mapToDto(ReportFisier raport) {
        return new ReportFisierDto(raport.getId(), raport.getNumeFisier());
    }
}
