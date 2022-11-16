package seg3102team3.project.domain.administration.events

import seg3102team3.project.domain.common.DomainEvent
import java.util.*

class AgentUpdated(
    val id: UUID,
    val occuredOn: Date,
    val userID: UUID
) : DomainEvent