package inno.edu.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "username", unique = true)
    private String username;

    @Column(name = "fio")
    private String fio;

    public User(String username, String fio) {
        super();
        this.username = username;
        this.fio = fio;
    }
}
