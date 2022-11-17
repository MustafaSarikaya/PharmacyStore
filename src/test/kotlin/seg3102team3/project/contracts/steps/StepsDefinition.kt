package seg3102.project.contracts.steps

import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.mockito.MockitoAnnotations

class StepsDefinition: En {

    init {
        Before { _: Scenario ->
            MockitoAnnotations.openMocks(this)
        }

    }

    //TODO LATER; RAN OUT OF TIME!!

}
