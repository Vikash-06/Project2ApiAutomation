package base;

public enum APIresources {
	AddPlaceAPI("maps/api/place/add/json"), GetPlaceAPI("maps/api/place/get/json");

	public String endpoints;

	APIresources(String endpoints) {
		this.endpoints = endpoints;
	}

	public String getEndpoint() {
		return endpoints;
	}

}
