package seg3102.team3.project.domain.administration.repositories

import seg3102team3.project.domain.administration.entities.User
import java.util.*

interface UserRepository {
    fun save(user: User): User
    fun find(id: UUID): User?
}