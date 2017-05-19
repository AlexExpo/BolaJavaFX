import javafx.scene.control.Button;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        
        Scene escena = new Scene(contenedor, 500, 500);
        
        int direccionEjeX = 1;
        int direccionEjey = 1;
     	 
        circulo.setCenterX(250);
        circulo.setCenterY(250);
        circulo.setRadius(20);
        circulo.setFill(Color.RED);
        contenedor.getChildren().add(circulo);
        
        
        
        Timeline timeLine = new Timeline();
        timeLine.setCycleCount(Animation.INDEFINITE);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.0200), event -> {
                     {
                        circulo.setTranslateX(circulo.getTranslateX() + direccionEjeX);
                        circulo.setTranslateY(circulo.getTranslateY() + direccionEjey);
                    } 
                });
                
        Button parar = new Button("Parar");
        parar.setOnAction(event -> {
            if (timeLine.getStatus() == Animation.Status.RUNNING) {
                timeLine.stop();
            }
            else {
                timeLine.play();
            }
        });
        
        contenedor.getChildren().add(parar);

        timeLine.getKeyFrames().add(kf);
        timeLine.play();     
        
        
        escenario.setScene(escena);
        escenario.show();
    }
  
}






