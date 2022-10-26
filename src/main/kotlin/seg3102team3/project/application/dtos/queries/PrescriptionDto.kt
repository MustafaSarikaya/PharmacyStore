package seg3102team3.project.application.dtos.queries

data class PrescriptionDto (
    val drugInfo: DrugDto
        ){
    //todo include UUIDs for patient/prescriber/drug among other prescription info
}
