package com.library.service;

import com.library.entity.Librarian;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface LibrarianService {

    
    Librarian getLibrarian(Long id);
    Librarian saveLibrarian(Librarian librarian);
    void deleteLibrarian(Long id);
    List<Librarian> getLibrarians();
}
