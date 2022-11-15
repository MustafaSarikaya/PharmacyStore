package seg3102team3.project.domain.administration.facade

import seg3102team3.project.application.dtos.queries.AgentDto

interface AgentFacade {
    fun addAgent(agentInfo: AgentDto) : UUID
    fun updateAgent(agentInfo: AgentDto)
    fun updateAgentCredentials(agentID: UUID, email: String, password: String)
    fun unregisterAgent(agentID: UUID)
}