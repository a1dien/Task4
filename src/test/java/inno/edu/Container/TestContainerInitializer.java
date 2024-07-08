package inno.edu.Container;

import inno.edu.model.User;
import inno.edu.repo.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TestContainerInitializer{
//    @LocalServerPort
//    private Integer port;

    static PostgreSQLContainer<?> posgres = new PostgreSQLContainer<>(
            "postgres:12.19-alpine3.20"
    );

    @BeforeAll
    static void beforeAll() {
        posgres.start();
    }

    @AfterAll
    static void afterAll() {
        posgres.stop();
    }

    @DynamicPropertySource
    static void confgireProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", posgres::getJdbcUrl);
        registry.add("spring.datasource.username", posgres::getUsername);
        registry.add("spring.datasource.password", posgres::getPassword);
    }

    @Autowired
    UserRepository userRepository;

    User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setUsername("UserName");
        testUser.setFio("Фамилия Имя Отчество");
        userRepository.save(testUser);
    }

    @Test
    void findUser() {
        User savedUser = userRepository.findById(testUser.getId()).orElse(null);
        assertNotNull(savedUser);
        assertEquals(testUser.getUsername(), savedUser.getUsername());
        assertEquals(testUser.getFio(), savedUser.getFio());
    }

}
