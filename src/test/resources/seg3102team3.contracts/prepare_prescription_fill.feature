Feature: Prepare Prescription Fill.
    Scenario 1: Agent locates medicine , medicine is not in stock.
        Given Agent is locating the medine
        When the agent could not search for the medicine , a orderMedicine command will be initiated
        Then the system will contact the patient for a later pick-up.
        And application command PreparePrescription will be invoked
        Then status will be set to delay.


    Scenario 2: Agent locates medicine , medicine is in stock.
        Given Agent is locating the medine
        When the agent could search for the medicine
        Then the agent prepares a container with all prescribed information printed on the contrainer
        And application command PreparePrescription will be invoked
        And the system will set prescription status as prepared and notify vertification by pharamcist
        When pharamcist verifies the prescription is applicable for patient where assessments and allergies are tested on the patient
        Then pharamcist sets prescription status as verified
        And application command PreparePrescription will be invoked 
        Then Prescription Status will be set to Ready.
        And agent will print off information and documents for the patient
        Then informs the patient that medicine is ready for pick-up.