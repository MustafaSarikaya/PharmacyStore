package seg3102team3.project.application.dtos.queries

import java.util.*

data class PrescriptionFillDto (
    val totalDrugAmount: String,
    val dosageAmount: String,
    val lotNumber: Int,
    val expiryDate: Date,
    val patientID: UUID,
    val pickUpSummary: String
        ) {
    var prescriptionInfo: PrescriptionDto? = null
    //todo remember to add the pick-up summary string
}
