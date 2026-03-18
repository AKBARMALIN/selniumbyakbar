Feature: Validating the place API's

  Scenario: Verify if place being successfully added using AddPlaceAPI
    Given Add place payload
    When user calls "AddPlaceAPI" with POST http request
    Then the API call is successful with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"