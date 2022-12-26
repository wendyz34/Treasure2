
/**
 * The Terrain class is designed to represent the zones between the towns in the Treasure Hunter game.
 * This code has been adapted from Ivan Turner's original program -- thank you Mr. Turner!
 */
public class Terrain
{
    //instance variables
    private String terrainName;
    private String neededItem;
    //color animation
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String GREY = "\u001B[90";
    public static final String WHITE = "\u001B[37m";
    public static final String GREEN_BOLD = "\033[1;32m";

    /**
     * Sets the class member variables
     * @param name The name of the zone.
     * @param item The item needed in order to cross the zone.
     */
    public Terrain(String name, String item)
    {
        terrainName = name;
        neededItem = item;
    }

    //Accessors + animation
    public String getTerrainName()
    {
        String color = "";
        if (terrainName== "Mountains") {
            color += GREY;
        } else if (terrainName == "Ocean") {
            color += BLUE;
        } else if (terrainName == "Plains") {
            color += GREEN;
        } else if (terrainName == "Desert") {
            color += YELLOW;
        }else if (terrainName == "Jungle"){
            color += GREEN_BOLD;
        } else if (terrainName== "Home") {
            color += RED;
        } else {
            color += WHITE;
        }
        return color + terrainName;
    }

    public String getNeededItem()
    {
        return neededItem;
    }

    /**
     * Guards against a hunter crossing the zone without the proper item.
     * Searches the hunter's inventory for the proper item and determines whether or not the hunter can cross.
     *
     * @param hunter The Hunter object trying to cross the terrain.
     * @returns  true if the Hunter has the proper item.
     */
    public boolean canCrossTerrain(Hunter hunter)
    {
        if(hunter.hasItem(neededItem, hunter.getKit()))
        {
            return true;
        }
        return false;
    }


    //toString
    public String toString()
    {
        return terrainName + " needs a(n) " + neededItem + " to cross.";
    }
}
