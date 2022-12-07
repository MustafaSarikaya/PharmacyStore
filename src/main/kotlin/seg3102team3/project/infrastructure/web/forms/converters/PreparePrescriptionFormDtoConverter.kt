package seg3102team3.project.infrastructure.web.forms.converters

import seg3102team3.project.application.dtos.queries.PrescriptionFillDto
import seg3102team3.project.infrastructure.web.forms.PrescriptionForm
import java.time.LocalDate
import java.util.UUID

abstract class PreparePrescriptionFormDtoConverter {

    abstract fun convertPrescriptionFill(prescriptionForm: PrescriptionForm): PrescriptionFillDto

    fun mapPrescriptionId(prescriptionId: String): UUID {
        return UUID.fromString(prescriptionId)
    }

    fun mapExpiryDate(expiryDate: String): LocalDate {
        return LocalDate.parse(expiryDate)
    }
}