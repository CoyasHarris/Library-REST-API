package com.library.controller;

import com.library.entity.Librarian;
import com.library.service.LibrarianService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/librarian")
@Tag(name = "Librarian Operations", description = "Create / Retrieve / Delete Librarians")

public class LibrarianController {

    @Autowired
    LibrarianService librarianService;

    @Operation(summary = "Gets a Librarian by Id.", description = "Returns a Librarian based on Id Given.",security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping("/{id}")
    public ResponseEntity<Librarian> getLibrarian(@PathVariable Long id) {
        return new ResponseEntity<>(librarianService.getLibrarian(id), HttpStatus.OK);
    }

    @Operation(summary = "Saves a  Librarian.", description = "Saves a Librarian from the provided Data.",security = @SecurityRequirement(name = "basicAuth"))
    @PostMapping
    public ResponseEntity<Librarian> saveLibrarian(@RequestBody Librarian librarian) {
        return new ResponseEntity<>(librarianService.saveLibrarian(librarian), HttpStatus.CREATED);
    }

    @Operation(summary = "Deletes a Librarian by Id.", description = "Deletes a Librarian based on Id Given.",security = @SecurityRequirement(name = "basicAuth"))
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLibrarian(@PathVariable Long id) {
        librarianService.deleteLibrarian(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Retrieves all Librarians.", description = "Provides a list of all Librarians.",security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping("/all")
    public ResponseEntity<List<Librarian>> getLibrarians() {
        return new ResponseEntity<>(librarianService.getLibrarians(), HttpStatus.OK);
    }

}
