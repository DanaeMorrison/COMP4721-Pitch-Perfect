package Model;
/**
 * @author Danae Morrison
 * @version 1.0
 **/

 import java.util.ArrayList;

 public class Model {
    private ArrayList<Unit> units;
    private ArrayList<Lesson> lessons;

    public Model()
    {
        units = new ArrayList<>();
        lessons = new ArrayList<>();
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

    public Lesson getLesson(int lessonID) {
        return lessons.get(lessonID);
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }


    public void initModel()
    {
        Flashcard[] flashcardList = new Flashcard[3];
        Lesson[] lessonList = new Lesson[1];
        Drill[] drillList = new Drill[0];
        //flashcardList[0] = new Flashcard(0, new int[]{0}, 'T', 'R');
        //flashcardList[1] = new Flashcard(0, new int[]{1}, 'T', 'R');
        //flashcardList[2] = new Flashcard(0, new int[]{2}, 'T', 'R');

        flashcardList[0] = new Flashcard(0, new int[]{60}, new int[]{0},'T', 'R');
        flashcardList[1] = new Flashcard(0, new int[]{64}, new int[]{4},'T', 'R');
        flashcardList[2] = new Flashcard(0, new int[]{67}, new int[]{7},'T', 'R');
        lessonList[0] = new Lesson(0, "Lesson 1", "LEEESSOSONNNN", flashcardList);
        lessons.add(lessonList[0]);
        Unit unit0 = new Unit(0, "Unit 1", "Im a unit, yipeeeee", lessonList, drillList);
        units.add(unit0);
    }
 }
