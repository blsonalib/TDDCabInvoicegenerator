package com.cabinvoicegenerator;

import java.util.*;

public class RideRepository {

    Map<String, ArrayList<Ride>> userRides = null;

    public RideRepository() {

        this.userRides = new HashMap<>();
    }

    public void addRides(String userId,Ride[] rides) throws CabServiceException{

           if (rides != null) {
               this.userRides.put(userId, new ArrayList<Ride>(Arrays.asList(rides)));
           }
           else{
                 throw new CabServiceException("You have no ride ",CabServiceException.ExceptionType.RIDE_NOT_FOUND);
             }
         }

        public Ride[] getRides(String userId) throws CabServiceException {

                if (userId != null) {
                    return this.userRides.get(userId).toArray(new Ride[0]);
                 }
                else {
                throw new CabServiceException("You have problem in ID", CabServiceException.ExceptionType.NULL_ID);
            }
        }
    }

