//package com.mkyong.csv;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainMenu {

    public static void main(String[] args) {

        String csvFile = "src/Navigation.csv";
        String csvSplitBy = ";";
        HashMap<Integer,Object> menuObjects = new HashMap<Integer, Object>();
        HashMap<Integer,ArrayList<MenuObject>> parentMap = new HashMap<>();

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
                    if (!isHidden) {

                        MenuObject menuObject = new MenuObject(id, menuName, parentID, linkURL);
                        menuObjects.put(menuObject.getId(), menuObject);
                        if(parentMap.containsKey(menuObject.getParentID()))
                        {
                            parentMap.get(menuObject.getParentID()).add(menuObject);
                            Collections.sort(parentMap.get(menuObject.getParentID()));
                        }else
                        {
                            parentMap.put(menuObject.getParentID(),
                                    new ArrayList<>(Collections.singletonList(menuObject)));
                        }
                    }
                }
                line ++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<MenuObject> root = parentMap.get(0);
        for(MenuObject parent: root)
        {
            printChildren(parent, parentMap);
        }

    }
    public static void printChildren(MenuObject parent, HashMap<Integer, ArrayList<MenuObject>> hashMap)
    {
        System.out.println(parent.toDirectoryStyle());
        if(hashMap.containsKey(parent.getId()))
        {
            for (MenuObject children: hashMap.get(parent.getId()))
            {
                printChildren(children, hashMap);
            }
        }
    }
}