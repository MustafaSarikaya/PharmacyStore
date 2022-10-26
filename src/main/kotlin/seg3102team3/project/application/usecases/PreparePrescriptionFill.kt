package seg3102team3.project.application.usecases

import seg3102team3.project.application.dtos.queries.PrescriptionFillDto
import java.util.UUID

interface PreparePrescriptionFill {
    fun preparePrescriptionFill(prescriptionFillInfo: PrescriptionFillDto): UUID? //agent client
    fun verifyPrescriptionFill(prescriptionFillID: UUID, clinicalCheck: String, verification: Boolean): Boolean //pharmacist client - clinical check info is associated with the Fill object and its status is changed (Cancelled/Verified) depending on verification bool
    fun fetchPrescriptionDocs(prescriptionFillID: UUID): ByteArray //agent client - ByteArray for returning both PDFs, as these are binary file formats
}