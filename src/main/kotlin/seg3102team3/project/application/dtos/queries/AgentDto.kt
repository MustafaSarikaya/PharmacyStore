package seg3102team3.project.application.dtos.queries

data class AgentDto (
    val fullName: String,
    val username: String,
    val email: String,
    val password: String, //business logic will hash the password before storing in Agent domain entity
    val pharmacist: Boolean) //if true, created domain entity is Pharmacist, else Agent (assistant)