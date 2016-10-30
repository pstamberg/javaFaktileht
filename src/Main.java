import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String args[]){
        System.out.println("Projekt: faktileht algus");
    	System.out.println("autor:Peeter");
        System.out.println("aasta: 2016 oktoober 12. test kas see toimib");
        System.out.println("kas alla ka oskab siit tõmmata");
        System.out.println("tegeleme FXga ka nüüd");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pealeht");

        VBox vbox = new VBox();
        Scene login = new Scene(vbox, 100, 100);
        primaryStage.setScene(login);

        Label pealkiri = new Label("Mis on parool");
        TextField paroolField = new TextField();
        Button submitButton = new Button("Login");


// kui oled sees siis selline stseen
        BorderPane panesees = new BorderPane();

        // kas tuleb
        HBox hbox = new HBox();
        panesees.setBottom(hbox);


        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);
        Button buttonProjected = new Button("See ei tee sedagi");
        buttonCurrent.setPrefSize(300, 20);
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        //katse lõppe

        //vboxi lisamine ka, et näha kuidas see käib
        VBox vertbox= new VBox();
        vertbox.setPadding(new Insets(10));
        vertbox.setSpacing(8);

        Text pealk = new Text("Andmed");
        pealk.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vertbox.getChildren().add(pealkiri);

        Hyperlink options[] = new Hyperlink[] {
                new Hyperlink("Portfellid"),
                new Hyperlink("Instrumendid"),
                new Hyperlink("Muud")};

        for (int i=0; i<3; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vertbox.getChildren().add(options[i]);
            }
        panesees.setLeft(vertbox); // lisab vertikaalse boxi

        //vboxi kaste lõpp

        // Flow pane
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); //mahutb 2 tulpa
        flow.setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[8];
        for (int i = 0; i < 8; i++) {
            pages[i] = new ImageView(
                    new Image(Main.class.getResourceAsStream("Ikoonid/chart_"+(i+1)+".png")));
            flow.getChildren().add(pages[i]);


        }
        panesees.setRight(flow);
        //flow pane lõpp

        Scene saidSisse = new Scene(panesees, 1000, 1000);

        buttonCurrent.setText("See ei tee suurt midagi");
        buttonCurrent.setOnMouseClicked(event ->{
            System.out.println("tegidki nii");

        });
// sees stseeni lõpp


        vbox.getChildren().addAll(pealkiri, paroolField, submitButton);

        //logimine ka Enteriga
        paroolField.setOnKeyPressed(event ->{
            if(event.getCode() == KeyCode.ENTER){
                String parool = paroolField.getText();

                if (parool.equals("q")){
                    System.out.println("Tubli");
                    primaryStage.setScene(saidSisse);
            }else {
                    System.out.println("VALE!!!");
                }
            }
        });
        //enteriga sisenemise lõpp

        submitButton.setOnAction(event ->{
            String parool = paroolField.getText();
            if (parool.equals("qwerty")){
                System.out.println("Tubli");
                primaryStage.setScene(saidSisse);
            } else {
                System.out.println("VALE!!!");
            }

        });
/*

        StackPane saidSisse = new StackPane();


        Scene scene = new Scene(saidSisse, 400, 400);
        primaryStage.setScene(scene);

        Button button = new Button();

        button.setText("Klikii");
        button.setOnMouseClicked(event ->{
            System.out.println("tegidki nii");
        });
        layout.getChildren().add(button);
        */

        primaryStage.show();
    }
}
