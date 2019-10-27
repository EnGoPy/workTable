package application.challenge;

import application.challenge.dataTransfer.MapperPulley;
import application.challenge.dataTransfer.PulleyDTO;
import application.challenge.entity.Pulley;
import application.challenge.parsing.ReadJSONFile;
import application.challenge.parsing.SchemaChecker;
import application.challenge.parsing.WriteJSONFile;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<List<Pulley>> inputSets = new ArrayList<>();
        List<List<PulleyDTO>> toBeSavedList = new ArrayList<>();
        try {
            byte[] inputData = Files.readAllBytes(Paths.get("daneWejsciowe.json"));
            JsonNode rootNode = objectMapper.readTree(inputData).path("uklady");

            Iterator<JsonNode> iter = rootNode.iterator();
            while (iter.hasNext()) {
                List<Pulley> pulleys = ReadJSONFile.getSinglePulleysSchemaFromFile(iter);
//                System.out.println(pulleys);
                SchemaChecker.contactChecker(pulleys);
//                for (Pulley p : pulleys) {
//                    System.out.println(p);
//                }
                inputSets.add(pulleys);
            }
            toBeSavedList = MapperPulley.transferWholeInput(inputSets);
            WriteJSONFile.writeResultToJsonFile(toBeSavedList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done. Check " + WriteJSONFile.getFileName() + " for results.");
    }


}
