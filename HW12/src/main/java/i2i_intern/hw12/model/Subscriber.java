package i2i_intern.hw12.model;


import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import java.time.LocalDate;


import java.time.LocalDate;

@Entity
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "tariff_id")
    private String tariffId;

    @Column(name = "registration_date")
    private LocalDate registrationDate;


    public static void addAttribute(String subscriber, Subscriber subscriber1) {

    }
}
