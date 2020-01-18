package com.siuhim.sfgpetclinic.services;

import com.siuhim.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
