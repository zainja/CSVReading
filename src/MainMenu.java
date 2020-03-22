//package com.mkyong.csv;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainMenu {

    public static void main(String[] args) {

        String csvFile = "src/Navigation.csv";
        String csvSplitBy = ";";
        ArrayList<MenuObject> menuObjects = new ArrayList<>();

        // read files from all opsys

        try {
            File iFile = new File(csvFile);
            Scanner iScan = new Scanner(iFile);
            int line = 0;
            while (iScan.hasNext()) {
                String nextLine = iScan.nextLine();
                if(line > 0)
                {
                    String[] arr = nextLine.split(csvSplitBy);
                    int id = Integer.parseInt(arr[0]);
                    String menuName = arr[1];
                    int parentID = (arr[2].equals("NULL"))? 0:Integer.parseInt(arr[2]);
                    boolean isHidden = arr[3].equals("True");
                    String linkURL = arr[4];
                    MenuObject menuObject = new MenuObject(id, menuName, parentID, isHidden, linkURL);
                    menuObjects.add(menuObject);
                }
                line ++;


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(menuObjects);
        for (MenuObject menu:
             menuObjects) {
            System.out.println(menu.toString());
        }

    }
}