
package User;

import java.time.LocalDate;

//Entidad con la que se trabajará creacion y escritura del registro.

public class Usuario {
    private String name;
    private String email;
    private String pass;
    private int edad;

    public Usuario() {
    }
    
    public Usuario(String name,String email,String pass,int edad){
    this.name = name;
    this.edad = edad;
    this.pass = pass;
    this.email = email;
    
    }
    //Metodo para retornar los datos del usuario.
    @Override
    public String toString() {
        return "Nombre_de_Usuario: "+ name +" E-mail: "+ email +" Edad: "+edad+ " Contraseña: " + pass + "\n";
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getContraseña() {
        return pass;
    }

    public void setContraseña(String contraseña) {
        this.pass = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
