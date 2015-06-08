package com.xebia.training.refactor.legacy;

import java.util.ArrayList;
import java.util.List;

public class User {
	
    private List<User> friends = new ArrayList<User>();

    private List<Trip> trips = new ArrayList<Trip>();

	public List<User> getFriends() {
		return friends;
	}
	
	public void addFriend(User user){
		this.friends.add(user);
	}

	public void addTrip(Trip trip) {
		this.trips.add(trip);
	}

	public List<Trip> getTrips() {
		return this.trips;
	}

	public boolean isFriendWith(User anotherUser) {
		return this.friends.contains(anotherUser);
	}

}
