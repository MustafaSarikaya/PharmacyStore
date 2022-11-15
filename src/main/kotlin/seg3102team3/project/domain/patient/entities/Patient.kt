package seg3102team3.project.domain.patient.entities
import Address
import Gender
import Language
import Name
import java.util.*
import java.time.LocalDate;

class Patient(val id: String,
              val dateOfBirth: LocalDate,
              val email: String,
              val allergies: MutableList<String> = ArrayList(),
              val prescriptionMeds: MutableList<UInt> = ArrayList(),
              val nonPrescriptionMeds: MutableList<UInt> = ArrayList(),
              val insuranceNumber: String,
              val patient: Prescription,
              val fullName: Name,
              val languagePref: Language,
              val genderType: Gender,
              val address: Address
)