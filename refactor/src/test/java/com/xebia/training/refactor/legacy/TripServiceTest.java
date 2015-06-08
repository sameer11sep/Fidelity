package com.xebia.training.refactor.legacy;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TripServiceTest {

	private static final User SAM = new User();
	private static final User PAUL = new User();
	private static final Trip DELHI = new Trip();
	private static final User SHEKHAR = new User();
	private static final Trip GURGAON = new Trip();
	private static final User SOMEUSER = new User();
	public static final User GUEST = null;
	User loggedInUser;
	private TripService tripService;
	
	@Before
	public void setUp() {
		tripService = new TestableTripService();
	}

	@Test(expected=NotLoggedInException.class)
	public void shouldThrowNotLoggedInExceptionWhenUserNotLoggedIn() throws Exception {
		loggedInUser=GUEST;
		tripService.getUserTrips(SOMEUSER);
		
	}
	
	@Test
	public void shouldReturnNoTripsIfUserHasNoFriends() throws Exception {
		loggedInUser=SOMEUSER;
		User user = new UserBuilder().aUser().withTrips(GURGAON).build();
		List<Trip> userTrips = tripService.getUserTrips(user);
		assertEquals(0, userTrips.size());
	}
	
	@Test
	public void shouldReturnTripsIfUserIsAFriendOfLoggedInUser() throws Exception {
		loggedInUser=SHEKHAR;
		User user = new UserBuilder().aUser().
				withTrips(DELHI,GURGAON).
				withFriends(SHEKHAR).build();
		List<Trip> userTrips = tripService.getUserTrips(user);
		assertEquals(2,userTrips.size());
		
	}
	
	@Test
	public void shouldReturnNoTripsIfUserISNotAFriendOfLoggedInUser() throws Exception {
		loggedInUser=SHEKHAR;
		User user = new UserBuilder().aUser().withFriends(PAUL,SAM).
		withTrips(DELHI,GURGAON).build();
		List<Trip> userTrips = tripService.getUserTrips(user);
		assertEquals(0,userTrips.size());
	}


	private class TestableTripService extends TripService{

		@Override
		User getLoggedInUser() {
			return loggedInUser;
		}

		@Override
		List<Trip> getTrips(User user) {
			return user.getTrips();
		}
		
	}
}
