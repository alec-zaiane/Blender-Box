import ApplicationMgmt.ApplicationLoader;
import ApplicationMgmt.Build;
import ProjectMgmt.Blend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Blender_Box_Main {

    public static void main(String[] args) {
        Scanner wordScan = new Scanner(System.in);
        Scanner numScan = new Scanner(System.in);
        ArrayList<Build> builds = new ArrayList<>();
        try {
            builds = ApplicationLoader.loadBuildsFromDir(new File("F:\\Blender versions"));
            System.out.println(builds.size());
        }
        catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        }
        System.out.println("what index would you like to run?");
        int idx = numScan.nextInt();
        try {
            builds.get(idx).run(new Blend(new File("F:\\Blender\\Weekly\\Week 92\\Week 92.blend")));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
