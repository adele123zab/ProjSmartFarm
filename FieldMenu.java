package projsmartfarm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FieldMenu {

    AgriculturalLand land1;
    AgriculturalLand land2;
    DroneTractorWithCultivator tractor;
    SeedingMachine seedingMachine;
    RoboticHarvester roboticHarvester;
    
    private Text title;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Text text;
    private Image put;
    private ImageView picture;
    
    private Text namesOfParam;
    private Text tfieldID;
    private Text landName;
    private Text area;
    private Text weeds;
    private Text soilMoisture;
    private Text soilTemp;
    private Text planted;
    private Text crop;
    
    //Конструктор
    public FieldMenu(int x, int y, AgriculturalLand land1, AgriculturalLand land2, DroneTractorWithCultivator tractor, SeedingMachine seedingMachine, RoboticHarvester roboticHarvester){
        this.land1 = land1;
        this.land2 = land2;
        this.tractor = tractor;
        this.seedingMachine = seedingMachine;
        this.roboticHarvester = roboticHarvester;
        
        title = new Text("Выберите действие:");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        btn1 = new Button("Дать команду вспашки Трактору-беспилотнику");
        btn2 = new Button("Дать команду прополки Культиватору Smart Farm");
        btn3 = new Button("Орошение");
        btn4 = new Button("Засеять поле");
        btn5 = new Button("Дать команду сбора урожая Роботизированному сборщику");
        btn6 = new Button("Продать урожай"); //Доход отобразится для определенной культуры
        text = new Text("(Здесь будут актуальные параметры поля)");
        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        //Узлы текста для характеристик поля
        namesOfParam = new Text("ID поля:      Название поля:      Площадь [м^2]:     Наличие сорняков:     Уровень влажности:      Температура:     Посажено единиц:      Урожайных единиц, готовых к сбору:");
        tfieldID = new Text("-----------");
        landName = new Text("-------------------");  
        area = new Text("---------------------");   
        weeds = new Text("------------------------");        
        soilMoisture = new Text("-------------------------");
        soilTemp = new Text("-------------------");        
        planted = new Text("-----------------------");        
        crop = new Text("-----------------------------------------"); 
                
        //затаскиваю узлы-кнопки в панели
         HBox hboxB1 = new HBox(8); // spacing = 8
        hboxB1.getChildren().addAll(btn1);
         HBox hboxB2 = new HBox(8); // spacing = 8
        hboxB2.getChildren().addAll(btn2);
         HBox hboxB3 = new HBox(8); // spacing = 8
        hboxB3.getChildren().addAll(btn3);
         HBox hboxB4 = new HBox(8); // spacing = 8
        hboxB4.getChildren().addAll(btn4);
         HBox hboxB5 = new HBox(8); // spacing = 8
        hboxB5.getChildren().addAll(btn5);
         HBox hboxB6 = new HBox(8); // spacing = 8
        hboxB6.getChildren().addAll(btn6);              
         HBox hboxTi = new HBox(8);
        hboxTi.getChildren().addAll(title);
         HBox hboxTe = new HBox(8);
        hboxTe.getChildren().addAll(text);
        
        HBox hboxNames = new HBox(8);
        hboxNames.getChildren().addAll(namesOfParam);
        HBox hboxParam = new HBox(8);
        hboxParam.getChildren().addAll(tfieldID, landName, area, weeds, soilMoisture, soilTemp, planted, crop);
        
        //Картинка
        put = new Image(getClass().getResource("Images/2022-12-18_17-02-10.png").toString());
        picture = new ImageView(put);  
        //изменение положения
        picture.setX(0); 
        picture.setY(0); 
        //масштабирование картинки фона
        picture.setPreserveRatio(true);
        picture.setFitWidth(1120);
        
        ProjSmartFarm.root.getChildren().addAll(hboxTi,hboxB1, 
                hboxB2, hboxB3, hboxB4, hboxB5, 
                hboxB6, hboxTe, picture, hboxNames, hboxParam);
        picture.toBack();
        hboxParam.toFront();
        //настраиваю положение панелей
        hboxTi.setLayoutX(50);
        hboxTi.setLayoutY(60);
        hboxB1.setLayoutX(50.0);
        hboxB1.setLayoutY(100.0);
        hboxB2.setLayoutX(50.0);
        hboxB2.setLayoutY(130.0);
        hboxB3.setLayoutX(50.0);
        hboxB3.setLayoutY(160.0);
        hboxB4.setLayoutX(50.0);
        hboxB4.setLayoutY(190.0);
        hboxB5.setLayoutX(50.0);
        hboxB5.setLayoutY(220.0);
        hboxB6.setLayoutX(50.0);
        hboxB6.setLayoutY(250.0);
        hboxTe.setLayoutX(800);
        hboxTe.setLayoutY(60);
        hboxNames.setLayoutX(50);
        hboxNames.setLayoutY(20);        
        hboxParam.setLayoutX(50);
        hboxParam.setLayoutY(40);
            
        interactions();
    }
    
    private void interactions(){
        //
        //заставляю кнопки показывать текст
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                text.setFill(Color.AQUA);
                text.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 16));
                //text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));////////
                if (land1.isHasAnythPlanted() == false) {
                    
                    text.setText("////////");
                }
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                text.setFill(Color.FIREBRICK);
                text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
                text.setText("Вы все равно в матрице!");
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                text.setFill(Color.AQUA);
                text.setFont(Font.font("Tahoma", FontWeight.THIN, 16));
                //text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));////////
                text.setText("Вы в матрице!");
            }
        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //seedingMachine.seeding();
                //text.setFill(Color.FIREBRICK);
                //text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
                text.setText("Команда успешно исполняется!");
                displayParametrs(seedingMachine.seeding());
            }
        });
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                text.setFill(Color.AQUA);
                text.setFont(Font.font("Tahoma", FontWeight.THIN, 16));
                //text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));////////
                text.setText("Вы в матрице!");
            }
        });
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                text.setFill(Color.FIREBRICK);
                text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
                text.setText("Вы все равно в матрице!");
            }
        });
    }
    
    public void displayParametrs(AgriculturalLand land){ 
        text.setText("Команда успешно исполняется!");
        //////////////////как отобразить параметры
        //String x1 = (land.getFieldID()).toString();
        tfieldID.setText(((Integer)land.getFieldID()).toString()); //int в Integer в String
        landName.setText(land.getLandName()); 
        area.setText(((Integer)land.getArea()).toString());  
        if(land.isWeeds() == true){
        weeds.setText("Необходима прополка"); 
        }
        else{
        weeds.setText("Сорняков нет"); 
        }
        soilMoisture.setText(((Double)land.getSoilMoisture()).toString());
        soilTemp.setText(((Double)AgriculturalLand.getSoilTemp()).toString());     
        planted.setText(((Integer)land.getPlanted()).toString());       
        crop.setText(((Integer)land.getCrop()).toString());
    
    }
    
}
