package seg3102team3.project.usecases

import java.util.*

interface RegisterPatient {
    fun RegisterPatient(PatientInfo: PatientInfoDto): Boolean
    
}