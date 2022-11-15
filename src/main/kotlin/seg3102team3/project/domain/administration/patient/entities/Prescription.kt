package seg3102team3.project.domain.administration.patient.entities

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
                   val refillCount: UShort


) {
}