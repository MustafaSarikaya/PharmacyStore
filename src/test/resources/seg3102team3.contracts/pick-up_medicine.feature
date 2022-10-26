Feature: Pick Up Prepared Prescription Fill
    Scenario: Pharmacist is signed in and Prescription Fill to be picked up exists
        Given the Pharmacist is signed in
        When the Pharmacist prompts to set a Prescription Fill as picked up
        Given the Prescription Fill to be picked up exists
        Then the System provides a form asking for the summary of the discussion
        When the Pharmacist submits the form
        Then the System invokes pickUpMedicine application comamnd
        And the System sets the Prescription Fill's pick-up summary to the provided value
        And the System sets the Prescription Fill's status to Retrieved
