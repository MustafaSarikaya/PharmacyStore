package seg3102team3.project.domain.common

enum class status {
    REFILLABLE,
    REFILLABLE_WITH_REAUTHORIZATION,
    NON_REFILLABLE
}

data class RefillableStatus(val status: status)
