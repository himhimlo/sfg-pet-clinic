package com.siuhim.sfgpetclinic.bootstrap;

import com.siuhim.sfgpetclinic.model.*;
import com.siuhim.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int numOfPetType = petTypeService.findAll().size();
        if (numOfPetType == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType dog = petTypeService.save(petType1);
        PetType petType2 = new PetType();
        petType2.setName("Cat");
        PetType cat = petTypeService.save(petType2);

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("Radiology");
        Speciality radiology = specialityService.save(speciality1);
        Speciality speciality2 = new Speciality();
        speciality1.setDescription("Surgery");
        Speciality surgery = specialityService.save(speciality2);
        Speciality speciality3 = new Speciality();
        speciality1.setDescription("Dentistry");
        Speciality dentistry = specialityService.save(speciality3);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mary");
        owner1.setLastName("Chan");
        owner1.setAddress("1 Abc Street");
        owner1.setCity("Hong Kong");
        owner1.setTelephone("123123");
        Pet pet1 = new Pet();
        pet1.setName("Puppy");
        pet1.setBirthDate(LocalDate.now());
        pet1.setPetType(dog);
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Tom");
        owner2.setLastName("Wong");
        owner2.setAddress("2 Abc Street");
        owner2.setTelephone("234234");
        owner1.setCity("Hong Kong");
        Pet pet2 = new Pet();
        pet2.setName("Kitty");
        pet2.setBirthDate(LocalDate.now());
        pet2.setPetType(cat);
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Yiu");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jack");
        vet2.setLastName("Cheung");
        vet2.getSpecialities().add(surgery);
        vet2.getSpecialities().add(dentistry);
        vetService.save(vet2);

        Visit visit1 = new Visit();
        visit1.setPet(pet1);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sneezy Puppy");
        visitService.save(visit1);
    }
}
