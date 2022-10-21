package br.com.ferro.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferro.exceptions.ResourceNotFoundException;
import br.com.ferro.mapper.DozerMapper;
import br.com.ferro.model.PersonModel;
import br.com.ferro.dto.PersonDTO;
import br.com.ferro.repository.PersonRepository;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<PersonDTO> findAllPeople() {		
		return DozerMapper.parseListObjects(repository.findAll(), PersonDTO.class);
	}
	
	public PersonDTO findById(Long id) {		
		logger.info("Find one person by id! ");			
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, PersonDTO.class);
	}
	
	
	/*
	public List<PersonDTO> findAll() {
		
		List<PersonDTO> persons = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			PersonDTO person = mockPersons(i);
			persons.add(person);
		}
		return persons;
	
	
	}
	
		public PersonDTO findById(String id) {
		
		logger.info("Find one person by id! ");
		PersonDTO person = new PersonDTO();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Fabiano");
		person.setLastName("Ferro");
		person.setAddress("Avenida Henriqueta Mendes Guerra");
		person.setGender("Macho");
		
		
		return person;
	}


/*
	private PersonDTO mockPersons(int i) {
		
		logger.info("Find one person by id! ");
		PersonDTO person = new PersonDTO();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Same address in Brazil " + i);
		person.setGender("Male");	
		
		return person;
	}
	*/	
	
	public PersonDTO create(PersonDTO person) {
		logger.info("Creating one person! ");
		
		var entity = DozerMapper.parseObject(person, PersonModel.class);
		var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
		return dto;		
	}
	
	public PersonDTO update(PersonDTO person) {
		logger.info("Updating one person! ");
		
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setId(counter.incrementAndGet());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class); 		
		return dto;
	}
	
	public void delete(long id) {
		logger.info("Deleting one person! ");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
		}
	
	
}
