package seg3102team3.project.domain.patient.facade.implementation

import seg3102team3.project.application.dtos.queries.PatientDto
import seg3102team3.project.application.dtos.queries.PrescriptionDto
import seg3102team3.project.application.services.DomainEventEmitter
import seg3102team3.project.domain.patient.entities.Patient
import seg3102team3.project.domain.patient.facade.PatientFacade
import seg3102team3.project.domain.patient.factory.PatientFactory
import seg3102team3.project.domain.patient.factory.PrescriptionFactory
import seg3102team3.project.domain.patient.repository.PatientRepository
import seg3102team3.project.domain.patient.repository.PrescriptionRepository
import java.util.*

class PatientFacadeImpl (
    private var patientFactory: PatientFactory,
    private var patientRepository: PatientRepository,
    private var prescriptionFactory: PrescriptionFactory,
    private var prescriptionRepository: PrescriptionRepository,
    private var eventEmitter: DomainEventEmitter
): PatientFacade {

    override fun addPatient(patientInfo: PatientDto) {
        val patient = patientFactory.createPatient(patientInfo)
        patientRepository.save(patient)
//        eventEmitter.emit()
    }

    override fun addPrescription(patientID: String, prescriptionInfo: PrescriptionDto) {
        val prescription = prescriptionFactory.createPrescription(prescriptionInfo)
        prescriptionRepository.save(prescription)
//        eventEmitter.emit()
    }

    override fun addPrescriptionFill(prescriptionID: UUID, agentID: UUID, clinicalCheck: String) {
    }

    override fun updatePatient(patientInfo: PatientDto) {
        TODO("Not yet implemented")
    }

    override fun identifyPatientByName(name: String): String? {
        TODO("Not yet implemented")
    }

    override fun identifyPatientByEmail(email: String): String? {
        TODO("Not yet implemented")
    }

    override fun identifyPatientByPHIN(phin: String): String? {
        TODO("Not yet implemented")
    }

    override fun fetchPrescriptionFillDIN(prescriptionFillID: UUID): String {
        TODO("Not yet implemented")
    }

    override fun pickUpPrescriptionFill(prescriptionFillID: UUID, agentID: UUID, pickUpSummary: String) {
        TODO("Not yet implemented")
    }

    override fun verifyPatientIdentifier(someIdentifier: String): String? {
        TODO("Not yet implemented")
    }

    override fun verifyPrescriptionFill(prescriptionFillID: UUID, pharmacistID: UUID, clinicalCheck: String) {
        TODO("Not yet implemented")
    }

    override fun cancelPrescriptionFill(prescriptionFillID: UUID, pharmacistID: UUID, clinicalCheck: String) {
        TODO("Not yet implemented")
    }


}