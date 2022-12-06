package seg3102team3.project.application.usecases.implementation

import seg3102team3.project.application.usecases.GenerateDrugReport
import seg3102team3.project.domain.agent.facade.AgentFacade
import seg3102team3.project.domain.drug.facade.DrugFacade
import java.util.*
import java.io.FileWriter;
import java.io.File
import java.io.FileInputStream
import java.io.BufferedWriter;
import java.nio.file.Files;
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.http.MediaType
import org.springframework.core.io.InputStreamResource


class GenerateDrugReportImpl(
    private var agentFacade: AgentFacade, private var drugFacade: DrugFacade): GenerateDrugReport {
        
        override fun generateDrugReport(agentID: UUID, drugDIN: UInt, startDate: String, endDate: String, description: String): ByteArray? {
            var filePath: String = "C:\\"
            var fileName: String = "PDF.pdf"
            var output: String
            var bytes: ByteArray
            var headers: HttpHeaders = HttpHeaders()
            var writer: BufferedWriter = BufferedWriter(FileWriter(filePath + fileName))
            var file: File = File(filePath+fileName)
            var resource: InputStreamResource = InputStreamResource(FileInputStream(file))
            if (!agentFacade.isPharmacist(agentID)) {
                output = "Drug DIN: " + drugDIN.toString() + "\n" + 
                    startDate + " - " + endDate + "\n" + 
                    "Prescriber ID: " + agentID.toString() + "\n" + description
            } else {return null}
            writer.write(output)
            writer.close()
            bytes = Files.readAllBytes(file.toPath());
            headers.add("Content-Disposition", "inline;filename=PDF.pdf");
            ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/pdf")).body(resource)
            return bytes;
        }
}