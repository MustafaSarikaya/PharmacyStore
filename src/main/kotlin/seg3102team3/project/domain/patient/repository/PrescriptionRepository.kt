package seg3102team3.project.domain.patient.repository

import seg3102team3.project.domain.patient.entities.Patient
import seg3102team3.project.domain.patient.entities.Prescription
import java.util.*

interface PrescriptionRepository {
    fun save(prescription: Prescription): Prescription
    fun find(id: UUID): Prescription?
}