Feature: Updating an Agent as an Administrator
    Scenario: Agent is registered in the System, Administrator is signed into System, Information entered into form is invalid
        Given the Administrator is signed into the System
        And the Agent is registered into the System
        When the Administrator selects an Agent
        And the Administrator prompts the System to update the Agent's information
        Then the System will provide a form to edit containing the Agent's current information
        When the Administrator submits the form
        Then the System will check the validitiy of the information entered in the form
        Given the information entered is invalid
        Then the System will return the form and ask the Administrator for valid information
        When the Administrator submits the form with valid information
        Then the application command privilegedUpdateAgent is invoked
        And the System will update the Agent object accordingly
        
    Scenario: Agent is registered in the System, Administrator is signed into System, Information entered into form is valid
        Given the Administrator is signed into the System
        And the Agent is registered into the System
        When the Administrator selects an Agent
        And the Administrator prompts the System to update the Agent's information
        Then the System will provide a form to edit containing the Agent's current information
        When the Administrator submits the form
        Then the System will check the validitiy of the information entered in the form
        Given the information entered is valid
        Then the application command privilegedUpdateAgent is invoked
        And the System will update the Agent object accordingly