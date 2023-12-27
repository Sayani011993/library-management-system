package com.lms.model.response;

import com.lms.model.Book;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder(setterPrefix = "set")
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBookResponse {
    List<Book> deletedBooks;
    List<Book> updatedBookList;
}
