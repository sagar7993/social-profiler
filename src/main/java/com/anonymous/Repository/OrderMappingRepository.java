package com.anonymous.Repository;

import com.anonymous.Entity.OrderMapping;
import com.anonymous.Entity.User;
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
public interface OrderMappingRepository extends CrudRepository<OrderMapping,Long>{

    @Transactional
    @Query(value = "select o from OrderMapping o where o.subscription.user = :user")
    List<OrderMapping> findByUser(@Param("user") User user);
}
