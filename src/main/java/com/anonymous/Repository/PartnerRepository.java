package com.anonymous.Repository;

import com.anonymous.Entity.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akash.mercer on 15-05-2016.
 */

@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long> {

    @Transactional
    Partner findById(@Param("id") Long id);
}
