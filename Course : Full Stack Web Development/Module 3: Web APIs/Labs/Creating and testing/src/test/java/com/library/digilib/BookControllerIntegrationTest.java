package com.library.digilib;

import com.library.digilib.model.Book;
import com.library.digilib.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
//TODO 14: Create an integration test class BookControllerIntegrationTest in src/test/java/com/library/digilib.
//TODO 15: Annotate the class with @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) to load Spring Boot Context with testing it on a random port.


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {

    private Long bookId;

    //TODO 16: Also inject TestRestTemplate to make REST calls and BookRepository to make DB CRUD calls.
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private BookRepository bookRepository;

    private final String baseUrl = "/books";
    @BeforeEach
    public void setUp(){
        Book book = new Book();
        book.setAuthor("Random Author");
        book.setTitle("Random Title");
        book.setPublicationDate(new java.sql.Date(2024,12,1));
        book.setAvailable(true);
        bookRepository.save(book);
        bookId = book.getId();
    }

    @AfterEach
    public void tearDown(){
        bookRepository.deleteById(bookId);
    }

    //TODO 17: Create  integration test methods for POST /books/{id}/borrow, POST /books/{id}/return and GET /books/{id}
    // Integration test for GET /products/{id}
    @Test
    public void integrationTestGetBook() {
        ResponseEntity<Book> response = restTemplate.getForEntity(baseUrl+"/"+bookId, Book.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(bookId);

    }

    // Integration test for POST /products/{id}/borrow
    @Test
    public void integrationTestBorrowBook() {
        ResponseEntity<Book> response = restTemplate.postForEntity(baseUrl+"/"+bookId+"/borrow", null, Book.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertFalse(response.getBody().isAvailable());
        assertThat(response.getBody().getId()).isEqualTo(bookId);

    }

    // Integration test for POST /products/{id}/return
    @Test
    public void integrationTestReturnBook() {
        Optional<Book> book = bookRepository.findById(bookId);
        Book tempBook = book.get();
        tempBook.setAvailable(false);
        bookRepository.save(tempBook);
        ResponseEntity<Book> response = restTemplate.postForEntity(baseUrl+"/"+bookId+"/return", null, Book.class);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertTrue(response.getBody().isAvailable());
        assertThat(response.getBody().getId()).isEqualTo(bookId);

    }



}

