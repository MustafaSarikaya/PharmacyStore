package seg3102team3.project.infrastructure.web.forms

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

class PatientForm {
    @NotEmpty(message ="{patient-create-no-phin}")
    var phin: String= ""
    @NotEmpty(message = "{account-create-no-firstname}")
    var firstname: String = ""
    var middlenames: String? = null
    @NotEmpty(message = "{account-create-no-lastname}")
    var lastname: String = ""
    var insuranceNumber: String? = null
    var dateOfBirth: String? = null
    var phoneNumber: String? = null
    var gender: String = ""
    var language: String = ""
    @NotEmpty(message = "{patient-create-no-houseNumber}")
    var houseNumber: String = ""
    @NotEmpty(message = "{patient-create-no-streetName}")
    var streetName: String = ""
    @NotEmpty(message = "{patient-create-no-zipCode}")
    var zipCode: String = ""
    @NotEmpty(message = "{patient-create-no-city}")
    var city: String = ""
    @NotEmpty(message = "{patient-create-no-province}")
    var province: String = ""
    @Email(message = "{account-create-wrong-email-format}")
    var email: String? = null
    var prescriptionMeds: String? = null
    var nonPrescriptionMeds: String? = null
    var healthHistoryNote: String? = null
}