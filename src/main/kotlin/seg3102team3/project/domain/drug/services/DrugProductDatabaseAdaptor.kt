package seg3102team3.project.domain.drug.services

import seg3102team3.project.domain.drug.entities.Drug

interface DrugProductDatabaseAdaptor {
    fun getDrugByName(name: String): Drug?
    fun getDrugByDIN(din: UInt): Drug?
    fun getDrugByATC(atc: String): Drug?
}
