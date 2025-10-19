package com.sameer.Mini.Project.Repository;

import com.sameer.Mini.Project.Data.TransactionTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepo extends JpaRepository<TransactionTable,Long> {

    List<TransactionTable> findAllByuserId(Long id);
}
