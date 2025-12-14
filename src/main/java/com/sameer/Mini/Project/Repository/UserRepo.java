package com.sameer.Mini.Project.Repository;

import com.sameer.Mini.Project.Data.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserTable,String> {


}
