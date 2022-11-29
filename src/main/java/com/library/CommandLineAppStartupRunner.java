
package com.library;

import com.library.entity.Book;
import com.library.entity.Client;
import com.library.entity.Librarian;
import com.library.repository.BookRepository;
import com.library.repository.ClientRepository;
import com.library.repository.LendingRepository;
import com.library.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

     //Setting some data upon Startup
    //TO BE COMMENTED AFTER FIRST RUN 
    
    
    
//    @Autowired
//    ClientRepository clientRepository;
//    @Autowired
//    BookRepository bookRepository;
//    @Autowired
//    LendingRepository lendingRepository;
//    @Autowired
//    LibrarianRepository librarianRepository;

    @Override
    public void run(String... args) throws Exception {
        
        
//COMMENT FROM THIS LINE
        
//        
//        Client[] clients = new Client[]{
//            new Client("Harris", "jocker_t66@yahoo.gr"),
//            new Client("Maria", "maria95@yahoo.gr"),
//            new Client("Tasos", "babis@yahoo.gr"),};
//
//        for (int i = 0; i < clients.length; i++) {
//            clientRepository.save(clients[i]);
//        }
//
//        Book[] books = new Book[]{
//            new Book("Da Vinci Code", "A Medieval quest with a professor.", 10),
//            new Book("Iluminati", "The journey of professor contiues.", 20),
//            new Book("Alchemist", "A young shepered seeks the truth of life", 35)};
//
//        for (int i = 0; i < books.length; i++) {
//            bookRepository.save(books[i]);
//        }
//
//        Librarian[] librarians = new Librarian[]{
//            new Librarian("John Elder", "librarian@library.com")
//        };
//        for (int i = 0; i < librarians.length; i++) {
//            librarianRepository.save(librarians[i]);
//        }


// TO THIS LINE

    }
}
