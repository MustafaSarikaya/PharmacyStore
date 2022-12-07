package seg3102team3.project.adapters.factories

import org.mapstruct.factory.Mappers
import seg3102team3.project.application.dtos.queries.AgentDto
import seg3102team3.project.application.dtos.queries.converters.AgentDtoConverter
import seg3102team3.project.domain.agent.entities.User
import seg3102team3.project.domain.agent.factories.UserFactory
import java.util.UUID

class AgentDtoFactory: UserFactory {
    private val dtoConverter = Mappers.getMapper(AgentDtoConverter::class.java)

    override fun createAgent(agentInfo: AgentDto): User {
        return dtoConverter.convertDto(agentInfo, UUID.randomUUID())
    }

}