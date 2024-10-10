package CinemaJava;

import java.util.Random;
import java.util.Scanner;

public class Ejecutador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Cine cine = null;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Agregar película");
            System.out.println("2. Ingreso de clientes");
            System.out.println("3. Mostrar asientos asignados y pendientes");
            System.out.println("4. Mostrar información de un asiento");
            System.out.println("5. Mostrar información de la película");
            System.out.println("6. Finalizar programa");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (opcion == 6) {
                break;
            }

            switch (opcion) {
                case 1:
                    cine = agregarPelicula(scanner);
                    break;

                case 2:
                    if (cine == null) {
                        System.out.println("Debe asignar una película antes de "
                                + "asignar un asiento.");

                    } else {
                        asignarAsientosAleatoriamente(cine, random, scanner);
                    }
                    break;

                case 3:
                    if (cine == null) {
                        System.out.println("Debe asignar una película antes "
                                + "de mostrar los asientos.");
                    } else {
                        mostrarAsientos(cine);
                    }
                    break;

                case 4:
                    if (cine == null) {
                        System.out.println("Debe asignar una película antes "
                                + "de consultar un asiento.");
                    } else {
                        System.out.println("Ingrese la etiqueta del asiento que"
                                + " desea consultar (por ejemplo, 1A):");
                        String etiquetaConsulta = scanner.nextLine();
                        cine.mostrarInformacionAsiento(etiquetaConsulta);
                    }
                    break;

                case 5:
                    if (cine == null) {
                        System.out.println("Debe asignar una película antes de "
                                + "mostrar la información de la película.");
                    } else {
                        cine.mostrarInformacionPelicula();
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static Cine agregarPelicula(Scanner scanner) {
        System.out.println("Ingrese el título de la película:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese la duración de la película (en minutos):");
        int duracion = scanner.nextInt();
        System.out.println("Ingrese la edad mínima para ver la película:");
        int edadMinima = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese el nombre del director de la película:");
        String director = scanner.nextLine();

        Pelicula pelicula = new Pelicula(titulo, duracion, edadMinima, director);

        System.out.println("Ingrese el precio de la entrada:");
        double precioEntrada = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        return new Cine(pelicula, precioEntrada);
    }

    private static void asignarAsientosAleatoriamente(Cine cine, Random random,
            Scanner scanner) {
        String[] nombres = {
            "Hiroshi Tanaka", "Yuki Yamamoto", "Sakura Suzuki", "Kenji Nakamura",
            "Aiko Sato",
            "Wei Zhang", "Li Wei", "Chen Wang", "Xiao Liu", "Hua Yang",
            "Juan Pérez", "María Rodríguez", "Carlos Gómez", "Ana Martínez",
            "Luis Hernández",
            "Sofía López", "Pedro González", "Laura Díaz", "Miguel Torres",
            "Lucía Ramírez",
            "Jorge Flores", "Elena Morales", "Fernando Ruiz", "Isabel Ortiz",
            "Raúl Castro",
            "Patricia Mendoza", "Andrés Romero", "Marta Vargas", "Diego Silva",
            "Clara Rojas",
            "Takeshi Yamada", "Akira Kato", "Mika Fujimoto", "Ryo Watanabe",
            "Naoko Takahashi",
            "Jing Li", "Fang Chen", "Ying Zhao", "Lei Sun", "Qiang Wu",
            "José Fernández", "Gabriela Castillo", "Ricardo Navarro",
            "Valeria Peña", "Daniela Soto",
            "Francisco Reyes", "Camila Paredes", "Esteban Rivas",
            "Natalia Cárdenas", "Sebastián Aguilar",
            "Tomás Pacheco", "Emilia Salazar", "Alejandro Campos",
            "Victoria Serrano", "Manuel Espinoza",
            "Yoshiko Matsumoto", "Kazuo Ishikawa", "Haruto Kobayashi",
            "Ayumi Shimizu", "Satoshi Arai",
            "Mei Huang", "Bo Xu", "Jie Zhang", "Shan Li", "Tao Chen",
            "Antonio Vargas", "Luciana Ortiz", "Felipe Herrera",
            "Mariana Cruz", "Javier Mendoza",
            "Andrea Ríos", "Rodrigo Vega", "Paula Fuentes", "Santiago León",
            "Carolina Muñoz",
            "Álvaro Gutiérrez", "Renata Medina", "Gustavo Ponce",
            "Daniela Guerrero", "Matías Soto",
            "Hana Kimura", "Kenta Saito", "Yui Nakajima", "Shota Taniguchi",
            "Rina Takeda",
            "Ling Wang", "Hong Zhang", "Yuan Liu", "Min Zhao", "Wei Guo",
            "Miguel Ángel", "Sofía Jiménez", "Carlos Ruiz", "Ana Beltrán",
            "Luis Castro",
            "Sofía Vargas", "Pedro Morales", "Laura Herrera", "Miguel Díaz",
            "Lucía Torres",
            "Jorge Ramírez", "Elena Fernández", "Fernando Gómez",
            "Isabel Martínez",
            "Raúl López",
            "Patricia Sánchez", "Andrés Pérez", "Marta García",
            "Diego Rodríguez",
            "Clara González"
        };
        int asientosLibres = contarAsientosLibres(cine);

        while (asientosLibres > 0) {
            String nombre = nombres[random.nextInt(nombres.length)];
            int edad = random.nextInt(50) + 10;
            double dinero = 7000 + (random.nextDouble() * (40000 - 7000));

            Espectador espectador = new Espectador(nombre, edad, dinero);

            System.out.println("Hola Bienvenido: " + nombre + ", Edad: "
                    + edad + ", Dinero: " + dinero);
            System.out.print("¿Desea aceptar este espectador? (s/n): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                boolean asignado = false;
                while (!asignado && asientosLibres > 0) {
                    int fila = random.nextInt(8);
                    int columna = random.nextInt(9);
                    String etiquetaAsiento = (8 - fila)
                            + String.valueOf((char) ('A' + columna));
                    if (!cine.getAsientos()[fila][columna].isOcupado()
                            && cine.asignarAsiento(espectador, etiquetaAsiento)) 
                    {
                        asignado = true;
                        asientosLibres--;
                        mostrarAsientos(cine);
                        System.out.println("Asientos disponibles: "
                                + asientosLibres);
                    }
                }
            }

            if (asientosLibres == 0) {
                System.out.println("No hay más asientos disponibles.");
            }
        }
    }

    private static int contarAsientosLibres(Cine cine) {
        int asientosLibres = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (!cine.getAsientos()[i][j].isOcupado()) {
                    asientosLibres++;
                }
            }
        }
        return asientosLibres;
    }

    private static void mostrarAsientos(Cine cine) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                String etiquetaAsiento = (8 - i)
                        + String.valueOf((char) ('A' + j));
                System.out.print(etiquetaAsiento
                        + (cine.getAsientos()[i][j].isOcupado() 
                                ? "[X]" : "[ ]") + " ");
            }
            System.out.println();
        }
    }
}
