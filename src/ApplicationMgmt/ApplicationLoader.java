package ApplicationMgmt;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;


public class ApplicationLoader {
    //Static class to manage usable builds

    /**
     * Recursively searches subdirectories for blender builds
     *
     * @param dir directory to start search from
     * @return list of usable blender builds in directory
     * @throws FileNotFoundException when dir is not found, not readable, or not a directory
     */
    public static ArrayList<Build> loadBuildsFromDir(File dir) throws FileNotFoundException {
        //confirm the input is a directory, readable, and exists
        if (!dir.exists()) throw new FileNotFoundException("File \"" + dir.getAbsolutePath() + "\" does not exist");
        if (!dir.canRead()) throw new FileNotFoundException("File \"" + dir.getAbsolutePath() + "\" is not readable");
        if (!dir.isDirectory())
            throw new FileNotFoundException("File \"" + dir.getAbsolutePath() + "\" is not a directory");
        ArrayList<Build> workingBuilds = new ArrayList<Build>(); //Create new arrayList to contain the working builds
        //test for "blender.exe" in the directory, and for other subdirectories
        //ignore directories called "datafiles","python","scripts"
        File[] fileList = dir.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {
                String name = fileList[i].getName();
                if (name != "scripts" && name != "python" && name != "files"){
                    workingBuilds.addAll(loadBuildsFromDir(fileList[i]));
                }
            }else if(fileList[i].getName().toLowerCase().equals("blender.exe")){
                System.out.println("blender.exe at: "+fileList[i].getAbsolutePath());
                workingBuilds.add(new Build(fileList[i]));
            }
        }

        return workingBuilds;
    }
}
