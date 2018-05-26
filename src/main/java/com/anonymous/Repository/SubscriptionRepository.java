package com.anonymous.Repository;

import com.anonymous.Entity.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by akash.mercer on 14-05-2016.
 */
@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {

    @Transactional
    Subscription findById(@Param("id") Long id);

    @Transactional
    @Query(value = "select o from Subscription o where o.user.id  = :userId")
    List<Subscription> findByUser(@Param("userId") Long userId);

}
