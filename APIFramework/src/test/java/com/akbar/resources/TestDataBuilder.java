package com.akbar.resources;

import com.akbar.pojo.AddPlace;
import com.akbar.pojo.Location;

import java.util.Arrays;

public class TestDataBuilder {

    public AddPlace addPlacePayload(String name, String language, String address) {

        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);

        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress(address);
        addPlace.setLanguage(language);
        addPlace.setName(name);
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setWebsite("http://google.com");
        addPlace.setTypes(Arrays.asList("shoe park", "shop"));
        addPlace.setLocation(location);

        return addPlace;

    }
}
