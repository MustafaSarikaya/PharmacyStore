Feature: Pick Up Medicine.
    Scenario: Patient arrives for a pick up.
        Given patient has arrived
        Then the pharamacist will review instructions and side effects with the patient
        And patients will ask questions about information about medicine.
        Then pharamcist records a summary of discussion
        And calls application comamnd PickUpMedicine to change prescription status as true.
        