Feature: Unregistering an Agent.
    Scenario: Deactivating an agent account
        Given the user account specified by the given ID is registered
        And the user account specified by the given ID is not an Administrator
        And the user account specified by the given ID is active
        When application command unregisterAgent is invoked
        Then the Agent's account is marked as deactivated
