package seg3102team3.project.domain.patient.repository

import seg3102team3.project.domain.patient.entities.Patient
import java.util.*

interface PatientRepository {
        fun save(patient: Patient): Patient
        fun find(id: UUID): Patient?
        fun find(searchKey: String): Patient?

        fun updatePatient(patient: Patient): Patient
}
