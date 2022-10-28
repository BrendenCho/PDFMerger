package src;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Merger {

    public static void merge(List<File> fileList, String outputLocation) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        merger.setDestinationFileName(outputLocation);
        for(File file:fileList){
            merger.addSource(file);
        }
        merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }

}
