package seg3102team3.project.domain.prescriber.entities

import seg3102team3.project.domain.common.Address
import seg3102team3.project.domain.common.Gender
import seg3102team3.project.domain.common.LanguagePreference
import seg3102team3.project.domain.common.Name

class Prescriber(
        val id: String,
        var phoneNumber: String,
        var emailAddress: String,
        var address: Address,
        var fullName: Name,
        var title: PrescriberTitle,
        var gender: Gender,
        var languagePref: LanguagePreference
) {}
