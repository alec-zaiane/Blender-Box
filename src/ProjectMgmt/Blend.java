package ProjectMgmt;

import java.io.File;

public class Blend {
    File location;

    /**
     * instantiate new Blend object with a file location
     * @param location File object with location of .blend
     */
    public Blend (File location){
        this.location = location;
    }

    /**
     * instantiate new Blend object with a string file location
     * @param location String of location of .blend
     */
    public Blend (String location){
        this.location = new File(location);
    }

    public File getLocation() {
        return location;
    }
}
