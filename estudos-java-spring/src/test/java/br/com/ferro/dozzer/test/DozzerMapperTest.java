package br.com.ferro.dozzer.test;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.ferro.dto.PersonDTO;
import br.com.ferro.mapper.DozerMapper;
import br.com.ferro.mock.test.MockPersonTest;
import br.com.ferro.model.PersonModel;

public class DozzerMapperTest {
	
	 MockPersonTest inputObject;

	    @BeforeEach
	    public void setUp() {
	        inputObject = new MockPersonTest();
	    }

	    @Test
	    public void parseEntityToVOTest() {
	        PersonDTO output = DozerMapper.parseObject(inputObject.mockEntity(), PersonDTO.class);
	        assertEquals(Long.valueOf(0L), output.getId());
	        assertEquals("First Name Test0", output.getFirstName());
	        assertEquals("Last Name Test0", output.getLastName());
	        assertEquals("Addres Test0", output.getAddress());
	        assertEquals("Male", output.getGender());
	    }

	    @Test
	    public void parseEntityListToVOListTest() {
	        List<PersonDTO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), PersonDTO.class);
	        PersonDTO outputZero = outputList.get(0);
	        
	        assertEquals(Long.valueOf(0L), outputZero.getId());
	        assertEquals("First Name Test0", outputZero.getFirstName());
	        assertEquals("Last Name Test0", outputZero.getLastName());
	        assertEquals("Addres Test0", outputZero.getAddress());
	        assertEquals("Male", outputZero.getGender());
	        
	        PersonDTO outputSeven = outputList.get(7);
	        
	        assertEquals(Long.valueOf(7L), outputSeven.getId());
	        assertEquals("First Name Test7", outputSeven.getFirstName());
	        assertEquals("Last Name Test7", outputSeven.getLastName());
	        assertEquals("Addres Test7", outputSeven.getAddress());
	        assertEquals("Female", outputSeven.getGender());
	        
	        PersonDTO outputTwelve = outputList.get(12);
	        
	        assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        assertEquals("First Name Test12", outputTwelve.getFirstName());
	        assertEquals("Last Name Test12", outputTwelve.getLastName());
	        assertEquals("Addres Test12", outputTwelve.getAddress());
	        assertEquals("Male", outputTwelve.getGender());
	    }

	    @Test
	    public void parseVOToEntityTest() {
	        PersonModel output = DozerMapper.parseObject(inputObject.mockVO(), PersonModel.class);
	        assertEquals(Long.valueOf(0L), output.getId());
	        assertEquals("First Name Test0", output.getFirstName());
	        assertEquals("Last Name Test0", output.getLastName());
	        assertEquals("Addres Test0", output.getAddress());
	        assertEquals("Male", output.getGender());
	    }

	    @Test
	    public void parserVOListToEntityListTest() {
	        List<PersonModel> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), PersonModel.class);
	        PersonModel outputZero = outputList.get(0);
	        
	        assertEquals(Long.valueOf(0L), outputZero.getId());
	        assertEquals("First Name Test0", outputZero.getFirstName());
	        assertEquals("Last Name Test0", outputZero.getLastName());
	        assertEquals("Addres Test0", outputZero.getAddress());
	        assertEquals("Male", outputZero.getGender());
	        
	        PersonModel outputSeven = outputList.get(7);
	        
	        assertEquals(Long.valueOf(7L), outputSeven.getId());
	        assertEquals("First Name Test7", outputSeven.getFirstName());
	        assertEquals("Last Name Test7", outputSeven.getLastName());
	        assertEquals("Addres Test7", outputSeven.getAddress());
	        assertEquals("Female", outputSeven.getGender());
	        
	        PersonModel outputTwelve = outputList.get(12);
	        
	        assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        assertEquals("First Name Test12", outputTwelve.getFirstName());
	        assertEquals("Last Name Test12", outputTwelve.getLastName());
	        assertEquals("Addres Test12", outputTwelve.getAddress());
	        assertEquals("Male", outputTwelve.getGender());
	    }
	}
