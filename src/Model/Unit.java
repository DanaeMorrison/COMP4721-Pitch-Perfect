package Model;

/**
 * Represents a unit with an ID, name, information, lessons, and drills.
 * 
 * @author Danae Morrison
 * @version 1.1
 */
public class Unit {
    private int unitID;
    private String unitName;
    private String unitInfo;
    private Lesson[] lessonList;
    private Drill[] drillList;

    /**
     * Constructs a new Unit.
     * 
     * @param unitID     the ID of the unit.
     * @param unitName   the name of the unit.
     * @param unitInfo   the information about the unit.
     * @param lessonList the list of lessons in the unit.
     * @param drillList  the list of drills in the unit.
     */
    public Unit(int unitID, String unitName, String unitInfo, Lesson[] lessonList, Drill[] drillList) {
        this.unitID = unitID;
        this.lessonList = lessonList;
        this.drillList = drillList;
        this.unitInfo = unitInfo;
        this.unitName = unitName;
    }

    /**
     * Gets the name of the unit.
     * 
     * @return the name of the unit.
     */
    public String getName() {
        return unitName;
    }

    /**
     * Gets the information about the unit.
     * 
     * @return the information about the unit.
     */
    public String getInfo() {
        return unitInfo;
    }

    /**
     * Gets the list of lessons in the unit.
     * 
     * @return the list of lessons.
     */
    public Lesson[] getLessons() {
        return lessonList;
    }

    /**
     * Gets the list of drills in the unit.
     * 
     * @return the list of drills.
     */
    public Drill[] getDrills() {
        return drillList;
    }

    /**
     * Gets the ID of the unit.
     * 
     * @return the ID of the unit.
     */
    public int getUnitID() {
        return unitID;
    }

    /**
     * Gets the number of lessons in the unit.
     * 
     * @return the number of lessons.
     */
    public int getNumLessons() {
        return lessonList.length;
    }

    /**
     * Gets the number of drills in the unit.
     * 
     * @return the number of drills.
     */
    public int getNumDrills() {
        return drillList.length;
    }
}
