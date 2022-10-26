Feature: Register Patient by Pharmacist.
    Scenario 1: Pharmacist is signed into the System, Information entered into form is invalid
        Given Pharmacist is signed into System
        When the Pharmacist prompts to register a Patient
        Then the System provides a form asking for the Patient information
        When the Pharmacist submits the form
        Then the System will check the validity of the information in the form
        Given the information in the form is invalid
        Then the System will return the form, demanding for valid information
        When the Pharmacist submits the form with valid information
        Then the System will invoke the registerPatient application command
        When the business logic of the System processes the registerPatient application command
        Then the System will create the Patient object
        And add the Patient object to its list of Patients

    Scenario 2: Pharmacist is signed into the System, Information entered into form is valid
        Given Pharmacist is signed into System
        When the Pharmacist prompts to register a Patient
        Then the System provides a form asking for the Patient information
        When the Pharmacist submits the form
        Then the System will check the validity of the information in the form
        Given the information in the form is valid
        Then the System will invoke the registerPatient application command
        When the business logic of the System processes the registerPatient application command
        Then the System will create the Patient object
        And add the Patient object to its list of Patients