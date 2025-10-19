package com.sameer.Mini.Project.Data;


import com.sameer.Mini.Project.utility.Operation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "Transaction_table")
public class TransactionTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime doneOn;

    private Long userId;
    private Integer currentBalance;
    private String Mobileno;
    private String operation;
    private Integer amount;
}
