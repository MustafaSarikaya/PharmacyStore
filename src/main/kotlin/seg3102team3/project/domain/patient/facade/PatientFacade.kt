package seg3102team3.project.domain.patient.facade

import seg3102team3.project.application.dtos.queries.PatientDto;
import seg3102team3.project.application.dtos.queries.PrescriptionDto;
import seg3102team3.project.application.dtos.queries.PrescriptionFillDto
import seg3102team3.project.domain.patient.entities.Patient
import java.util.UUID

interface PatientFacade {
    fun addPatient(patientInfo: PatientDto)
    fun addPrescription(patientId: String, prescriptionInfo: PrescriptionDto)
    fun addPrescriptionFill(prescriptionFillInfo: PrescriptionFillDto, agentID: UUID)
    fun updatePatient(patientID: String, patientInfo: PatientDto)
    fun identifyPatientByName(name: String): Patient?
    fun identifyPatientByEmail(email: String): Patient?
    fun identifyPatientByPHIN(phin: String): Patient?
    fun fetchPrescriptionFillDIN(prescriptionFillID: UUID): String
    fun pickUpPrescriptionFill(prescriptionFillID: UUID, agentID: UUID, pickUpSummary: String)
    fun verifyPatientIdentifier(someIdentifier: String):Patient?
    fun verifyPrescriptionFill(prescriptionFillID: UUID, pharmacistID: UUID, clinicalCheck: String)
    fun cancelPrescriptionFill(prescriptionFillID: UUID, pharmacistID: UUID, clinicalCheck: String)
}