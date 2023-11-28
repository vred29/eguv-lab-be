package egov.lab.lab01.domain.dtos;

public record ReservationDto(String nume, String startingDate, Long cost, Long discountCategory, String surname,
                             String cnp, String cui, String seriesAndNumber, String email, String phone, String judet,
                             String oras, String street, String codPostal, String course, String observatii) {
}
