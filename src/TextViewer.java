import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextViewer extends Application {

    private Label lastAction;
    private TextArea writingArea;
    public void start(Stage stage) throws Exception{
        BorderPane backdrop = new BorderPane();

        backdrop.setTop(buttons());

        lastAction = new Label();
        lastAction.setText("Hello World");
        lastAction.setAlignment(Pos.CENTER);
        backdrop.setBottom(lastAction);

        writingArea = new TextArea();
        backdrop.setCenter(writingArea);

        Scene scene = new Scene(backdrop, 1000, 600);
        stage.setScene(scene);
        stage.setTitle("TextViewer App - Mason Rein");
        stage.show();
    }
    private HBox buttons(){
        HBox buttonSection = new HBox();
        Button load = new Button("Load...");
        Button undo = new Button("Undo");
        Button redo = new Button("Redo");

        buttonSection.getChildren().addAll(load, undo, redo);
        EventHandler<ActionEvent> loadevent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent mouseEvent) {
                lastAction.setText("Loading File");
            }
        };
        load.setOnAction(loadevent);
        EventHandler<ActionEvent> undoevent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent mouseEvent) {
                lastAction.setText("Undo requested");
                writingArea.undo();
            }
        };
        undo.setOnAction(undoevent);
        EventHandler<ActionEvent> redoevent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent mouseEvent) {
                lastAction.setText("Redo requested");
                writingArea.redo();
            }
        };
        redo.setOnAction(redoevent);
        return buttonSection;
    }
}
