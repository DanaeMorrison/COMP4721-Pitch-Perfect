// Source code is decompiled from a .class file using FernFlower decompiler.
package Model;

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
      return this.courseInfo;
   }

   public Lesson[] getLessons() {
      return this.lessonList;
   }

   public Drill[] getDrills() {
      return this.drillList;
   }

   public int getUnitID() {
      return this.unitID;
   }
}
