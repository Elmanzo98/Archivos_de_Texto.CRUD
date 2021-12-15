
package ConexionArchivo;

import User.Usuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;




public class Archivo_de_Registros {
    
    
    //Metodo para buscar y abrir el archivo.   
    public File conexionArchivo(){
        
       File archivoPrueba = new File("Archivo_De_Cuentas.txt");

        if (archivoPrueba.exists()) {
            return archivoPrueba;

        } else {
            //Si el archivo no existe se creará.
            try {
                archivoPrueba.createNewFile();
            } catch (IOException ex) {
               ex.printStackTrace();
            }

            return archivoPrueba;
        }
    }
    
    
    public void crearRegistro(String name,String email, String pass,int edad) throws IOException{
    //Metodo para crear un usuario y guardarlo en el archivo.
        Usuario user = new Usuario(name,email,pass,edad);
        FileWriter fw = new FileWriter(conexionArchivo(),true);
        BufferedWriter escritura;
        
        try {   
            escritura = new BufferedWriter(fw);
            escritura.write("Nombre_de_Usuario: "+ name +" E-mail: "+ email +" Edad: "+edad+ " Contraseña: " + pass + "\n");
            escritura.close();
            fw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    
    
    }
    
   
    public ArrayList<String> listaRegistros(){
    //Metodo que devuelve una lista de objetos,cada uno de ellos un registro en el archivo.
        ArrayList<String> lista;
        lista = new ArrayList();
          Scanner sc;
          String linea;
          try {
                sc = new Scanner(conexionArchivo());
                while(sc.hasNextLine()){
                linea = sc.nextLine();
                
                lista.add(linea);   
                }
                
        } catch (Exception e) {
        }
          
        return lista;
    }
     
   
    public boolean validarEmailyPass(String email,String pass){
    //Metodo para validacion de Email y Contraseña al momento de iniciar sesión.
        boolean validacion = false;
        listaRegistros();
     for (int i = 0; i < listaRegistros().size(); i++) {
            
            if(listaRegistros().get(i).split(" ")[3].equalsIgnoreCase(email)&&listaRegistros().get(i).split(" ")[7].equals(pass)){
            
                validacion = true;
                break;
            }
            if(!listaRegistros().get(i).split(" ")[3].equalsIgnoreCase(email)&&listaRegistros().get(i).split(" ")[7].equals(pass)){
            
                validacion = false;
                break;
            }
         
           
        }
     return validacion;
    
    
    
    }
    
    
    public void modificarRegistro(String email,String n_usuario,String pass,int edad) throws FileNotFoundException, IOException{
    //Metodo para hacer una modificacion de algún registro.
    //En este caso solo se puede modificar el Nombre de usuario y la Edad.
        ArrayList<String> lista = listaRegistros();
        Usuario user = new Usuario(n_usuario,email,pass,edad);
        
            for (int i = 0; i <lista.size(); i++) {
                if(lista.get(i).split(" ")[3].equalsIgnoreCase(email)){
                
                    lista.remove(i);
                    lista.add(user.toString());
                }
        }
        for (int i = 0; i <lista.size(); i++) {
             System.out.println(lista.get(i));
        
        }
       
        
        
        FileWriter fw = new FileWriter(conexionArchivo(),true);
        BufferedWriter escritura;
        
        try {   
            escritura = new BufferedWriter(fw);
            escritura.write("Nombre_de_Usuario: "+ n_usuario +" E-mail: "+ email +" Edad: "+edad+ " Contraseña: " + pass + "\n");
            escritura.close();
            fw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    
        
    
    public void eliminarRegistro(String email) throws FileNotFoundException, IOException {
    //Metodo para eliminar un registro.
    //En este caso solo se pide el Email para apuntar al registro.
        ArrayList<String> lista;
        lista = new ArrayList<String>();
     
            Scanner input = new Scanner(conexionArchivo());

        try{ String line = null;
            String lineaAux;
            while (input.hasNextLine()) {

                line = input.nextLine();
                if (!line.split(" ")[3].equals(email)) {
                    lista.add(line);

                }

                if (line.split(" ")[3].equals(email)) {
                    continue;
                }

            }

            PrintWriter escritura;
            try {
                escritura = new PrintWriter(conexionArchivo(), "utf-8");
                for (int i = 0; i < lista.size(); i++) {
                    escritura.print(lista.get(i) + "\n");
                }

                escritura.close();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        
        }
            
    }
    
    
}
