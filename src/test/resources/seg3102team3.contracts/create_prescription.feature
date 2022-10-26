Feature: Create Prescription.
    Scenario: Agent is signed into the System, prescription DIN or prescriber information is invalid or patient is not registered 
        Given Agent is signed into System 
        When Agent request to create new prescription
        Then System provides a form for prescription information
        When the Agent submits the form
        Then System checks whether prescription DIN is in the Drug Product Database
        And System checks if prescriber information is valid 
        And System checks if patient information matches a registered patient
        Given that some of the information is invalid
        Then System will prompt Agent to modify the entered information
        When the Agent submits the form with valid information
        Then the System invokes the createPrescription application command
        And System assign unique identifer to prescription 
        And System record prescription
        And System adds prescription to the patient prescription

    Scenario: Agent is signed into the System, prescription DIN and prescriber information is valid and patient is registered 
        Given Agent is signed into System 
        When Agent request to create new prescription
        Then System provides a form for prescription information
        When the Agent submits the form
        Then System checks whether prescription DIN is in the Drug Product Database
        And System checks if prescriber information is valid 
        And System checks if patient information matches a registered patient
        Given that all the information is valid
        Then the System invokes the createPrescription application command
        And System assign unique identifer to prescription 
        And System record prescription
        And System adds prescription to the patient prescription

