package ApalakthkhErgasiaJava.src.gui;

import javafx.event.EventHandler;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.time.temporal.ChronoUnit;
import ApalakthkhErgasiaJava.src.core.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

public class RentalWindowScene extends SceneCreator implements EventHandler<MouseEvent>  {
	GridPane rootGridPane , inputFieldsPane;
	FlowPane BottomButtonFlow;
	Button cancelRentBtn,addRentBtn,showAllRentBtn,backBtn;
	TextField totalCostField,rentedVehicleLisenceField,rentedToNameField,getFromStoreField,returnToStoreField,rentDateField,returnDateField;
	Label  totalCostLbl,rentedVehicleLbl,rentedToNameLbl,getFromStoreLbl,returnToStoreLbl,rentDateLbl,returnDateLbl;
	ApplicationFx c = new ApplicationFx();
	public RentalWindowScene(double width,double height) {
		super(width,height);
		
		rootGridPane = new GridPane();
		inputFieldsPane = new GridPane();
		BottomButtonFlow = new FlowPane();
		
		cancelRentBtn = new Button("Cancel");
		addRentBtn = new Button("Add to Rentals");
		showAllRentBtn = new Button("Show All");
		backBtn = new Button("Back");
		
		
		totalCostField = new TextField();
		rentedVehicleLisenceField = new TextField();
		rentedToNameField = new TextField();
		getFromStoreField = new TextField();
		returnToStoreField = new TextField();
		rentDateField = new TextField();
		returnDateField = new TextField();
		
		totalCostLbl = new Label("Total Cost: ");
		rentedVehicleLbl = new Label("License Plate number: ");
		rentedToNameLbl = new Label("Name Of leaseholder: ");
		getFromStoreLbl = new Label("Receipt Store: ");
		returnToStoreLbl = new Label("Return Store: ");
		rentDateLbl = new Label("(dd/MM/yyyy) Lease Date: ");
		returnDateLbl = new Label("(dd/MM/yyyy) Return Date: ");
		
		cancelRentBtn.setOnMouseClicked(this);
		addRentBtn.setOnMouseClicked(this);
		showAllRentBtn.setOnMouseClicked(this);
		backBtn.setOnMouseClicked(this);
		
		Image image = new Image(getClass().getResourceAsStream("Back_btn_Img.png"));
		backBtn.setGraphic(new ImageView(image));	
		
		BottomButtonFlow.setHgap(10);
		BottomButtonFlow.getChildren().add(addRentBtn);
		BottomButtonFlow.getChildren().add(showAllRentBtn);
		BottomButtonFlow.getChildren().add(cancelRentBtn);
		BottomButtonFlow.setAlignment(Pos.BOTTOM_CENTER);
		
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(25);
		inputFieldsPane.setHgap(5);
		
		inputFieldsPane.add(totalCostField, 1, 1);
		inputFieldsPane.add(rentedVehicleLisenceField, 1, 2);
		inputFieldsPane.add(rentedToNameField, 1, 3);
		inputFieldsPane.add(getFromStoreField, 1, 4);
		inputFieldsPane.add(returnToStoreField, 1, 5);
		inputFieldsPane.add(rentDateField, 1, 6);
		inputFieldsPane.add(returnDateField, 1, 7);
		
		inputFieldsPane.add(totalCostLbl, 0, 1);
		inputFieldsPane.add(rentedVehicleLbl, 0, 2);
		inputFieldsPane.add(rentedToNameLbl, 0, 3);
		inputFieldsPane.add(getFromStoreLbl, 0, 4);
		inputFieldsPane.add(returnToStoreLbl, 0, 5);
		inputFieldsPane.add(rentDateLbl,0, 6);
		inputFieldsPane.add(returnDateLbl, 0, 7);
		
		
		rootGridPane.setVgap(15);
		rootGridPane.setHgap(15);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(c.rentalTableView, 0, 0);
		rootGridPane.add(BottomButtonFlow, 0, 1);
		rootGridPane.add(backBtn, 1, 1);
		
		 BackgroundFill myBF = new BackgroundFill(Color.ALICEBLUE, new CornerRadii(1),
		            new Insets(0.0,0.0,0.0,0.0));
		    rootGridPane.setBackground(new Background(myBF));
		    
		    TableColumn<Rental, String> totalCostColumn = new TableColumn("Total Cost");
		    totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("TotalCost"));
			c.rentalTableView.getColumns().add(totalCostColumn);
			
			TableColumn<Rental, String> rentedVehicleColumn = new TableColumn("Licence Plate");
			rentedVehicleColumn.setCellValueFactory(new PropertyValueFactory<>("RentedVehicle"));
			c.rentalTableView.getColumns().add(rentedVehicleColumn);
			
