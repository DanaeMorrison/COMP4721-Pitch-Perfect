package Model;
/**
 * @author Danae Morrison
 * @version 1.0
 **/

public class Unit {
    private int unitID;
    private Lesson[] lessonList;
    private String courseInfo;

    public Unit(int unitID, Lesson[] lessonList, String courseInfo) {
        this.unitID = unitID;
        this.lessonList = lessonList;
        this.courseInfo = courseInfo;
    }

    public String getInfo() {
        return courseInfo;
    }

    public Lesson[] getLessons() {
        return lessonList;
    }

    public int getUnitID() {
        return unitID;
    }
}