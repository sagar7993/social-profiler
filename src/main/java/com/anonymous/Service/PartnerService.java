package com.anonymous.Service;

import com.anonymous.Entity.Partner;
import com.anonymous.Repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akash.mercer on 15-05-2016.
 */

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    public Partner save(Partner partner){
        Partner retrievedPartner = partnerRepository.findById(partner.getId());

        if (retrievedPartner == null) {
            return partnerRepository.save(partner);
        }

        return retrievedPartner;
    }
}
