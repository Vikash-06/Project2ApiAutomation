package stepDefination;

import org.junit.Assert;

import base.APIresources;
import base.Utill;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import pojo.TestDataBuild;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class PlaceSteps extends Utill {

	RequestSpecification Rqst;
	Response repo;
	TestDataBuild tb = new TestDataBuild();

	@When("Add Place Payload With Request")
	public void add_place_payload_with_request() throws IOException {

		Rqst = given().log().all().spec(setup()).body(tb.Requestspecification());

	}

	@When("User Calls {string} with {string} HTTP request")
	public void user_calls_with_http_request(String EndPoint, String RequestMethod) {
		if (RequestMethod.equalsIgnoreCase("Post")) {
			APIresources resources = APIresources.valueOf(EndPoint);
			repo = Rqst.when().post(resources.getEndpoint());
		} else if (RequestMethod.equalsIgnoreCase("Get")) {
			APIresources resources = APIresources.valueOf(EndPoint);
			repo = Rqst.when().get(resources.getEndpoint());
		}
	}

	@Then("the called API got success with status code 200")
	public void the_called_api_got_success_with_status_code() {

		int statusCode = repo.statusCode();
		Assert.assertEquals(200, statusCode);

	}

	@Then("{string} in reponse body is {string}")
	public void in_reponse_body_is(String key, String value) {

		String response = repo.asString();
		JsonPath js = new JsonPath(response);
		String statusvalue = js.getString(key);
		Assert.assertEquals(statusvalue, value);

	}
}