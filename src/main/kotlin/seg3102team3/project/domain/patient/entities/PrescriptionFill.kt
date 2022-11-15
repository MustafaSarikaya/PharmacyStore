package seg3102team3.project.domain.patient.entities

import java.time.LocalDate
import java.util.UUID

class PrescriptionFill(val id: UUID,
                       val lotNumber: UInt,
                       val expiryDate: LocalDate
) {
}