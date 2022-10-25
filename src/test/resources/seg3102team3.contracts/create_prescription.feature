Feature: Create Prescription.
    Scenario 1: Agent is signed into the System, patient and prescriber information are invalid
        Given Agent is signed into System 
        When the application command CreatePrescription is invoked
        Then the system will check if patient is registered 
        Given if patient is unregistered
        Then the system will return null
        Given if the patient is registered
        Then the System will check the validity of the prescriber being matched to database
        When the prescription information is valid 
        Then the System will create a unique identifier to the prescription and add to the patient's prescriptions.


    Scenario 2: Agent is signed into the System, patient and prescriber information are valid
        Given Agent is signed into System 
        When the application command CreatePrescription is invoked
        Then the system will check if patient is registered 
        Given if the patient is registered
        Then the System will check the validity of the prescriber being matched to database
        When the prescription information is valid 
        Then the System will create a unique identifier to the prescription and add to the patient's prescriptions.