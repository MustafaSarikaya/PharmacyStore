class Prescriber(
        val id: String,
        var phoneNumber: String,
        var emailAddress: String,
        var address: Address,
        var fullName: Name,
        var title: PrescriberTitle,
        var gender: Gender,
        var languagePref: Language
) {}
