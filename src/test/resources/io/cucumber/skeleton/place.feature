Feature: Validating place API's

    Scenario Outline: Verify if place is being successfully added using AddPlaceApi
        Given Add place payload "<name>" "<language>" <"address">
        When user calls "AddPlaceApi" with post http request
        Then the API call is success with status code 200
        And "status" in response is "OK"
        And "scope" in response is "APP"

        Examples:
            | name    | language | address            |
            | Aahouse | English  | World cross center |



