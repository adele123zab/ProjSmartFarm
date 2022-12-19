package projsmartfarm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

public class FieldMenu {

    AgriculturalLand land1;
    AgriculturalLand land2;
    Plants[] plants;//////////
    DroneTractorWithCultivator tractor;
    SeedingMachine seedingMachine;
    RoboticHarvester roboticHarvester;
    
    private Text title;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    //private Button btn6;
    private Text text;
    private Image put;
    private ImageView picture;
    private Image put1;
    private ImageView picture1;
    private Image put2;
    private ImageView picture2;
    private Image put3;
    private ImageView picture3;
    private Text cult1;
    private Text cult2;
    private Text cult3;
    
    //private Text namesOfParam;
    private Text tfieldID;
    private Text landName;
    private Text area;
    private Text hasPloved;
    private Text weeds;
    private Text soilMoisture;
    private Text plant;
    private Text planted;
    private Text crop;
    
    //Конструктор
    public FieldMenu(int x, int y, Plants[] plants, AgriculturalLand land1, AgriculturalLand land2, DroneTractorWithCultivator tractor, SeedingMachine seedingMachine, RoboticHarvester roboticHarvester){
        this.plants = plants;
        this.land1 = land1;
        this.land2 = land2;
        this.tractor = tractor;
        this.seedingMachine = seedingMachine;
        this.roboticHarvester = roboticHarvester;
        
        title = new Text("Выберите действие:");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title.setFill(Color.WHITE);
        btn1 = new Button("Дать команду вспашки");
        btn2 = new Button("Дать команду прополки");
        btn3 = new Button("Орошение");
        btn4 = new Button("Засеять поле");
        btn5 = new Button("Дать команду сбора урожая");
        //btn6 = new Button("Продать урожай"); //Доход отобразится для определенной культуры
        text = new Text("(Здесь будут актуальные параметры поля)");
        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        cult1 = new Text("1 Костируза");
        cult1.setFill(Color.WHITE);
        cult2 = new Text("2 Тыкваэлл");
        cult2.setFill(Color.WHITE);
        cult3 = new Text("3 Сонтрава");
        cult3.setFill(Color.WHITE);
        
        //Узлы текста для характеристик поля
        //namesOfParam = new Text("1)ID поля 2)Название поля 3)Площадь [м^2] 4)Вспахано ли 5)Наличие сорняков 6)Уровень влажности 7)Текущая культура 8)Посажено единиц 9)Урожайных единиц, готовых к сбору:");
        tfieldID = new Text("-----------");
        landName = new Text("-------------------");  
        area = new Text("---------------------");   
        hasPloved = new Text("---------------------"); ////
        weeds = new Text("------------------------");        
        soilMoisture = new Text("-------------------------");
        plant = new Text("-------------------");        
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
        // HBox hboxB6 = new HBox(8); // spacing = 8
        //hboxB6.getChildren().addAll(btn6);              
         HBox hboxTi = new HBox(8);
        hboxTi.getChildren().addAll(title);
         HBox hboxTe = new HBox(8);
        hboxTe.getChildren().addAll(text);
        
        HBox hboxC1 = new HBox(8);
        hboxC1.getChildren().addAll(cult1);
        HBox hboxC2 = new HBox(8);
        hboxC2.getChildren().addAll(cult2);
        HBox hboxC3 = new HBox(8);
        hboxC3.getChildren().addAll(cult3);

        HBox hboxParam = new HBox(8);
        hboxParam.getChildren().addAll(tfieldID, landName, area,  hasPloved, weeds, soilMoisture, plant, planted, crop);
        
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
        //hboxB6.setLayoutX(50.0);
        //hboxB6.setLayoutY(250.0);
        hboxTe.setLayoutX(400);
        hboxTe.setLayoutY(40);
        //hboxNames.setLayoutX(50);
        //hboxNames.setLayoutY(20);        
        hboxParam.setLayoutX(20);
        hboxParam.setLayoutY(20);

        hboxC1.setLayoutX(1030);
        hboxC1.setLayoutY(50);
        hboxC2.setLayoutX(1030);
        hboxC2.setLayoutY(120);
        hboxC3.setLayoutX(1030);
        hboxC3.setLayoutY(190);
        
        //Картинка и фоны
        put = new Image(getClass().getResource("Images/2022-12-18_17-02-10.png").toString());
        picture = new ImageView(put);  
        //изменение положения
        picture.setX(0); 
        picture.setY(0); 
        //масштабирование картинки фона
        picture.setPreserveRatio(true);
        picture.setFitWidth(1120);
        
        put1 = new Image(getClass().getResource("Images/2022-12-18_22-03-45.png").toString());
        picture1 = new ImageView(put1);  
        //изменение положения
        picture1.setX(950); 
        picture1.setY(50); 
        //масштабирование картинки фона
        picture1.setPreserveRatio(true);
        picture1.setFitWidth(70);
        
        put2 = new Image(getClass().getResource("Images/2022-12-18_22-02-54.png").toString());
        picture2 = new ImageView(put2);  
        //изменение положения
        picture2.setX(950); 
        picture2.setY(120); 
        //масштабирование картинки фона
        picture2.setPreserveRatio(true);
        picture2.setFitWidth(70);
        
        put3 = new Image(getClass().getResource("Images/2022-12-18_22-04-21.png").toString());
        picture3 = new ImageView(put3);  
        //изменение положения
        picture3.setX(950); 
        picture3.setY(190); 
        //масштабирование картинки фона
        picture3.setPreserveRatio(true);
        picture3.setFitWidth(70);
        
        Rectangle rect = new Rectangle(30, 40, 250, 270); // X Y ширина рост
        Color color1 = Color.rgb(0, 0, 50, 0.5);
        rect.setFill(color1);
        //rect.setX(30); 
        //rect.setY(40); 
        Rectangle rect1 = new Rectangle(930, 40, 200, 240); // X Y ширина рост
        rect1.setFill(color1);
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ProjSmartFarm.root.getChildren().addAll(hboxTi,hboxB1, 
                hboxB2, hboxB3, hboxB4, hboxB5, 
                hboxTe, picture, rect, rect1,
                picture1, picture2, picture3,  
                hboxC1, hboxC2, hboxC3,
                hboxParam);
        rect.toBack();
        picture.toBack();
        hboxParam.toFront();
        
            
        interactions();
    }
    
