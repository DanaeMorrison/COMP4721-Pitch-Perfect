# Team-1

- Adil Alizmhanov
- Danae Morrison (most commits under happyldg)
- Duncan MacIsaac
- Jacob Richard
- Tan Karageldi

## Pitch Perfect: Sight Reading Practice App

**Pitch Perfect** is an interactive application designed to help users improve their sight-reading skills in music. Whether you're a beginner learning to identify single notes or an advanced musician practicing chords, Pitch Perfect provides a structured, engaging, and user-friendly experience.

## Key Features

- **Lessons with Single Note Input**: Practice identifying and playing single notes displayed on a staff using a MIDI keyboard. Get immediate feedback on accuracy.
- **Lessons with Chord Input**: Challenge yourself with chord identification exercises and receive detailed feedback on each chord played.
- **Real-Time Feedback**: Immediate visual feedback using colour-coded indicators and note-specific guidance to help users understand their performance.
- **Unit-Based Progression**: Lessons are organized into units, allowing users to advance their skills step by step.
- **Customizable Learning Path** (Planned): Users will be able to track progress, revisit past lessons, and customize their practice sessions.

## How It Works

1. **Select a Unit**: Choose from a variety of units tailored to different skill levels and musical concepts.
2. **Practice a Lesson**: Follow on-screen prompts to play single notes or chords on a MIDI keyboard. (Note: the program takes into consideration octaves so you may need to change the octave on the MIDI keyboard as you complete lessons.)
3. **Receive Feedback**: View instant feedback indicating correctness and areas for improvement.
4. **Get Drill Results**: View your drill results at the end of a drill (currently visible in the terminal as opposed to in the GUI window)
6. **Track Your Progress** (Planned): Review your drill results and export progress summaries as PDFs for long-term tracking.

## Technologies Used

- **Programming Language**: Java
- **Framework**: JavaFX for UI development
- **Hardware**: MIDI keyboard for user interaction

## Current Development Status

This project is currently in the **high-fidelity prototype** stage. Two core functionalities are implemented:

1. Lessons: Guides the user through a series of flashcards to learn new concepts in sight reading. This includes topics such as:
   - Single note identification in both bass and treble clef,
   - Triads and inversions
   - 7th chords.
   - Sharp accidentals
2. Drills: A collection of flashcards meant to test the user. These drills are meant to simulate playing at the piano so feedback is only offered after in the form of a review.

Future updates will include:

- Gamification elements, such as progress tracking and badges.
- Enhanced lesson navigation menus as well as a tutorial mode.

Current encountered problems:
- Getting text to display the score of a drill consistently does not seem possible with our understanding of JavaFX. To further the app, the team might have to consider switching to another framework for UI development.

## Getting Started

To run Pitch Perfect:

1. Clone the repository:

   ```bash

   git clone [https://github.com/COMP4721-F24/Team-1]
   ```

2. Open the project in your Java IDE (e.g., IntelliJ, Eclipse).
3. Connect your MIDI keyboard.
4. Run the `main` class in the `\Code` folder to launch the application.

When doing drills:


## Contribution Guidelines

We welcome contributions to improve Pitch Perfect! Here's how you can get started:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Submit a pull request with a detailed description of your changes.
