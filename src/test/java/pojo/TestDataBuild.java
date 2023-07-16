package pojo;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

public class TestDataBuild {

	public BookData Requestspecification() {
		BookData Bd = new BookData();
		Location loc = new Location();
		Faker f = new Faker();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		Bd.setLocation(loc);
		Bd.setAccuracy(50);
		Bd.setName(f.name().firstName());
		Bd.setPhone_number(f.number().digits(10));
		Bd.setAddress("29, side layout, cohen 09");

		List<String> list = new ArrayList<>();
		list.add("shoe park");
		list.add("shoe park");
		Bd.setTypes(list);
		Bd.setWebsite("http://google.com");
		Bd.setLanguage("French-IN");
		return Bd;

	}

}
