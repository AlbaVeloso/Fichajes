package com.formacom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fichajes implements IFichajes {
    @Override
    public Boolean loging(String user, String pass) {
        if (user.equals("admin") && pass.equals("1234")) {
            return true;
        }
        return false;
    }

    @Override
    public String alta_alumno(String nombre, String dni) {
        if (listaAlumnos.stream().anyMatch(a -> a.getDni().equals(dni))) {
            return "Ya existe un alumno con ese DNI";
        }
        listaAlumnos.add(new Alumno(nombre, dni));
        return "Alumno añadido correctamente";
    }

    @Override
    public String cambiar_modo(String modo) {
        this.modo=modo;
        return this.modo;
    }

    @Override
    public List<Registro> informe_por_dia(LocalDate dia) {
        List<Registro> informe = new ArrayList<>();
        for (Registro registro : registros) {
            if (registro.getFecha().toLocalDate().equals(dia)) {
                informe.add(registro);
            }
        }
        return informe;
    }

    @Override
    public List<Registro> informe_por_alumno(String dni) {
        List<Registro> informe=new ArrayList<>();
        for (Registro registro : registros) {
            if(registro.getAlumno().getDni().equals(dni)){
                informe.add(registro);
            }
        }
        return informe;
    }

    @Override
    public String fichar(String dni) {
        Alumno alumno=buscarPorDni(dni);
        if(alumno==null){
            return "No existe un alumno con ese DNI";
        }
        Registro registro=new Registro(alumno,modo);
        registros.add(registro);
        return "Fichaje realizado correctamente";
    }

private Alumno buscarPorDni(String dni) {
    for (Alumno alumno : listaAlumnos) {
        if (alumno.getDni().equals(dni)) {
            return alumno;
        }
    }
    return null;
}

private List<Alumno> listaAlumnos;
    private String modo;
    private List<Registro> registros;

    public Fichajes() {
        listaAlumnos = new ArrayList<Alumno>();
        registros = new ArrayList<>();
        modo = "Entrada";
    }
}
