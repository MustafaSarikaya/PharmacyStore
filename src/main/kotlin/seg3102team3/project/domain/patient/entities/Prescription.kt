package seg3102team3.project.domain.patient.entities

import seg3102team3.project.domain.common.RefillableStatus
import seg3102team3.project.domain.common.adminMethod
import java.util.UUID;
import java.time.LocalDate;
import javax.xml.stream.events.ProcessingInstruction;

class Prescription(val id: UUID,
                   val prescriberLicenseID: String,
                   val drugIdentificationNumber: UInt,
                   val originDate: LocalDate,
                   val drugDoseMg: Float,
                   val frequencyInstruction: String,
                   val notes: String?,
                   val refillCount: UShort,
                   val refillable: RefillableStatus,
                   val adminMethod: adminMethod,
                   val prescriptionFill: PrescriptionFill

                   ) {
}