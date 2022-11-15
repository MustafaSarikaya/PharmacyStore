package seg3102team3.project.domain.administration.entities

import seg3102team3.project.domain.common.Language
import seg3102team3.project.domain.common.Gender
import seg3102team3.project.domain.common.Name

class User(
    val id: UUID,
    val userName: String,
    val email: String,
    val password: String,
    val name: Name
) {
    var passwordTemporary: Boolean = true
    var language: Language = null
    var role: UserRole = null
    var gender: Gender = null

    fun setLanguage(language: Language) {
        this.language = language
    }
}