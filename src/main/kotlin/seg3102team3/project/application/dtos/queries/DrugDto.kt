package seg3102team3.project.application.dtos.queries

import java.util.*

class DrugDto (
    val id : UUID,
    val name: String,
    val dosageAmount: String,
    val expiryDate: Date,
    ) {
}