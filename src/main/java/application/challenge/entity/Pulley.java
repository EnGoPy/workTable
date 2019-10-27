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

    public void addAnnotation(String annotation){
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


    public void addContact(Pulley p){
        this.contact.add(p.getId());
        System.out.println(this.getId()+"  "+this.contact);
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

    //    @Override
//    public String toJson() {
//        final StringWriter writable = new StringWriter();
//        try{
//            this.toJson(writable);
//        }catch (final IOException e){
//        }
//        return writable.toString();
//    }
//
//    @Override
//    public void toJson(Writer writable) throws IOException {
//
//        final JsonObject json  = new JsonObject();
//        json.put("pulleyId", this.getPulleyId());
//        json.put("powered", this.isPowered());
//        json.put("xCord", this.getxCord());
//        json.put("yCord", this.getyCord());
//        json.put("rg", this.getRd());
//        json.put("rd", this.getRd());
//        json.put("n", this.getN());
//    }
}
