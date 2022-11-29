


package com.library.service;

import com.library.entity.Book;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    
    
    Book getBook(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
    List<Book> getBooks();
}
