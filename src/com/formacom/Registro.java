package com.formacom;

import java.time.LocalDateTime;

public class Registro {
    private Alumno alumno;
    private LocalDateTime fecha;
    private String modo;

    public Registro(Alumno alumno, String modo) {
        this.alumno = alumno;
        this.modo = modo;
        fecha = LocalDateTime.now();
    }

    public String getModo() {
        return modo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "alumno=" + alumno +
                ", fecha=" + fecha +
                ", modo='" + modo + '\'' +
                '}';
    }
}
