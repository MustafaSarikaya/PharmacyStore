package seg3102team3.project.adapters.factories

import org.mapstruct.factory.Mappers
import seg3102team3.project.application.dtos.queries.PrescriptionDto
import seg3102team3.project.application.dtos.queries.PrescriptionFillDto
import seg3102team3.project.application.dtos.queries.converters.PrescriptionDtoConverter
import seg3102team3.project.application.dtos.queries.converters.PrescriptionFillDtoConverter
import seg3102team3.project.domain.patient.entities.Prescription
import seg3102team3.project.domain.patient.entities.PrescriptionFill
import seg3102team3.project.domain.patient.factory.PrescriptionFillFactory
import java.util.*

class PrescriptionFillDtoFactory: PrescriptionFillFactory {
    private val dtoConverter = Mappers.getMapper(PrescriptionFillDtoConverter::class.java)

    override fun createPrescriptionFill(
        prescriptionFillInfo: PrescriptionFillDto
    ): PrescriptionFill {
        return dtoConverter.convertDTO(prescriptionFillInfo, UUID.randomUUID())
    }
}