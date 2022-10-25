package seg3102team3.project.usecases

import java.util.*

interface CreatePrescription {
    fun createPrescription(prescriptionInfo: PrescriptionInfoDto): Boolean
}
