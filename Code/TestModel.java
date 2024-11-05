/**
 * @author Danae Morrison
 * @version 1.0
 **/

public class TestModel {
    public static void main(String[] args) {
        Model model = new Model();
        model.initializeModel();

        //As though user selected Unit 1
        int currentUnitChoiceID = 1;
        Unit currentUnit = model.getUnit(currentUnitChoiceID-1);
        System.out.println("User selected Unit 1.");
        System.out.println("Course info: " + currentUnit.getInfo());

        //As though user selected Lesson 1
        int currentLessonChoiceID = 1;
        Lesson currentLesson = currentUnit.getLessons()[currentLessonChoiceID-1];
        System.out.println("User selected Lesson 1.");
        System.out.println("Lesson info: " + currentLesson.getInfo());

    }
    
}