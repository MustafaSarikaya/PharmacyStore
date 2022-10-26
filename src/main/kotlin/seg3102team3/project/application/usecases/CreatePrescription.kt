package seg3102team3.project.application.usecases

import seg3102team3.project.application.dtos.queries.PrescriptionDto
import java.util.UUID

interface CreatePrescription {
    fun createPrescription(prescriptionInfo: PrescriptionDto): UUID?
}