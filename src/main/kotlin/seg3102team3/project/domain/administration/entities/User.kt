package seg3102team3.project.domain.administration.entities

import Gender
import Language
import Name
import java.util.UUID

class User(
        val id: UUID,
        var userName: String,
        var email: String,
        var password: String,
        var name: Name
) {
    var activated: Boolean = true
    var passwordTemporary: Boolean = true
    var language: Language? = null
    var role: UserRole? = null
    var gender: Gender? = null

    fun setLanguage(language: Language) {
        this.language = language
    }

    fun setGender(gender: Gender) {
        this.gender = gender
    }

    fun setRole(userRole: UserRole) {
        this.role = userRole
    }

    fun update(agent: User) {
        this.userName = agent.userName
        this.name = agent.name
    }

    fun updateDetails(email: String, password: String) {
        this.email = email
        this.password = password
    }

    fun setFirstPassword(password: String) {
        this.password = password
        passwordTemporary = false
    }

    fun setTempPassword(password: String) {
        this.password = password
    }

    fun deactivate() {
        this.activated = false
    }
}
