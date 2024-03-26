package com.application.application.TestDozerMapper;

import com.application.application.Mapper.DozerMapper;
import com.application.application.VO.PersonVO;
import com.application.application.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DozerMapperTest {
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        var output = DozerMapper.ParseObject(inputObject.mockEntity(), PersonVO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First name0", output.getFirstName());
        assertEquals("Last name0", output.getLastName());
        assertEquals("Address test0", output.getAddress());
        assertEquals("Male", output.getGender());

    }

    @Test
    public void parseListEntityToVOList() {
        var outputList = DozerMapper.ParseListObject(inputObject.mockEntityList(), PersonVO.class);
        var output = outputList.get(0);
        assertEquals("First name0", output.getFirstName());
        assertEquals("Last name0", output.getLastName());
        assertEquals("Address test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }
}
