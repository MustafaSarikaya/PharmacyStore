interface PrescriberFacade {
    fun identifyPrescriberByName(name: String): String?
    fun identifyPrescriberByEmail(email: String): String?
    fun identifyPrescriberByLicenseNumber(licenseNum: String): String?
    fun fetchPrescriberEmail(id: String): String
}