package seg3102team3.project.domain.agent.entities

import seg3102team3.project.domain.common.Name;
import seg3102team3.project.domain.common.LanguagePreference;
import seg3102team3.project.domain.common.Gender;
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
    var language: LanguagePreference? = null
    var role: UserRole? = null
    var gender: Gender? = null

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
