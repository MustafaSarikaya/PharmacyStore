package seg3102team3.project.application.dtos.queries

import java.time.LocalDate
import java.util.UUID

data class PrescriptionFillDto (
    val prescriptionID: UUID,
    val lotNumber: Int,
    val expiryDate: LocalDate,
    val status: String) //this matches to an PrescriptionFillStatus enum (Prepared/Verified/Retrieved/Cancelled) defined in the prescription subdomain