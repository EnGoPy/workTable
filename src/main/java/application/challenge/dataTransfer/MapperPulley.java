package application.challenge.dataTransfer;

import application.challenge.entity.Pulley;
import application.challenge.parsing.WriteJSONFile;

import java.util.ArrayList;
import java.util.List;

public class MapperPulley {

    public static PulleyDTO fromEntityToDto(Pulley p) {
        String name;
        String rotationDirection;
        int id = p.getId();
        int n = p.getN();
        if (p.getId() == 1) {
            name = "Powered_pulley";
        } else {
            name = "pulley_" + p.getId();
        }
        if (n > 0) rotationDirection = "P";
        else if (n < 0) rotationDirection = "L";
        else rotationDirection = "none";

        PulleyDTO created = new PulleyDTO(name, id, n, rotationDirection, p.getAnnotations());
        return created;
    }

    public static List<List<PulleyDTO>> transferWholeInput(List<List<Pulley>> inputSets) {
        List<List<PulleyDTO>> transferredSet = new ArrayList<>();
        for(List<Pulley> someList : inputSets){
            List<PulleyDTO> results = new ArrayList<>();
            for(Pulley p: someList){
                PulleyDTO temp = fromEntityToDto(p);
                results.add(temp);
            }
            System.out.println(results);
            transferredSet.add(results);
            WriteJSONFile.writeResultToJsonFile(transferredSet);
        }
        return transferredSet;
    }
}

