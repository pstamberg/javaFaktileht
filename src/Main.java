import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
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



        Scene saidSisse = new Scene(panesees, 600, 500);

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
