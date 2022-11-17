package seg3102team3.project.domain.patient.facade.implementation

import seg3102team3.project.application.dtos.queries.PatientDto
import seg3102team3.project.application.dtos.queries.PrescriptionDto
import seg3102team3.project.application.dtos.queries.PrescriptionFillDto
import seg3102team3.project.application.services.DomainEventEmitter
import seg3102team3.project.domain.patient.entities.PrescriptionFillStatus
import seg3102team3.project.domain.patient.entities.Patient
import seg3102team3.project.domain.patient.events.NewPatientAdded
import seg3102team3.project.domain.patient.events.NewPrescriptionAdded
import seg3102team3.project.domain.patient.events.NewPrescriptionFillAdded
import seg3102team3.project.domain.patient.events.PatientUpdated
import seg3102team3.project.domain.patient.facade.PatientFacade
import seg3102team3.project.domain.patient.factory.PatientFactory
import seg3102team3.project.domain.patient.factory.PrescriptionFactory
import seg3102team3.project.domain.patient.factory.PrescriptionFillFactory
import seg3102team3.project.domain.patient.repository.PatientRepository
import seg3102team3.project.domain.patient.repository.PrescriptionFillRepository
import seg3102team3.project.domain.patient.repository.PrescriptionRepository
import java.time.LocalDateTime
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

    override fun addPatient(newPatientInfo: PatientDto): String {
        val patient = patientFactory.createPatient(newPatientInfo)
        patientRepository.save(patient)
        eventEmitter.emit(NewPatientAdded(patient.id, Date()))
        return patient.id
    }

    override fun addPrescription(prescriptionInfo: PrescriptionDto): UUID? {
        val patient = patientRepository.find(prescriptionInfo.patientID)
        if(patient == null) return null

        val prescription = prescriptionFactory.createPrescription(prescriptionInfo)
        prescription.patient = patient
        patient.prescriptions.add(prescription)

        patientRepository.save(patient)
        eventEmitter.emit(NewPrescriptionAdded(prescription.id, Date()))
        return prescription.id
    }

    override fun addPrescriptionFill(prescriptionFillInfo: PrescriptionFillDto, agentID: UUID): UUID? {
        val patient = patientRepository.findByPrescriptionID(prescriptionFillInfo.prescriptionID)
        if(patient == null) return null

        val prescription = patient.getPrescription(prescriptionFillInfo.prescriptionID)
        if(prescription == null) return null

        val prescriptionFill = prescriptionFillFactory.createPrescriptionFill(prescriptionFillInfo)
        prescriptionFill.prescription = prescription
        prescriptionFill.preparationAgentID = agentID
        prescription.fills.add(prescriptionFill)

        patientRepository.save(patient)
        eventEmitter.emit(NewPrescriptionFillAdded(prescriptionFill.id, Date()))
        return prescriptionFill.id
    }

    override fun updatePatient(patientID: String, patientInfo: PatientDto): Boolean {
        val patient = patientRepository.find(patientID)
        if(patient == null) return false

        patient.update(patientInfo)
        patientRepository.save(patient)
        eventEmitter.emit(PatientUpdated(patient.id, Date()))
        return true
    }

    override fun identifyPatientByName(name: String): String? {
        return patientRepository.findByName(name)?.id
    }

    override fun identifyPatientByEmail(email: String): String? {
        return patientRepository.findByEmail(email)?.id
    }

    override fun identifyPatientByPHIN(phin: String): String? {
        return patientRepository.find(phin)?.id
    }

    override fun fetchPrescriptionFillDIN(prescriptionFillID: UUID): UInt? {
        val prescriptionFill = prescriptionFillRepository.find(prescriptionFillID)
        val prescription = prescriptionFill?.prescription?.let { prescriptionRepository.find(it.id) }
        val DIN = prescription?.drugIdentificationNumber
        return DIN
    }

    override fun pickUpPrescriptionFill(prescriptionFillID: UUID, agentID: UUID, pickUpSummary: String): Boolean {
        val prescriptionFill = prescriptionFillRepository.find(prescriptionFillID)
        if(prescriptionFill == null) return false
        prescriptionFill.status = PrescriptionFillStatus.RETRIEVED
        prescriptionFill.pickUpSummary = pickUpSummary
        prescriptionFillRepository.update(prescriptionFill, agentID)
        return true
    }

    override fun verifyPatientIdentifier(someIdentifier: String): Patient? {
        return patientRepository.find(someIdentifier)
    }

    override fun verifyPrescriptionFill(prescriptionFillID: UUID, pharmacistID: UUID, clinicalCheck: String, verification: Boolean): Boolean {
        val prescriptionFill = prescriptionFillRepository.find(prescriptionFillID)
        if(prescriptionFill == null) return false

        prescriptionFill.status = if(verification) PrescriptionFillStatus.VERIFIED else PrescriptionFillStatus.CANCELLED
        prescriptionFill.clinicalCheck = clinicalCheck
        prescriptionFillRepository.update(prescriptionFill, pharmacistID)

        return true
    }

}