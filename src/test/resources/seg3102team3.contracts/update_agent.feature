Feature: Update Agent.
    Scenario 1: Agent needs update but information filled is invalid.
        Given Agent needs to update information
        Then application command UpdateAgent will be invoked
        And the System will create a new form for the agent to fill in new password and email
        Given Information filled is invalid 
        When system checks the information entered being invalid 
        Then system will inform to input the correct format of email and password 
        And system will check for validity again.
        When information is valid
        Then System will update the agent information.



    Scenario 2: Agent needs update where information filled is valid.
        Given Agent needs to update information
        Then application command UpdateAgent will be invoked
        And the System will create a new form for the agent to fill in new password and email
        Given Information filled is valid 
        When information is valid
        Then System will update the agent information.