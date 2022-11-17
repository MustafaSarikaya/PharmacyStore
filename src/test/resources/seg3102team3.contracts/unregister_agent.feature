//TO REDO LATER FOR BDD; RAN OUT OF TIME
Feature: Unregistering an Agent.
    Scenario: The Administrator is signed into the System
        Given the Administrator is signed in
        When the Administrator prompts to un-register an Agent
        Then the System provides a form for Administrator to select which agent is to be un-registered
        When the Administrator submits the form
        Then the System will ask for confirmation
        When the Administrator provides confirmation 
        Then the System invokes the unregisterAgent application command
        And the System sets the Agent's account as deactivated
