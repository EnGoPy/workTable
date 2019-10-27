package application.challenge.parsing;

import application.challenge.entity.Pulley;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadJSONFile {

    private static ObjectMapper objectMapper;

    public static List<Pulley> getSinglePulleysSchemaFromFile(Iterator<JsonNode> iter) {

        objectMapper = new ObjectMapper();
        List<Pulley> pulleysSchema = new ArrayList<>();
        try {

            JsonNode parameterNode = iter.next();
            JsonNode napedNode = parameterNode.get("naped");
            JsonNode rolkiNode = parameterNode.get("rolki");

            Pulley pulley = objectMapper.treeToValue(napedNode, Pulley.class);
            pulleysSchema.add(pulley);

            Iterator<JsonNode> iterkrazki = rolkiNode.iterator();
            while (iterkrazki.hasNext()) {
                JsonNode rolka = iterkrazki.next();
                Pulley pulley1 = objectMapper.treeToValue(rolka, Pulley.class);
                pulleysSchema.add(pulley1);
            }
            return pulleysSchema;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return pulleysSchema;

    }
}
