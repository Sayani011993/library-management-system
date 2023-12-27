package com.lms.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class BookControllerTest {
    @Autowired
    BookController bookController;

    @Test
    public void getBookListTest() {
        BookController bc = new BookController();
        Assertions.assertEquals(10, bc.getBookList().size());
    }

    @Test
    public void getBookListFailedTest() {
        BookController bc = new BookController();
        Assertions.assertEquals(5, bc.getBookList().size());
    }
}