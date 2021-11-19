/** 
 Write a JavaFX GUI program that meets the following requirements
 and adheres to the layout included sketch.
 
 + Must set the title of the window to be "TextViewer App - YOURNAME", where YOURNAME 
   is replaced with your first and last name.
 + Must include some non-editable text stating the last action the user 
   requested.
     - File loaded & the name of the file
     - File loading cancelled
     - Undo requested
     - Redo requested
 + Must use a File Chooser (https://openjfx.io/javadoc/11/javafx.graphics/javafx/stage/FileChooser.html) 
   that allows you select a file from the local filesystem.
     - Make sure to check the returned File for a valid file
     - A button should be used that, when clicked, creates and shows
       the FileChooser. Make sure to attach it to the main Stage of the
       application.
 + Must display the contents of the chosen file in an editable TextArea
     - When the file is valid, the contents of the TextArea should be 
       replaced with the contents of the valid file.
     - When the file is invalid, no change to the contents of the TextArea 
       should occur
     - The TextArea should properly "word wrap" the text when the window
       is resized to a narrower width than a line of text (see API)
 + Must include a button to undo recent changes to the TextArea
     - Fortunately, the parent class of TextArea manages the undo behavior
       https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextInputControl.html#undo--
 + Must include a button to redo recent changes to the TextArea
     - Fortunately, the parent class of TextArea manages the undo behavior
       https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextInputControl.html#redo--

  + You must implement your event handling at least two of the three ways we taught 
     - named inner class
     - anonymous inner class
     - lambda expression
     - For example, at least one handler as an anonymous inner class and at least 
       one handler as a lambda expression. 
  
  + You must use at least two different types of layouts.

  + YOU SHOULD ONLY SUBMIT A SINGLE JAVA FILE. 
    ENSURE THAT ANY OTHER CLASSES YOU INCLUDE EXIST WITHIN THE SAME FILE.

  + IF YOUR SUBMITTED CODE DOES NOT COMPILE, YOU WILL RECEIVE A ZERO. 
    SAVE, BACKUP, AND TEST OFTEN!

 The following is an example layout for your UI, but as long as 
 you meet the requirements stated above the layout is flexible:
 */