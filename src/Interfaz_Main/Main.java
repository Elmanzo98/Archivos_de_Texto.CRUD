
package Interfaz_Main;

import ConexionArchivo.Archivo_de_Registros;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Archivo_de_Registros arch = new Archivo_de_Registros();
        int opcion_1 = 0;
        boolean opcionAux =false;
        String name;
        String email;
        String pass;
        int edad;
        try {
            arch.conexionArchivo();
        } catch (Exception e) {
        }
        //Menú para utilizacion del programa a través de la consola.
        System.out.println("-----Sistema de Guardado de registros.-----\n");
        do {System.out.println("Elija la operacion a realizar: ");
            System.out.println("1.Crear cuenta.");
            System.out.println("2.Iniciar sesion.");
            System.out.println("3.Modificar cuenta.");
            System.out.println("4.Eliminar mi cuenta.");
            System.out.println("3.salir.");
          
            opcion_1 = sc.nextInt();
            switch (opcion_1) {
                //Datos requeridos para creacion de una cuenta.
            case 1: System.out.println("Nombre de usuario: ");
                    name = sc.next();
                    System.out.println("Email: ");
                    email = sc.next();
                    System.out.println("Edad: ");
                    edad = sc.nextInt();
                    System.out.println("Contraseña: ");
                    pass = sc.next();
 
                try {
                    arch.crearRegistro(name, email, pass, edad);
                    System.out.println("Guardado con exito. "+"\n");
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
                
                
            case 2: do{
                    //Para "inicio de sesion".
                    System.out.println("Ingrese su E-mail: ");
                    email = sc.next();
                    System.out.println("Ingrese su Contraseña: ");
                    pass = sc.next();
                    opcionAux=arch.validarEmailyPass(email, pass);
                        if(!opcionAux){
                            System.out.println("Email o Contraseña inválida. Reintente.");
                            opcionAux=false;
                        }
                        if(opcionAux){
                            System.out.println("Datos validados!.");
                            System.out.println("Bienvenido.\n");
                            opcionAux=true;
                            break;
                            
                        }
                    } while (opcionAux == false);
            
                    
            //Para Modificacion de un registro.
            case 3 :System.out.println("Email: ");
                    email = sc.next();
                    System.out.println("Contraseña: ");
                    pass = sc.next();
                    
                    System.out.println("Nombre de usuario: ");
                    name = sc.next();

                    System.out.println("Edad: ");
                    edad = sc.nextInt();
                    
                   try {
                    arch.modificarRegistro(email, name, pass, edad);
                } catch (Exception e) {
                }   
                   break;
                //Para eliminar un registro.      
                case 4:
                    do {
                        System.out.println("Para borrar su cuenta ingrese su Email y Contraseña.------\n");
                        System.out.println("Ingrese su E-mail: ");
                        email = sc.next();
                        System.out.println("Ingrese su Contraseña: ");
                        pass = sc.next();
                        opcionAux = arch.validarEmailyPass(email, pass);
                        if (!opcionAux) {
                            System.out.println("Email o Contraseña inválida. Reintente.");
                            opcionAux = false;
                        }
                        if (opcionAux) {
                            int opc =0;
                            System.out.println("¿Seguro que desea eliminar su cuenta?.\n");
                            System.out.println("1.Si");
                            System.out.println("2.No");
                            opc = sc.nextInt();
                            switch(opc){
                                case 1 : arch.eliminarRegistro(email);
                                    System.out.println("Registro eliminado exitosamente.");
                                    
                            }
                            opcionAux = true;
                            break;

                        }
                 }while(opcionAux==false);            
                     
          
        }
        } while (opcion_1!=3);
        
        
        
    }
    
}
