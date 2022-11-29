

package com.library.service;


import com.library.entity.Librarian;
import com.library.exception.LibrarianNotFoundException;
import com.library.repository.LibrarianRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LibrarianServiceImpl implements LibrarianService{
    
    @Autowired
    LibrarianRepository librarianRepository;
    
    
    @Override
    public Librarian getLibrarian(Long id) {
        Optional<Librarian> librarian = librarianRepository.findById(id);
        return unwrapLibrarian(librarian, id);
    }

    @Override
    public Librarian saveLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    @Override
    public void deleteLibrarian(Long id) {
        librarianRepository.deleteById(id);

    }

    @Override
    public List<Librarian> getLibrarians() {
        return (List<Librarian>) librarianRepository.findAll();
    }

    static Librarian unwrapLibrarian(Optional<Librarian> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new LibrarianNotFoundException(id);
        }
    }
    
    
}
