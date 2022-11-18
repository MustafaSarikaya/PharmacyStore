package seg3102team3.project.application.usecases.implementation

import seg3102team3.project.application.dtos.queries.AgentDto
import seg3102team3.project.application.usecases.UpdateAgent
import seg3102team3.project.domain.agent.facade.AgentFacade
import java.util.*

class UpdateAgentImpl(
    private var agentFacade: AgentFacade):UpdateAgent {
    override fun updateAgent(agentID: UUID, updatedAgentInfo: AgentDto): Boolean {
        updatedAgentInfo.pharmacist = agentFacade.isPharmacist(agentID)
        var result: Boolean = agentFacade.updateAgent(agentID, updatedAgentInfo)
        return result
    }
}