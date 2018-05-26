package com.anonymous.Repository;

import com.anonymous.Entity.DateType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akash.mercer on 15-05-2016.
 */

@Repository
public interface DateTypeRepository extends CrudRepository<DateType, Long> {

    @Transactional
    DateType findByType(@Param("type") Integer type);

}
