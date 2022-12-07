package seg3102team3.project.infrastructure.web.forms.converters

import seg3102team3.project.application.dtos.queries.PatientDto
import seg3102team3.project.infrastructure.web.forms.PatientForm
import java.time.LocalDate

abstract class PatientFormDtoConverter {

    abstract fun convertPatient(formData: PatientForm): PatientDto

    fun mapDateOfBirth(dateOfBirth: String): LocalDate {
        return LocalDate.parse(dateOfBirth)
    }
}