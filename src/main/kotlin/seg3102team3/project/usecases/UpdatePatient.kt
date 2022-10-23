package seg3102team3.project.usecases

import java.util.*

interface UpdatePatient {
    fun UpdatePatient(updatePatientInfo: UpdatePatientInfoDto): Boolean
    
}