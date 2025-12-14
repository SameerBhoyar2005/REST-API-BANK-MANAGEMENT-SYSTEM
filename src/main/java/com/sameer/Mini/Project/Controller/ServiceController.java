package com.sameer.Mini.Project.Controller;


import com.sameer.Mini.Project.Data.TransactionTable;
import com.sameer.Mini.Project.Service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service")
public class ServiceController {

     private final OperationService operationService;


    @GetMapping("/alltransactions/{id}")
    public List<TransactionTable> getAllTrasactionById(@PathVariable String id){
        return operationService.getAllTransactionById(id);
    }

    @GetMapping("/withdraw/{id}/{amount}")
    public String withdraw(@PathVariable String id, @PathVariable Integer amount){
        return operationService.withdraw(id,amount);
    }

    @GetMapping("/diposit/{id}/{amount}")
    public String diposit(@PathVariable String id, @PathVariable Integer amount){
        return operationService.diposit(id,amount);
    }




}
