Feature: Validate Google place details

Scenario: Validate user add new place with API
 
When Add Place Payload With Request
And User Calls "AddPlaceAPI" with "Post" HTTP request
Then the called API got success with status code 200
Then "status" in reponse body is "OK"


