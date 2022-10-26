package seg3102team3.project.application.usecases

import java.util.UUID

interface UpdateAgent {
    fun updateAgent(agentID: UUID, email: String, password: String): Boolean
}