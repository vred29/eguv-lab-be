package egov.lab.lab01.service;

import egov.lab.lab01.domain.*;
import egov.lab.lab01.domain.dtos.ReservationDto;
import egov.lab.lab01.repository.CourseRepository;
import egov.lab.lab01.repository.DiscountRepository;
import egov.lab.lab01.repository.ReservationRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final DiscountRepository discountRepository;
    private final CourseRepository courseRepository;

    public Reservation createReservation(ReservationDto reservationDto){
        Reservation reservation = new Reservation();
        reservation.setName(reservationDto.nume());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startingDate = LocalDate.parse(reservationDto.startingDate(), formatter);
        reservation.setStartingDate(startingDate);

        reservation.setCost(reservationDto.cost());

        DiscountCategory discountCategory = discountRepository.findByPercentage(reservationDto.discountCategory()).orElseThrow();
        reservation.setDiscountCategory(discountCategory);

        reservation.setContactData(
                new ContactData(reservationDto.surname(),
                        reservationDto.cnp(),
                        null,
                        reservationDto.seriesAndNumber(),
                        reservationDto.email(),
                        reservationDto.phone())
        );

        reservation.setAddress(
                new Address(reservationDto.judet(),
                        reservationDto.oras(),
                        reservationDto.street(),
                        reservationDto.codPostal())
        );

        Course course = courseRepository.findByName(reservationDto.course()).orElseThrow();
        reservation.setCourse(course);

        reservation.setObservatii(reservationDto.observatii());

        return reservationRepository.save(reservation);
    }

    public int getTotalReservationNumber(){
        return reservationRepository.findAll().size();
    }

    public int getTotalReservationStudentDiscountedNumber(){
        DiscountCategory discountCategory = discountRepository.findByName("Student").orElseThrow();
        return reservationRepository.findAllByDiscountCategory(discountCategory).size();
    }


    public int getTotalReservationPersoanaJuridica(){
        return (int) reservationRepository.findAll().stream().filter(reservation -> reservation.getContactData().getCui() != null).count();
    }

}
