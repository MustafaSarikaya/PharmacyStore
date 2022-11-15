package seg3102team3.project.domain.patient.repository

import seg3102team3.project.domain.patient.entities.PrescriptionFill
import java.util.*

interface PrescriptionFillRepository {
    fun save(prescriptionFill: PrescriptionFill, agentID: UUID): PrescriptionFill
    fun find(id: UUID): PrescriptionFill?
    fun update(prescriptionFill: PrescriptionFill, agentID: UUID): PrescriptionFill

}