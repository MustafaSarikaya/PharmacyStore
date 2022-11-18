Feature: Updating One's Own Information as an Agent.
    Scenario: Agent is registered
        Given an agent exists with the given ID
        And the agent info's language preference matches to a Language value
        And the agent info's gender matches to a Gender value
        When the application command updateAgent is invoked
        Then the agent's UserRole remains the same as before
        And the agent is otherwise updated from the agent information
