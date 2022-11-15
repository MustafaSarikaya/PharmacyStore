class PrescriberFacadeImpl(val prescriberRepository: PrescriberRegistryAdaptor) : PrescriberFacade {

    override fun identifyPrescriberByName(name: String): String? {
        return if (prescriberRepository.getPrescriberByName(name) != null) name else null
    }

    override fun identifyPrescriberByEmail(email: String): String? {
        return if (prescriberRepository.getPrescriberByEmail(email) != null) email else null
    }

    override fun identifyPrescriberByLicenseNumber(licenseNum: String): String? {
        return if (prescriberRepository.getPrescriberByLicenseNumber(licenseNum) != null) licenseNum
        else null
    }

    /**
     * Returns the email associated with the prescriber with the given ID.
     *
     * Assumes that the id is valid
     */
    override fun fetchPrescriberEmail(id: String): String {
        val p = prescriberRepository.getPrescriberByID(id)!!
        return p.emailAddress
    }
}
