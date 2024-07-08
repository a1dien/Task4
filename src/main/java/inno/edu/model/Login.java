package inno.edu.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Entity
@Table(name = "logins")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Login {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "access_date")
    private Timestamp accessDate;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "application")
    private String application;

    public Login(Timestamp accessDate, Long Id, String application) {
        super();
        this.accessDate = accessDate;
        this.userId = Id;
        this.application = application;
    }
}
