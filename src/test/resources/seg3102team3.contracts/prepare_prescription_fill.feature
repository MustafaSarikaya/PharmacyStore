Feature: Creating and Preparing a Prescription Fill.
    Scenario: Agent is signed in and has prepared a prescription fill for a refillable prescription
        Given the Agent is signed in 
        When the Agent prompts the System to create a prescription fill for a prescription
        Given the prescription is refillable
        Then the System provides a form asking for information about the fill to be created
        When the Agent submits the form 
        Then the System invokes the preparePrescriptionFill application command
        And the System will create the Prescription Fill object
        And the System will set the Prescription Fill attributes to the provided values
        And the System will add the Prescription Fill to the specified Prescription's list
        And the System will set the Prescription Fill as prepared
        And the System sets the Prescription Fill's operating agent ID for preparation to the Agent's



    Scenario: Agent is signed in and requests creation of a prescription fill for a non-refillable prescription
        Given the Agent is signed in 
        When the Agent prompts the System to create a prescription fill for a prescription
        Given the prescription is non-refillable
        Then the System will notify the Agent refilling the prescription is not allowed
