package com.lms.service.impl;

import com.lms.model.Book;
import com.lms.service.iface.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class BookServiceImplTest {
    static List<String> listOfBooksOfAuthor;
    static List<Book> listOfBooks;
    @Autowired
    BookService bookService;

    @BeforeAll
    public static void init() {
        log.info("start init Method");
        listOfBooksOfAuthor = Arrays.asList("Chaturanga", "Gitanjali", "Gora");
        Book b = Book.builder().setBookName("Ain-i-Akbari").setAuthor("Abul Fazal").build();
        Book b1 = Book.builder().setBookName("Arthashastra").setAuthor("Kautilya").build();
        Book b2 = Book.builder().setBookName("Ramayan").setAuthor("Valmiki").build();
        Book b3 = Book.builder().setBookName("Panchatantra").setAuthor("Pt.Vishnu Sharma").build();
        Book b4 = Book.builder().setBookName("Mudra Rakshas").setAuthor("Vishakhadatta").build();
        Book b5 = Book.builder().setBookName("Chaturanga").setAuthor("Rabindranath Tagore").build();
        Book b6 = Book.builder().setBookName("Gitanjali").setAuthor("Rabindranath Tagore").build();
        Book b7 = Book.builder().setBookName("Pather Panchali").setAuthor("Bibhutibhushan  Bandyopadhyay").build();
        Book b8 = Book.builder().setBookName("Ichhamati").setAuthor("Bibhutibhushan  Bandyopadhyay").build();
        Book b9 = Book.builder().setBookName("Gora").setAuthor("Rabindranath Tagore").build();
        listOfBooks = new ArrayList<>(Arrays.asList(b, b1, b2, b3, b4, b5, b6, b7, b8, b9));
        log.info("end init Method");
    }

    /* @BeforeEach
     public void initBeforeEach(){
         log.info("start init Method");
         bookService = new BookServiceImpl();
         bookService.init();
         log.info("end init Method");
     }*/
    @Test
    public void getBookListTest() {
        //log.info("List of books are {}",(bookService.getBookList().stream()).);
        bookService.getBookList().forEach(book -> log.info(book.toString()));

        Assertions.assertArrayEquals(listOfBooks.toArray(), bookService.getBookList().toArray());
    }

    @Test
    void getBookNamesByAuthorTest() {

        log.info("Booklist of Author {} {}",
                "Rabindranath Tagore",
                bookService.getBookNamesByAuthor("Rabindranath Tagore"));
        Assertions.assertEquals(listOfBooksOfAuthor, bookService.getBookNamesByAuthor("Rabindranath Tagore"));

    }

    @Test
    void getBookCountByAuthorTest() {

        Assertions.assertEquals(3, bookService.getBookNamesByAuthor("Rabindranath Tagore").size());
    }

    @Test
    void getBookCountTest() {
        Assertions.assertEquals(10, bookService.getBookList().size());
    }

    @Test
    void sortBookListByBookName() {
    }

    @Test
    void checkServiceHealth() {
    }

    @Test
    void addBookTest() {
    }

}