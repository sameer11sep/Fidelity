package com.xebia.training.refactor.legacy;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    public List<Trip> getUserTrips(User user) throws NotLoggedInException{
        User loggedInUser = getLoggedInUser();
        if(loggedInUser != null){
            boolean isFriend = false;
            for (User friend : user.getFriends()) {
                if(loggedInUser.equals(friend)){
                    isFriend = true;
                    break;
                }
            }
            if(isFriend){
                TripDao.getTrips(user);
            }
        }else{
            throw new NotLoggedInException("You are not currently logged in..");
        }
        return new ArrayList<Trip>();
    }

	User getLoggedInUser() {
		return SecurityContext.getLoggedInUser();
	}

}
