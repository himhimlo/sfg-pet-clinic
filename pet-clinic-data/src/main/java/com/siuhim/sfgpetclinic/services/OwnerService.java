package com.siuhim.sfgpetclinic.services;

import com.siuhim.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);
    Owner findByLastName(String lastName);
    Set<Owner> findAll();
    Owner save(Owner owner);
}
