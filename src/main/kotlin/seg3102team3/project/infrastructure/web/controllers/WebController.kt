package seg3102team3.project.infrastructure.web.controllers;

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import seg3102team3.project.infrastructure.web.forms.AccountForm
import seg3102team3.project.infrastructure.web.services.PharmacyService
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


}