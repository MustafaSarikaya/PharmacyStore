package seg3102team3.project.application.usecases

import seg3102team3.project.application.dtos.queries.AgentDto

interface PrivilegedUpdateAgent {
    fun privilegedUpdateAgent(updatedAgentInfo: AgentDto): Boolean
}