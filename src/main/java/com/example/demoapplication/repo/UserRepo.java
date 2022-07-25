package com.example.demoapplication.repo;

import com.example.demoapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER WHERE ID = ?1",nativeQuery = true)//native query searching buy id
    User getUserByUserID(String userId);

    @Query(value = "SELECT * FROM USER WHERE ID = ?1 AND ADDRESS = ?2",nativeQuery = true)//native query search by id and address
    User getUserByUserIDAndAddress(String userId, String address);

    //@Modyfying for update query instead of selected
}
