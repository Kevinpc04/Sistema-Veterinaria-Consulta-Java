/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.util.List;
import modelo.MascotaDTO;
/**
 *
 * @author Usuario
 */
public interface MascotaDAO {
    public boolean almacenarMascota(MascotaDTO mascota);
    public MascotaDTO consultarMascota(String identificacion);
    public List<MascotaDTO> listarMascotas();
    public boolean eliminarMascota(String identificacion);//Depende de la ventana sin RESOLVER
    public boolean actualizarMascota(MascotaDTO mascota);
    
    
}
