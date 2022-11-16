package seg3102team3.project.application.usecases.implementation

import seg3102team3.project.application.usecases.PickUpMedicine
import seg3102team3.project.domain.patient.facade.PatientFacade
import java.util.*

class PickUpMedicineImpl(
    private var patientFacade: PatientFacade): PickUpMedicine {

    override fun pickUpMedicine(prescriptionFillId: UUID, pharmacistID: UUID, pickUpSummary: String): Boolean {
        var success: Boolean = patientFacade.pickUpPrescriptionFill(prescriptionFillId, pharmacistID, pickUpSummary)
        return success
    }
}