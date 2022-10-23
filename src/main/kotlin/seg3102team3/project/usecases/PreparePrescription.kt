package seg3102team3.project.usecases

import java.util.*

interface PreparePrescription {
    fun PreparePrescription(preparePrescriptionFill: PreparePrescriptionFillDto): Boolean
}