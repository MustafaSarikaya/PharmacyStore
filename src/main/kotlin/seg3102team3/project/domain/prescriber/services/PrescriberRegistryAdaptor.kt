interface PrescriberRegistryAdaptor {
    fun getPrescriberByID(id: String): Prescriber?
    fun getPrescriberByLicenseNumber(licenseNumber: String): Prescriber?
    fun getPrescriberByName(name: String): Prescriber?
    fun getPrescriberByEmail(email: String): Prescriber?
}
