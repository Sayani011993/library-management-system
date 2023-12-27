package com.lms.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder(setterPrefix = "set")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Slf4j
public class Book implements Comparable<Book> {
    String bookName;
    String author;

    @Override
    public int compareTo(Book book) {
        log.debug("comparing {} {}", this.getBookName(), book.getBookName());
        if (this.getBookName().compareTo(book.getBookName()) > 0) {
            return 1;
        }
        return -1;
    }
}
