package projsmartfarm;

import javax.swing.JOptionPane;
/**
 *
 * @author Адель
 */
public class SeedingMachine {

    public Plants getPlant() {
        return plant;
    }

    public void setPlant(Plants plant) {
        this.plant = plant;
    }

    public int getCulture() {
        return culture;
    }

    public void setCulture(int culture) {
        this.culture = culture;
    }

    public static int getNumOfSeedingMachine() {
        return numOfSeedingMachine;
    }

    public int getSeedingMachineID() {
        return seedingMachineID;
    }

    public AgriculturalLand getLand1() {
        return land1;
    }

    public AgriculturalLand getLand2() {
        return land2;
    }

    public Plants[] getPlants() {
        return plants;
    }

    public static void setNumOfSeedingMachine(int aNumOfSeedingMachine) {
        numOfSeedingMachine = aNumOfSeedingMachine;
    }

    public void setLand1(AgriculturalLand land1) {
        this.land1 = land1;
    }

    public void setLand2(AgriculturalLand land2) {
        this.land2 = land2;
    }

    public void setPlants(Plants[] plants) {
        this.plants = plants;
    }
    
    private static int numOfSeedingMachine = 0;
    private final int seedingMachineID;
    private AgriculturalLand land1;
    private AgriculturalLand land2;
    private Plants[] plants;
    private Plants plant;
    private int culture;
    
    //Конструктор
    public SeedingMachine(AgriculturalLand land1, AgriculturalLand land2, Plants[] plants) {    
        this.land1 = land1;
        this.land2 = land2;
        this.plants = plants;
        numOfSeedingMachine++;
        seedingMachineID = numOfSeedingMachine;             
    }
    
    public AgriculturalLand seeding(){ 
        //int culture;
        int field;
        //проверить, пспахано ли поле!!!!!!!
        field = Integer.parseInt(JOptionPane.showInputDialog("Выберите поле для посадки (1-2):"));
        if (field == 1 && land1.isHasAnythPlanted() == false && land1.isHasPloved() == true && land1.isWeeds() == false){
            land1.setHasAnythPlanted(true);
            setCulture(Integer.parseInt(JOptionPane.showInputDialog("Выберите культуру для посадки (1, 2 или 3):")));
            switch (getCulture()) {
                case 1:
                    land1.setPlant(plants[0]);
                    plant = plants[0];
                    land1.setPlanted(land1.getArea() * 4); //на 1 кв метр 4 единиц культуры
                    return land1;
                    //break;                   
                case 2:
                    land1.setPlant(plants[1]);
                    plant = plants[1];
                    land1.setPlanted(land1.getArea()); //на 1 кв метр 1 единиц культуры
                    return land1;
                    //break;
                case 3:
                    land1.setPlant(plants[2]);
                    plant = plants[2];
                    land1.setPlanted(land1.getArea() * 6); //на 1 кв метр 6 единиц культуры
                    return land1;
                    //break;
                //default:
                //    break;
            }
            
        }
        else if(field == 2 && land2.isHasAnythPlanted() == false && land2.isHasPloved() == true && land2.isWeeds() == false){
            land2.setHasAnythPlanted(true);
            setCulture(Integer.parseInt(JOptionPane.showInputDialog("Выберите культуру для посадки (1, 2 или 3):")));
            switch (getCulture()) {
                case 1:
                    land2.setPlant(plants[0]);
                    plant = plants[0];
                    land2.setPlanted(land2.getArea() * 4); //на 1 кв метр 4 единиц культуры
                    JOptionPane.showMessageDialog(null, "Поле засеяно!");                   
                    return land2;
                    //break;
                case 2:
                    land2.setPlant(plants[1]);
                    plant = plants[1];
                    land2.setPlanted(land2.getArea()); //на 1 кв метр 1 единиц культуры
                    JOptionPane.showMessageDialog(null, "Поле засеяно!");
                    return land2;
                    //break;
                case 3:
                    land2.setPlant(plants[2]);
                    plant = plants[2];
                    land2.setPlanted(land2.getArea() * 6); //на 1 кв метр 6 единиц культуры
                    JOptionPane.showMessageDialog(null, "Поле засеяно!");
                    return land2;
                    //break;
                default:
                    break;
            }           
        }
        else {
            JOptionPane.showMessageDialog(null, "Операция невозможна. Убедитесь, что поле вспахано и свободно.");
            if(field == 1) return land1;
            else return land2;
        } //а так можно?
        return null;
        
    }
    
    //public Plants checkCulture(){ 
    //    return plant;
    //}       
}
