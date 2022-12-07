package seg3102team3.project.infrastructure.web.forms.converters

import seg3102team3.project.application.dtos.queries.AgentDto
import seg3102team3.project.domain.common.Gender
import seg3102team3.project.domain.common.LanguagePreference
import seg3102team3.project.infrastructure.web.forms.AgentForm
import java.util.UUID

abstract class AgentFormDtoConverter {
    abstract fun convertAgent(form: AgentForm): AgentDto

    fun mapGender(gender: String): Gender {
        return Gender.valueOf(gender)
    }

    fun mapLanguagePref(languagePref: String): LanguagePreference {
        return LanguagePreference.valueOf(languagePref)
    }
}