package com.xebia.training.refactor.legacy;

import java.util.ArrayList;
import java.util.List;

public class TripService {

	private static final ArrayList<Trip> noTrips = new ArrayList<Trip>();

	public List<Trip> getUserTrips(User user) throws NotLoggedInException {
		User loggedInUser = getLoggedInUser();
		if (loggedInUser == null) {
			throw new NotLoggedInException("You are not currently logged in..");
		}
		return user.isFriendWith(loggedInUser)?getTrips(user):noTrips;
	}

	List<Trip> getTrips(User user) {
		return TripDao.getTrips(user);
	}

	User getLoggedInUser() {
		return SecurityContext.getLoggedInUser();
	}

}
