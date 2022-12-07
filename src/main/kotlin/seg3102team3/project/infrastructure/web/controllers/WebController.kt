package seg3102team3.project.infrastructure.web.controllers;

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import seg3102team3.project.application.dtos.queries.AgentDto
import seg3102team3.project.application.dtos.queries.PatientDto
import seg3102team3.project.infrastructure.web.forms.AccountForm
import seg3102team3.project.infrastructure.web.forms.PrescriptionForm
import seg3102team3.project.infrastructure.web.forms.SearchRequest
import seg3102team3.project.infrastructure.web.services.PharmacyService
import java.util.ArrayList
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
        val accountData = AccountForm()
        model.addAttribute("accountData", accountData)
        return "createAccount"
    }

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
    }

    @GetMapping(value = ["/auth/newPrescription"])
    fun newPrescription(model: Model, session: HttpSession): String {
        model.addAttribute("createPrescriptionStatus", null)
        val prescriptionData = PrescriptionForm()
        model.addAttribute("prescriptionData", prescriptionData)
        return "newPrescription"
    }

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
                model.addAttribute("createPrescriptionStatus", "error")
            }
        }
        model.addAttribute("prescriptionData", prescriptionData)
        return "newPrescription"
    }



}