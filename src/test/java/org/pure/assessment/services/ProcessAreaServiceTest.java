package org.pure.assessment.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pure.assessment.entities.ProcessArea;

class ProcessAreaServiceTest {
	
	private ProcessAreaService service;
	private List<ProcessArea> list;
	@BeforeEach
	void setUp() throws Exception {
		this.service = new ProcessAreaService();
		this.list = service.getList();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetList() {
		this.list.add(new ProcessArea(1l, "Action Plan Operation","APO"));
		this.list.add(new ProcessArea(2l, "Evaluate Assess Do","EAD"));
		this.list.add(new ProcessArea(3l, "Monitor Evaluate Assess","MEA"));
		ProcessArea deleteArea = new ProcessArea(4l, "Process Area for Delete","PAFD");
		this.list.add(deleteArea);
		
		assertTrue(this.service.getList().size() == 4);
		
		//Remove action and updated list
		this.list.remove(deleteArea);
		assertTrue(this.service.getList().size() == 3);
		
	}
	
	@Test
	void testAddProcessArea()
	{
		//Load
		ProcessArea testProcessArea = new ProcessArea(1l, "Test", "T1");
		this.service.addProcessArea(testProcessArea);
		
		//assert
		assertEquals(this.service.getList().get(0).getName(), "Test");
		
		//TODO: Check for duplication with same Id
		
	}
	
	@Test 
	void testRemoveProcessArea()
	{
		//load
		var list = this.service.getList();
		ProcessArea processAreaFordelete = new ProcessArea(1l, "Test", "T1");
		list.add(processAreaFordelete);
		Long deletedId = processAreaFordelete.getId();
		
		//Assert for valid removal
		assertEquals(this.service.removeProcessArea(deletedId), true);
		
		//Assert for null remove
		assertEquals(this.service.removeProcessArea(null), false);
		
		
		//TODO: assert for removed item removal
		assertEquals(this.service.removeProcessArea(deletedId), false);
		
		//TODO: assert for invalid Item
		assertEquals(this.service.removeProcessArea(new Random(1l).nextLong(4l, 1000l)), false);
	}

}
