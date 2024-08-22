
package com.mycompany.proyecto1_poo_2023;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author sap1
 */
public class FileManager {
 
    
    
    
    
    // read txt file, para ller el query
    public static String readFile (String path) throws FileNotFoundException, IOException
    {
       
        String everything;

        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        everything = sb.toString();
        }   

        return everything;
    }
    
    
        // read txt file, para ller el query
    public static void writeFile (String path, String value) throws IOException 
    {


        try(BufferedWriter bw = new BufferedWriter (new FileWriter(path, true))) 
        {
            bw.write(value);
            bw.close();
        }
        
    }
    
    // escribe un objeto
    public static void writeObject (Object obj, String filePath)
    {
        try{
            //use buffering
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try{
                // escribe el objeto
              output.writeObject(obj);
            }
            finally{
              output.close();
            }
          }  
          catch(IOException ex){
              
          }
        
    }
    
      // escribe un objeto
    public static Object readObject(String filePath) {
        try (InputStream file = new FileInputStream(filePath);
             InputStream buffer = new BufferedInputStream(file);
             ObjectInput input = new ObjectInputStream(buffer)) {
            return input.readObject();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(); // Muestra detalles de la excepción
        } catch (IOException ex) {
            ex.printStackTrace(); // Muestra detalles de la excepción
        }
        return null;
    } 

    public static void saveIntToFile(int value, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeInt(value);
            dataOutputStream.close();
            fileOutputStream.close();
            System.out.println("Integer value saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadIntFromFile(String fileName) {
        int loadedIntValue = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            loadedIntValue = dataInputStream.readInt();
            dataInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedIntValue;
    }    
    
    
}// fin clase

