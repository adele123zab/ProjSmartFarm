package projsmartfarm;
/**
 *
 * @author Адель
 */
public class RoboticHarvester {
    private static int numOfHarvester = 0;
    private final int harvesterID;
    
    //Конструктор
    public RoboticHarvester() {  
        
        numOfHarvester++;
        harvesterID = numOfHarvester;             
    }
    
}
