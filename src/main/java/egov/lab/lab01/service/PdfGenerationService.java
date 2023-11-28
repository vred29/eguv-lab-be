package egov.lab.lab01.service;

import egov.lab.lab01.domain.Reservation;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Service
public class PdfGenerationService {
    public byte[] generateReservationPdf(Reservation reservation) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.setLeading(14); // Set the line height (adjust as needed)
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 750);

            contentStream.showText("Reservation Details");
            contentStream.newLine();
            contentStream.newLine();

            contentStream.setFont(PDType1Font.HELVETICA, 10);

            contentStream.showText("COURSE DATA");
            contentStream.newLine();
            contentStream.showText("Course Name: " + reservation.getCourse().getName());
            contentStream.newLine();
            contentStream.showText("Starting Date: " + reservation.getStartingDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            contentStream.newLine();
            contentStream.showText("Duration: " + reservation.getCourse().getDuration());
            contentStream.newLine();
            contentStream.showText("Cost: " + reservation.getCost() + " Lei");
            contentStream.newLine();
            contentStream.showText("Discount Category: " + reservation.getDiscountCategory().getName());
            contentStream.newLine();

            contentStream.showText("CONTACT DATA");
            contentStream.newLine();
            contentStream.showText("Name: " + reservation.getName());
            contentStream.newLine();
            contentStream.showText("Surname: " + reservation.getContactData().getSurname());
            contentStream.newLine();
            contentStream.showText("CNP: " + reservation.getContactData().getCnp());
            contentStream.newLine();
            contentStream.showText("Series and Number: " + reservation.getContactData().getSeriesAndNumber());
            contentStream.newLine();
            contentStream.showText("Email: " + reservation.getContactData().getEmail());
            contentStream.newLine();
            contentStream.showText("Phone: " + reservation.getContactData().getPhone());
            contentStream.newLine();

            contentStream.showText("ADDRESS DATA");
            contentStream.newLine();
            contentStream.showText("Judet: " + reservation.getAddress().getJudet());
            contentStream.newLine();
            contentStream.showText("Oras: " + reservation.getAddress().getOras());
            contentStream.newLine();
            contentStream.showText("Strada: " + reservation.getAddress().getStreet());
            contentStream.newLine();
            contentStream.showText("Cod Postal: " + reservation.getAddress().getCodPostal());
            contentStream.newLine();

            contentStream.showText("Observatii: " + reservation.getObservatii());
            contentStream.endText();
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.save(byteArrayOutputStream);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
