package br.com.ferro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ferro.model.PersonModel;

@Repository
public interface PersonRepository extends  JpaRepository<PersonModel, Long>{}
