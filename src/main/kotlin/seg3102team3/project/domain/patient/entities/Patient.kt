package seg3102team3.project.domain.patient.entities
import seg3102team3.project.domain.common.Address
import seg3102team3.project.domain.common.Gender
import seg3102team3.project.domain.common.LanguagePreference
import seg3102team3.project.domain.common.Name
import java.util.*
import java.time.LocalDate;

class Patient(
    val id: String,
    val dateOfBirth: LocalDate,
    val email: String? = null,
    val phoneNumber: String? = null,
    val healthHistoryNote: String? = null,
    val prescriptionMeds: Array<UInt>? = emptyArray(),
    val nonPrescriptionMeds: Array<UInt>? = emptyArray(),
    val insuranceNumber: String? = null,
    val fullName: Name,
    val languagePref: LanguagePreference,
    val genderType: Gender,
    val address: Address
){
    val prescriptions: MutableList<Prescription> = ArrayList();
}