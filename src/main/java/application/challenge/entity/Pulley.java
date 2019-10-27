package application.challenge.entity;

import java.util.ArrayList;
import java.util.List;

public class Pulley {

    private int x;
    private int y;
    private int rg;
    private int rd;
    private int n;
    private List<String> annotations = new ArrayList<>();
    private int id;
    private List<Integer> contact = new ArrayList<>();


    public Pulley() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getRd() {
        return rd;
    }

    public void setRd(int rd) {
        this.rd = rd;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void addAnnotation(String annotation) {
        this.annotations.add(annotation);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getContact() {
        return contact;
    }


    public void addContact(Pulley p) {
        this.contact.add(p.getId());
    }

    @Override
    public String toString() {
        return "Pulley{" +
                "n=" + n +
                ", annotations=" + annotations +
                ", id=" + id +
                ", contact=" + contact +
                '}';
    }
}
