package com.lms.service.iface;

import com.lms.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Book> getBookList();

    List<String> getBookNamesByAuthor(String author);

    int getBookCountByAuthor(String author);

    int getBookCount();

    List<Book> sortBookListByBookName(String order);

    void init();

    List<Book> addBook(Book book);

    List<Book> deleteBook(Book book);

    List<Book> deleteBookByAuthor(String author);


}

