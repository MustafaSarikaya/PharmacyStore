package seg3102team3.project.application.usecases

import java.util.UUID

interface PickUpMedicine {
    fun pickUpMedicine(prescriptionFillId: UUID, pickUpSummary: String): Boolean
    //pick up summary is updated from null to the new value in the chosen Prescription Fill's domain entity & status is set to retrieved
}