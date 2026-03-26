Feature: Validating the place API's

  Scenario Outline: Verify if place being successfully added using AddPlaceAPI
    Given Add place payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with POST http request
    Then the API call is successful with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | name       | language | address            |
      | AAhouse    | English  | World cross center |