package com.xebia.training.refactor.state;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AgileTaskTest {
	
	@Rule
	public ExpectedException expectedException=ExpectedException.none(); 

	@Test
	public void shouldMoveTaskToInProgressFromToDo() throws Exception {
		AgileTask agileTask = new AgileTask();
		agileTask.assigned();
		assertEquals(agileTask.getState(),"IN_PROGRESS");
	}

	@Test
	public void shouldThrowExceptionIfTriestoAssignADoneTask() throws Exception {
		AgileTask agileTask = new AgileTask();
		agileTask.setState("DONE");
		expectedException.expect(IllegalStateException.class);
		expectedException.expectMessage("Cannot make the transition from current state");
		agileTask.assigned();
	}
	
	@Test
	public void shouldMoveTaskToTestFromInProgress() throws Exception {
		AgileTask agileTask = new AgileTask();
		agileTask.setState("IN_PROGRESS");
		agileTask.moveToTest();
		assertEquals(agileTask.getState(),"IN_TEST");
	}
	
}
