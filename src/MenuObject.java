import java.util.ArrayList;
import java.util.Collections;

public class MenuObject implements Comparable<MenuObject>{
    private int ID;
    private String menuName;
    private int parentID;
    private String linkURL;
    private int depth;
    public MenuObject(int ID, String menuName, int parentID, String linkURL) {
        this.ID = ID;
        this.menuName = menuName;
        this.parentID = parentID;
        this.linkURL = linkURL;
        for(char letter: linkURL.toCharArray())
        {
            if(letter == '/')
            {
                this.depth ++;
            }
        }
    }

    public int getId() {
        return ID;
    }

    public String getMenuName()
    {
        return this.menuName;
    }
    public int getParentID() {
        return parentID;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " Parent ID: " + this.getParentID() + " Name: " + this.getMenuName();
    }
    public String toDirectoryStyle()
    {
        String dots = "";
        for(int i = 0; i < this.depth; i++ )
        {
            dots += ".";
            if(i > 1)
            {
                dots += "..";
            }
        }
        return dots + " " + this.menuName;
    }

    @Override
    public int compareTo(MenuObject object) {
        return this.getMenuName().compareTo(object.menuName);
    }

}
