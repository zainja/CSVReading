public class MenuObject implements Comparable<MenuObject>{
    private int ID;
    private String MenuName;
    private int ParentID;
    private boolean isHidden;
    private String LinkURL;
    public static int classAncestor = 0;
    int currentAncestor;

    public MenuObject(int ID, String menuName, int parentID, boolean isHidden, String linkURL) {
        this.ID = ID;
        MenuName = menuName;
        ParentID = parentID;
        this.isHidden = isHidden;
        LinkURL = linkURL;
        currentAncestor = classAncestor;
        classAncestor ++;
    }

    public int getId() {
        return ID;
    }

    public void setID(int newID) {
        this.ID = newID;
    }

    public int getParentID() {
        return ParentID;
    }

    public void setMenuName(String newMenuName) {
        this.MenuName = newMenuName;
    }
    void setParentID(int newParentID){
        this.ParentID = newParentID;
    }
    public void setisHidden(boolean newisHidden) {
        this.isHidden = newisHidden;
    }
    public void setLinkURL(String newLinkURL) {
        this.LinkURL = newLinkURL;
    }
    public int getCurrentAncestor()
    {
        return this.currentAncestor;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " Parent ID: " + this.getParentID() + "Name: " + this.MenuName;
    }

    @Override
    public int compareTo(MenuObject object) {
        return Integer.compare(this.getParentID(), object.getParentID());
    }
}
