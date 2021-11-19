import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipleStageDemo extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create A scene and place A button in the scene
    Button button = new Button("Kick");
    button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("*thump*");
            }
        });
    Scene scene = new Scene(button, 200, 250);
    primaryStage.setTitle("MyJavaFX"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the primary stage

    Stage secondaryStage = new Stage(); // Create A new stage
    secondaryStage.setTitle("Second Stage"); // Set the stage title
    // Set A scene with A button in the stage
    button = new Button("Snare");
    button.setOnAction((event) -> System.out.println("*crack*"));
    secondaryStage.setScene(new Scene(button, 100, 100));        
    secondaryStage.show(); // Display the secondary stage
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  // public static void main(String[] args) {
    // launch(args);
  // }
}
