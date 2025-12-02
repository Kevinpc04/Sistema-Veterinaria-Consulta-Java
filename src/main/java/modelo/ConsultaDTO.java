package modelo;

public class ConsultaDTO {
        private String id;
        private String fecha;
        private String identificacionMascota;
        private String sintomas;
        private String tratamiento;

    public ConsultaDTO() {
    }
        

    public ConsultaDTO(String id, String fecha, String identificacionMascota, String sintomas, String tratamiento) {
        this.id = id;
        this.fecha = fecha;
        this.identificacionMascota = identificacionMascota;
        this.sintomas = sintomas;
        this.tratamiento = tratamiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdentificacionMascota() {
        return identificacionMascota;
    }

    public void setIdentificacionMascota(String identificacionMascota) {
        this.identificacionMascota = identificacionMascota;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "ConsultaDTO{" + "id=" + id + ", fecha=" + fecha + ", identificacionMascota=" + identificacionMascota + ", sintomas=" + sintomas + ", tratamiento=" + tratamiento + '}';
    }
    
    
        
}
    