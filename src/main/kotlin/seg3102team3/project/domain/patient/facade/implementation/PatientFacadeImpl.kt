package seg3102team3.project.domain.patient.facade.implementation

import seg3102team3.project.application.dtos.queries.PatientDto
import seg3102team3.project.application.dtos.queries.PrescriptionDto
import seg3102team3.project.application.dtos.queries.PrescriptionFillDto
import seg3102team3.project.application.services.DomainEventEmitter
import seg3102team3.project.domain.common.PrescriptionFillStatus
import seg3102team3.project.domain.patient.entities.Patient
import seg3102team3.project.domain.patient.entities.PrescriptionFill
import seg3102team3.project.domain.patient.facade.PatientFacade
import seg3102team3.project.domain.patient.factory.PatientFactory
import seg3102team3.project.domain.patient.factory.PrescriptionFactory
import seg3102team3.project.domain.patient.factory.PrescriptionFillFactory
import seg3102team3.project.domain.patient.repository.PatientRepository
import seg3102team3.project.domain.patient.repository.PrescriptionFillRepository
import seg3102team3.project.domain.patient.repository.PrescriptionRepository
import java.util.*

class PatientFacadeImpl (
    private var patientFactory: PatientFactory,
    private var patientRepository: PatientRepository,
    private var prescriptionFactory: PrescriptionFactory,
    private var prescriptionRepository: PrescriptionRepository,
    private var prescriptionFillFactory: PrescriptionFillFactory,
    private var prescriptionFillRepository: PrescriptionFillRepository,
    private var eventEmitter: DomainEventEmitter
): PatientFacade {

    override fun addPatient(patientInfo: PatientDto) {
        val patient = patientFactory.createPatient(patientInfo)
        patientRepository.save(patient)
//        eventEmitter.emit()
    }

    override fun addPrescription(patientID: String, prescriptionInfo: PrescriptionDto) {
        val prescription = prescriptionFactory.createPrescription(prescriptionInfo)
        prescriptionRepository.save(patientID, prescription)
//        eventEmitter.emit()
    }

    override fun addPrescriptionFill(prescriptionFillInfo: PrescriptionFillDto, agentID: UUID) {
        val prescriptionFill = prescriptionFillFactory.createPrescriptionFill(prescriptionFillInfo)
        prescriptionFillRepository.save(prescriptionFill, agentID)
//        eventEmitter.emit()
    }

    override fun updatePatient(patientInfo: PatientDto) {
        val patient = patientFactory.createPatient(patientInfo)
        patientRepository.update(patient)
//        eventEmitter.emit()
    }

    override fun identifyPatientByName(name: String): Patient? {
        return patientRepository.find(name)
    }

    override fun identifyPatientByEmail(email: String): Patient? {
        return patientRepository.find(email)
    }

    override fun identifyPatientByPHIN(phin: String): Patient? {
        return patientRepository.find(phin)
    }

    override fun fetchPrescriptionFillDIN(prescriptionFillID: UUID): UInt? {
        val prescriptionFill = prescriptionFillRepository.find(prescriptionFillID)
        val prescription = prescriptionFill?.presriptionID?.let { prescriptionRepository.find(it) }
        val DIN = prescription?.drugIdentificationNumber
        return DIN
    }

    override fun pickUpPrescriptionFill(prescriptionFillID: UUID, agentID: UUID, pickUpSummary: String) {
        val prescriptionFill = prescriptionFillRepository.find(prescriptionFillID)
        if (prescriptionFill != null) {
            prescriptionFill.status = PrescriptionFillStatus.RETRIEVED
            prescriptionFill.pickUpSummary = pickUpSummary
            prescriptionFillRepository.update(prescriptionFill, agentID)
        }
    }

    override fun verifyPatientIdentifier(someIdentifier: String): Patient? {
        return patientRepository.find(someIdentifier)
    }

    override fun verifyPrescriptionFill(prescriptionFillID: UUID, pharmacistID: UUID, clinicalCheck: String) {
        val prescriptionFill = prescriptionFillRepository.find(prescriptionFillID)
        if (prescriptionFill != null) {
            prescriptionFill.status = PrescriptionFillStatus.VERIFIED
            prescriptionFill.clinicalCheck = clinicalCheck
            prescriptionFillRepository.update(prescriptionFill, pharmacistID)
        }
    }

    override fun cancelPrescriptionFill(prescriptionFillID: UUID, pharmacistID: UUID, clinicalCheck: String) {
        val prescriptionFill = prescriptionFillRepository.find(prescriptionFillID)
        if (prescriptionFill != null) {
            prescriptionFill.status = PrescriptionFillStatus.CANCELLED
            prescriptionFill.clinicalCheck = clinicalCheck
            prescriptionFillRepository.update(prescriptionFill, pharmacistID)
        }
    }

}