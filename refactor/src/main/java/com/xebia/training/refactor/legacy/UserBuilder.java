package com.xebia.training.refactor.legacy;

public class UserBuilder {

	private User user;
	
	public UserBuilder aUser() {
		user=new User();
		return this;
	}

	public UserBuilder withTrips(Trip...trips) {
		for (Trip trip : trips) {
			user.addTrip(trip);
		}
		return this;
	}

	public UserBuilder withFriends(User...users) {
		for (User friend : users) {
			user.addFriend(friend);
		}
		return this;
		
	}

	public User build() {
		return this.user;
	}

}
