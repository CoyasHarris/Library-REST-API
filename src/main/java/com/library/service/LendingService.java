
package com.library.service;

import com.library.entity.Lending;
import java.time.LocalDate;
import java.util.List;


public interface LendingService {
    
    Lending getLending(Long clientId, Long bookId);
    Lending saveLending(Lending lending, Long clientId, Long bookId);
    Lending returnLending(LocalDate returnDate, Long clientId, Long bookId);
    void deleteLending(Long clientId, Long bookId);
    List<Lending> getClientLendings(Long clientId);
    List<Lending> getBookLendings(Long bookId);
    List<Lending> getAllLendings();
    
}
