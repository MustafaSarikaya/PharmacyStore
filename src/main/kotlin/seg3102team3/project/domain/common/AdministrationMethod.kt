package seg3102team3.project.domain.common

enum class adminMethod {
    ORAL,
    NASAL,
    SUPPOSITORY,
    INTRAMUSCULAR_INJECTION,
    INTRAVENOUS_INJECTION,
    TOPICAL
}

data class AdministrationMethod(val adminMethod: adminMethod)