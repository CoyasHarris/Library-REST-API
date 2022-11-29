
package com.library.exception;


public class LendingNotFoundException extends RuntimeException{
    
     public LendingNotFoundException(Long clientId , Long bookId) {
        super("The lending id '" + clientId + "'book id :" + bookId + " does not exist in our records");
    }
    
}
