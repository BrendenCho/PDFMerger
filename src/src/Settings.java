package src;

import java.io.*;

public class Settings implements Serializable {

    private String homeFolderLocation;
    private String serializationLocation;

    public void setHomeFolderLocation(String homeFolderLocation) {
        File f = new File(homeFolderLocation);

        if(!f.exists()){
            System.err.println("Tried to open home folder but it does not exist");
            return;
        }
        this.homeFolderLocation = homeFolderLocation;
    }

    public String getHomeFolderLocation(){
        File f = new File(homeFolderLocation);

        if(!f.exists()){
            return null;
        }
        return this.homeFolderLocation;
    }

    public void setSerializationLocation(String serializationLocation){
        this.serializationLocation = serializationLocation;
    }

    public String getSerializationLocation(){
        return serializationLocation;
    }

    public static Settings deserialize(File f){
        try {
            FileInputStream fStream = new FileInputStream(f);
            ObjectInputStream stream = new ObjectInputStream(fStream);
            Settings s = (Settings)stream.readObject();
            return s;
        }catch(IOException e){
            System.err.println("Ran into IO Error when trying to read settings");
            e.printStackTrace();
            return null;
        }catch(ClassNotFoundException c){
            System.err.println("Ran into error trying to deserialize class");
            c.printStackTrace();
            return null;
        }
    }

    public static void serialize(Settings s){
        try{
            File f = new File(s.getSerializationLocation());
            FileOutputStream fStream = new FileOutputStream(f);
            ObjectOutputStream stream = new ObjectOutputStream(fStream);
            stream.writeObject(s);
        }catch(IOException e){
            System.err.println("Encountered an IO Error when trying to serialize settings");
        }
    }


}
