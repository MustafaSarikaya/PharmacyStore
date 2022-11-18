package seg3102team3.project.contracts.steps

import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.mockito.MockitoAnnotations

class StepsDefinition: En {


    init {
        Before { _: Scenario ->
            MockitoAnnotations.openMocks(this)
        }

        Given("the prescription info's patient exists") {

        }
        Given("the prescription info's prescriber exists") {

        }
        Given("the prescription info's drug exists") {

        }
        Given("the prescription info's admin method matches to an AdministrationMethod value") {

        }
        Given("the prescription info's refillable status matches to a RefillableStatus value") {

        }
        Given("the given prescriber exists") {
            TODO("Not yet implemented")
        }
        Given("the Prescription Fill specified by the given ID is registered"){

        }
        Given("the status of the Prescription Fill specified by the given ID is verified"){

        }
        Given("the prescription fill info's prescription exists"){

        }
        Given("the prescription fill info's status matches to a PrescriptionFillStatus value"){

        }
        Given("an agent exists with the given ID"){

        }
        Given("the agent info's language preference matches to a Language value"){

        }
        Given("the agent info's gender matches to a Gender value"){

        }
        Given("the patient info's language preference matches to a Language value") {
            TODO("Not yet implemented")
        }
        Given("the patient info's gender matches to a Gender value") {
            TODO("Not yet implemented")
        }
        Given("the patient info's address contains 5 comma seperated substrings") {
            TODO("Not yet implemented")
        }
        Given("the user account specified by the given ID is registered") {
            TODO("Not yet implemented")
        }
        Given("the user account specified by the given ID is not an Administrator") {
            TODO("Not yet implemented")
        }
        Given("the user account specified by the given ID is active") {
            TODO("Not yet implemented")
        }
        Given("the Patient specified by the given ID is registered") {
            TODO("Not yet implemented")
        }
        Given("the given identifier matches a known Drug's name") {
            TODO("Not yet implemented")
        }
        Given("the given identifier matches a registered Patient's name") {
            TODO("Not yet implemented")
        }
        Given("the given identifier matches a known Drug's ATC") {
            TODO("Not yet implemented")
        }
        Given("the given identifier matches a known Drug's DIN") {
            TODO("Not yet implemented")
        }
        Given("the given identifier does not match a known Drug's name, ATC or DIN") {
            TODO("Not yet implemented")
        }
        Given("the given identifier matches a registered Patient's email") {
            TODO("Not yet implemented")
        }
        Given("the given identifier matches a registered Patient's PHIN") {
            TODO("Not yet implemented")
        }
        Given("the given identifier does not match a registered Patient's name, email or PHIN") {
            TODO("Not yet implemented")
        }
        Given("the given identifier matches a known Prescriber's name") {
            TODO("Not yet implemented")
        }
        Given("the given identifier matches a known Prescriber's email") {
            TODO("Not yet implemented")
        }
        Given("the given identifier matches a known Prescriber's license number") {
            TODO("Not yet implemented")
        }
        Given("the given identifier does not match a known Prescriber's name, email or license number") {
            TODO("Not yet implemented")
        }
        Given("the status of the Prescription Fill specified by the given ID is prepared") {
            TODO("Not yet implemented")
        }
        Given("the Pharmacist specified by the given ID is registered") {
            TODO("Not yet implemented")
        }
        Given("the Pharmacist intends to verify the fill") {
            TODO("Not yet implemented")
        }





        When("application command registerPatient is invoked") {
            TODO("Not yet implemented")
        }
        When("application command unregisterAgent is invoked") {
            TODO("Not yet implemented")
        }
        When("the application command updateAgent is invoked") {
            TODO("Not yet implemented")
        }
        When("the application command updatePatient is invoked") {
            TODO("Not yet implemented")
        }
        When("application command verifyDrugInfo is invoked") {
            TODO("Not yet implemented")
        }
        When("application command verifyPatientInfo is invoked") {
            TODO("Not yet implemented")
        }
        When("application command verifyPrescriberInfo is invoked") {
            TODO("Not yet implemented")
        }
        When("application command verifyPrescriptionFill is invoked") {
            TODO("Not yet implemented")
        }
        When("application command registerAgent is invoked") {
            TODO("Not yet implemented")
        }
        When("the application command privilegedUpdateAgent is invoked") {
            TODO("Not yet implemented")
        }
        When("application command preparePrescriptionFill is invoked") {
            TODO("Not yet implemented")
        }
        When("application command pickUpPrescriptionFill is invoked") {
            TODO("Not yet implemented")
        }
        When("application command fetchPrescriptionDocs is invoked") {
            TODO("Not yet implemented")
        }
        When("application command fetchPrescriberContactInfo is invoked") {
            TODO("Not yet implemented")
        }
        When("application command createPrescription is invoked") {
            TODO("Not yet implemented")
        }




        Then("the Agent's account is marked as deactivated") {
            TODO("Not yet implemented")
        }
        Then("a new patient is created") {
            TODO("Not yet implemented")
        }
        Then("the new patient is initialized from the patient information") {
            TODO("Not yet implemented")
        }
        Then("the agent's UserRole remains the same as before") {
            TODO("Not yet implemented")
        }
        Then("the agent is otherwise updated from the agent information") {
            TODO("Not yet implemented")
        }
        Then("the patient is updated from the patient information") {
            TODO("Not yet implemented")
        }
        Then("the patient's list of prescriptions was not changed") {
            TODO("Not yet implemented")
        }
        Then("the System returns the ID of the known Drug") {
            TODO("Not yet implemented")
        }
        Then("the system returns the same DIN that was given") {
            TODO("Not yet implemented")
        }
        Then("the System returns null") {
            TODO("Not yet implemented")
        }
        Then("the System returns the ID of the registered Patient") {
            TODO("Not yet implemented")
        }
        Then("the system returns the same PHIN that was given") {
            TODO("Not yet implemented")
        }
        Then("the System returns the ID of the known Prescriber") {
            TODO("Not yet implemented")
        }
        Then("the system returns the same license number that was given") {
            TODO("Not yet implemented")
        }
        Then("the Prescription Fill's status is set to verified") {
            TODO("Not yet implemented")
        }
        Then("the Prescription Fill's recorded clinical check is set to the one provided by the Pharmacist") {
            TODO("Not yet implemented")
        }
        Then("the Prescription Fill's clinical check pharmacist ID is set to the given ID") {
            TODO("Not yet implemented")
        }
        Then("a new user is created") {
            TODO("Not yet implemented")
        }
        Then("the new user is initialized from the agent information") {
            TODO("Not yet implemented")
        }
        Then("the agent is updated from the agent information") {
            TODO("Not yet implemented")
        }
        Then("a new prescription fill is created") {
            TODO("Not yet implemented")
        }
        Then("the new prescription fill is initialized from the prescription fill information") {
            TODO("Not yet implemented")
        }
        Then("the new prescription fill's prescription is set to the provided prescription") {
            TODO("Not yet implemented")
        }
        Then("the new prescription fill is added to the prescription's fills") {
            TODO("Not yet implemented")
        }
        Then("the new prescription fill's preparation agent ID is set to the given ID") {
            TODO("Not yet implemented")
        }
        Then("a pharmacist exists with the given ID") {
            TODO("Not yet implemented")
        }
        Then("the Prescription Fill's pick-up summary is set to the provided value") {
            TODO("Not yet implemented")
        }
        Then("the Prescription Fill's status is set to Retrieved") {
            TODO("Not yet implemented")
        }
        Then("the Prescription Fill's retrieval pharmacist ID is set to the given ID") {
            TODO("Not yet implemented")
        }
        Then("the System fetches and returns those documents from the Drug Product Database") {
            TODO("Not yet implemented")
        }
        Then("the System fetches and returns contact information from the Prescriber Registry") {
            TODO("Not yet implemented")
        }
        Then("a new prescription is created") {
            TODO("Not yet implemented")
        }
        Then("the new prescription is initialized from the prescription information") {
            TODO("Not yet implemented")
        }
        Then("the new prescription's patient is set to the provided patient") {
            TODO("Not yet implemented")
        }
        Then("the new prescription is added to the patient's prescriptions") {
            TODO("Not yet implemented")
        }

        After { _: Scenario ->

        }
    }
}
