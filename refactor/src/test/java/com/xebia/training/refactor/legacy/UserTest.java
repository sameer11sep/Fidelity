package com.xebia.training.refactor.legacy;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void shouldInformIfAnotherUserIsFriend() throws Exception {
		User sameer=new User();
		User shekhar = new User();
		sameer.addFriend(shekhar);
		sameer.addFriend(new User());
		assertTrue(sameer.isFriendWith(shekhar));
	}
	
	@Test
	public void shouldInformWhenUserIsNotFriendOfAnotherUser() throws Exception {
		User sameer=new User();
		User shekhar = new User();
		sameer.addFriend(new User());
		assertFalse(sameer.isFriendWith(shekhar));
	}

}
