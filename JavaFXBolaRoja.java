import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.Group;


public class JavaFXBolaRoja extends Application
{
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage escenario)
    {
        Group contenedor = new Group();
    
        Circle circulo = new Circle();
     	 
        circulo.setCenterX(250);
        circulo.setCenterY(250);
        circulo.setRadius(20);
        circulo.setFill(Color.RED);
        contenedor.getChildren().add(circulo);
        
        Scene escena = new Scene(contenedor, 500, 500);
        escenario.setScene(escena);
        escenario.show();
    }
  
}






