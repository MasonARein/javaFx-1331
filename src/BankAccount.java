import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 * Creates a scene of a bank account.
 *
 * @author Mason Rein
 * @version 11.0.12
 */
public class BankAccount extends Application {
    /**
     * Starts the scene of bank account being created.
     *
     * @param stage Used stage for making window
     * @throws Exception Throws exception if error encountered
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1000, 600);
        stage.setTitle("Bank Account");
        Image img = new Image("bankBackground.jpeg");
        BackgroundImage backImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backGrnd = new Background(backImg);
        root.setBackground(backGrnd);
        Rectangle transactionLog = new Rectangle(scene.getWidth() * 0.2, scene.getHeight() * 0.125,
                scene.getWidth() * 0.6, scene.getHeight() * 0.75);
        transactionLog.setFill(Color.WHITESMOKE);
        Circle accountBalance = new Circle(scene.getWidth() * 0.9, scene.getHeight() * 0.2,
                scene.getWidth() * 0.075);
        accountBalance.setFill(Color.WHITESMOKE);
        Text text = new Text(scene.getWidth() * 0.84, scene.getHeight() * 0.2, "$3,002.80");
        text.setFont(
                Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 25));
        root.getChildren().add(accountBalance);
        root.getChildren().add(transactionLog);
        root.getChildren().add(text);
        stage.setScene(scene);
        stage.show();
    }
}
