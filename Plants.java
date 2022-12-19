package projsmartfarm;
/**
 *
 * @author Адель
 */
public class Plants {

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public int getSumCrop() {
        return sumCrop;
    }

    public void setSumCrop(int sumCrop) {
        this.sumCrop = sumCrop;
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

    
    private static int numOfPlantSpecies = 0;
    private final int PlantSpecieID;
    private String nameOfPlant;
    private int cost;
    private int sumCrop = 0; //количество выращенного урожая (со всех полей) настраивает сборщик
    private double sumMoney = 0;
    
    //Конструктор
    public Plants(String nameOfPlant, int cost) { 
        this.nameOfPlant = nameOfPlant;
        this.cost = cost;
        numOfPlantSpecies++;
        PlantSpecieID = numOfPlantSpecies;             
    }
    
}
