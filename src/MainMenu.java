import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainMenu {
    // depth of the tree of menus
    public static int depth;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter file name or e to exit: ");
        String csvFile = scanner.nextLine();
        if (csvFile.equals("e"))
        {
            System.exit(0);
        }
        String csvSplitBy = ";";
        HashMap<Integer, ArrayList<MenuObject>> parentMap = new HashMap<>();

        try {
            File iFile = new File(csvFile);
            Scanner iScan = new Scanner(iFile);
            int line = 0;
            while (iScan.hasNext()) {
                String nextLine = iScan.nextLine();
                if (line > 0) {
                    String[] arr = nextLine.split(csvSplitBy);
                    int id = Integer.parseInt(arr[0]);
                    String menuName = arr[1];
                    int parentID = (arr[2].equals("NULL")) ? 0 : Integer.parseInt(arr[2]);
                    boolean isHidden = arr[3].equals("True");
                    String linkURL = arr[4];
                    if (!isHidden) {

                        MenuObject menuObject = new MenuObject(id, menuName, parentID, linkURL);
                        if (parentMap.containsKey(menuObject.getParentID())) {
                            parentMap.get(menuObject.getParentID()).add(menuObject);
                            // sort alphabetically
                            Collections.sort(parentMap.get(menuObject.getParentID()));
                        } else {
                            parentMap.put(menuObject.getParentID(),
                                    new ArrayList<>(Collections.singletonList(menuObject)));
                        }
                    }
                }
                line++;

            }
            ArrayList<MenuObject> root = parentMap.get(0);
            for (MenuObject parent : root) {
                depth = 0;
                printChildren(parent, parentMap);
            }

        } catch (FileNotFoundException e) {
            System.out.println("print a correct file name");
        }
        finally {
            main(null);
        }


    }

    public static void printChildren(MenuObject parent, HashMap<Integer, ArrayList<MenuObject>> hashMap) {
        System.out.println(parent.toString(depth));
        if (hashMap.containsKey(parent.getId())) {
            int parent_depth = depth;
            depth ++;
            for (MenuObject children : hashMap.get(parent.getId())) {
                printChildren(children, hashMap);
            }
            depth = parent_depth;
        }
    }
}