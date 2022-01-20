package ApalakthkhErgasiaJava.src.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class CenterWindowScene extends SceneCreator implements EventHandler<MouseEvent> {
	GridPane rootGridPane;
	Pane root;
    
	Button citiesBtn,storesBtn,clientsBtn,vehiclesBtn,vehicleRentalBtn;
	public CenterWindowScene() {}
	
	public CenterWindowScene(double width, double height) {
		super(width, height);
		
		rootGridPane = new GridPane();
		//Button text
		citiesBtn = new Button("Cities");
	    storesBtn = new Button("Store");	
	    clientsBtn = new Button("Client");
	    vehiclesBtn = new Button("Vehicles ");
	    vehicleRentalBtn = new Button("Rented Vehicles");
	    //Adding images to buttons
	    Image image = new Image(getClass().getResourceAsStream("Store_Btn_Img.png"));
		storesBtn.setGraphic(new ImageView(image));		
		
		Image image2 = new Image(getClass().getResourceAsStream("Cities_btn_img.png"));
	    citiesBtn.setGraphic(new ImageView(image2));	
		
	    Image image3 = new Image(getClass().getResourceAsStream("Clients_btn_img.png"));
	    clientsBtn.setGraphic(new ImageView(image3));	
	    
	    Image image4 = new Image(getClass().getResourceAsStream("Vehicles_btn_img.png"));
	    vehiclesBtn.setGraphic(new ImageView(image4));	
	    
	    Image image5 = new Image(getClass().getResourceAsStream("RentVehicles_btn_img.png"));
	    vehicleRentalBtn.setGraphic(new ImageView(image5));
	    
	    
	    citiesBtn.setOnMouseClicked(this);
	    storesBtn.setOnMouseClicked(this);
	    clientsBtn.setOnMouseClicked(this);
	    vehiclesBtn.setOnMouseClicked(this);
	    vehicleRentalBtn.setOnMouseClicked(this);
	    //Setting background Color
	    BackgroundFill myBF = new BackgroundFill(Color.ALICEBLUE, new CornerRadii(1),
	            new Insets(0.0,0.0,0.0,0.0));
	    rootGridPane.setBackground(new Background(myBF));
	    //Setting button sizes
	    citiesBtn.setPrefSize(100, 50);
	    storesBtn.setPrefSize(100, 50);
	    clientsBtn.setPrefSize(100, 50);
	    vehiclesBtn.setPrefSize(100, 50);
	    vehicleRentalBtn.setPrefSize(145, 50);
	    RowConstraints con = new RowConstraints();
	    con.setPrefHeight(40);
	    rootGridPane.getRowConstraints().add(con);
	    rootGridPane.setAlignment(Pos.CENTER);
	    //making a root Pane to add all the required elements in the required coordinates(x,y)
	    root = new Pane();
	    vehicleRentalBtn.setLayoutX(148);
	    vehicleRentalBtn.setLayoutY(35);
	    root.getChildren().add(vehicleRentalBtn);
	    
	    citiesBtn.setLayoutX(0);
	    citiesBtn.setLayoutY(-25);
	    root.getChildren().add(citiesBtn);
	    
	    storesBtn.setLayoutX(110);
	    storesBtn.setLayoutY(-25);
	    root.getChildren().add(storesBtn);
	    
	    clientsBtn.setLayoutX(220);
	    clientsBtn.setLayoutY(-25);
	    root.getChildren().add(clientsBtn);
	    
	    vehiclesBtn.setLayoutX(330);
	    vehiclesBtn.setLayoutY(-25);
	    root.getChildren().add(vehiclesBtn);
	    
	    
	    rootGridPane.getChildren().add(root);
	    
	}
	
	
	
	@Override
	Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}

	@Override
	public void handle(MouseEvent event) {
		//Actions to take when each button is pressed
		if(event.getSource() == citiesBtn) {
			ApplicationFx.mainStage.setTitle("Cities Window");
			ApplicationFx.mainStage.setScene(ApplicationFx.citiesScene);
		}
		if(event.getSource() == storesBtn) {
			ApplicationFx.mainStage.setTitle("Store Window");
			ApplicationFx.mainStage.setScene(ApplicationFx.storeScene);
		}
		if(event.getSource() == vehiclesBtn) {
			ApplicationFx.mainStage.setTitle("Vehicles Window");
			ApplicationFx.mainStage.setScene(ApplicationFx.vehicleScene);
		}
		if(event.getSource() == clientsBtn) {
			ApplicationFx.mainStage.setTitle("Clients Window");
			ApplicationFx.mainStage.setScene(ApplicationFx.clientScene);
		}
		if(event.getSource() == vehicleRentalBtn) {
			ApplicationFx.mainStage.setTitle("Vehicle Rental Window");
			ApplicationFx.mainStage.setScene(ApplicationFx.rentalScene);
		}
	}

}
