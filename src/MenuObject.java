import java.util.ArrayList;
import java.util.Collections;

public class MenuObject implements Comparable<MenuObject>{
    private int ID;
    private String menuName;
    private int parentID;
    private boolean isHidden;
    private String linkURL;

    public MenuObject(int ID, String menuName, int parentID, boolean isHidden, String linkURL) {
        this.ID = ID;
        this.menuName = menuName;
        parentID = parentID;
        this.isHidden = isHidden;
        linkURL = linkURL;
    }

    public int getId() {
        return ID;
    }
    public boolean getHidden()
    {
        return this.isHidden;
    }
    public String getMenuName()
    {
        return this.menuName;
    }
    public int getParentID() {
        return parentID;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " Parent ID: " + this.getParentID() + " Name: " + this.getMenuName();
    }

    @Override
    public int compareTo(MenuObject object) {
        return Integer.compare(this.getParentID(), object.getParentID());
    }

}
