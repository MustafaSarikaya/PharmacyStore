package seg3102team3.project.infrastructure.web.services

import org.mapstruct.factory.Mappers
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import seg3102team3.project.application.dtos.queries.PatientDto
import seg3102team3.project.application.dtos.queries.PrescriptionFillDto
import seg3102team3.project.application.dtos.queries.converters.PrescriptionFillDtoConverter
import seg3102team3.project.application.usecases.*
import seg3102team3.project.infrastructure.web.forms.AgentForm
import seg3102team3.project.infrastructure.web.forms.PatientForm
import seg3102team3.project.infrastructure.web.forms.PickUpMedicineForm
import seg3102team3.project.infrastructure.web.forms.PrescriptionForm
import seg3102team3.project.infrastructure.web.forms.converters.AgentFormDtoConverter
import seg3102team3.project.infrastructure.web.forms.converters.PatientFormDtoConverter
import seg3102team3.project.infrastructure.web.forms.converters.PrescriptionFormDtoConverter
import java.util.UUID

@Service
class PharmacyService(
    private val browsePatient: BrowsePatient,
    private val createPrescription: CreatePrescription,
    private val generateDrugReport: GenerateDrugReport,
    private val pickUpMedicine: PickUpMedicine,
    private val preparePrescriptionFill: PreparePrescriptionFill,
    private val privilegedUpdateAgent: PrivilegedUpdateAgent,
    private val registerAgent: RegisterAgent,
    private val registerPatient: RegisterPatient,
    private val unregisterAgent: UnregisterAgent,
    private val updateAgent: UpdateAgent,
    private val updatePatient: UpdatePatient,
    private val encoder: PasswordEncoder
) {

    private val prescriptionConverter = Mappers.getMapper(PrescriptionFormDtoConverter::class.java)
    private val prescriptionFillDtoConverter = Mappers.getMapper(PrescriptionFillDtoConverter::class.java)
    private val agentConverter = Mappers.getMapper(AgentFormDtoConverter::class.java)
    private val patientConverter = Mappers.getMapper(PatientFormDtoConverter::class.java)

    fun browsePatient(patientId: String): PatientDto? {
        return browsePatient.getPatient(patientId)
    }

    fun createPrescription(patient: PatientDto, prescriptionData: PrescriptionForm): Boolean {
        val prescription = prescriptionConverter.convertPrescription(patient.patientID, prescriptionData)

        val prescId = createPrescription.addPrescription(prescription)
        return prescId != null
    }

    fun pickUpMedicine(pharmacistId: UUID, pickUpSummaryData: PickUpMedicineForm, prescriptionFillId: UUID): Boolean {
        return pickUpMedicine.pickUpMedicine( prescriptionFillId, pharmacistId, pickUpSummaryData.pickUpMedicine)
    }

    fun preparePrescriptionFill(agentId: UUID, prescriptionFillInfo: PrescriptionFillDto, prescriptionFillId: UUID): UUID? {
        val prescriptionFill = prescriptionFillDtoConverter.convertDTO(prescriptionFillInfo, prescriptionFillId)
        return preparePrescriptionFill.preparePrescriptionFill(prescriptionFillInfo, agentId)
    }

    fun privilegedUpdateAgent(agentId: UUID, agentForm: AgentForm): Boolean {
        val agent = agentConverter.convertAgent(agentForm)
        return privilegedUpdateAgent.privilegedUpdateAgent(agentId, agent)
    }

    fun registerAgent(agentForm: AgentForm): UUID? {
        val agent = agentConverter.convertAgent(agentForm)
        return registerAgent.registerAgent(agent)
    }

    fun updateAgent(agentId: UUID, agentForm: AgentForm): Boolean {
        val agent = agentConverter.convertAgent(agentForm)
        return updateAgent.updateAgent(agentId, agent)
    }

    fun registerPatient(patientForm: PatientForm): String? {
        val patient = patientConverter.convertPatient(patientForm)
        return registerPatient.registerPatient(patient)
    }

    fun updatePatient(patientId: String, patientForm: PatientForm): Boolean {
        val patient = patientConverter.convertPatient(patientForm)
        return updatePatient.updatePatient(patientId, patient)
    }
}