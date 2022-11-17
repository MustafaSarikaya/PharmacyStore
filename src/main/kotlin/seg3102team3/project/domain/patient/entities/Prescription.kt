package seg3102team3.project.domain.patient.entities

import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList

class Prescription(val id: UUID,
                   val prescriberLicenseID: String,
                   val drugIdentificationNumber: UInt,
                   val originDate: LocalDateTime,
                   val drugDoseMg: Float,
                   val frequencyInstruction: String,
                   val notes: String? = null,
                   val refillable: RefillableStatus,
                   val refillCount: UShort? = 0u,
                   val adminMethod: AdministrationMethod,
                   val drugName: String? = null,
                   val drugStrengthMgPerMl: Float? = 0f
                   ){
    val fills: MutableList<Prescription> = ArrayList()
    lateinit var patient : Patient
}