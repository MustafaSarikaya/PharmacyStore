package seg3102team3.project.application.usecases.implementation

import seg3102team3.project.application.dtos.queries.PrescriptionFillDto
import seg3102team3.project.application.usecases.PreparePrescriptionFill
import seg3102team3.project.domain.patient.facade.PatientFacade
import seg3102team3.project.domain.prescriber.facade.PrescriberFacade
import java.util.*

class PreparePrescriptionFillImpl(
    private var patientFacade: PatientFacade,
    private var prescriberFacade: PrescriberFacade): PreparePrescriptionFill {

    override fun preparePrescriptionFill(prescriptionFillInfo: PrescriptionFillDto, agentID: UUID): UUID? {
        var uuid: UUID? = patientFacade.addPrescriptionFill(prescriptionFillInfo, agentID)
        return uuid
    }

    override fun fetchPrescriberContactInfo(prescriberID: String): String? {
        var contactInfo: String? = prescriberFacade.fetchContactInfo(prescriberID)
        return contactInfo
    }

    override fun verifyPrescriptionFill(
        prescriptionFillID: UUID,
        pharmacistID: UUID,
        clinicalCheck: String,
        verification: Boolean
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun fetchPrescriptionDocs(prescriptionFillID: UUID): ByteArray {
        TODO("Not yet implemented")
    }
}