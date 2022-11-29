

package com.library.service;

import com.library.entity.Book;
import com.library.exception.BookNotFoundException;
import com.library.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Override
    public Book getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return unwrapBook(book, id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    static Book unwrapBook(Optional<Book> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new BookNotFoundException(id);
        }
    }

}
