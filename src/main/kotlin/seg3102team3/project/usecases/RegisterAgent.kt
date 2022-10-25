package seg3102team3.project.usecases

import java.util.*

interface RegisterAgent {
    fun registerAgent(newAgentInfo: AgentInfoDto): Boolean
}
