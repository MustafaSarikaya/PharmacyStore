# Database Adaptors

This subdomain includes adaptors for the **PrescriberRegistry** and the **DrugProductDatabase**, which provide data for Prescriptions and Drug-related documents. It also includes data classes **Prescriber** and **Drug**, which map to system-relevant attributes of records from each respective database. <br>

The **PrescriberRegistry** adaptor will include functionality such as:
* Fetching the list of names and license numbers for Prescribers in the Pharmacy's region.
* Lookup to verify valid user-supplied Prescriber identifying information.
* Retrieving Prescriber contact info for authorization purposes.

The **DrugProductDatabase** adaptor will include functionality such as:
* Searching for Drug information (including Drug-related documents) based on various criteria.
* Lookup to verify valid user-supplied Drug identifying information.
* Adding new Drug-related documents to the public knowledge corpus, such as Drug Reports.
