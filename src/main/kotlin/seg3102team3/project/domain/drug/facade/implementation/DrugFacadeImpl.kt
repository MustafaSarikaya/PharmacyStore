class DrugFacadeImpl(val drugDB: DrugProductDatabaseAdaptor) : DrugFacade {

    override fun identifyDrugByName(name: String): UInt? {
        val d = drugDB.getDrugByName(name)
        return if (d != null) d.id else null
    }

    override fun identifyDrugByDIN(din: UInt): UInt? {
        val d = drugDB.getDrugByDIN(din)
        return if (d != null) d.id else null
    }

    override fun identifyDrugByATC(atc: String): UInt? {
        val d = drugDB.getDrugByATC(atc)
        return if (d != null) d.id else null
    }
    /**
     * Returns the monograph of the drug with the given DIN.
     *
     * Assumes that the DIN is valid
     */
    override fun fetchDrugDocuments(din: String): ByteArray {
        val d = drugDB.getDrugByDIN(din.toUInt())!!
        return d.monographPDF
    }
}
