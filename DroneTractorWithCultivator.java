package projsmartfarm;

import javax.swing.JOptionPane;

/**
 *
 * @author Адель
 */
public class DroneTractorWithCultivator {

    public AgriculturalLand getLand1() {
        return land1;
    }

    public AgriculturalLand getLand2() {
        return land2;
    }

    public void setLand1(AgriculturalLand land1) {
        this.land1 = land1;
    }

    public void setLand2(AgriculturalLand land2) {
        this.land2 = land2;
    }

    public static int getNumOfTractor() {
        return numOfTractor;
    }

    public int getTractorID() {
        return tractorID;
    }

    public double getBatteryCharge() {
        return batteryCharge;
    }

    public static void setNumOfTractor(int aNumOfTractor) {
        numOfTractor = aNumOfTractor;
    }

    public void setBatteryCharge(double batteryCharge) {
        this.batteryCharge = batteryCharge;
    }
    
    private static int numOfTractor = 0;
    private final int tractorID;
    private double batteryCharge = 100;
    private AgriculturalLand land1;
    private AgriculturalLand land2;
    
    //Конструктор
    public DroneTractorWithCultivator(AgriculturalLand land1, AgriculturalLand land2) { 
        this.land1 = land1;
        this.land2 = land2;
        numOfTractor++;
        tractorID = numOfTractor;             
    }
    
    //ВСПАШКА
    public AgriculturalLand plowing(){ 
        int field;       
        field = Integer.parseInt(JOptionPane.showInputDialog("Выберите поле для вспахивания (1-2):"));
        if(batteryCharge >= 20) {           
            if (field == 1 && land1.isHasAnythPlanted() == false){
                land1.setHasPloved(true); //новый статус поля 1
                batteryCharge = batteryCharge - (land1.getArea())*0.5; //уменьшение заряда
                JOptionPane.showMessageDialog(null, "Поле вспахано!");
                return land1;
            }
            else if(field == 2 && land2.isHasAnythPlanted() == false){
                land2.setHasPloved(true); //новый статус поля 2
                batteryCharge = batteryCharge - (land2.getArea())*0.5; //уменьшение заряда
                JOptionPane.showMessageDialog(null, "Поле вспахано!");
                return land2;           
            }
            else {
                JOptionPane.showMessageDialog(null, "Операция недоступна");
                if(field == 1) return land1;
                else return land2;
            }     
        }        
        else if (batteryCharge < 20) {
            JOptionPane.showMessageDialog(null, "Трактор на тех-обслуживании");
            batteryCharge = 100;
            if(field == 1) return land1;
            else return land2;
        }       
        return null;
    } 
    
    //ПРОПОЛКА
    public AgriculturalLand weeding(){ 
        int field;       
        field = Integer.parseInt(JOptionPane.showInputDialog("Выберите поле для культивации (1-2):"));
        if(batteryCharge >= 20) {           
            if (field == 1 && land1.isHasAnythPlanted() == false){
                land1.setWeeds(false); //новый статус поля 1
                batteryCharge = batteryCharge - (land1.getArea())*0.5; //уменьшение заряда
                JOptionPane.showMessageDialog(null, "Поле обработано!");
                return land1;
            }
            else if(field == 2 && land2.isHasAnythPlanted() == false){
                land2.setWeeds(false); //новый статус поля 2
                batteryCharge = batteryCharge - (land2.getArea())*0.5; //уменьшение заряда
                JOptionPane.showMessageDialog(null, "Поле обработано!");
                return land2;           
            }
            else {
                JOptionPane.showMessageDialog(null, "Операция недоступна. Убедитесь, что поле свободно.");
                if(field == 1) return land1;
                else return land2;
            }     
        }        
        else if (batteryCharge < 20) {
            JOptionPane.showMessageDialog(null, "Культиватор SmartFarm на тех-обслуживании");
            batteryCharge = 100;
            if(field == 1) return land1;
            else return land2;
        }       
        return null;
    }
}
