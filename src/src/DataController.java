package src;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DataController {

    List<File> fileList = new LinkedList<>();
    String homeFolder;
    Settings settings;

    public DataController(Settings settings){
        this.settings = settings;
        this.homeFolder = settings.getHomeFolderLocation();
    }

    public void addFile(String fileName){
        File f = new File(fileName);
        if(f.exists()){
            fileList.add(f);
        }else{
            System.err.println("Tried to add File but it does not exist");
        }
    }

    public void switchFileOrder(int from, int to){
        if(from == to || from < 0 || from >= fileList.size() + 1){
            return;
        }

        File f = fileList.remove(from);
        fileList.add(to, f);
    }

    public void removeFile(int index){
        fileList.remove(index);
    }

    public void clearFileList(){
        fileList = new LinkedList<>();
    }

    public void merge(String newFileName){
        try {
            Merger.merge(fileList, newFileName);
        }catch(IOException e){
            System.err.println("Encountered an IO Exception when trying to merge files");
            e.printStackTrace();
        }
    }

}
