package seg3102team3.project.usecases

import java.util.*

interface PreparePrescription {
    fun preparePrescription(preparePrescriptionFill: PreparePrescriptionFillDto): Boolean
}
