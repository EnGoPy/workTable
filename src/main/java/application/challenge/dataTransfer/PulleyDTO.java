package application.challenge.dataTransfer;

import java.util.ArrayList;
import java.util.List;

public class PulleyDTO {
    private String name;
    private int id;
    private int n;
    private String rotationDirection;
    private List<String> annotations = new ArrayList<>();

    public PulleyDTO(String name, int id, int n, String rotationDirection, List<String> annotations) {
        this.name = name;
        this.id = id;
        this.n = n;
        this.rotationDirection = rotationDirection;
        this.annotations = annotations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getRotationDirection() {
        return rotationDirection;
    }

    public void setRotationDirection(String rotationDirection) {
        this.rotationDirection = rotationDirection;
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<String> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return "PulleyDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", n=" + n +
                ", rotationDirection='" + rotationDirection + '\'' +
                ", annotations=" + annotations +
                '}';
    }
}
