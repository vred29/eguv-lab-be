package egov.lab.lab01.service;

import egov.lab.lab01.domain.ReportFisier;
import egov.lab.lab01.repository.ReportFisierRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class ReportService {

    @Autowired
    private ReportFisierRepository reportFisierRepository;

    @Autowired
    private ReservationService reservationService;

    @Value("${report.directorSalvare}")
    private String directorSalvare;

    public void generareRaport(String numeFisier) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String numeFisierCuTimestamp = numeFisier + "_" + timestamp + ".pdf";

            String caleAbsoluta = System.getProperty("user.dir") + File.separator + directorSalvare;
            File director = new File(caleAbsoluta);

            if (!director.exists()) {
                director.mkdirs();
            }

            File fisierPDF = new File(director, numeFisierCuTimestamp);

            try (PDDocument document = new PDDocument()) {
                // Creează un fișier PDF

                adaugaGraficDiscountStudent(document);

                document.save(fisierPDF);
            }

            System.out.println("Fișier PDF creat la: " + fisierPDF.getAbsolutePath());

            salveazaInBazaDeDate(numeFisierCuTimestamp, fisierPDF.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            // Tratează eroarea în funcție de necesitățile tale
        }
    }

    private void adaugaGraficDiscountStudent(PDDocument document) throws IOException {
        // Simulează datele din baza de date - numărul total de rezervări și numărul de rezervări cu discount de student
        int totalRezervari = reservationService.getTotalReservationNumber(); // înlocuiește cu logica ta pentru a obține numărul total de rezervări
        int rezervariCuDiscountStudent = reservationService.getTotalReservationStudentDiscountedNumber(); // înlocuiește cu logica ta pentru a obține numărul de rezervări cu discount de student

        // Calculează procentajul de rezervări cu discount de student
        double procentajDiscountStudent = (rezervariCuDiscountStudent * 100.0) / totalRezervari;

        // Creează un set de date pentru grafic
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Cu Discount Student", procentajDiscountStudent);
        dataset.setValue("Fără Discount Student", 100.0 - procentajDiscountStudent);

        // Creează un grafic circular (pie chart)
        JFreeChart chart = ChartFactory.createPieChart(
                "Procentaj Rezervări cu Discount Student",
                dataset,
                true, // afișează legenda
                true,
                false);

        // Converteste graficul în imagine
        BufferedImage bufferedImage = chart.createBufferedImage(400, 300);

        // Creează un obiect PDImageXObject din BufferedImage
        PDImageXObject pdImage = LosslessFactory.createFromImage(document, bufferedImage);

        // Adaugă imaginea în document
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.drawImage(pdImage, 100, 400);
        contentStream.close();

//        2


        // Simulează datele din baza de date - numărul total de rezervări și numărul de rezervări cu discount de student
        int rezervariPersoanaJuridica = reservationService.getTotalReservationPersoanaJuridica(); // înlocuiește cu logica ta pentru a obține numărul de rezervări cu discount de student

        // Calculează procentajul de rezervări cu discount de student
        double procentajRezervariPersoanaJuridica = (rezervariPersoanaJuridica * 100.0) / totalRezervari;


        // Creează un nou set de date pentru rezervari pe EJ
        DefaultPieDataset datasetElev = new DefaultPieDataset();
        datasetElev.setValue("Procent Persoane Juridice", procentajRezervariPersoanaJuridica);
        datasetElev.setValue("Procent Persoane Fizice", 100.0 - procentajRezervariPersoanaJuridica);

        // Creează un grafic circular (pie chart) pentru discount de elev
        JFreeChart chartDiscountElev = ChartFactory.createPieChart(
                "Procentaj Rezervări cu Persoane Juridice",
                datasetElev,
                true,
                true,
                false);

        // Converteste graficul în imagine pentru discount de elev
        BufferedImage bufferedImageDiscountElev = chartDiscountElev.createBufferedImage(400, 300);

        // Creează un obiect PDImageXObject din BufferedImage pentru discount de elev
        PDImageXObject pdImageDiscountElev = LosslessFactory.createFromImage(document, bufferedImageDiscountElev);

        // Adaugă imaginea pentru discount de elev în document
        PDPage pageDiscountElev = new PDPage();
        document.addPage(pageDiscountElev);
        PDPageContentStream contentStreamDiscountElev = new PDPageContentStream(document, pageDiscountElev);
        contentStreamDiscountElev.drawImage(pdImageDiscountElev, 100, 400);
        contentStreamDiscountElev.close();
    }

    private void salveazaInBazaDeDate(String numeFisier, String caleFisier) {
        ReportFisier raportFisier = new ReportFisier();
        raportFisier.setNumeFisier(numeFisier);
        raportFisier.setCaleFisier(caleFisier);
        reportFisierRepository.save(raportFisier);
    }

    public List<ReportFisier> getAll(){
        return reportFisierRepository.findAll();
    }

    public Optional<ReportFisier> getById(UUID reportId){
        return reportFisierRepository.findById(reportId);
    }
}
