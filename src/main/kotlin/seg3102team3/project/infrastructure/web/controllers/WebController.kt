package seg3102team3.project.infrastructure.web.controllers;

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import seg3102team3.project.application.dtos.queries.AgentDto
import seg3102team3.project.infrastructure.web.forms.AgentForm
import seg3102team3.project.infrastructure.web.forms.PatientForm
import seg3102team3.project.infrastructure.web.forms.PrescriptionFillForm
import seg3102team3.project.infrastructure.web.forms.PrescriptionForm
import seg3102team3.project.infrastructure.web.services.PharmacyService
import java.security.Principal
import java.util.*
import javax.servlet.http.HttpSession
import javax.validation.Valid

@Controller
@SessionAttributes(names = ["searchRequest"])
class WebController(private val pharmacyService: PharmacyService) {

    @RequestMapping("/")
    fun showWelcome(model: Model, session: HttpSession): String {
        return "welcome"
    }

    @GetMapping("/login")
    fun login(model: Model, session: HttpSession): String {
        return "login"
    }

    @GetMapping(value = ["/register"])
    fun register(model: Model, session: HttpSession): String {
        val accountData = AgentForm()
        model.addAttribute("accountData", accountData)
        return "createAccount"
    }

    @PostMapping(value = ["/register"])
    fun createAccount(@Valid @ModelAttribute("accountData") accountData: AgentForm, bindingResults: BindingResult, model: Model, session: HttpSession): String {
        model.addAttribute("accountData", accountData)
        if(!bindingResults.hasErrors()){
            if(pharmacyService.createAccount(accountData)){
                model.addAttribute("createAccountStatus", "ok")
                model.addAttribute("accountData", AgentForm())
            } else {
                model.addAttribute("createAccountStatus", "error")
            }
        }
        return "createAccount"
    }

    @GetMapping(value = ["/auth/account"])
    fun viewAccount(principal: Principal, model: Model, session: HttpSession): String{
        setAccountViewModel(session, model, principal)
        return "account"
    }

    private fun setAccountViewModel(
        session: HttpSession,
        model: Model,
        principal: Principal
    ) {
        val account = getCurrentUser(session, principal)
        model.addAttribute("account", account)
    }

    private fun getCurrentUser(session: HttpSession, principal: Principal): AgentDto {
        var account = session.getAttribute("currentUser")
        if (account == null) {
            val userid = principal.name
            account = pharmacyService.getAccount(userid)
            session.setAttribute("currentUser", account)
        }
        return account as AgentDto
    }

    @GetMapping(value = ["/auth/agent/createPrescription"])
    fun createPrescription(principal: Principal, model: Model, session: HttpSession): String{
        val prescriptionForm = PrescriptionForm()
        model.addAttribute("prescriptionData", prescriptionForm)
        return "createPrescription"
    }

    @GetMapping(value = ["/auth/agent/prepFill"])
    fun preparePrescriptionFill(principal: Principal, model: Model, session: HttpSession): String{
        val fillForm = PrescriptionFillForm()
        model.addAttribute("fillData", fillForm)
        return "prepFill"
    }

    @GetMapping(value = ["/auth/agent/verifiedPrescriptions"])
    fun fetchPrescriptionDocs(principal: Principal, model: Model, session: HttpSession): String{
        return "verifiedPrescriptions"
    }

    @GetMapping(value = ["/auth/agent/updateAgent"])
    fun updateAgent(principal: Principal, model: Model, session: HttpSession): String{
        val accountData = AgentForm()
        model.addAttribute("accountData", accountData)
        return "updateAgent"
    }

    @GetMapping(value = ["/auth/pharmacist/createPatient"])
    fun createPatient(principal: Principal, model: Model, session: HttpSession): String{
        val patientData = PatientForm()
        model.addAttribute("patientData", patientData)
        return "createPatient"
    }

    @PostMapping(value = ["/auth/pharmacist/createPatient"])
    fun postPatient(@Valid @ModelAttribute("patientData") patientData: PatientForm, bindingResults: BindingResult, model: Model, session: HttpSession): String {
        model.addAttribute("patientData", patientData)
        if(!bindingResults.hasErrors()){
            if(pharmacyService.registerPatient(patientData) != null){
                model.addAttribute("createPatientStatus", "ok")
                model.addAttribute("patientData", PatientForm())
            } else {
                model.addAttribute("createPatientStatus", "error")
            }
        }
        return "createPatient"
    }

    @GetMapping(value = ["/auth/pharmacist/updatePatient"])
    fun updatePatient(principal: Principal, model: Model, session: HttpSession): String{
        val patientData = PatientForm()
        model.addAttribute("patientData", patientData)
        return "updatePatient"
    }

    @GetMapping(value = ["/auth/pharmacist/preparedPrescriptions"])
    fun verifyPrescriptionFills(principal: Principal, model: Model, session: HttpSession): String{
        return "preparedPrescriptions"
    }

    @GetMapping(value = ["/auth/pharmacist/generateReport"])
    fun generateDrugReport(principal: Principal, model: Model, session: HttpSession): String{
        return "generateReport"
    }

    @GetMapping(value = ["/auth/admin/createAgent"])
    fun registerAgent(principal: Principal, model: Model, session: HttpSession): String{
        return "createAgent"
    }

    @GetMapping(value = ["/auth/admin/unregisterAgent"])
    fun unregisterAgent(principal: Principal, model: Model, session: HttpSession): String{
        return "unregisterAgent"
    }

    @GetMapping(value = ["/auth/admin/updateAgentAdmin"])
    fun privilegedUpdateAgent(principal: Principal, model: Model, session: HttpSession): String{
        return "updateAgentAdmin"
    }

    /*I don't understand the need for search stuff, so commenting out for now
    @PostMapping(value = ["/search"])
    fun patientSearch(@ModelAttribute("searchRequest") searchRequest: SearchRequest,
                      model: Model, session: HttpSession): String {
        val patient = searchRequest.patientId?.let { pharmacyService.browsePatient(it) }
        session.setAttribute("patient", patient)
        model.addAttribute("patient", patient)
        return "browsePatient"
    }

    @GetMapping(value = ["/search"])
    fun showSearchResult(model: Model, session: HttpSession): String {
        val patient = session.getAttribute("patient") as PatientDto
        model.addAttribute("patient", patient)
        return "browsePatient"
    }*/

    @GetMapping(value = ["/auth/newPrescription"])
    fun newPrescription(model: Model, session: HttpSession): String {
        model.addAttribute("createPrescriptionStatus", null)
        val prescriptionData = PrescriptionForm()
        model.addAttribute("prescriptionData", prescriptionData)
        return "newPrescription"
    }

    /*Was causing errors, will come back to when I'm doing this
    @PostMapping(value = ["/auth/patientId/{patientId}/createPrescription"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun addPrescription(
        @Valid @ModelAttribute("prescriptionData") prescriptionData: PrescriptionForm,
        @PathVariable patientId: String,
        model: Model, session: HttpSession
    ): String {
        val acc = session.getAttribute("currentUser")
        if (acc != null) {
            val account = acc as AgentDto
            val patientData = pharmacyService.browsePatient(patientId)
            if (patientData?.let { pharmacyService.createPrescription(it, prescriptionData) }!!) {
                model.addAttribute("createPrescriptionStatus", "ok")
            } else {
                model.addAttribute("createAccountStatus", "error")
            }
        }
        return "createAccount"
    }*/
}