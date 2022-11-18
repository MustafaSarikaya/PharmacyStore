Feature: Fetch Drug Information and Counselling Documents
    Scenario: Fetching all documents of a verified prescription fill's drug
        Given the Prescription Fill specified by the given ID is registered
        And the status of the Prescription Fill specified by the given ID is verified
        When application command fetchPrescriptionDocs is invoked
        Then the System fetches and returns those documents from the Drug Product Database