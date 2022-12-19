package projsmartfarm;
/**
 *
 * @author Адель
 */
public class IrrigationSystem {
    private static int numOfIrrigSys = 0;
    private final int irrigSysID;
    
    //Конструктор
    public IrrigationSystem() {     

      numOfIrrigSys++;
      irrigSysID = numOfIrrigSys;             
    }
    
}
