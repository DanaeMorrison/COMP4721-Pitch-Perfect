package Model;
/**
 * @author Danae Morrison
 * @version 1.0
 **/

 import java.util.ArrayList;

 public class Model {
    private ArrayList<Unit> units;

    public Model()
    {
        units = new ArrayList<>();
        //initModel();
        //initModel();
    }
    public Unit getUnit(int unitID) {
        return units.get(unitID);
    }
    public ArrayList<Unit> getUnits()
    {
        return units;
    }

    public void initModel()
    {
        Flashcard[] flashcardList = new Flashcard[3];
        Lesson[] lessonList = new Lesson[1];
        Drill[] drillList = new Drill[0];
        flashcardList[0] = new Flashcard(0, new int[]{0}, 'T', 'R');
        flashcardList[1] = new Flashcard(0, new int[]{1}, 'T', 'R');
        flashcardList[2] = new Flashcard(0, new int[]{2}, 'T', 'R');
        lessonList[0] = new Lesson(0, "Lesson 1", "LEEESSOSONNNN", flashcardList);
        Unit unit0 = new Unit(0, "Unit 1", "Im a unit, yipeeeee", lessonList, drillList);
        units.add(unit0);
    }
 }
