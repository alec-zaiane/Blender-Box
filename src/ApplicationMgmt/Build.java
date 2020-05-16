package ApplicationMgmt;

import ProjectMgmt.Blend;

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
     *
     * @param location location of blender.exe for this build
     */
    public Build(File location) {
        this.location = location;
        verify();
        try {
            this.Time = location.lastModified();
        } catch (SecurityException e) {
            //TODO implement logging
            System.out.println("Security Exception, time not readable");
            e.printStackTrace();
        }
    }

    /**
     * runs the build from exe location
     */
    public void run() throws IOException {
        try {
            Runtime.getRuntime().exec(location.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(Blend file) throws IOException {
        try {
            Runtime.getRuntime().exec(location.getAbsolutePath()+" \""+file.getLocation().getAbsolutePath()+"\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * verify that this build will work
     *
     * @return whether or not build exists and works
     */
    public boolean verify() {
        try {
            if (this.location.getName().equals("blender.exe") && this.location.isFile()) {
                usable = true;
                return true;
            } else {
                usable = false;
                return false;
            }
        } catch (SecurityException e) {
            usable = false;
            return false;
        }
    }
}
