package CinemaJava;

public class Asiento {

    private String etiqueta;
    private boolean ocupado;
    private Espectador espectador;

    public Asiento(String etiqueta) {
        this.etiqueta = etiqueta;
        this.ocupado = false;
        this.espectador = null;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    @Override
    public String toString() {
        return "Asiento{"
                + "etiqueta='" + etiqueta + '\''
                + ", ocupado=" + ocupado
                + ", espectador=" + (espectador != null ? espectador.getNombre()
                : "N/A")
                + '}';
    }
}
