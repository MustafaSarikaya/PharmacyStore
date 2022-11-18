Feature: Prepare Prescription Fill.
    Scenario: Creating and saving a new prescription fill
        Given the prescription fill info's prescription exists
        And the user account specified by the given ID is registered
        And the user account specified by the given ID is an Agent
        When application command preparePrescriptionFill is invoked
        Then a new prescription fill is created
        And the new prescription fill is initialized from the prescription fill information
        And the new prescription fill's prescription is set to the provided prescription
        And the new prescription fill is added to the prescription's fills
        And the new prescription fill's status is set to prepared
        And the new prescription fill's preparation agent ID is set to the given ID