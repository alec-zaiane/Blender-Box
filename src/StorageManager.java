import ProjectMgmt.Blend;

import java.io.FileWriter;
import java.io.IOException;

public class StorageManager {

    public static void saveBlend(Blend toSave){
        try {
            FileWriter writer = new FileWriter("data/Blends.txt",true);
            writer.write(toSave.getLocation().getAbsolutePath()+"\n");
            writer.close();
        }catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
