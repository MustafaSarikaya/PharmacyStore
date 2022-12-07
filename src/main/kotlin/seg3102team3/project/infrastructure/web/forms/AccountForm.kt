package seg3102team3.project.infrastructure.web.forms

import seg3102team3.project.infrastructure.web.forms.validators.PasswordMatch
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@PasswordMatch(
    passwordField = "password",
    passwordConfField = "passwordConf",
    message="{account-password-not-match}"
)
class AccountForm {
    @Size(min=2, message = "{account-create-username-short}")
    var userName: String? = null
    var password: String? = null
    var passwordConf: String? = null
    var firstname: String? = null
    var middlenames: String? = null
    var lastname: String? = null
    @NotEmpty(message ="{account-create-no-email}")
    @Email(message="{account-create-wrong-email-format}")
    var email: String? = null
    @Pattern(regexp = "^[1-9][0-9]*$|", message="{credit-card-number-wrong-format}")
    var gender: String? = null
    var language: String? = null
    var role: String? = null
}
