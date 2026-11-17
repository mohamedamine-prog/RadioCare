package model;

public abstract class Objet {
    protected String id;

    public Objet(String id) {
        this.id = id;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
