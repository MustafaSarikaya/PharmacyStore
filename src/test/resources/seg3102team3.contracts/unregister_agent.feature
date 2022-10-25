Feature: Unregister Agent by Administrator.
    Scenario 1: Administor unregisteres agent but agent account could not be found.
        Given Administor unregisters the agent
        Then application command UnregisteredAgent will be invoked
        And system will search for the agent
        Given Agent Account could not be found in the system
        Then system will return AgentNotFound status.


    Scenario 2: Administor unregisters agent and agent is found .
        Given Administor unregisters the agent
        Then application command UnregisteredAgent will be invoked
        And system will search for the agent
        Given Agent Account is found in the system
        Then system will ask for confirmation to Unregistered Agent
        And system will remove agent from the database of agents in the system.
