/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;
import java.util.List;
import java.io.*;
import javax.swing.JOptionPane;
import modelo.ClienteDTO;
import java.util.ArrayList;
import dao.ClienteDAO;


/**
 *
 * @author Usuario
 */
public class ClienteDAOFile implements ClienteDAO {

    private static final String DELIMITADOR_ARCHIVO = ",";
    private static final String FILE_NAME = "clienteDTO.txt";
    private BufferedWriter escritorBuffer;
    private BufferedReader lectorBuffer;
    private FileWriter escritorArchivo;
    private FileReader lectorArchivo;
    private File archivoClientes;

    public ClienteDAOFile() {
        archivoClientes = new File(FILE_NAME);
    }

    @Override
    public boolean almacenarCliente(ClienteDTO cliente) {
        StringBuilder sb = new StringBuilder();
        sb.append(cliente.getDocumento());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(cliente.getNombres());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(cliente.getApellidos());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(cliente.getGenero());

        try {

            escritorArchivo = new FileWriter(archivoClientes, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);
            escritorBuffer.write(sb.toString());
            escritorBuffer.newLine();
            escritorBuffer.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error");
        }
        return false;
    }

    @Override
    public ClienteDTO consultarCliente(String identificacion) {
        String linea;
        try {
            lectorArchivo = new FileReader(archivoClientes);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(identificacion)) {
                    String parametros[] = linea.split(",");
                    return (new ClienteDTO(parametros[1], parametros[2],
                            parametros[3].charAt(0), parametros[0]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        archivoClientes = new File(FILE_NAME);
        String linea;
        List<ClienteDTO> clientes = new ArrayList<>();
        try {
            lectorArchivo = new FileReader(archivoClientes);
            lectorBuffer = new BufferedReader(lectorArchivo);
            while ((linea = lectorBuffer.readLine()) != null) {
                String parametros[] = linea.split(",");
                clientes.add(new ClienteDTO(parametros[1], parametros[2],
                        parametros[3].charAt(0), parametros[0]));
            }
            return clientes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean eliminarCliente(String documento) {
        String linea;
        archivoClientes = new File(FILE_NAME);
        File archivoTemporal = new File("temporal.txt");

        try {
            lectorArchivo = new FileReader(archivoClientes);
            lectorBuffer = new BufferedReader(lectorArchivo);

            escritorArchivo = new FileWriter(archivoTemporal, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(documento)) {
                    System.out.println("coincide");
                    escritorBuffer.write("");
                } else {
                    escritorBuffer.write(linea);
                    escritorBuffer.newLine();
                }
            }
            escritorBuffer.close();
            lectorBuffer.close();

            escritorBuffer = new BufferedWriter(new FileWriter(archivoClientes));
            lectorBuffer = new BufferedReader(new FileReader(archivoTemporal));
            while ((linea = lectorBuffer.readLine()) != null) {
                escritorBuffer.write(linea);
                escritorBuffer.newLine();
            }
            escritorBuffer.close();
            lectorBuffer.close();
            System.out.println(archivoTemporal.delete());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (null != lectorArchivo) {
                    lectorArchivo.close();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        return false;
    }

    @Override
    public boolean actualizarCliente(ClienteDTO cliente) {
        archivoClientes = new File(FILE_NAME);
        String linea;
        try {
            lectorArchivo = new FileReader(archivoClientes);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(cliente.getDocumento())) {
                    lectorBuffer.close();
                    eliminarCliente(cliente.getDocumento());
                    almacenarCliente(cliente);
                    return true;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}