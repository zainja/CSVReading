import java.util.ArrayList;
import java.util.Collections;

public class MenuObject implements Comparable<MenuObject>{
    private int ID;
    private String menuName;
    private int parentID;
    private boolean isHidden;
    private String linkURL;
    private int depth;
    public MenuObject(int ID, String menuName, int parentID, boolean isHidden, String linkURL) {
        this.ID = ID;
        this.menuName = menuName;
        this.parentID = parentID;
        this.isHidden = isHidden;
        this.linkURL = linkURL;
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

    public String getLinkURL() {
        return linkURL;
    }
    @Override
    public String toString() {
        return "ID: " + this.getId() + " Parent ID: " + this.getParentID() + " Name: " + this.getMenuName();
    }

    @Override
    public int compareTo(MenuObject object) {
        return this.getMenuName().compareTo(object.menuName);
    }

}
