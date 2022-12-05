package seg3102team3.project.application.usecases.implementation
import seg3102team3.project.application.usecases.GenerateDrugReport
import seg3102team3.project.domain.agent.facade.AgentFacade
import seg3102team3.project.domain.drug.facade.DrugFacade
import java.util.*
import java.io.FileWriter;
import java.io.File
import java.io.BufferedWriter;
import java.nio.file.Files;

class GenerateDrugReportImpl(
    private var agentFacade: AgentFacade, private var drugFacade: DrugFacade): GenerateDrugReport {
        
        override fun generateDrugReport(agentID: UUID, drugDIN: UInt, startDate: String, endDate: String, description: String): ByteArray? {
            var output: String = "test"
            var bytes: ByteArray = ByteArray(2)
            if (agentFacade.isPharmacist(agentID)) {
                output = "Drug DIN: " + drugDIN.toString() + "\n" + 
                    startDate + " - " + endDate + "\n" + 
                    "Prescriber ID: " + agentID.toString() + "\n" + description
            }
            if (agentFacade.isPharmacist(agentID)) {
                var file: File = File("test.txt");
                var writer: BufferedWriter = BufferedWriter(FileWriter("test.txt"))
                writer.write(output)
                writer.close()
                bytes = Files.readAllBytes(file.toPath());
                
            }
            return if (agentFacade.isPharmacist(agentID)) bytes else null;
        }
}