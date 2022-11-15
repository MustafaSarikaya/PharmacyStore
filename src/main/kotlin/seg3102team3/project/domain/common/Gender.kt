enum class GenderType {
    MALE,
    FEMALE,
    OTHER,
    UNSPECIFIED
}

data class Gender(val genderType: GenderType)
