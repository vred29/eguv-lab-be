package egov.lab.lab01.controller;

import egov.lab.lab01.domain.Reservation;
import egov.lab.lab01.domain.dtos.ReservationDto;
import egov.lab.lab01.service.PdfGenerationService;
import egov.lab.lab01.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final PdfGenerationService pdfGenerationService;

    @PostMapping
    public ResponseEntity<byte[]> createReservation(@RequestBody ReservationDto reservationDto) throws IOException {
        // Save the reservation in the database
        // ...
        Reservation createdReservation = reservationService.createReservation(reservationDto);

        // Generate PDF for the reservation
        byte[] pdfBytes = pdfGenerationService.generateReservationPdf(createdReservation);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Set the Content-Disposition header to indicate how browsers should handle the response (e.g., download as a file)
        headers.setContentDispositionFormData("reservation.pdf", "reservation.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }
}
