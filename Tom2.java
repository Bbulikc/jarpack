
package tom2;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.util.jar.JarOutputStream;
import java.io.FileInputStream;
import java.util.jar.JarInputStream;
import java.util.jar.JarEntry;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 *
 * @author Bublikc
 */
public class Tom2 {


    public static void main(String[] args) throws FileNotFoundException,  IOException  {
    
        PackJar p=new PackJar();
        p.pack( "c:\\2.jar","c:\\2\\");
      
    
}     
}