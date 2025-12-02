/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.util.List;
import modelo.ClienteDTO;
/**
 *
 * @author Usuario
 */


public interface ClienteDAO {
	
    public boolean almacenarCliente(ClienteDTO cliente);
    public ClienteDTO consultarCliente(String documento);
    public List<ClienteDTO> listarClientes();
    public boolean eliminarCliente(String documento);
    public boolean actualizarCliente(ClienteDTO cliente);
}