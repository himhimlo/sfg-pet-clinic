package com.siuhim.sfgpetclinic.repositories;

import com.siuhim.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
