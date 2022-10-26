package seg3102team3.project.application.dtos.queries

import java.time.LocalDate
import java.util.UUID

data class PrescriptionFillDto (
    val totalDrugAmount: String,
    val dosageAmount: String,
    val lotNumber: Int,
    val expiryDate: LocalDate,
    val patientID: UUID,
    val pickUpSummary: String,
    val verification: Boolean,
    val verifierID: UUID,
) {
    var prescriptionInfo: PrescriptionDto? = null
    //todo remember to add the pick-up summary string
}
