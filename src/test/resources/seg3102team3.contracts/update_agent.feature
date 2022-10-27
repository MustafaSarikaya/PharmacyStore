Feature: Updating One's Own Information as an Agent
    Scenario: Agent is signed into the System, email or password entered into form is invalid
        Given the Agent is signed into the System
        When the Agent prompts to update their credentials
        Then the System will provide a form to edit containing the Agent's current email and password
        When the Agents submits the form
        Then the System will check the validity of the credentials entered in the form
        Given the credentials entered are invalid
        Then the System will return the form and ask the Agent for valid credentials 
        When the Agent submits the form with valid credentials
        Then the application command updateAgent is invoked
        And the System will update the Agent's credentials accordingly
        
    Scenario: Agent is signed into the System, email or password entered into form is valid
        Given the Agent is signed into the System
        When the Agent prompts to update their credentials
        Then the System will provide a form to edit containing the Agent's current email and password
        When the Agents submits the form
        Then the System will check the validity of the credentials entered in the form
        Given the credentials entered are valid
        Then the application command updateAgent is invoked
        And the System will update the Agent's credentials accordingly
