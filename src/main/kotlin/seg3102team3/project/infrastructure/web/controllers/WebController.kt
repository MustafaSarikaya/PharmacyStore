package seg3102team3.project.infrastructure.web.controllers;

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes
import javax.servlet.http.HttpSession

@Controller
@SessionAttributes(names = ["searchRequest"])
class WebController {

    @RequestMapping("/")
    fun showWelcome(model: Model, session: HttpSession): String {
        return "welcome"
    }
}