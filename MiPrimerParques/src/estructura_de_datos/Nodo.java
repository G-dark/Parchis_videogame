package estructura_de_datos;

public class Nodo {

    private int casilla;
    private int color;
    private String usuario;
    public float[] position = new float[2];
    public float[] position2 = new float[2];
    public float[] position3 = new float[2];
     public float[] position4 = new float[2];

    private Nodo link;

    public Nodo() {

    }

    public void setLink(Nodo link) {
        this.link = link;
    }

    public Nodo getLink() {
        return link;
    }

    public int getCasilla() {
        return casilla;
    }

    public void setCasilla(int casilla) {
        this.casilla = casilla;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
