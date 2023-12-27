package com.lms.controller;

import com.lms.model.Book;
import com.lms.model.response.DeleteBookResponse;
import com.lms.service.iface.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController(value = "Book Controller")
public class BookController {

    @Autowired
    BookService bookService;

    //getBookList, search(bookName, Author, )sort(byAuthor, byBookName, publishedDate, publishedMonth, publishedYear)
    @GetMapping(path = "/getBookList", name = "Returns All book list")
    public List<Book> getBookList() {
        //bookService=new BookServiceImpl();
        return bookService.getBookList();
    }

    @PostMapping(path = "/getBookNamesByAuthor", name = "Return book list by Author")
    public List<String> getBookNamesByAuthor(String author) {
        return bookService.getBookNamesByAuthor(author);
    }

    @PostMapping(path = "/getBookCountByAuthor", name = "Return Book Count By Author")
    public int getBookCountByAuthor(@RequestBody String author) {
        return bookService.getBookCountByAuthor(author);
    }

    @PostMapping(path = "/addBook", name = "add a Book")
    public List<Book> addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping(path = "/delete-book", name = "delete a Book")
    public List<Book> deleteBook(@RequestBody Book book) {

        return bookService.deleteBook(book);
    }

    @DeleteMapping(path = "/delete-book-by-author", name = "delete Books by Author")
    public DeleteBookResponse deleteBookByAuthor(@RequestParam(value = "authorName") String author) {

        return DeleteBookResponse.builder()
                .setDeletedBooks(bookService.deleteBookByAuthor(author))
                .setUpdatedBookList(bookService.getBookList())
                .build();
    }

    @PostMapping(path = "/sortBookListByBookName", name = "sort bookList by BookName")
    public List<Book> sortBookListByBookName(String order) {
        log.info("value of order is {}", order);
        return bookService.sortBookListByBookName(order);
    }
}
