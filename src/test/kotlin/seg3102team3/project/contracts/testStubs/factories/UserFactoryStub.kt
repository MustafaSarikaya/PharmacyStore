package seg3102team3.project.contracts.testStubs.factories

import seg3102team3.project.application.dtos.queries.AgentDto
import seg3102team3.project.domain.agent.entities.User
import seg3102team3.project.domain.agent.entities.UserRole
import seg3102team3.project.domain.agent.factories.UserFactory
import seg3102team3.project.domain.common.Gender
import seg3102team3.project.domain.common.LanguagePreference
import seg3102team3.project.domain.common.Name
import java.util.UUID

class UserFactoryStub: UserFactory {
    override fun createAgent(agentInfo: AgentDto): User {
        return User(
            UUID.randomUUID(),
            agentInfo.username,
            agentInfo.email,
            agentInfo.password,
            Name(
                agentInfo.fullName.substring(0, agentInfo.fullName.indexOf(' ')),
                agentInfo.fullName.substring(agentInfo.fullName.indexOf(' ')+1, agentInfo.fullName.lastIndexOf(' ')),
                agentInfo.fullName.substring(agentInfo.fullName.lastIndexOf(' ')+1),
            ),
            LanguagePreference.valueOf(agentInfo.languagePref),
            Gender.valueOf(agentInfo.gender),
            if(agentInfo.pharmacist) UserRole.PHARMACIST else UserRole.ASSISTANT
        )
    }
}