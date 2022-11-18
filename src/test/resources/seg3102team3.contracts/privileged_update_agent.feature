Feature: Updating an Agent as an Administrator
    Scenario: Admin updates a registered Agent
        Given the Agent is registered into the System
        And the agent info's language preference matches to a Language value
        And the agent info's gender matches to a Gender value
        When the application command privilegedUpdateAgent is invoked
        Then the agent is updated from the agent information