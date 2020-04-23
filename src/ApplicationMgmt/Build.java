package ApplicationMgmt;

import java.io.File;

public class Build {
    //Object to store each usable build of blender, needs to verify build will work (maybe via hash?)
    boolean usable;
    File location;

    /**
     * Creates a new build object from the executable's location
     * @param location location of blender.exe for this build
     */
    public Build(File location){
        this.location = location;
    }
}
