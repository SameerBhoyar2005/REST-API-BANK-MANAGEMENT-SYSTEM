package com.sameer.Mini.Project.Data;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name = "User_Table")
@Getter
@Setter
public class UserTable {
    @Id
    private String id;
    private Integer money;
    private String name;
    private String mob_no;
}
