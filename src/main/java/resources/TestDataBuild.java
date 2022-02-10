package resources;

import io.cucumber.skeleton.Location;
import io.cucumber.skeleton.Place;

import java.util.*;

public class TestDataBuild {
    public static Place addPlacePayload(String name, String language, String address) {
        Place place = new Place();
        place.setName(name);
        place.setAccuracy(50);
        place.setAddress(address);
        place.setLanguage(language);
        Location location = new Location();
        location.setLat(12.233);
        location.setLng(32.233);
        place.setLocation(location);
        place.setPhone_number("09837363663");
        place.setTypes(Arrays.asList("shoe-park", "hou-park"));
        place.setWebsite("website.com");
        return place;
    }
}
