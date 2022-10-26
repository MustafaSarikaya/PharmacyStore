package seg3102team3.project.application.dtos.queries

import java.util.*

data class AgentDto (
    val name: String,
    val password: String,
    val email: String,
    val activationStatus: Boolean
    ){
    //todo remember to have a field for activated/unactivated account
    //todo remember to hash passes
}
