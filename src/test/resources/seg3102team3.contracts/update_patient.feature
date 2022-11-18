Feature: Updating a Patient
    Scenario: Updating a registered patient
        Given the Patient specified by the given ID is registered
        And the patient info's language preference matches to a Language value
        And the patient info's gender matches to a Gender value
        And the patient info's address contains 5 comma seperated substrings
        When the application command updatePatient is invoked
        Then the patient is updated from the patient information
        And the patient's list of prescriptions was not changed