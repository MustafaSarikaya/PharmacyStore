Feature: Fetch Drug Information and Counselling Documents
    Scenario: Agent is signed in and Prescription Fill is verified 
        Given the Agent is signed in 
        And the Prescription Fill has been verified
        Then the System notifies the Agent that the Prescription Fill has been verified
        When the Agent requests drug information and counselling documents for that Prescription Fill
        Then the System invokes the fetchPrescriptionDocs application command 
        And the System fetches those documents from the Drug Product Database 
        And the System returns those documents to the Agent