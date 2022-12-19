package projsmartfarm;

import javax.swing.JOptionPane;

/**
 *
 * @author Адель
 */
public class RoboticHarvester {

    public static int getNumOfHarvester() {
        return numOfHarvester;
    }

    public int getHarvesterID() {
        return harvesterID;
    }

    public Plants[] getPlants() {
        return plants;
    }

    public Plants getPlant() {
        return plant;
    }

    public AgriculturalLand getLand() {
        return land;
    }

    public static void setNumOfHarvester(int aNumOfHarvester) {
        numOfHarvester = aNumOfHarvester;
    }

    public void setPlants(Plants[] plants) {
        this.plants = plants;
    }

    public void setPlant(Plants plant) {
        this.plant = plant;
    }

    public void setLand(AgriculturalLand land) {
        this.land = land;
    }
    
    private static int numOfHarvester = 0;
    private final int harvesterID;
    private Plants[] plants;
    private Plants plant;
    private AgriculturalLand land;
    //private AgriculturalLand land2;
    
    //Конструктор
    public RoboticHarvester(Plants[] plants) {  
        this.plants = plants;
        numOfHarvester++;
        harvesterID = numOfHarvester;             
    }
    
    //СБОР УРОЖАЯ
    public void harvester(AgriculturalLand land, Plants plant) { 
        this.land = land;
        this.plant = plant;
        //Cчитаю сумму собранного урожая опр культуры и сумму потенциального дохода с нее
        if(getLand().getCrop() != 0) {
        getPlant().setSumCrop(getPlant().getSumCrop() + getLand().getCrop());
        getPlant().setSumMoney(getPlant().getSumMoney() + getLand().getCrop() * getPlant().getCost());
        getLand().setCrop(0);//////////////!!!!!!
        getLand().setHasPloved(false);
        getLand().setPlant(null);
        getLand().setHasAnythPlanted(false);
        getLand().setWeeds(true);       
        //hasPloved = false; getLand().getPlant = null
        JOptionPane.showMessageDialog(null, "Склады пополены!");
        }
        else {
        JOptionPane.showMessageDialog(null, "Урожай не готов.");
        }
    
    }
    
}
