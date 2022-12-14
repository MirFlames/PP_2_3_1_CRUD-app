package web.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Setter @Getter
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "deposit")
    private BigDecimal deposit;

    public User(String name, String surname, BigDecimal deposit) {
        this.name = name;
        this.surname = surname;
        this.deposit = deposit;
    }
}
