package seg3102team3.project.domain.patient.entities
import seg3102team3.project.domain.common.Address
import seg3102team3.project.domain.common.Gender
import seg3102team3.project.domain.common.LanguagePreference
import seg3102team3.project.domain.common.Name
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
              val languagePref: LanguagePreference,
              val genderType: Gender,
              val address: Address
)