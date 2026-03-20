package com.akbar.resources;

import com.akbar.pojo.AddPlace;
import com.akbar.pojo.Location;

import java.util.Arrays;

public class TestDataBuilder {

    public AddPlace addPlacePayload() {

        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);

        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress("29, side layout, cohen 09");
        addPlace.setLanguage("French-IN");
        addPlace.setName("Frontline house");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setWebsite("http://google.com");
        addPlace.setTypes(Arrays.asList("shoe park", "shop"));
        addPlace.setLocation(location);

        return addPlace;

    }
}
