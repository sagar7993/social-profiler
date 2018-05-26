package com.anonymous.Repository;

import com.anonymous.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akash.mercer on 14-05-2016.
 */

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

//    @Transactional
//    @Query(value = "select u from User u where u.mobileNumber = :mobileNumber")
//    User findByEmail(@Param("mobileNumber") String mobileNumber);

    @Transactional
    @Query(value = "select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);

}
