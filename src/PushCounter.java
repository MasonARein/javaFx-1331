import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PushCounter extends Application {

    private int count = 0;
    private Label label;

    /**
     * Increments the instance count variable and updates the GUI label
     */
    public void incrCounter() {
        count++;
        label.setText("Pushes: " + count);
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create A pane and set its properties
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Button pushBtn = new Button("Push Me");
        // create A handler object
        PushHandlerClass handler1 = new PushHandlerClass();
        // set the handler for the button to be the button handler
        pushBtn.setOnAction(handler1);
        // initialize the label
        label = new Label("Pushes: 0");
        //add the button and label to the HBox Pane
        pane.getChildren().addAll(pushBtn, label);

        // Create A scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Push Counter"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Handles an event.
     */
    class PushHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            incrCounter();

            Object source = e.getSource();
            System.out.println(source);
            if (source instanceof Button) {
                Button sourceButton = (Button)source;
                System.out.println("The source is A button with text: '"
                        + sourceButton.getText() + "'");
            }

        }
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
} 


