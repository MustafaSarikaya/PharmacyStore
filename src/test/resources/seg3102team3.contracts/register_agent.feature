Feature: Register Agent by Administrator.
    Scenario 1: Administrator registers the agent but information entered are invalid.
        Given Administrator register the agent
        When application command Register Patient is invoked
        Then the System will provide a form asking for Agent information
        When information are submitted 
        Then System will check for validity 
        Given information is invalid
        Then The System will notify agent to re-enter information until validity
        When information passes validity 
        Then System will create an account with specified credential for the agent.

    Scenario 2: Administrator registers the agent and information entered are valid.
        Given Administrator register the agent
        When application command Register Patient is invoked
        Then the System will provide a form asking for Agent information
        When information are submitted 
        Given information entered are valid
        When information passes validity 
        Then System will create an account with specified credential for the agent.