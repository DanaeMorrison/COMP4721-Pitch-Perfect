package Model;

/**
 * @author Danae Morrison
 * @version 1.1
 **/

public class Unit {
    private int unitID;
    private String courseInfo;
    private Lesson[] lessonList;
    private Drill[] drillList;

    public Unit(int unitID, String courseInfo, Lesson[] lessonList, Drill[] drillList) {
        this.unitID = unitID;
        this.lessonList = lessonList;
        this.drillList = drillList;
        this.courseInfo = courseInfo;
    }

    public String getInfo() {
        return courseInfo;
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
}
