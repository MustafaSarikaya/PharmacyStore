Feature: Update Patient
    Scenario 1: Patient is registered in the System, Pharmacist is signed into System, Information entered into form is invalid
        Given the Pharmacist is signed into the System
        And the Patient is registered into the System
        When the Pharmacist selects the Patient
        And the Pharmacist prompts the System to update a Patient's information
        Then the System will provide a form containing current information
        When the Pharmacist submits the form
        Then the System will check the validitiy of the information entered in the form
        Given the information entered is invalid
        Then the System will return the form and ask the Pharmacist for valid information
        When the Pharmacist submits the form with valid information
        Then the application command updatePatient is invoked
        And the System will update the Patient object accordingly
        
    Scenario 2: Patient is registered in the System, Pharmacist is signed into System, Information entered into form is valid
        Given the Pharmacist is signed into the System
        And the Patient is registered into the System
        When the Pharmacist selects the Patient
        And the Pharmacist prompts the System to update a Patient's information
        Then the System will provide a form containing current information
        When the Pharmacist submits the form
        Then the System will check the validitiy of the information entered in the form
        Given the information entered is valid
        Then the application command updatePatient is invoked
        And the System will update the Patient object accordingly
