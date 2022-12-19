package projsmartfarm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 *
 * @author Адель
 */
public class ProjSmartFarm extends Application {
    public static Group root = new Group();
    
    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Scene scene = new Scene(root, 1120, 563, Color.GOLD);
        primaryStage.setTitle("Панель упраления Smart Farm");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Создание объектов
        Plants kostiruza = new Plants("Костируза", 50); //на 1 кв метр посадка 4х единиц (цена продажи за 1)
        Plants tyikva = new Plants("Тыквахэлл", 100); //на 1 кв метр посадка 1й единицы (цена продажи за 1)    
        Plants sontrava = new Plants("Сонтрава", 144); //на 1 кв метр посадка 6и единиц (цена продажи за 1)
        
        Plants[] plants = {kostiruza, tyikva, sontrava};
        
        AgriculturalLand land1 = new AgriculturalLand("Поле номер 1", 200, plants);
        AgriculturalLand land2 = new AgriculturalLand("Поле номер 2", 100, plants);
        
        DroneTractorWithCultivator tractor = new DroneTractorWithCultivator(land1, land2);
        SeedingMachine seedingMachine = new SeedingMachine(land1, land2, plants);
        RoboticHarvester roboticHarvester = new RoboticHarvester(plants);     
        
        FieldMenu menu = new FieldMenu(500,20, plants, land1, land2, tractor, seedingMachine, roboticHarvester); 


    }

    public static void main(String[] args) {
        launch(args);
    }   
}
