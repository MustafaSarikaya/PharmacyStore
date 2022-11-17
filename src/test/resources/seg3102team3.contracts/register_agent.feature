//TO REDO LATER FOR BDD; RAN OUT OF TIME
Feature: Registering an Agent.
    Scenario: The Administrator is signed into the System, information entered is invalid
        Given the Administrator is signed in
        When the Administrator prompts to register an Agent
        Then the System provides a form asking for the Agent information
        When the Administrator submits the form
        Then the System will check the validity of the information in the form 
        Given the information in the form is invalid
        Then the System will return the form asking to modify the invalid information
        When the Administrator submits the form with valid information
        Then the System will invoke the registerAgent application command
        And the System creates a new Agent object with the provided information  
        And the System sets the Agent's account as activated

    Scenario: The Administrator is signed into the System, information entered is valid
        Given the Administrator is signed in
        When the Administrator prompts to register an Agent
        Then the System provides a form asking for the Agent information
        When the Administrator submits the form
        Then the System will check the validity of the information in the form 
        Given the information in the form is valid
        Then the System will invoke the registerAgent application command
        And the System creates a new Agent object with the provided information  
        And the System sets the Agent's account as activated