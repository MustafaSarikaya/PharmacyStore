package seg3102team3.project.infrastructure.web.forms.converters

import org.springframework.stereotype.Component
import seg3102team3.project.application.dtos.queries.PatientDto
import seg3102team3.project.infrastructure.web.forms.PatientForm
import java.time.LocalDate

@Component
class PatientFormDtoConverter{
    fun convertFormPatient(formData: PatientForm): PatientDto {
        return PatientDto(formData.phin,
            formData.firstname + " " + if(formData.middlenames != null) formData.middlenames + " " else "" + formData.lastname,
            "0, " + formData.streetName + ", " + formData.zipCode + ", " + formData.city + ", " + formData.province,
            formData.email,formData.phoneNumber,formData.gender, LocalDate.EPOCH,formData.language,formData.healthHistoryNote,
            emptyArray(), emptyArray(), formData.insuranceNumber)
    }
}
