package projsmartfarm;
/**
 *
 * @author Адель
 */
public class Plants {

    public double getCrop() {
        return crop;
    }

    public void setCrop(double crop) {
        this.crop = crop;
    }

    public static int getNumOfPlantSpecies() {
        return numOfPlantSpecies;
    }

    public int getPlantSpecieID() {
        return PlantSpecieID;
    }

    public String getNameOfPlant() {
        return nameOfPlant;
    }

    public int getCost() {
        return cost;
    }

    public static void setNumOfPlantSpecies(int aNumOfPlantSpecies) {
        numOfPlantSpecies = aNumOfPlantSpecies;
    }

    public void setNameOfPlant(String nameOfPlant) {
        this.nameOfPlant = nameOfPlant;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    private static int numOfPlantSpecies = 0;
    private final int PlantSpecieID;
    private String nameOfPlant;
    private int cost;
    private double crop = 0; //количество выращенного урожая (зависит от вида урожая и единиц посаженного) настраивает сборщик
    
    //Конструктор
    public Plants(String nameOfPlant, int cost) { 
        this.nameOfPlant = nameOfPlant;
        this.cost = cost;
        numOfPlantSpecies++;
        PlantSpecieID = numOfPlantSpecies;             
    }
    
}
