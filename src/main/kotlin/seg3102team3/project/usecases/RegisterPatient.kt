package seg3102team3.project.usecases

import java.util.*

interface RegisterPatient {
    fun registerPatient(newPatientInfo: PatientInfoDto): Boolean
}
