package Controller;

import Model.Flashcard;
import View.*;

public class DrillViewer {
    private UI ui;
    private NoteMapping noteCoords;
    private ImageComponent clef;
    private ImageComponent leftHand;
    private ImageComponent rightHand;
    private ImageComponent[] notes;
    private TextComponent timer;
    private DrillTimer drillTimer; // Private timer class for this DrillViewer

    public DrillViewer(UI ui) {
        noteCoords = new NoteMapping();
        this.ui = ui;
    }

    public void initializeDrill() {
        // Setting up the flashcard
        int[] clefChords = { 170, 1190, 0, 800 };
        int clefID = ui.createViewComponent("image");
        ui.getViewComponent(clefID).updateXY(clefChords);
        clef = (ImageComponent) ui.getViewComponent(clefID);

        int[] leftHandChords = { 155, 355, 600, 800 };
        int leftHandID = ui.createViewComponent("image");
        ui.getViewComponent(leftHandID).updateXY(leftHandChords);
        leftHand = (ImageComponent) ui.getViewComponent(leftHandID);

        int[] rightHandChords = { 995, 1195, 600, 800 };
        int rightHandID = ui.createViewComponent("image");
        ui.getViewComponent(rightHandID).updateXY(rightHandChords);
        rightHand = (ImageComponent) ui.getViewComponent(rightHandID);

        int[] timerChords = { 400, 800, 100, 150 };
        int timerID = ui.createViewComponent("text"); // Timer text component
        ui.getViewComponent(timerID).updateXY(timerChords);
        timer = (TextComponent) ui.getViewComponent(timerID);

        notes = new ImageComponent[4];
        for (int i = 0; i < notes.length; i++) {
            notes[i] = (ImageComponent) ui.getViewComponent(ui.createViewComponent("image"));
            notes[i].setHidden(true);
        }
    }

    public void loadFlashcard(Flashcard flashcard) {
        int[] clefChords = { 170, 1190, 0, 800 };
        clef.setXY(clefChords);
        
        int[] leftHandChords = { 155, 355, 600, 800 };
        leftHand.setXY(leftHandChords);
        
        int[] rightHandChords = { 995, 1195, 600, 800 };
        rightHand.setXY(rightHandChords);
        

        for (int i = 0; i < notes.length; i++) {
            notes[i].setHidden(true);
        }

        for (int i = 0; i < flashcard.getAnswer().length; i++) {
            int[] noteCoordsArray = noteCoords.getCoordinates(flashcard.getAnswer()[i], flashcard.getClef());
            //notes[i].updateXY(noteCoordsArray);
            notes[i].setXY(noteCoordsArray);
            //check to see if the note needs a ledger line
            //we'll need some class/method that does this check against maybe a hashmap
            //with values that need a ledger line
            
            String path = noteCoords.getImagePath(flashcard.getAnswer()[i], flashcard.getClef());
            notes[i].changeImage(path);
            
            notes[i].setHidden(false);
        }
        if (flashcard.getClef() == 'T') {
            clef.changeImage("/Assets/trebleStaff.png");
        } else if (flashcard.getClef() == 'B') {
            clef.changeImage("/Assets/bassStaff.png");
        }
        clef.setHidden(false);

        if (flashcard.getHand() == 'L') {
            leftHand.changeImage("/Assets/leftHandFilled.png");
            rightHand.changeImage("/Assets/rightHandBlank.png");
        } else if (flashcard.getHand() == 'R') {
            leftHand.changeImage("/Assets/leftHandBlank.png");
            rightHand.changeImage("/Assets/rightHandFilled.png");
        }
        leftHand.setHidden(false);
        rightHand.setHidden(false);
    }

    public void close() {
        clef.setHidden(true);
        leftHand.setHidden(true);
        rightHand.setHidden(true);

        for (ImageComponent note : notes) {
            note.setHidden(true);
        }
    }

    public void startTimer(int startTime) {
        if (drillTimer != null) {
            drillTimer.stop();
        }

        drillTimer = new DrillTimer(startTime);
        drillTimer.start();
    }

    public void stopTimer() {
        if (drillTimer != null) {
            drillTimer.stop();
        }
        closeTimer();
    }

    private void loadTimer(int time) {
        timer.setText(String.valueOf(time));
        timer.setHidden(false);
    }

    private void closeTimer() {
        timer.setHidden(true);
    }

    // Inner DrillTimer class
    private class DrillTimer extends Thread {
        private int time;
        private volatile boolean running = true;

        public DrillTimer(int startTime) {
            this.time = startTime;
        }

        @Override
        public void run() {
            while (time > 0 && running) {
                loadTimer(time); // Update UI with remaining time
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
                time--;
            }

            if (running) {
                loadTimer(0); // Show "0" when timer ends
            }
        }

        public void stopTimer() {
            running = false;
            this.interrupt();
        }
    }
}
