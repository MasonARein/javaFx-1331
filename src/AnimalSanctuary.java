import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;

/**
 * Defines the Javafx class of animal sanctuary.
 *
 * @author Mason Rein
 * @version 11.0.12
 */
public class AnimalSanctuary extends Application {
    /**
     * Main method argument.
     *
     * @param args List of string data
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the running of an animal sanctuary visualization.
     *
     * @param stage Stage class is to be defined in
     * @throws Exception Excpetion to be thrown
     */
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane backdrop = new BorderPane();
        stage.setTitle("My Animal Sanctuary");
        Image img = new Image("animalBackground.jpeg");

        BackgroundImage backImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backGrnd = new Background(backImg);
        backdrop.setBackground(backGrnd);
        Scene scene = new Scene(backdrop, img.getWidth(), img.getHeight());
        stage.setMaxWidth(img.getWidth());
        stage.setMaxHeight(img.getHeight());

        Label label = new Label("The Animal Sanctuary");
        label.setFont(new Font("Serif", 30));
        label.setUnderline(true);
        label.setTextFill(Color.WHITE);
        label.setPadding(new Insets(50, 333, 15, 333));

        backdrop.setTop(label);

        TilePane animalArea = animalSections();
        HBox userInput = new HBox();
        VBox vName = nameVbox();
        VBox vType = typeVbox();
        VBox vHealth = healthVbox();


        EventHandler<MouseEvent> clearAnimal = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Pane originalAnimal = ((Pane) e.getSource());
                animalArea.getChildren().remove(originalAnimal);
                animalArea.getChildren().add(animalPane("", "", ""));
            }
        };
        Button animalAddition = new Button("Add animal");
        animalAddition.setFont(Font.font("Serif"));
        animalAddition.setMaxSize(200, 100);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = ((TextField) (vName.getChildren().get(1))).getText();
                String type = (String) (((ComboBox) (vType.getChildren().get(1))).getValue());
                String health = ((TextField) (vHealth.getChildren().get(1))).getText();

                name = (name.equals("")) ? "No Name Yet" : name;
                health = (Integer.parseInt(health) < 1 || Integer.parseInt(health) > 5) ? "5" : health;

                if (((Label) ((Pane) animalArea.getChildren().get(5)).getChildren().get(0)).getText().equals("Empty")) {

                    for (int i = 0; i < 6; i++) {
                        if (((Label) ((Pane)
                                animalArea.getChildren().get(i)).getChildren().get(0)).getText().equals("Empty")) {
                            animalArea.getChildren().remove(i);
                            animalArea.getChildren().add(i, animalPane(name, health, type));
                            animalArea.getChildren().get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, clearAnimal);
                            animalArea.getChildren().get(i).setStyle("-fx-background-color: FFD478");
                            break;
                        }
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("There is no more room!");
                    a.show();
                }

                ((TextField) (vName.getChildren().get(1))).clear();
                ((TextField) (vHealth.getChildren().get(1))).clear();

            }
        };
        animalAddition.setOnAction(event);

        userInput.setPadding(new Insets(25, 25, 25, 25));
        userInput.getChildren().addAll(vName, vType, vHealth, animalAddition);
        userInput.setAlignment(Pos.CENTER);

        animalArea.setAlignment(Pos.CENTER);

        backdrop.setBottom(userInput);
        backdrop.setCenter(animalArea);


        stage.setScene(scene);
        stage.show();
    }

    private TilePane animalSections() {
        TilePane sections = new TilePane();
        sections.setVgap(20);
        sections.setHgap(20);
        sections.setPadding(new Insets(10, 350, 100, 350));
        sections.setPrefTileHeight(100);
        sections.setPrefTileWidth(100);
        sections.setPrefRows(2);
        sections.setAlignment(Pos.CENTER);

        Pane animalPane1 = animalPane("", "", "");
        Pane animalPane2 = animalPane("", "", "");
        Pane animalPane3 = animalPane("", "", "");
        Pane animalPane4 = animalPane("", "", "");
        Pane animalPane5 = animalPane("", "", "");
        Pane animalPane6 = animalPane("", "", "");

        sections.getChildren().addAll(animalPane1, animalPane2, animalPane3, animalPane4, animalPane5, animalPane6);

        return sections;
    }

    private Pane animalPane(String name, String health, String type) {
        Pane animal = new Pane();
        animal.setMaxHeight(100);
        animal.setMaxWidth(100);
        animal.setStyle("");
        Label animalDetail = new Label();
        if (name == null || name.equals("")) {
            animalDetail.setText("Empty");
            animalDetail.setFont(Font.font("Serif"));
            animalDetail.setAlignment(Pos.CENTER);
            animal.setStyle("-fx-background-color: C9C9C9;");
        }
        Label animalChange = new Label();
        animalChange.setText(name + "\n" + type + "\n" + health);
        animalChange.setFont(Font.font("Serif"));
        animalChange.setAlignment(Pos.CENTER);
        animal.getChildren().addAll(animalDetail, animalChange);

        return animal;
    }

    private VBox nameVbox() {
        VBox vName = new VBox(10);
        vName.setPadding(new Insets(10, 10, 10, 10));
        vName.setStyle("-fx-background-color: FFAE9E;");
        Label forName = new Label("Type name here:");
        forName.setFont(Font.font("serif"));
        TextField name = new TextField();
        name.setText("");
        name.setFont(Font.font("Serif"));
        vName.getChildren().addAll(forName, name);
        return vName;
    }

    private VBox typeVbox() {
        VBox vType = new VBox(10);
        vType.setPadding(new Insets(10, 10, 10, 10));
        vType.setStyle("-fx-background-color: FFAE9E;");
        Label forType = new Label("Pick animal type:");
        ComboBox<String> animalList = new ComboBox<String>();
        animalList.getItems().addAll(Animal.DOG.name(), Animal.CAT.name(),
                Animal.SQUIRREL.name(), Animal.BIRD.name(), Animal.HORSE.name(),
                Animal.COW.name(), Animal.PIG.name());
        vType.getChildren().addAll(forType, animalList);
        return vType;
    }

    private VBox healthVbox() {
        VBox vHealth = new VBox(10);
        vHealth.setPadding(new Insets(10, 10, 10, 10));
        vHealth.setStyle("-fx-background-color: FFAE9E;");
        Label forHealth = new Label("Type health here:");
        forHealth.setFont(Font.font("Serif"));
        TextField health = new TextField();
        health.setText("");
        health.setFont(Font.font("Serif"));
        vHealth.getChildren().addAll(forHealth, health);
        return vHealth;
    }
}
