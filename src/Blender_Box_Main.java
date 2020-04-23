import ApplicationMgmt.ApplicationLoader;
import ApplicationMgmt.Build;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Blender_Box_Main {

    public static void main(String[] args) {
        try {
            ArrayList<Build> builds = ApplicationLoader.loadBuildsFromDir(new File("F:\\Blender versions"));
            System.out.println(builds.size());
        }
        catch (FileNotFoundException e){
            System.out.println("ERROR"+e);
        }
    }
}
