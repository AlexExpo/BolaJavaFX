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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class JavaFXBolaRoja extends Application
{
    
    private static int direccionEjeX;
    
    private static int direccionEjeY;
    
    private static final int DIMENSION_ESCENA = 500;
    
    private static final int MITAD_RADIO_BOLA = 13;
    
    private int velocidadRectangulo;
    
    private static final double PIXELES_X_IMAGEN = 200;
    
    private static final double PIXELES_Y_IMAGEN = 112;
    
    public JavaFXBolaRoja()
    {
        direccionEjeX = 1;
        direccionEjeY = 1;
        velocidadRectangulo = 1;
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage escenario)
    {
        Group contenedor = new Group();
    
        Circle circulo = new Circle();
        
        Rectangle rectangulo = new Rectangle();
        
        Scene escena = new Scene(contenedor, DIMENSION_ESCENA, DIMENSION_ESCENA);
        
        Random random = new Random();
        
        Image imagen = new Image("1.jpg");
        ImageView iv = new ImageView();
        iv.setImage(imagen);
        iv.setX(escena.getWidth()/2 - PIXELES_X_IMAGEN / 2);
        iv.setY(escena.getHeight()/2  - PIXELES_Y_IMAGEN / 2);
                
        rectangulo.setWidth(80);
        rectangulo.setHeight(20);
        rectangulo.setFill(Color.BLUE);
        rectangulo.setArcWidth(20);
        rectangulo.setArcHeight(20);
        rectangulo.setX(200);
        rectangulo.setY(400);
        
        circulo.setRadius(26);
        circulo.setCenterX(MITAD_RADIO_BOLA + random.nextInt(DIMENSION_ESCENA) - circulo.getRadius());
        circulo.setCenterY(MITAD_RADIO_BOLA + random.nextInt(DIMENSION_ESCENA) - circulo.getRadius());
        circulo.setFill(Color.RED);
        
        
        contenedor.getChildren().add(circulo);
        contenedor.getChildren().add(rectangulo);
        
        
        Timeline timeLine = new Timeline();
        timeLine.setCycleCount(Animation.INDEFINITE);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.00200), event -> {
            
                        circulo.setTranslateX(circulo.getTranslateX() + direccionEjeX);
                        circulo.setTranslateY(circulo.getTranslateY() + direccionEjeY);
                        rectangulo.setTranslateX(rectangulo.getTranslateX() + velocidadRectangulo);
                        
                        double xMin = circulo.getBoundsInParent().getMinX();
                        double yMin = circulo.getBoundsInParent().getMinY();
                        double xMax = circulo.getBoundsInParent().getMaxX();
                        double yMax = circulo.getBoundsInParent().getMaxY();
                        double rXMax = rectangulo.getBoundsInParent().getMaxX();
                        double rXMin = rectangulo.getBoundsInParent().getMinX();

                        if (xMin < 0 || xMax > escena.getWidth()) {
                            direccionEjeX = direccionEjeX * -1;
                        }
                        if (yMin < 0) {
                            direccionEjeY = direccionEjeY * -1;
                        }
                        if (rXMin == 0 || rXMax == escena.getWidth()) {
                            velocidadRectangulo = 0;
                        }
                        
                        //if (circulo.getBoundsInParent().getMaxY() == rectangulo.getBoundsInParent().getMinY()) {
                            //if ((circulo.getBoundsInParent().getMinY() + circulo.getRadius()) >= rectangulo.getBoundsInParent().getMaxX() && 
                            //(circulo.getBoundsInParent().getMinY() + circulo.getRadius()) <= rectangulo.getBoundsInParent().getMaxX()) {
                             //  direccionEjeY = -direccionEjeY;
                            //}
                        //}
                        if (circulo.getBoundsInParent().intersects(rectangulo.getBoundsInParent())) {
                            direccionEjeY = -direccionEjeY;
                        }
                        
                    escena.setOnKeyPressed(event2 -> {
                        if (event2.getCode() == KeyCode.RIGHT) {
                            if (rXMax != escena.getWidth()) {
                                velocidadRectangulo = 1;
                            } 
                        }
                        else if (event2.getCode() == KeyCode.LEFT) {
                            if (rXMin != 0) {
                                velocidadRectangulo = -1;
                            }
                        }
                    });
                        if (yMin > escena.getHeight()) {
                            contenedor.getChildren().add(iv);
                            timeLine.stop();
                        }
                            
                });
                
                

        timeLine.getKeyFrames().add(kf);
        timeLine.play();     
        
        
        escenario.setScene(escena);
        escenario.show();
    }
  
}






