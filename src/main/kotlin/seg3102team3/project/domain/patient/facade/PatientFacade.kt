package seg3102team3.project.domain.patient.facade

import seg3102team3.project.application.dtos.queries.PatientDto;
import seg3102team3.project.application.dtos.queries.PrescriptionDto;
import java.util.UUID

interface PatientFacade {
    fun addPatient(patientInfo: PatientDto)
    fun addPrescription(patientID: String, prescriptionInfo: PrescriptionDto)
    fun addPrescriptionFill(prescriptionID: UUID, agentID: UUID, clinicalCheck: String)
    fun updatePatient(patientInfo: PatientDto)
    fun identifyPatientByName(name: String): String?
    fun identifyPatientByEmail(email: String): String?
    fun identifyPatientByPHIN(phin: String): String?
    fun fetchPrescriptionFillDIN(prescriptionFillID: UUID): String
    fun pickUpPrescriptionFill(prescriptionFillID: UUID, agentID: UUID, pickUpSummary: String)
    fun verifyPatientIdentifier(someIdentifier: String):String?
    fun verifyPrescriptionFill(prescriptionFillID: UUID, pharmacistID: UUID, clinicalCheck: String)
    fun cancelPrescriptionFill(prescriptionFillID: UUID, pharmacistID: UUID, clinicalCheck: String)
}