package ApalakthkhErgasiaJava.src.gui;

import java.util.List;
import ApalakthkhErgasiaJava.src.core.*;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class VehicleWindowScene extends SceneCreator implements EventHandler<MouseEvent>{
	GridPane rootGridPaneVehicle , inputFieldsPaneVehicle;
	FlowPane BottomButtonFlowVehicle;
	Button addVehicleBtn,showAllVehicleBtn,updateVehicleBtn,deleteVehicleBtn,backBtn,searchFieldBtn;
	Label modelLbl,searchLbl,licensePlateLbl,fuelTypeLbl,vehicleSizeLbl,cubismLbl,rentalCostLbl,doorNumLbl,seatNumLbl,seatHeightLbl,baggageTypeLbl;
	TextField modelField,licensePlateField,fuelTypeField,vehicleSizeField,cubismField,rentalCostField,doorNumField,seatNumField,seatHeightField,baggageTypeField;
	String comboSel[] = {"Car" , "Two Wheeled"};
	ComboBox selection = new ComboBox(FXCollections.observableArrayList(comboSel));
	ApplicationFx c = new ApplicationFx();
	
	public VehicleWindowScene(double width, double height) {
		super(width,height);
		
		selection.getSelectionModel().selectFirst();
		rootGridPaneVehicle = new GridPane();
		inputFieldsPaneVehicle = new GridPane();
		BottomButtonFlowVehicle = new FlowPane();
		//Buttons 
		addVehicleBtn = new Button("Add Vehicle");
		showAllVehicleBtn = new Button("Show All");
		updateVehicleBtn = new Button("Update");
		deleteVehicleBtn = new Button("Delete");
		searchFieldBtn = new Button("Search");
		backBtn = new Button("Back");
		//Labels
		licensePlateLbl = new Label("Licence Plate: ");
		modelLbl = new Label("Model: ");
		fuelTypeLbl = new Label("Fuel Type: ");
		vehicleSizeLbl = new Label("Vehicle Size: ");
		cubismLbl = new Label("Cubism: ");
		rentalCostLbl = new Label("Rental Cost: ");
		doorNumLbl = new Label("(Car only)Doors: ");
		seatNumLbl = new Label("(Car only)Seat Number: ");
		seatHeightLbl = new Label("(Two Wheeled only)Seat Height: ");
		baggageTypeLbl = new Label("(Two Wheeled only)baggage store Type:");
		//TextFields
		modelField = new TextField();
		modelField.anchorProperty();
		licensePlateField = new TextField();
		fuelTypeField = new TextField();
		vehicleSizeField = new TextField();
		cubismField = new TextField();
		rentalCostField = new TextField();
		doorNumField = new TextField();
		seatNumField = new TextField();
		seatHeightField = new TextField();
		baggageTypeField = new TextField();
		//Set Buttons to trace clicks
		addVehicleBtn.setOnMouseClicked(this);
		showAllVehicleBtn.setOnMouseClicked(this);
		updateVehicleBtn.setOnMouseClicked(this);
		deleteVehicleBtn.setOnMouseClicked(this);
		backBtn.setOnMouseClicked(this);
		searchFieldBtn.setOnMouseClicked(this);
		c.vehicleTableView.setOnMouseClicked(this);
		
		Image image = new Image(getClass().getResourceAsStream("Back_btn_Img.png"));
		backBtn.setGraphic(new ImageView(image));	
		
		//CHAOS
		BottomButtonFlowVehicle.setHgap(10);
		BottomButtonFlowVehicle.setVgap(10);
		BottomButtonFlowVehicle.setAlignment(Pos.BOTTOM_CENTER);
		BottomButtonFlowVehicle.getChildren().add(addVehicleBtn);
		BottomButtonFlowVehicle.getChildren().add(showAllVehicleBtn);
		BottomButtonFlowVehicle.getChildren().add(updateVehicleBtn);
		BottomButtonFlowVehicle.getChildren().add(deleteVehicleBtn);
		BottomButtonFlowVehicle.getChildren().add(searchFieldBtn);
		
		
		inputFieldsPaneVehicle.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPaneVehicle.setVgap(5);
		inputFieldsPaneVehicle.setHgap(5);
		inputFieldsPaneVehicle.add(modelField, 1, 1);
		inputFieldsPaneVehicle.add(licensePlateField, 1, 2);
		inputFieldsPaneVehicle.add(fuelTypeField, 1, 3);
		inputFieldsPaneVehicle.add(vehicleSizeField, 1, 4);
		inputFieldsPaneVehicle.add(cubismField, 1, 5);
		inputFieldsPaneVehicle.add(rentalCostField, 1, 6);
		inputFieldsPaneVehicle.add(seatNumField,1,8);
		inputFieldsPaneVehicle.add(doorNumField,1,7);
		inputFieldsPaneVehicle.add(seatHeightField,1,9);
		inputFieldsPaneVehicle.add(baggageTypeField,1,10);
		inputFieldsPaneVehicle.add(selection,1,11);
		
		inputFieldsPaneVehicle.add(modelLbl,0,1);
		inputFieldsPaneVehicle.add(licensePlateLbl,0,2);
		inputFieldsPaneVehicle.add(fuelTypeLbl,0,3);
		inputFieldsPaneVehicle.add(vehicleSizeLbl,0,4);
		inputFieldsPaneVehicle.add(cubismLbl,0,5);
		inputFieldsPaneVehicle.add(rentalCostLbl,0,6);
		inputFieldsPaneVehicle.add(doorNumLbl, 0, 7);
		inputFieldsPaneVehicle.add(seatNumLbl, 0, 8);
		inputFieldsPaneVehicle.add(searchFieldBtn, 0, 11);
		inputFieldsPaneVehicle.add(seatHeightLbl,0,9);
		inputFieldsPaneVehicle.add(baggageTypeLbl,0,10);
		
		
		rootGridPaneVehicle.setHgap(30);
		rootGridPaneVehicle.setVgap(5);
		rootGridPaneVehicle.add(BottomButtonFlowVehicle, 0, 1);
		rootGridPaneVehicle.add(inputFieldsPaneVehicle, 1, 0);
		rootGridPaneVehicle.add(c.vehicleTableView, 0, 0);
		rootGridPaneVehicle.add(backBtn, 1, 1);
		
		//Setting background color to something really ugly but still better than other colors
		 BackgroundFill myBF = new BackgroundFill(Color.ALICEBLUE, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		    rootGridPaneVehicle.setBackground(new Background(myBF));
		
		
		TableColumn<Vehicle, String> brandColumn = new TableColumn("Model");
		brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
		c.vehicleTableView.getColumns().add(brandColumn);
		
		
		TableColumn<Vehicle, String> licensePlateColumn = new TableColumn("license Plate");
		licensePlateColumn.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
		c.vehicleTableView.getColumns().add(licensePlateColumn);
		
		
		TableColumn<Vehicle, String> fuelPoweredColumn = new TableColumn("Fuel Type");
		fuelPoweredColumn.setCellValueFactory(new PropertyValueFactory<>("fuelPowered"));
		c.vehicleTableView.getColumns().add(fuelPoweredColumn);
		
		TableColumn<Vehicle, String> vehicleTypeColumn = new TableColumn("Vehicle Size");	
		vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
		c.vehicleTableView.getColumns().add(vehicleTypeColumn);

		TableColumn<Vehicle, String> cubismColumn = new TableColumn("Cubism");
		cubismColumn.setCellValueFactory(new PropertyValueFactory<>("cubism"));
		c.vehicleTableView.getColumns().add(cubismColumn);
		
		TableColumn<Vehicle, String> rentalCostColumn = new TableColumn("rental Cost");
		rentalCostColumn.setCellValueFactory(new PropertyValueFactory<>("rentalCost"));
		c.vehicleTableView.getColumns().add(rentalCostColumn);
		
		TableColumn<Vehicle, String> baggageTypeColumn = new TableColumn("Baggage Type");
		baggageTypeColumn.setCellValueFactory(new PropertyValueFactory<>("baggageType"));
		c.vehicleTableView.getColumns().add(baggageTypeColumn);
		
		TableColumn<Vehicle, String> seatHeightColumn = new TableColumn("Seat Height");	
		seatHeightColumn.setCellValueFactory(new PropertyValueFactory<>("seatHeight"));
		c.vehicleTableView.getColumns().add(seatHeightColumn);
		
		TableColumn<Vehicle, String> seatNumberColumn = new TableColumn("Seat Number");
		seatNumberColumn.setCellValueFactory(new PropertyValueFactory<>("seatNum"));
		c.vehicleTableView.getColumns().add(seatNumberColumn);
		
		TableColumn<Vehicle, String> doorNumberColumn = new TableColumn("Door Number");
		doorNumberColumn.setCellValueFactory(new PropertyValueFactory<>("doorNum"));
		c.vehicleTableView.getColumns().add(doorNumberColumn);
		
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getSource() == addVehicleBtn) {
			if(selection.getValue() == "Car" && !(modelField.getText().isEmpty())&& !(licensePlateField.getText().isEmpty()) && !(fuelTypeField.getText().isEmpty()) && !(vehicleSizeField.getText().isEmpty()) 
			&& !(cubismField.getText().isEmpty()) && !(rentalCostField.getText().isEmpty()) && !(doorNumField.getText().isEmpty()) && !(seatNumField.getText().isEmpty())) 
			{
				createCar(licensePlateField.getText(),modelField.getText(),fuelTypeField.getText(),vehicleSizeField.getText(),cubismField.getText(),rentalCostField.getText(),seatNumField.getText(),doorNumField.getText());
				tableSync();
				clearTextFields();
			}
			else if (selection.getValue() == "Two Wheeled" && !(modelField.getText().isEmpty())&& !(licensePlateField.getText().isEmpty()) && !(fuelTypeField.getText().isEmpty()) && !(vehicleSizeField.getText().isEmpty()) 
			&& !(cubismField.getText().isEmpty()) && !(rentalCostField.getText().isEmpty()) && !(baggageTypeField.getText().isEmpty()) && !(seatHeightField.getText().isEmpty())) 
			{
				createTwoWheeled(licensePlateField.getText(),modelField.getText(),fuelTypeField.getText(),vehicleSizeField.getText(),cubismField.getText(),seatHeightField.getText(),baggageTypeField.getText(),rentalCostField.getText());
				tableSync();
				clearTextFields();
			}
		}
		if(event.getSource() == backBtn) {
			ApplicationFx.mainStage.setTitle("Car Rental Service");
			ApplicationFx.mainStage.setScene(ApplicationFx.centerScene);
		}
		if(event.getSource() == searchFieldBtn) {
			if(selection.getValue() == "Car") {
				searchCar();
			}
			else if (selection.getValue() == "Two Wheeled") {
				searchTwoWheeled();
			}
		}
		if (event.getSource() == showAllVehicleBtn) {
			tableSync();
			clearTextFields();
		}
		if (event.getSource() == c.vehicleTableView) {
			Vehicle selectedVehicle = c.vehicleTableView.getSelectionModel().getSelectedItem();
			if(selectedVehicle != null) {
				modelField.setText(selectedVehicle.getBrand());
				licensePlateField.setText(selectedVehicle.getLicensePlate());
				fuelTypeField.setText(selectedVehicle.getFuelPowered());
				vehicleSizeField.setText(selectedVehicle.getVehicleType());
				cubismField.setText(String.valueOf(selectedVehicle.getCubism()));
				rentalCostField.setText(String.valueOf(selectedVehicle.getRentalCost()));
				if(selectedVehicle instanceof Car) {
					seatNumField.setText(String.valueOf(((Car) selectedVehicle).getSeatNum()));
					doorNumField.setText(String.valueOf(((Car) selectedVehicle).getDoorNum()));
				}
				else if(selectedVehicle instanceof TwoWheeled) {
					seatHeightField.setText(String.valueOf(((TwoWheeled) selectedVehicle).getSeatHeight()));
					baggageTypeField.setText(((TwoWheeled) selectedVehicle).getBaggageType());
				}
			}
		}
		if(event.getSource() == updateVehicleBtn) {
			updateVehicle();
			tableSync();
			clearTextFields();
		}
		if(event.getSource() == deleteVehicleBtn) {
			Vehicle selectedVehicle = c.vehicleTableView.getSelectionModel().getSelectedItem();
			Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete the selected Vehicle ?", ButtonType.YES, ButtonType.NO);
			alert.showAndWait();
			if(selectedVehicle != null) {
				if(alert.getResult() == ButtonType.YES) {
					ApplicationFx.vehicleList.remove(selectedVehicle);
					tableSync();
					clearTextFields();
				}
				else {
					clearTextFields();
				}
			}
			
		}
	}
	
	public void clearTextFields() {
		modelField.setText("");
		licensePlateField.setText("");
		fuelTypeField.setText("");
		vehicleSizeField.setText("");
		cubismField.setText("");
		rentalCostField.setText("");
		doorNumField.setText("");
		seatNumField.setText("");
		seatHeightField.setText("");
		baggageTypeField.setText("");
		selection.getSelectionModel().selectFirst();
	}
	public void tableSync() {
		List<Vehicle> items = c.vehicleTableView.getItems();
		items.clear();
		for (int i=0;i<ApplicationFx.vehicleList.size();i++) {
			if(ApplicationFx.vehicleList.get(i) instanceof TwoWheeled) {
				items.add(ApplicationFx.vehicleList.get(i));
			}
			else if(ApplicationFx.vehicleList.get(i) instanceof Car) {
				items.add(ApplicationFx.vehicleList.get(i));
			}
		}
	}
	public void updateVehicle() {
		Vehicle selectedVehicle = c.vehicleTableView.getSelectionModel().getSelectedItem();
		//Checking if the given String can be converted to integer or if the user has provided wrong data
		try {
			selectedVehicle.setCubism(Integer.parseInt(cubismField.getText()));
			
		}
		catch(NumberFormatException inputMismatchException) {
			System.err.printf( "\nException: %s\n",inputMismatchException);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
			alert.showAndWait();
		}
		
		try {
			selectedVehicle.setRentalCost(Integer.parseInt(rentalCostField.getText()));
		}
		catch(NumberFormatException inputMismatchException) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
			alert.showAndWait();
		}
		selectedVehicle.setBrand(modelField.getText());
		selectedVehicle.setFuelPowered(fuelTypeField.getText());
		selectedVehicle.setVehicleType(vehicleSizeField.getText());
		//If the selected objects is Car or Vehicle filling the fields with given data
		if(selectedVehicle instanceof Car) {
			try {
				((Car) selectedVehicle).setSeatNum(Integer.parseInt(seatNumField.getText()));
				
			}
			catch(NumberFormatException inputMismatchException) {
				System.err.printf( "\nException: %s\n",inputMismatchException);
				Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
				alert.showAndWait();
			}
			
			try {
				((Car) selectedVehicle).setDoorNum(Integer.parseInt(doorNumField.getText()));
			}
			catch(NumberFormatException inputMismatchException) {
				Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
				alert.showAndWait();
			}
		}
		else if(selectedVehicle instanceof TwoWheeled) {
			try {
				((TwoWheeled) selectedVehicle).setSeatHeight(Integer.parseInt(seatHeightField.getText()));
				
			}
			catch(NumberFormatException inputMismatchException) {
				System.err.printf( "\nException: %s\n",inputMismatchException);
				Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
				alert.showAndWait();
			}
			((TwoWheeled) selectedVehicle).setBaggageType(baggageTypeField.getText());
		}
	}
	public void createTwoWheeled(String model,String plateNum,String fuelType,String vehicleSize,String cubism,String rentalCost,String seatHeight,String baggageType) {
		int c,r;
		float s;
		try {
			
				c = Integer.parseInt(cubism);
				r = Integer.parseInt(rentalCost);
				s = Float.parseFloat(seatHeight);
				for (Vehicle vehicle : ApplicationFx.vehicleList) {
			        if (vehicle.getLicensePlate().equals(plateNum)) 
			        	return ;
			    }
				ApplicationFx.vehicleList.add(new TwoWheeled(plateNum,model,fuelType,vehicleSize,c,s,baggageType,r));
				
		}
		catch (NumberFormatException inputMismatchException){
			System.err.printf("\nException: %s\n",inputMismatchException);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
			alert.showAndWait();
		}
	}
	public void createCar(String plateNum,String model,String fuelType,String vehicleSize,String cubism,String rentalCost,String seatNum,String doorNum) {
		int c,r,s,d;	
		try 
			{
				c = Integer.parseInt(cubism);
				r = Integer.parseInt(rentalCost);
				s = Integer.parseInt(seatNum);
				d = Integer.parseInt(doorNum);
				for (Vehicle vehicle : ApplicationFx.vehicleList) {
			        if (vehicle.getLicensePlate().equals(plateNum)) 
			        	return ;
			    }
				ApplicationFx.vehicleList.add(new Car(model,plateNum,fuelType,vehicleSize,c,r,s,d));
			}
			catch( NumberFormatException inputMismatchException)
			{
				System.err.printf( "\nException: %s\n",inputMismatchException);
				Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
				alert.showAndWait();
			}
		
	}
	public void searchCar() {
		List<Vehicle> items = c.vehicleTableView.getItems();
		items.clear();
			for(Vehicle car : ApplicationFx.vehicleList) {
					if(car instanceof Car) {
							items.add((Car) car);
					}
			}
	}
	public void searchTwoWheeled() {
		List<Vehicle> items =  c.vehicleTableView.getItems();
		items.clear();
		for(Vehicle twoWheeled : ApplicationFx.vehicleList) {
			if(twoWheeled instanceof TwoWheeled) {
					items.add((TwoWheeled) twoWheeled);
			}
		}
	}
	
	@Override
	Scene createScene() {
		return new Scene(rootGridPaneVehicle,width,height);
	}
}
