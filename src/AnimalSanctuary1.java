import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Creates a Animal Sanctuary.
 * @author Kaleb Rasmussen
 * @version 1.0.0
 */
public class AnimalSanctuary1 extends Application {


    /**
     * Creates a Animal Sanctuary visualization.
     * @param stage stage.
     * @throws Exception exceptions.
     */
    public void start(Stage stage) throws Exception {
        StackPane stack = new StackPane();
        BorderPane border = new BorderPane();


        Image image = new Image("animalImage.jpg");
        ImageView imv = new ImageView(image);
        imv.setFitHeight(1000);
        imv.setFitWidth(1000);

        VBox vBox1 = getVBox1();
        VBox vBox2 = getVBox2();
        VBox vBox3 = getVBox3();

        TilePane tilePane = getTilePane();

        EventHandler<MouseEvent> clearBox = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Pane ap = ((Pane) e.getSource());
                tilePane.getChildren().remove(ap);
                tilePane.getChildren().add(getAnimalPane("", "", 0));

            }
        };

        Button b1 = new Button("Add Animal");
        b1.setFont(Font.font("Verdana"));
        b1.setMaxSize(100, 100);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = ((TextField) (vBox1.getChildren().get(1))).getText();
                String type = (String) (((ComboBox) (vBox3.getChildren().get(1))).getValue());
                int health = Integer.parseInt(((TextField) (vBox2.getChildren().get(1))).getText());

                name = (name.equals("")) ? "No Name Yet" : name;
                health = (health < 1 || health > 5) ? 5 : health;

                if (((Label) ((Pane) tilePane.getChildren().get(5)).getChildren().get(0)).getText().equals("Empty")) {

                    for (int i = 0; i < 6; i++) {
                        if (((Label) ((Pane)
                            tilePane.getChildren().get(i)).getChildren().get(0)).getText().equals("Empty")) {
                            tilePane.getChildren().remove(i);
                            tilePane.getChildren().add(i, getAnimalPane(name, type, health));
                            tilePane.getChildren().get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, clearBox);
                            break;
                        }
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("There is no more room!");
                    a.show();
                }

                ((TextField) (vBox1.getChildren().get(1))).clear();
                ((TextField) (vBox2.getChildren().get(1))).clear();

            }
        };
        b1.setOnAction(event);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(50, 50, 50, 50));
        hBox.getChildren().addAll(vBox1, vBox2, vBox3, b1);
        hBox.setAlignment(Pos.CENTER);

        Label label = new Label("The Animal Sanctuary");
        label.setFont(new Font("Verdana", 30));
        label.setUnderline(true);
        label.setTextFill(Color.WHITE);
        label.setPadding(new Insets(50, 333, 15, 333));


        border.setTop(label);
        border.setBottom(hBox);
        border.setCenter(tilePane);

        stack.getChildren().addAll(imv, border);


        Scene scene = new Scene(stack, 1000, 1000);
        stage.setMaxHeight(1000);
        stage.setMaxWidth(1000);
        stage.setTitle("My Animal Sanctuary");
        stage.setScene(scene);
        stage.show();
    }


    private VBox getVBox1() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        vBox.setStyle("-fx-background-color: DAE6F3;");
        Label l1 = new Label("Type Name Here");
        l1.setFont(Font.font("Verdana"));
        l1.setAlignment(Pos.CENTER);
        TextField name = new TextField();
        name.setPromptText(l1.getText());
        name.setFont(Font.font("Verdana"));
        vBox.getChildren().addAll(l1, name);

        return vBox;

    }

    private VBox getVBox2() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        vBox.setStyle("-fx-background-color: DAE6F3;");
        Label l2 = new Label("Type Health Here");
        l2.setFont(Font.font("Verdana"));
        l2.setAlignment(Pos.CENTER);
        TextField health = new TextField();
        health.setPromptText(l2.getText());
        health.setFont(Font.font("Verdana"));
        vBox.getChildren().addAll(l2, health);

        return vBox;

    }

    private VBox getVBox3() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        vBox.setStyle("-fx-background-color: DAE6F3;");
        Label l3 = new Label("Pick Animal Type");
        l3.setFont(Font.font("Verdana"));
        l3.setAlignment(Pos.CENTER);

        final ComboBox<String> animalList = new ComboBox<String>();
        animalList.getItems().addAll(Animal.DOG.name(), Animal.CAT.name(), Animal.SQUIRREL.name(), Animal.BIRD.name());

        vBox.getChildren().addAll(l3, animalList);

        return vBox;

    }

    private TilePane getTilePane() {
        TilePane tilePane = new TilePane();
        tilePane.setPadding(new Insets(115, 300, 15, 300));
        tilePane.setHgap(20);
        tilePane.setVgap(20);
        tilePane.setPrefRows(2);
        tilePane.setPrefTileHeight(100);
        tilePane.setPrefTileWidth(100);
        tilePane.setAlignment(Pos.CENTER);

        Pane animalPane1 = getAnimalPane("", "", 0);
        Pane animalPane2 = getAnimalPane("", "", 0);
        Pane animalPane3 = getAnimalPane("", "", 0);
        Pane animalPane4 = getAnimalPane("", "", 0);
        Pane animalPane5 = getAnimalPane("", "", 0);
        Pane animalPane6 = getAnimalPane("", "", 0);

        tilePane.getChildren().addAll(animalPane1, animalPane2, animalPane3, animalPane4, animalPane5, animalPane6);

        return tilePane;

    }

    private Pane getAnimalPane(String name, String type, int h) {
        Pane pane = new Pane();
        pane.setMaxSize(100, 100);

        String health = (h == 0) ? "" : Integer.toString(h);

        pane.setStyle("-fx-background-color: E68978;");
        Label empty = new Label();
        if (name.equals("") || name == null) {
            empty.setText("Empty");
            empty.setFont(Font.font("Verdana"));
            empty.setAlignment(Pos.CENTER);
            pane.setStyle("-fx-background-color: DAE6F3;");
        }

        Label l1 = new Label();
        l1.setText(name + "\n" + type + "\n" + health);
        l1.setFont(Font.font("Verdana"));
        l1.setAlignment(Pos.CENTER);


        pane.getChildren().addAll(empty, l1);

        return pane;
    }



    /**
     * Main Method.
     *
     * @param args runs the visualization.
     */
    public static void main(String[] args) {
        launch(args);
    }


}
