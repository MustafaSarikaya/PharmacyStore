Feature: Register Patient by Pharmacist.
    Scenario 1: Pharmacist is signed into the System, Information entered into form is invalid
        Given Pharmacist is signed into System
        When the application command RegisterPatient is invoked
        Then the System provides a form asking for the Patient information
        When the Pharmacist submits the form
        Then the System will check the validity of the information in the form
        Given the information in the form is invalid
        Then the System will return the form, demanding for valid information
        When the Pharmacist submits the form with valid information
        Then the System will invoke the registerPatient command application
        And the System will allow Prescriptions to be filled for the Patient

    Scenario 2: Pharmacist is signed into the System, Information entered into form is valid
        Given Pharmacist is signed into System
        When the application command RegisterPatient is invoked
        Then the System provides a form asking for the Patient information
        When the Pharmacist submits the form
        Then the System will check the validity of the information in the form
        Given the information in the form is valid
        Then the System will invoke the registerPatient command application
        And the System will allow Prescriptions to be filled for the Patient
