import ApplicationMgmt.ApplicationLoader;
import ApplicationMgmt.Build;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Blender_Box_Main {

    public static void main(String[] args) {
        Scanner wordScan = new Scanner(System.in);
        Scanner numScan = new Scanner(System.in);
        ArrayList<Build> builds = new ArrayList<Build>();
        try {
            builds = ApplicationLoader.loadBuildsFromDir(new File("F:\\Blender versions"));
            System.out.println(builds.size());
        }
        catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("IOException");
            e.printStackTrace();
        }
        System.out.println("what index would you like to run?");
        int idx = numScan.nextInt();
        builds.get(idx).run();

    }
}
