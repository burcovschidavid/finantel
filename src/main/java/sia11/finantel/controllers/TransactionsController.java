package sia11.finantel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sia11.finantel.models.Transaction;
import sia11.finantel.repositories.TransactionRepository;

import java.util.Date;


@RestController
public class TransactionsController {
    @Autowired
    private TransactionRepository transactionRepository;
    @CrossOrigin(origins = "http://localhost:8003")
    @GetMapping("/api/transactions")
    public @ResponseBody
    Iterable<Transaction> all(){
        return transactionRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:8003")
    @PostMapping("/api/transactions")
    public @ResponseBody
    Transaction add(@RequestBody Transaction transaction){
        transaction.setDatetime(new Date());
        transactionRepository.save(transaction);
        return transaction;
    }
    @CrossOrigin(origins = "http://localhost:8003")
    @PutMapping("/api/transactions")
    public @ResponseBody
    Transaction update(@RequestBody Transaction transaction){
        transactionRepository.save(transaction);
        return transaction;
    }
    @CrossOrigin(origins = "http://localhost:8003")
    @DeleteMapping("/api/transactions")
    public @ResponseBody
    Iterable<Transaction> delete(@RequestBody Transaction transaction){
        transactionRepository.delete(transaction);
        return transactionRepository.findAll();
    }


}
