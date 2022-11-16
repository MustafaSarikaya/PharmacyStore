package seg3102team3.project.domain.administration.entities
enum class RoleName {
    ADMINISTRATOR,
    ASSISTANT,
    PHARMACIST
}

class UserRole(val roleName: RoleName)
