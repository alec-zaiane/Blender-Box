package ApplicationMgmt;

import java.io.File;
import java.io.IOException;

/**
 * represents a blender build
 */
public class Build {
    //Object to store each usable build of blender, needs to verify build will work (maybe via hash?)
    boolean usable;
    File location;
    private long Time;

    /**
     * Creates a new build object from the executable's location
     * @param location location of blender.exe for this build
     */
    public Build(File location) {
        this.location = location;
        if (this.location.getName().equals("blender.exe") && this.location.isFile())
            usable = true; //confirm the location is a blender file
        try {
            this.Time = location.lastModified();
        } catch (SecurityException e){
            //TODO implement logging
            System.out.println("Security Exception, time not readable");
            e.printStackTrace();
        }
    }

    public void run() {
        try { Runtime.getRuntime().exec(location.getAbsolutePath());
        }catch (IOException e) { e.printStackTrace();}
    }
}
