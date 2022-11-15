package seg3102team3.project.domain.administration.facade.implementation

import seg3102team3.project.application.dtos.queries.AgentDto
import seg3102team3.project.domain.administration.repositories.UserRepository
import seg3102team3.project.domain.administration.factories.AgentFactory
import seg3102team3.project.application.services.DomainEventEmitter
import seg3102team3.project.domain.administration.events.NewAgentCreated
import seg3102team3.project.domain.administration.events.AgentUpdated
import seg3102team3.project.domain.administration.events.AgentRemoved
import java.util.*

class AgentFacadeImpl (
        var userRepository: UserRepository,
        var agentFactory: AgentFactory,
        var eventEmitter: DomainEventEmitter
    ): AgentFacade {

    override fun addAgent(agentInfo: AgentDto): UUID {
        val agent = agentFactory.createAgent(agentInfo)
        userRepository.save(agent)
        eventEmitter.emit(NewAgentCreated(UUID.randomUUID(), Date(), agent.id))
        return agent.id
    }

    override fun updateAgent(agentID: UUID, agentInfo: AgentDto) {
        val agent = userRepository.find(agentID)
        if (agent != null) {
            val tempAgent = agentFactory.addAgent(agentInfo)
            agent.name = tempAgent.name
            agent.userName = tempAgent.userName
            agent.language = tempAgent.language
            agent.role = tempAgent.role
        }
    }

    override fun updateAgentCredentials(agentID: UUID, email: String, password: String) {
        val agent = userRepository.find(agentID)
        if (agent != null) {
            agent.email = email
            agent.password = password
        }
    }

    override fun unregisterAgent(agentID: UUID) {
        val agent = userRepository.find(agentID)
        if (agent != null) {
            agent = null
            
        }
    }
}