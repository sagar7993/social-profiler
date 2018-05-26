package com.anonymous.Repository;

import com.anonymous.Entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by akash.mercer on 14-05-2016.
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {

//    @Transactional
//    @Query(value = "select c from Category c where c.user.id  = :userId")
//    List<Category> findAll(@Param("userId") Long userId);
}
