package com.anonymous.Service;

import com.anonymous.Entity.DateType;
import com.anonymous.Repository.DateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akash.mercer on 15-05-2016.
 */

@Service
public class DateTypeService {

    @Autowired
    private DateTypeRepository dateTypeRepository;

    public DateType findByType(int type){
        if(type == 1 || type == 7){
            return dateTypeRepository.findByType(2);
        } else {
            return dateTypeRepository.findByType(1);
        }
    }
}
