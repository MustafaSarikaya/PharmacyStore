package seg3102team3.project.domain.administration.factories

import seg3102team3.project.application.dtos.queries.AgentDto
import seg3102team3.project.domain.administration.entities.User

interface AgentFactory {
    fun createAgent(agentInfo: AgentDto): User
}