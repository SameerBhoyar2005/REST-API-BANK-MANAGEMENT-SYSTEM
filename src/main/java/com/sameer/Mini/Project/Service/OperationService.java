package com.sameer.Mini.Project.Service;


import com.sameer.Mini.Project.Data.TransactionTable;
import com.sameer.Mini.Project.Data.UserTable;
import com.sameer.Mini.Project.Repository.ServiceRepo;
import com.sameer.Mini.Project.Repository.UserRepo;
import com.sameer.Mini.Project.utility.Operation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class OperationService {

    private final UserRepo userRepo;
    private final ServiceRepo serviceRepo;


    public List<TransactionTable> getAllTransactionById(Long id) {
        return serviceRepo.findAllByuserId(id);
    }

    public String withdraw(Long userId, Integer amount) {
        Optional<UserTable> user=userRepo.findById(userId);
        if(user.isEmpty()){
            return "NO USER FOUND OF ID "+userId;
        }
        UserTable ruser = user.get();
        if(ruser.getMoney() < amount){
            return "INSUFFICIENT BALANCE FOR USER " + ruser.getName();
        }
        Integer newAmount = ruser.getMoney() - amount;

        TransactionTable transactionTable = new TransactionTable();

        transactionTable.setOperation("WITHDRAW");
        transactionTable.setUserId(userId);
        transactionTable.setAmount(amount);
        transactionTable.setCurrentBalance(newAmount);
        transactionTable.setMobileno(ruser.getMob_no());
        serviceRepo.save(transactionTable);

        ruser.setMoney(newAmount);
        userRepo.save(ruser);

        return "AMOUNT WITHDRAW SUCCESSFULLY OF RUPEES " + amount +" BY USER " + ruser.getName() ;

    }

    public String diposit(Long userId, Integer amount) {
        Optional<UserTable> user=userRepo.findById(userId);
        if(user.isEmpty()){
            return "NO USER FOUND OF ID "+userId;
        }
        UserTable ruser = user.get();
        Integer newAmount = ruser.getMoney() + amount;
        TransactionTable transactionTable = new TransactionTable();

        transactionTable.setOperation("DIPOSIT");
        transactionTable.setUserId(userId);
        transactionTable.setAmount(amount);
        transactionTable.setCurrentBalance(newAmount);
        transactionTable.setMobileno(ruser.getMob_no());
        serviceRepo.save(transactionTable);

        ruser.setMoney(newAmount);
        userRepo.save(ruser);
        return "AMOUNT " + amount +" DIPOSITED SUCCESSFULLY FOR USER "+ruser.getName();
    }
}
