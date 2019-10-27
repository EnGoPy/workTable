package application.challenge.parsing;

import application.challenge.dataTransfer.PulleyDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteJSONFile {

    private static ObjectMapper objectMapper;
    private static String fileName = "daneWyjsciowe.json";
    private static File outputFile =  new File(fileName);

    public static void writeResultToJsonFile(List<List<PulleyDTO>> pulleysResults){

        objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(outputFile, pulleysResults);
        }catch (IOException e){
            e.printStackTrace();

        }


    }
}
