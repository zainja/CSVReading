public class MenuObject implements Comparable<MenuObject>{
    private int ID;
    private String menuName;
    private int parentID;
    private String linkURL;

    public MenuObject(int ID, String menuName, int parentID, String linkURL) {
        this.ID = ID;
        this.menuName = menuName;
        this.parentID = parentID;
        this.linkURL = linkURL;
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

    public String toString() {
        return this.menuName;
    }

    public String toString(int depth) {
        String dots = "";
        if(depth == 0)
        {
            return ". " + this.menuName;
        }
        for(int i = 0; i < depth; i++ )
        {
            dots += "..";

        }
        return dots + " " + this.menuName;
    }

    @Override
    public int compareTo(MenuObject object) {
        return this.getMenuName().compareTo(object.menuName);
    }

}
