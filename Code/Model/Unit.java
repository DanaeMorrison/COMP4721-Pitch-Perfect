package Model;

/**
 * @author Danae Morrison
 * @version 1.1
 **/

public class Unit {
    private int unitID;
    private String unitName;
    private String unitInfo;
    private Lesson[] lessonList;
    private Drill[] drillList;

    public Unit(int unitID, String unitName, String unitInfo, Lesson[] lessonList, Drill[] drillList) {
        this.unitID = unitID;
        this.lessonList = lessonList;
        this.drillList = drillList;
        this.unitInfo = unitInfo;
        this.unitName = unitName;
    }

    public String getName()
    {
        return unitName;
    }

    public String getInfo() {
        return unitInfo;
    }

    public Lesson[] getLessons() {
        return lessonList;
    }

    public Drill[] getDrills() {
        return drillList;
    }

    public int getUnitID() {
        return unitID;
    }
        
    public int getNumLessons()
    {
        return lessonList.length;
    }
    
    public int getNumDrills()
    {
        return drillList.length;
    }
}
