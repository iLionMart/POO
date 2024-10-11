import javax.swing.*;

public class ArreglosObjetos{
    public static void main(String[] args) {
        int cantAlum = Integer.parseInt(JOptionPane.showInputDialog("Teclea número de Alumnos a registrar"));
        VectorOb vectorOb = new VectorOb();
        Alumno[] alumnos = vectorOb.cargarAlumnos(cantAlum);

        // Mostrar alumnos antes de ordenar en la consola
        System.out.println("Lista de alumnos antes de ordenar:");
        System.out.print(vectorOb.mostrarAlumnos());

        // Ordenar y luego mostrar alumnos ordenados en la consola
        vectorOb.ordenarAlumnos();
        System.out.println("\nLista de alumnos después de ordenar por nombre:");
        System.out.print(vectorOb.mostrarAlumnos());

        vectorOb.buscarAlumno();
    }
}

class Alumno {
    private String numCon;
    private String nombre;
    private int semestre;

    public Alumno() {
    }

    public void capturar() {
        this.numCon = JOptionPane.showInputDialog("Teclea el numero de control");
        this.nombre = JOptionPane.showInputDialog("Teclea nombre del alumno con numero de control: " + numCon);
        this.semestre = Integer.parseInt(JOptionPane.showInputDialog("Teclea el semestre del alumno: " + nombre));
    }

    public String getNumCon() {
        return numCon;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestre() {
        return semestre;
    }
}

class VectorOb {
    private Alumno[] alumnos;

    public Alumno[] cargarAlumnos(int n) {
        alumnos = new Alumno[n];
        for (int i = 0; i < n; i++) {
            alumnos[i] = new Alumno();
            alumnos[i].capturar();
        }
        return alumnos;
    }

    public String mostrarAlumnos() {
        StringBuilder s = new StringBuilder("Alumnos registrados\nNum Con:\tNombre:\tSemestre:\n");
        for (Alumno alumno : alumnos) {
            s.append(alumno.getNumCon()).append("\t")
             .append(alumno.getNombre()).append("\t")
             .append(alumno.getSemestre()).append("\n");
        }
        return s.toString();
    }

    public void ordenarAlumnos() {
        for (int i = 0; i < alumnos.length - 1; i++) {
            for (int j = 0; j < alumnos.length - i - 1; j++) {
                if (alumnos[j].getNombre().compareTo(alumnos[j + 1].getNombre()) > 0) {
                    Alumno temp = alumnos[j];
                    alumnos[j] = alumnos[j + 1];
                    alumnos[j + 1] = temp;
                }
            }
        }
    }

    public void buscarAlumno() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Elige 1 para buscar por numero de control o 2 para buscar por nombre"));
        String busqueda;
        boolean encontrado = false;

        if (id == 1) {
            busqueda = JOptionPane.showInputDialog("Teclea el numero de control del alumno para buscarlo");
            for (Alumno alumno : alumnos) {
                if (busqueda.equals(alumno.getNumCon())) {
                    JOptionPane.showMessageDialog(null, "El numero de control: " + busqueda + " existe.\nNombre: " + alumno.getNombre() + "\nSemestre: " + alumno.getSemestre());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El alumno de numero: " + busqueda + " no existe.");
            }
        } else if (id == 2) {
            busqueda = JOptionPane.showInputDialog("Teclea el nombre del alumno para buscarlo");
            for (Alumno alumno : alumnos) {
                if (busqueda.equals(alumno.getNombre())) {
                    JOptionPane.showMessageDialog(null, "El nombre: " + busqueda + " existe.\nNumero de Control: " + alumno.getNumCon() + "\nSemestre: " + alumno.getSemestre());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El alumno de nombre: " + busqueda + " no existe.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opción no válida.");
        }
    }
}
