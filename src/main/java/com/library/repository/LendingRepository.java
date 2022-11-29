
package com.library.repository;

import com.library.entity.Lending;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;


public interface LendingRepository extends CrudRepository<Lending, Long> {
    
    Optional<Lending> findByClientIdAndBookId(Long clientId, Long bookId);
     List<Lending> findByClientId(Long clientId);
     List<Lending> findByBookId(Long bookId);
     @Transactional
     void deleteByClientIdAndBookId(Long clientId, Long bookId);
    
    
}
