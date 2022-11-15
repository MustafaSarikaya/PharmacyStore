enum class TitleName {
    DOCTOR,
    DENTIST,
    NURSE,
    OPTOMETRIST,
    PODIATRIST
    // List from initial requirements
}

data class PrescriberTitle(val titleName: TitleName)