			TableColumn<Rental, String> nameColumn = new TableColumn("Name");
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("RentedToName"));
			c.rentalTableView.getColumns().add(nameColumn);
			
			TableColumn<Rental, String> leaseStoreColumn = new TableColumn("Lease Store");
			leaseStoreColumn.setCellValueFactory(new PropertyValueFactory<>("GetFromStore"));
			c.rentalTableView.getColumns().add(leaseStoreColumn);
			
			TableColumn<Rental, String> returnToStoreColumn = new TableColumn("Return Store");
			returnToStoreColumn.setCellValueFactory(new PropertyValueFactory<>("ReturnToStore"));
			c.rentalTableView.getColumns().add(returnToStoreColumn);
			
			TableColumn<Rental, String> RentDateColumn = new TableColumn("Lease Date");
			RentDateColumn.setCellValueFactory(new PropertyValueFactory<>("RentDate"));
			c.rentalTableView.getColumns().add(RentDateColumn);
			
			TableColumn<Rental, String> ReturnDateColumn = new TableColumn("Return Date");
			ReturnDateColumn.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
			c.rentalTableView.getColumns().add(ReturnDateColumn);
			
			
		    
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getSource() == c.rentalTableView) {
			Rental selection = c.rentalTableView.getSelectionModel().getSelectedItem();
				rentedVehicleLisenceField.setText(String.valueOf(selection.getRentedVehicle()));
				rentedToNameField.setText(selection.getRentedToName());
				getFromStoreField.setText(selection.getGetFromStore());
				returnToStoreField.setText(selection.getReturnToStore());
				rentDateField.setText(selection.getRentDate().toString());
				returnDateField.setText(selection.getReturnDate().toString());
				totalCostField.setText(String.valueOf(selection.getTotalCost()));
		}
		if(event.getSource() == backBtn) {
			ApplicationFx.mainStage.setTitle("Car Rental Service");
			ApplicationFx.mainStage.setScene(ApplicationFx.centerScene);
		}
		if(event.getSource() == addRentBtn) {
			try {
				createRentalVehicle();
				tableSync();
				clearTextFields();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		}
		if(event.getSource() == showAllRentBtn) {
			tableSync();
		}
		if(event.getSource()== cancelRentBtn) {
			//taking the selected objects date and converting it to LocalDate type then checking days between objects date and current date and saving the output to a long variable
			//the checking if the output is between 0 and 2 and if so canceling the rent without extra cost
			Rental selection = c.rentalTableView.getSelectionModel().getSelectedItem();
			if(selection != null) {
				LocalDate localDate2 = selection.getRentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.now(),localDate2);
				if(noOfDaysBetween <= 2 && noOfDaysBetween >=0) {
					Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to cancel the selected rent without any extra cost?", ButtonType.YES, ButtonType.NO);
					alert.showAndWait();
					if(alert.getResult() == ButtonType.YES) {
						ApplicationFx.rentalList.remove(selection);	
						tableSync();
						clearTextFields();
					}
				}
				//checking if the user is trying to cancel a rent that is already expired
				else if(noOfDaysBetween <0){
					Alert alert = new Alert(AlertType.CONFIRMATION, "You cant cancel selected rent because its past due time", ButtonType.OK);
					alert.showAndWait();
					if(alert.getResult() == ButtonType.OK) {
						tableSync();
						clearTextFields();
					}
				}
				else {
					Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to cancel the selected rent? (extra cost will be added)", ButtonType.YES, ButtonType.NO);
					alert.showAndWait();
					if(alert.getResult() == ButtonType.YES) {
						ApplicationFx.rentalList.remove(selection);	
						tableSync();
						clearTextFields();
					}
				}
			}
		}
		
	}
	
	public void clearTextFields() {
		rentedVehicleLisenceField.setText("");
		rentedToNameField.setText("");
		getFromStoreField.setText("");
		returnToStoreField.setText("");
		rentDateField.setText("");
		returnDateField.setText("");
		totalCostField.setText("");
	}
	public void tableSync() {
		List<Rental> items = c.rentalTableView.getItems();
		items.clear();
		for (Rental c : ApplicationFx.rentalList) {
			if(c instanceof Rental) {
			items.add(c);
				
			}
		}
	}
	public void createRentalVehicle() throws ParseException {
		
		//validating user input in case its of the wrong data type and checking if provided vehicle,client,store exist
		try {
			boolean info1 = false,info2 = false,info3 = false,info4 = false;
			
			int t,licensePlateNum;
			licensePlateNum = Integer.parseInt(rentedVehicleLisenceField.getText());
			t = Integer.parseInt(totalCostField.getText());
			for (Vehicle vehicle : ApplicationFx.vehicleList) {
				int lic = Integer.parseInt(vehicle.getLicensePlate());
		        if (lic == licensePlateNum) 
		        	info1 = true;
		    }
			for (Client client : ApplicationFx.clientsList) {
		        if (client.getClientName().equals(rentedToNameField.getText())) 
		        	info2 = true;
		    }
			for(Store store : ApplicationFx.storeArrayList) {
				if (store.getBrand().equals(getFromStoreField.getText())) 
					info3 = true;
			}
			for(Store store : ApplicationFx.storeArrayList) {
				if (store.getBrand().equals(returnToStoreField.getText())) 
					info4 = true;
			}
			
			if(info1 == true && info2 == true && info3 == true && info4 == true)
			ApplicationFx.rentalList.add(new Rental(t,licensePlateNum,rentedToNameField.getText(),getFromStoreField.getText(),returnToStoreField.getText(),rentDateField.getText()
					,returnDateField.getText()));
			
		}
		catch(NumberFormatException inputMismatchException) {
			System.out.printf("\nException: %s\n",inputMismatchException);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
			alert.showAndWait();
		}
	}
	
	@Override
	Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}

}
