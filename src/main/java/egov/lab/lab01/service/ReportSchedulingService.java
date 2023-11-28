package egov.lab.lab01.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class ReportSchedulingService {

    @Autowired
    ReportService reportService;

    @Scheduled(cron = "0 0 0 * * 0")  // Rulează saptamanal, la miezul noptii in prima zi a saptamanii
    public void generareRaportLunar() {
        try {
            reportService.generareRaport("raport_achizitii_lunar.pdf");
            // Poți adăuga și alte acțiuni sau trimite notificări după generarea raportului
        } catch (Exception e) {
            e.printStackTrace();
            // Tratează eroarea așa cum consideri necesar
        }
    }
}
