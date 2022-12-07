package seg3102team3.project.infrastructure.web.forms.converters

import seg3102team3.project.application.dtos.queries.PrescriptionDto
import seg3102team3.project.infrastructure.web.forms.PrescriptionForm
import java.time.LocalDateTime

abstract class PrescriptionFormDtoConverter {

    // TODO update mappings (check for the input field for patient)
    abstract fun convertPrescription(patientId: String, formData: PrescriptionForm): PrescriptionDto

    fun mapOriginDate(originDate: String): LocalDateTime {
        return LocalDateTime.parse(originDate)
    }
}