package projsmartfarm;

import java.util.Random;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javax.swing.JOptionPane;

/**
 *
 * @author Адель
 */
public class AgriculturalLand {

    public boolean isHasPloved() {
        return hasPloved;
    }

    public void setHasPloved(boolean hasPloved) {
        this.hasPloved = hasPloved;
    }

    public Plants getPlant() {
        return plant;
    }

    public void setPlant(Plants plant) {
        this.plant = plant;
    }

    public Plants[] getPlants() {
        return plants;
    }

    public void setPlants(Plants[] plants) {
        this.plants = plants;
    }

    //public IrrigationSystem getIrrigationSystem() {
    //    return irrigationSystem;
    //}

    public static int getNumOfFields() {
        return numOfFields;
    }

    public int getFieldID() {
        return fieldID;
    }

    //public void setIrrigationSystem(IrrigationSystem irrigationSystem) {
    //    this.irrigationSystem = irrigationSystem;
    //}

    public static void setNumOfFields(int aNumOfFields) {
        numOfFields = aNumOfFields;
    }

    public String getLandName() {
        return landName;
    }

    public int getArea() {
        return area;
    }

    public boolean isHasAnythPlanted() {
        return hasAnythPlanted;
    }

    public boolean isWeeds() {
        return weeds;
    }

    public double getSoilMoisture() {
        return soilMoisture;
    }

    //public static double getSoilTemp() {
    //    return soilTemp;
    //}
    //public static void setSoilTemp(double aSoilTemp) {
    //    soilTemp = aSoilTemp;
    //}

    public int getPlanted() {
        return planted;
    }

    public int getCrop() {
        return crop;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setHasAnythPlanted(boolean hasAnythPlanted) {
        this.hasAnythPlanted = hasAnythPlanted;
    }

    public void setWeeds(boolean weeds) {
        this.weeds = weeds;
    }

    public void setSoilMoisture(double soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public void setPlanted(int planted) {
        this.planted = planted;
    }

    public void setCrop(int crop) {
        this.crop = crop;
    }
    
    Random rand = new Random();
    
    //private IrrigationSystem irrigationSystem = new IrrigationSystem();
    private static int numOfFields = 0;
    private final int fieldID;
    private String landName; 
    private int area; //площадь [кв метр]
    private boolean hasPloved = false;
    private Plants[] plants;
    private Plants plant;
    private boolean hasAnythPlanted = false; //посажено ли что-то
    private boolean weeds = true; //есть ли сорняки
    private double soilMoisture = rand.nextInt(81); //уровень влажности почвы
    //private static double soilTemp = 10;
    private int planted = 0; //количество посаженных единиц культуры
    private int crop = 0; //количество выращенного урожая за 1 сбор (единицы посаженного)   
    
    //Конструктор
    public AgriculturalLand(String landName, int area, Plants[] plants) {   
        this.plants = plants;
        this.landName = landName;
        this.area = area;
        numOfFields++;
        fieldID = numOfFields;             
    }
    
    public void irrigation(){ 
        if (hasPloved == true && hasAnythPlanted == true && soilMoisture < 80){
                soilMoisture+=20;
                JOptionPane.showMessageDialog(null, "Уровень влажности почвы повышен.");
        }
        else if (hasPloved == true && hasAnythPlanted != true && soilMoisture < 80){
                JOptionPane.showMessageDialog(null, "Операция недоступна. Поле не засеяно.");
        }
        //УСЛОВИЕ ГОТОВНОСТИ УРОЖАЯ
        else if (hasPloved == true && hasAnythPlanted == true && soilMoisture >= 80){
                JOptionPane.showMessageDialog(null, "Достигнута достаточная влажность. Урожай готов к сбору.");
                crop = planted;
                planted = 0;
                soilMoisture = rand.nextInt(81);
                
        }
        else {
               JOptionPane.showMessageDialog(null, "Операция недоступна. Поле не вспахано.");
        }
                 
    }
    //private void interactions() {
    //   dormRect.setOnMousePressed((me) -> {
    //       mouseGrabPosition.x = me.getSceneX();
    //       mouseGrabPosition.y = me.getSceneY();
    //       iconGrabPosition.x = (double)xLocation;
    //       iconGrabPosition.y = (double)yLocation;
    //       dormRect.toFront();
    //   });
    //}
   
}
