package ApplicationMgmt;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;

/**
 * static class for application management
 */
public class ApplicationLoader {


    /**
     * Recursively searches subdirectories for blender builds
     * @param dir directory to start search from
     * @return list of usable blender builds in directory
     * @throws FileNotFoundException when dir is not found, not readable, or not a directory
     */
    public static ArrayList<Build> loadBuildsFromDir(File dir) throws FileNotFoundException {
        //confirm the input is a directory, readable, and exists
        if (!dir.exists()) throw new FileNotFoundException("File \"" + dir.getAbsolutePath() + "\" does not exist");
        if (!dir.canRead()) throw new FileNotFoundException("File \"" + dir.getAbsolutePath() + "\" is not readable");
        if (!dir.isDirectory()) throw new FileNotFoundException("File \"" + dir.getAbsolutePath() + "\" is not a directory");
        ArrayList<Build> workingBuilds = new ArrayList<>(); //Create new arrayList to contain the working builds
        //test for "blender.exe" in the directory, and for other subdirectories
        //ignore directories called "datafiles","python","scripts"
        File[] fileList = dir.listFiles();
        assert fileList != null;
        for (File file : fileList) {
            if (file.isDirectory()) {
                String name = file.getName();
                if (!name.equals("scripts") && !name.equals("python") && !name.equals("files")) {
                    workingBuilds.addAll(loadBuildsFromDir(file));
                }
            } else if (file.getName().toLowerCase().equals("blender.exe")) {
                System.out.println("blender located at: " + file.getAbsolutePath());
                //confirm the build will work, then add it to the list
                Build buildTemp = new Build(file);
                if (buildTemp.usable) workingBuilds.add(buildTemp);
            }
        }
        return workingBuilds;
    }
}
