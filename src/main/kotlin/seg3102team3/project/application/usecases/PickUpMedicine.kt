package seg3102team3.project.application.usecases

import java.util.UUID

interface PickUpMedicine {
    fun pickUpMedicine(prescriptionFillId: UUID, pickUpSummary: String): Boolean
}