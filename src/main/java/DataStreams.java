import java.io.*;

public class DataStreams {

    private final String filePath;


    public DataStreams(final String filePath){
        this.filePath = filePath;
    }

    public void streamRead(){
        try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))){
            System.out.println(dis.readInt());
        }catch (IOException ioe){
            System.out.println("Datei nicht schreibbar");
        }
    }

    public void streamWrite(){
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))){
            dos.writeInt(150);
            //dos.writeBytes("hallo");
        }catch (IOException ioe){
            System.out.println("Datei nicht schreibbar");
        }
    }
}
