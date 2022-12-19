package projsmartfarm;

/**
 *
 * @author Адель
 */
public class DroneTractorWithCultivator {
    private static int numOfTractor = 0;
    private final int tractorID;
    
    //Конструктор
    public DroneTractorWithCultivator() {     

      numOfTractor++;
      tractorID = numOfTractor;             
    }
  
}
