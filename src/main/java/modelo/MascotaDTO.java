package modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Usuario
 */
public class MascotaDTO {

    public MascotaDTO() {
}

    public MascotaDTO(String nombre, String identificacion, String raza, int edad, String tipo, float peso, String estado, String fechaIngreso, String lugarOrigen, String genero, String documentoPropietario) {
    }
    private String nombre;
    private String identificacion;
    private String raza;
    private int edad;
    private String tipo;
    private float peso;
    private String estado;
    private String fechaIngreso;
    private String lugarOrigen;
    private char genero;
    private String documentoPropietario;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getDocumentoPropietario() {
        return documentoPropietario;
    }

    public void setDocumentoPropietario(String documentoPropietario) {
        this.documentoPropietario = documentoPropietario;
    }

    @Override
    public String toString() {
        return "MascotaDTO{" + "nombre=" + nombre + ", identificacion=" + identificacion + ", raza=" + raza + ", edad=" + edad + ", tipo=" + tipo + ", peso=" + peso + ", estado=" + estado + ", fechaIngreso=" + fechaIngreso + ", lugarOrigen=" + lugarOrigen + ", genero=" + genero + ", documentoPropietario=" + documentoPropietario + '}';
    }

    
   
}
