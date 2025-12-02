/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class ClienteDTO { // DTO = DATA TRANSFER OBJECT = OBJETO DE
							// TRANSFERENCIA DE DATOS
	private String nombres;
	private String apellidos;
	private char genero;
	private String documento;

        public ClienteDTO() {
        }
        

	public ClienteDTO(String nombres, String apellidos, char genero, String documento) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.genero = genero;
		this.documento = documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	@Override
	public String toString(){
		return "Documento: "+documento+", Nombre: "+nombres
                        + ", Apellidos: "+apellidos+", Género: "+genero;
	}

}