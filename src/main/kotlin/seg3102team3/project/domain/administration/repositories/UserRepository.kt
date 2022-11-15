package seg3102.team3.project.domain.administration.repositories

interface UserRepository {
    fun save(user: User): User
    fun find(id: UUID): User?
}