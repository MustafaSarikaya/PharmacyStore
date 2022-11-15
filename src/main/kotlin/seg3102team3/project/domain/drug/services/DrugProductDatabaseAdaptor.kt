interface DrugProductDatabaseAdaptor {
    fun getDrugByName(name: String): Drug?
    fun getDrugByDIN(din: UInt): Drug?
    fun getDrugByATC(atc: String): Drug?
}
