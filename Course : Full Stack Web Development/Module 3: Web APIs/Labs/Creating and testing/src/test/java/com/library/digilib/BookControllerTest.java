package com.library.digilib;

import com.library.digilib.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
//TODO 9: Create a test class BookControllerTest in src/test/java/com/library/digilib.
//TODO 10:Annotate the class with @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) to load Spring Boot Context with testing it on a random port.


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    @LocalServerPort
    private int port;

    //TODO 11: Also inject TestRestTemplate to make REST calls.
    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;
    private final String books = "(1,'Spring Boot in Action','Craig Walls','2015-11-01',1),\n" +
            "    (2,'Effective Java','Joshua Bloch','2018-01-06',0),\n" +
            "    (3,'Clean Code: A Handbook of Agile Software Craftsmanship','Robert C. Martin','2008-08-11',1),\n" +
            "    (4,'Head First Java','Kathy Sierra, Bert Bates','2005-02-09',1),\n" +
            "    (5,'Java: The Complete Reference','Herbert Schildt','2019-11-01',0),\n" +
            "    (6,'Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides','1994-10-21',1);";

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/books";
    }

    //TODO 14: Write a unit test for the GET /books/{id} method.
    @Test
    public void shouldReturnProductById() {
        // Act
        ResponseEntity<Book> response = restTemplate.getForEntity(baseUrl + "/1", Book.class);
        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(1L);
        assertThat(response.getBody().getTitle()).isEqualTo("Spring Boot in Action");
    }
    //TODO 12: Write a unit test for the POST /books/{id}/borrow method.

    @Test
    public void shouldBorrowProduct() {
        // Act
        ResponseEntity<Book> response = restTemplate.postForEntity(baseUrl + "/1/borrow", null, Book.class);
        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().isAvailable());
    }

    //TODO 13: Write a unit test for the POST /books/{id}/return method.
    @Test
    public void shouldReturnProduct() {
        // Act
        ResponseEntity<Book> response = restTemplate.postForEntity(baseUrl + "/2/return", null,  Book.class);
        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(!response.getBody().isAvailable());
    }
}

