package seg3102team3.project.adapters.factories

import org.mapstruct.factory.Mappers
import seg3102team3.project.application.dtos.queries.PrescriptionDto
import seg3102team3.project.application.dtos.queries.converters.PrescriptionDtoConverter
import seg3102team3.project.domain.patient.entities.Prescription
import seg3102team3.project.domain.patient.factory.PrescriptionFactory
import java.util.*

class PrescriptionDtoFactory : PrescriptionFactory {
    private val dtoConverter = Mappers.getMapper(PrescriptionDtoConverter::class.java)

    override fun createPrescription(
        prescriptionInfo: PrescriptionDto
    ): Prescription {
        return dtoConverter.convertDTO(prescriptionInfo, UUID.randomUUID())
    }
}