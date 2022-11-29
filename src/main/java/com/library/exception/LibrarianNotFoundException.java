
package com.library.exception;

public class LibrarianNotFoundException extends RuntimeException {
    public LibrarianNotFoundException(Long id) {
        super("The librarian id '" + id + "' does not exist in our records");
    }
}