    private void interactions(){

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {             
                displayParametrs(tractor.plowing());
                text.setText("Команда отправлена Трактору-беспилотнику!");
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayParametrs(tractor.weeding());
                text.setText("Команда отправлена Культиватору Smart Farm!");
                
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int field;       
                field = Integer.parseInt(JOptionPane.showInputDialog("Выберите поле для орошения (1-2):"));
                if(field == 1) {
                    text.setText("Команда отправлена на Irrigation System 1");
                    land1.irrigation();
                    displayParametrs(land1);
                }
                else if(field == 2) {
                    text.setText("Команда отправлена на Irrigation System 1");
                    land2.irrigation();
                    displayParametrs(land2);
                }
            }
        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                text.setText("Команда отправлена Сеятельной машине!");
                displayParametrs(seedingMachine.seeding());
                //seedingMachine.checkCulture();
                /////////////надо получить вид растения
            }
        });
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int field = Integer.parseInt(JOptionPane.showInputDialog("Выберите поле (1-2):"));
                if (field == 1){
                    roboticHarvester.harvester(land1, land1.getPlant());
                    text.setText("Команда отправлена Роботизированному сборщику!");                   
                    displayParametrs(land1);
                    displayCultures();
                }
                else if (field == 2) {
                    roboticHarvester.harvester(land2, land2.getPlant());
                    text.setText("Команда отправлена Роботизированному сборщику!"); 
                    displayParametrs(land2);
                    displayCultures();
                }
            }
        });
        /*
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                text.setFill(Color.FIREBRICK);
                text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
                text.setText("Вы все равно в матрице!");
            }
        });*/
    }
    
    public void displayParametrs(AgriculturalLand land){ 
        text.setText("Актуальные характеристики");
        //////////////////как отобразить параметры
        //"1)ID поля 2)Название поля 3)Площадь [м^2] 4)Вспахано ли 5)Наличие сорняков 6)Уровень влажности 7)Текущая культура 8)Посажено единиц 9)Урожайных единиц, готовых к сбору:");
        
        tfieldID.setText("1)ID: "+((Integer)land.getFieldID()).toString()); //int в Integer в String
        
        landName.setText("2)Название: "+land.getLandName()); 
        
        area.setText("3)Площадь[м^2]: "+((Integer)land.getArea()).toString()); 
        
        if(land.isHasPloved() == true){
        hasPloved.setText("4)Вспахано ли: " + "+"); 
        }
        else{
        hasPloved.setText("4) Вспахано ли: " + "-"); 
        }    
                
        if(land.isWeeds() == true){
        weeds.setText("5)Сорняки: " + "есть"); 
        }
        else{
        weeds.setText("5)Сорняки: " + "нет"); 
        }
        
        soilMoisture.setText("6)Уровень влаги: " +((Double)land.getSoilMoisture()).toString());
        
        if(land.isHasAnythPlanted() == true){
            plant.setText("7)Текущая культура: " +(land.getPlant()).getNameOfPlant()); 
        }
        
        planted.setText("8)Посажено[ед]: " + ((Integer)land.getPlanted()).toString());   
        
        crop.setText("9)Готовый урожайн[ед]: "+((Integer)land.getCrop()).toString());
    
    }
    
    public void displayCultures(){ //Plants[] plants       
        cult1.setText(((Integer)plants[0].getSumCrop()).toString());
        cult2.setText(((Integer)plants[1].getSumCrop()).toString());
        cult3.setText(((Integer)plants[2].getSumCrop()).toString());
    }
    
    
}
