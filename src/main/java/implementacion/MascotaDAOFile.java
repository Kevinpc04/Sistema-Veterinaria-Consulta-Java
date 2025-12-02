/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;

import java.util.List;
import java.io.*;
import javax.swing.JOptionPane;
import modelo.MascotaDTO;
import java.util.ArrayList;
import dao.MascotaDAO;

/**
 *
 * @author Usuario
 */
public class MascotaDAOFile implements MascotaDAO {

    private static final String DELIMITADOR_ARCHIVO = ",";
    private static final String FILE_NAME = "mascota.txt";
    private BufferedWriter escritorBuffer;
    private BufferedReader lectorBuffer;
    private FileWriter escritorArchivo;
    private FileReader lectorArchivo;
    private File archivoMascota;

    public MascotaDAOFile() {
        archivoMascota = new File(FILE_NAME);
    }

    @Override
    public boolean almacenarMascota(MascotaDTO mascota) {
        StringBuilder sb = new StringBuilder();
        sb.append(mascota.getIdentificacion());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(mascota.getNombre());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(mascota.getEstado());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(mascota.getGenero());

        try {

            escritorArchivo = new FileWriter(archivoMascota, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);
            escritorBuffer.write(sb.toString());
            escritorBuffer.newLine();
            escritorBuffer.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return false;
    }

    @Override
    public MascotaDTO consultarMascota(String identificacion) {
        String linea;
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(identificacion)) {
                    String parametros[] = linea.split(",");
                    return (new MascotaDTO(parametros[1], parametros[0], parametros[2], Integer.parseInt(parametros[3]), parametros[4], Float.parseFloat(parametros[5]), parametros[6], parametros[7], parametros[8], parametros[9], parametros[10]));
                } else {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MascotaDTO> listarMascotas() {
        archivoMascota = new File(FILE_NAME);
        String linea;
        List<MascotaDTO> mascotas = new ArrayList<>();
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);
            while ((linea = lectorBuffer.readLine()) != null) {
                String parametros[] = linea.split(",");
                mascotas.add(new MascotaDTO(parametros[1], parametros[0], parametros[2], Integer.parseInt(parametros[3]), parametros[4], Float.parseFloat(parametros[5]), parametros[6], parametros[7], parametros[8], parametros[9], parametros[10]));
            }
            return mascotas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean eliminarMascota(String identificacion) {
        String linea;
        archivoMascota = new File(FILE_NAME);
        File archivoTemporal = new File("temporal.txt");

        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            escritorArchivo = new FileWriter(archivoTemporal, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(identificacion)) {
                    System.out.println("coincide");
                    escritorBuffer.write("");
                } else {
                    escritorBuffer.write(linea);
                    escritorBuffer.newLine();
                }

            }
            escritorBuffer.close();
            lectorBuffer.close();

            escritorBuffer = new BufferedWriter(new FileWriter(archivoMascota));
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
    public boolean actualizarMascota(MascotaDTO mascota) {
        archivoMascota = new File(FILE_NAME);
        String linea;
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(mascota.getIdentificacion())) {
                    lectorBuffer.close();
                    eliminarMascota(mascota.getIdentificacion());
                    almacenarMascota(mascota);
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
