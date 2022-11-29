package com.library.service;

import com.library.entity.Book;
import com.library.entity.Client;
import com.library.entity.Lending;
import com.library.exception.LendingNotFoundException;
import com.library.repository.BookRepository;
import com.library.repository.ClientRepository;
import com.library.repository.LendingRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LendingServiceImpl implements LendingService {

    ClientRepository clientRepository;
    BookRepository bookRepository;
    LendingRepository lendingRepository;

    @Override
    public Lending getLending(Long clientId, Long bookId) {
        Optional<Lending> lending = lendingRepository.findByClientIdAndBookId(clientId, bookId);
        return unwrapLending(lending, clientId, bookId);

    }

    @Override
    public Lending saveLending(Lending lending, Long clientId, Long bookId) {
        Client client = ClientServiceImpl.unwrapClient(clientRepository.findById(clientId), clientId);
        Book book = BookServiceImpl.unwrapBook(bookRepository.findById(bookId), bookId);
        //Reducing Inventory items
        int oldInv = book.getInventory();
        int newInv = --oldInv;
        book.setInventory(newInv);
//        ------------
        lending.setClient(client);
        lending.setBook(book);
        return lendingRepository.save(lending);
    }

    @Override
    public Lending returnLending(LocalDate returnDate, Long clientId, Long bookId) {
        Optional<Lending> lending = lendingRepository.findByClientIdAndBookId(clientId, bookId);
        Lending unwrappedLending = unwrapLending(lending, clientId, bookId);
        unwrappedLending.setReturnDate(returnDate);
        //Incrementing Inventory items
        Book book = BookServiceImpl.unwrapBook(bookRepository.findById(bookId), bookId);
        int oldInv = book.getInventory();
        int newInv = ++oldInv;
        book.setInventory(newInv);
//        ------------

        return lendingRepository.save(unwrappedLending);
    }

    @Override
    public void deleteLending(Long clientId, Long bookId) {
        //Incrementing Inventory items
        Book book = BookServiceImpl.unwrapBook(bookRepository.findById(bookId), bookId);
        int oldInv = book.getInventory();
        int newInv = ++oldInv;
        book.setInventory(newInv);
 //        ------------
        lendingRepository.deleteByClientIdAndBookId(clientId, bookId);
    }

    @Override
    public List<Lending> getClientLendings(Long clientId) {
        return lendingRepository.findByClientId(clientId);
    }

    @Override
    public List<Lending> getBookLendings(Long bookId) {
        return lendingRepository.findByBookId(bookId);

    }

    @Override
    public List<Lending> getAllLendings() {
        return (List<Lending>) lendingRepository.findAll();

    }

    static Lending unwrapLending(Optional<Lending> entity, Long clientId, Long bookId) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new LendingNotFoundException(clientId, bookId);
        }
    }

}
