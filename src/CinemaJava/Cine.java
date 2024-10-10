package CinemaJava;

public class Cine {

    private Pelicula pelicula;
    private double PrecioEntrada;
    private Asiento[][] asientos;

    public Cine(Pelicula pelicula, double PrecioEntrada) {
        this.pelicula = pelicula;
        this.PrecioEntrada = PrecioEntrada;
        this.asientos = new Asiento[8][9];
        inicializarAsientos();
    }

    private void inicializarAsientos() {
        char[] columnas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {

                asientos[i][j] = new Asiento((8 - i)
                        + String.valueOf(columnas[j]));
            }
        }
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getPrecioEntrada() {
        return PrecioEntrada;
    }

    public void setPrecioEntrada(double PrecioEntrada) {
        this.PrecioEntrada = PrecioEntrada;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public boolean asignarAsiento(Espectador espectador, String etiquetaAsiento) 
    {
        if (espectador.getDinero() < PrecioEntrada) {
            System.out.println("El espectador " + espectador.getNombre()
                    + " no tiene dinero suficiente. Necesita " + PrecioEntrada
                    + " solo tiene " + espectador.getDinero() + ".");
            return false;
        }
        if (espectador.getEdad() < pelicula.getEdadMinima()) {
            System.out.println("El espectador " + espectador.getNombre()
                    + " no cumple con la edad " + pelicula.getEdadMinima()
                    + " años.");
            return false;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (asientos[i][j].getEtiqueta().equals(etiquetaAsiento)) {
                    if (asientos[i][j].isOcupado()) {
                        System.out.println("El asiento " + etiquetaAsiento
                                + " no esta disponible "
                                + asientos[i][j].getEspectador().getNombre()
                                + " (Edad: "
                                + asientos[i][j].getEspectador().getEdad()
                                + ").");
                        return false;
                    } else {
                        asientos[i][j].setOcupado(true);
                        asientos[i][j].setEspectador(espectador);
                        double cambio = espectador.getDinero() - PrecioEntrada;
                        System.out.println("Espectador "
                                + espectador.getNombre()
                                + "a sido asignado al puesto " + etiquetaAsiento
                                + ". Cambio devuelto: " + cambio + ".");
                        return true;
                    }
                }
            }
        }

        System.out.println("El asiento " + etiquetaAsiento + " no existe.");
        return false;
    }

    public void mostrarInformacionAsiento(String etiquetaAsiento) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (asientos[i][j].getEtiqueta().equals(etiquetaAsiento)) {
                    if (asientos[i][j].isOcupado()) {
                        Espectador espectador = asientos[i][j].getEspectador();
                        System.out.println("El asiento " + etiquetaAsiento
                                + " está ocupado por " + espectador.getNombre()
                                + " (Edad: " + espectador.getEdad() + ").");
                    } else {
                        System.out.println("El asiento "
                                + etiquetaAsiento + " está libre.");
                    }
                    return;
                }
            }
        }
        System.out.println("El asiento " + etiquetaAsiento + " no existe.");
    }

    public void mostrarInformacionPelicula() {
        System.out.println("Información de la Película:");
        System.out.println("Título: " + pelicula.getTitulo());
        System.out.println("Duración: " + pelicula.getDuracion() + " minutos");
        System.out.println("Edad Mínima: " + pelicula.getEdadMinima()
                + " años");
        System.out.println("Director: " + pelicula.getDirector());
        System.out.println("Precio de la Entrada: " + PrecioEntrada);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cine{");
        sb.append("pelicula=").append(pelicula);
        sb.append(", precioEntrada=").append(PrecioEntrada);
        sb.append(", asientos=");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(asientos[i][j].toString()).append(" ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
