package com.library.controller;

import com.library.entity.Lending;
import com.library.service.LendingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/lending")
@Tag(name = "Lending Operations", description = "Is Used for handling Lendings / "
        + "Connect a book with a Client / Update Lending upon Book return / Retrieve Lendings either by client or by Book or In TOTAL.")

public class LendingController {

    LendingService lendingService;

    @Operation(summary = "Gets a Specific Lending by Ids.", description = "Returns a Specific Lending, based on Client ID and Book ID.",security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping("/client/{clientId}/book/{bookId}")
    public ResponseEntity<Lending> getLending(@PathVariable Long clientId, @PathVariable Long bookId) {
        return new ResponseEntity<>(lendingService.getLending(clientId, bookId), HttpStatus.OK);

    }

    @Operation(summary = "Creates a  Lending.", description = "Saves a Specific Lending,Linking a Client with a Book, based on given Ids (Client ID / Book ID).",security = @SecurityRequirement(name = "basicAuth"))
    @PostMapping("/client/{clientId}/book/{bookId}")
    public ResponseEntity<Lending> saveLending(@RequestBody Lending lending, @PathVariable Long clientId, @PathVariable Long bookId) {
        return new ResponseEntity<>(lendingService.saveLending(lending, clientId, bookId), HttpStatus.CREATED);
    }

    @Operation(summary = "Updates a Lending.", description = "Takes a ReturnDate and updates an existing Lending, based on given Ids (Client ID / Book ID).",security = @SecurityRequirement(name = "basicAuth"))
    @PutMapping("/client/{clientId}/book/{bookId}")
    public ResponseEntity<Lending> updateLending(@RequestBody Lending lending, @PathVariable Long clientId, @PathVariable Long bookId) {
        return new ResponseEntity<>(lendingService.returnLending(lending.getReturnDate(), clientId, bookId), HttpStatus.OK);

    }

    @Operation(summary = "Deletes a  Lending.", description = "Deletes a Specific Lending, based on Client ID and Book ID.",security = @SecurityRequirement(name = "basicAuth"))
    @DeleteMapping("/client/{clientId}/book/{bookId}")
    public ResponseEntity<HttpStatus> deleteLending(@PathVariable Long clientId, @PathVariable Long bookId) {
        lendingService.deleteLending(clientId, bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    @Operation(summary = "Gets Lendings by Client.", description = "Retrieves a List of all Lendings based on the Client ID given.",security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Lending>> getClientLendings(@PathVariable Long clientId) {
        return new ResponseEntity<>(lendingService.getClientLendings(clientId), HttpStatus.OK);
    }
    
    
    @Operation(summary = "Gets Lendings by Book.", description = "Retrieves a List of all Lendings based on the Book ID given.",security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Lending>> getBookLendings(@PathVariable Long bookId) {
        return new ResponseEntity<>(lendingService.getBookLendings(bookId), HttpStatus.OK);
    }

    @Operation(summary = "Gets All Lendings.", description = "Retrieves a List of all Lendings.",security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping("/all")
    public ResponseEntity<List<Lending>> getLendings() {
        return new ResponseEntity<>(lendingService.getAllLendings(), HttpStatus.OK);
    }
}
