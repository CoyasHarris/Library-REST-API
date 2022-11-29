


package com.library.exception;


public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(Long id) {
        super("The client id '" + id + "' does not exist in our records");
    }
    
}
    
    

