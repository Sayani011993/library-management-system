package com.lms.service.impl;

import com.lms.model.Book;
import com.lms.service.iface.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.lms.constants.ModelConstants.ASC;
import static com.lms.constants.ModelConstants.DESC;

@Service
@Slf4j

public class BookServiceImpl implements BookService {
    List<Book> bookList;

    @Override
    public List<Book> getBookList() {

        return bookList;
    }

    @Override
    public List<String> getBookNamesByAuthor(String author) {

        if (StringUtils.isEmpty(author)) {
            log.error("author is not present in the request");
            throw new RuntimeException("Author is NULL or EMPTY");
        }
        List<String> myList = new ArrayList<>();

        for (Book bk : bookList) {
            if (bk.getAuthor().equals(author)) {
                myList.add(bk.getBookName());
            }
        }
        return myList;
    }

    @Override
    public int getBookCountByAuthor(String author) {

        return this.getBookNamesByAuthor(author).size();
    }

    @Override
    public int getBookCount() {

        return 0;
    }

    @Override
    public List<Book> sortBookListByBookName(String order) {
        /**
         * Stream always returns a new collection thats why it is returning stream but our need to return
         */
        switch (order) {
            case ASC: {
                log.info(" booklist before ascending sort :{}", bookList);
                return bookList.stream().sorted(Comparator.comparing(Book::getBookName)

                                .thenComparing(Book::getAuthor))
                        .collect(Collectors.toList());
            }
            case DESC: {
                log.info(" booklist before decending sort :{}", bookList);
                return bookList.stream().sorted(Comparator.comparing(Book::getBookName)
                                .thenComparing(Book::getAuthor)
                                .reversed())
                        .collect(Collectors.toList());
            }
            default: {
                log.info("the default booklist is:{}", bookList);
                return bookList.stream().sorted(Book::compareTo)
                        .collect(Collectors.toList());

            }
        }

    }


    @Override
    //@PostConstruct
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        log.info("Book Service is available.");
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
        bookList = new ArrayList<>(Arrays.asList(b, b1, b2, b3, b4, b5, b6, b7, b8, b9));
        log.info("Book List is initialised {}", bookList.size());
    }

    @Override
    public List<Book> addBook(Book book) {
        if (book == null)
            return null;
        bookList.add(book);
        return bookList;
    }


    public void addBook1(Book book) {
        if (Objects.isNull(book)) {
            log.warn("Book is null or empty");
            return;
        }
        bookList.add(book);
    }

    @Override
    public List<Book> deleteBook(Book book) {
        bookList.remove(book);
        return bookList;
    }

    public List<Book> deleteBookByAuthor(String author) {
        List<Book> deletedBooks = bookList.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
        // bookList.removeAll(deletedBooks);
        //get list of author and remove from the BookList
        bookList.removeIf(book -> book.getAuthor().equals(author));
        return deletedBooks;
    }
}
