
package tom2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.Deflater;

public class PackJar {
public void pack(String s,String put)throws  FileNotFoundException,IOException{

    String[] filesname;
    File[] files=null;
    byte[] bf;    
    File file=null;
    File filejar=null;
    FileOutputStream writefile=null;
    FileInputStream readfile=null;
    JarOutputStream jarfile=null;
    JarEntry jr=null;
   
    try{
        file=new File(put);
        System.out.println(s);
        filejar=new File(s);
        files=file.listFiles();
        
       if (!file.exists() || !file.isDirectory()) {
        throw new FileNotFoundException(file + " not found");
        }
       
       int count=0;
       for(int i=0;i<files.length;i++)
           if (!files[i].isDirectory()) 
               count++;
           
       filesname=new String[count];
       count=0;
       
       for(int i=0;i<files.length;i++)
           if (!files[i].isDirectory()) {
             filesname[count]=files[i].getPath();
             count++;}
               
        bf=new byte[2_048];
        writefile=new FileOutputStream(filejar);
        jarfile=new JarOutputStream(writefile); 
        jarfile.setLevel(Deflater.DEFAULT_COMPRESSION);
        
        for (String filesname1 : filesname) {
            System.out.println(filesname1);
            jarfile.putNextEntry(new JarEntry(filesname1));
            readfile=new FileInputStream(filesname1);
            int len;
               
            while((len=readfile.read(bf))>0){
                jarfile.write(bf,0,len);}
                jarfile.closeEntry();}}
    
                //lg mn6353n 3150

    catch(FileNotFoundException e){System.out.printf("error1");}    
    catch(IOException e){System.out.printf("error2"+e);}
    finally{jarfile.close();}
}}