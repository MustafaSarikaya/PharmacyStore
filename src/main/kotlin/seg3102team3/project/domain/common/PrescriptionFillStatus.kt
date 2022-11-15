package seg3102team3.project.domain.common

enum class fillStatus {
    RETRIEVED,
    CANCELLED,
}

data class PrescriptionFillStatus(val fillStatus: fillStatus)
