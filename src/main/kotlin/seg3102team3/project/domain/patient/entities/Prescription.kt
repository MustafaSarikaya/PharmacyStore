package seg3102team3.project.domain.patient.entities

import java.util.UUID;
import java.time.LocalDate;

class Prescription(val id: UUID,
                   val prescriberLicenseID: String,
                   val drugIdentificationNumber: UInt,
                   val originDate: LocalDate,
                   val drugDoseMg: Float,
                   val frequencyInstruction: String,
                   val notes: String?,
                   val refillCount: UShort,
                   val refillable: RefillableStatus,
                   val adminMethod: AdministrationMethod,
                   val prescriptionFill: PrescriptionFill
                   )