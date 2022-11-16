package seg3102team3.project.domain.patient.entities

import seg3102team3.project.domain.common.PrescriptionFillStatus
import java.time.LocalDate
import java.util.UUID

class PrescriptionFill(val id: UUID,
                       val presriptionID: UUID,
                       val lotNumber: UInt,
                       val expiryDate: LocalDate,
                       var status: PrescriptionFillStatus,
                       var pickUpSummary: String?,
                       var clinicalCheck: String?
    ) {
}