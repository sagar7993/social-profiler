package com.anonymous.Repository;

import com.anonymous.Entity.Cuisine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akash.mercer on 14-05-2016.
 */
public interface CuisineRepository extends CrudRepository<Cuisine,Long> {

    @Transactional
    Cuisine findById(@Param("id") Long id);

    @Transactional
    Cuisine findByName(@Param("name") String name);
}
