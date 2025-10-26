package application;

//importing JavaFX application
import javafx.application.Application;

//importing UI building blocks
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;

//importing java utilities
import java.io.FileWriter; // writing files
import java.io.IOException; //needed for catch
import java.time.LocalDateTime; //timestamps
import java.util.Random; // random generator


public class CreatingUserInterface extends Application {
	private TextArea textArea; 
	private BorderPane root; //variables for text area and main layout
	
@Override
public void start(Stage primaryStage) {
	root = new BorderPane(); //layout organization
	textArea = new TextArea(); //text field
	textArea.setPrefSize(500, 150);
	textArea.setMaxSize(500, 150); //this is needed to overwrite the BorderPane layout
	
	//this centers the textArea in the window
	VBox vbox = new VBox(textArea);
	vbox.setAlignment(Pos.CENTER);
	root.setCenter(vbox);
	
	//creation of menu bar and main menu title
	MenuBar menuBar = new MenuBar();
	Menu menu = new Menu("Menu");
	
	//clickable menu buttons
	MenuItem dateTimeItem = new MenuItem("Insert Date/Time");
	MenuItem saveItem = new MenuItem("Save to log.txt");
	MenuItem randomGreenItem = new MenuItem("Change Colors");
	MenuItem exitItem = new MenuItem("Exit");
	
	menu.getItems().addAll(dateTimeItem, saveItem, randomGreenItem,
		new SeparatorMenuItem(), exitItem);
	menuBar.getMenus().add(menu);
		root.setTop(menuBar);
		
//timestamp action
dateTimeItem.setOnAction(e ->
	textArea.appendText(LocalDateTime.now().toString() + "\n")
	);

//save to log.txt action
saveItem.setOnAction(e -> {
	try(FileWriter writer = new FileWriter("log.txt")) {
		writer.write(textArea.getText());
		textArea.appendText("Saved to log.txt\n");
	}
	catch (IOException ex) {
		textArea.appendText("Error saving file\n");
	}
});

//random green background action
randomGreenItem.setOnAction(e -> {
	Random rand = new Random();
	double hue = rand.nextDouble() * 60 + 60;
	
	Color randomGreen = Color.hsb(hue, 1.0, 1.0);
	root.setStyle("-fx-background-color: " + toRgbString(randomGreen) + ";");
	randomGreenItem.setText(String.format("Random Green (Hue: %.1f)", hue));
	});

//exit program action
	exitItem.setOnAction(e -> primaryStage.close());

//displaying UI
	Scene scene = new Scene (root, 500, 300);
		primaryStage.setTitle("User Interface Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
}
	
private String toRgbString(Color color) {
	return String.format("rgb(%d, %d, %d)",
			(int) (color.getRed() * 255),
			(int) (color.getGreen() * 255),
			(int) (color.getBlue() * 255));
}
	
public static void main(String[] args) {
	launch(args);
}

}


