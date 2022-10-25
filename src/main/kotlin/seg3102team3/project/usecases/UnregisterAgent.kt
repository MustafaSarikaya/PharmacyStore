package seg3102team3.project.usecases

import java.util.*

interface UnregisterAgent {
    fun unregisterAgent(unregisterAgentInfo: UnregisterAgentDto): Boolean
}
