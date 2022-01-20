package ApalakthkhErgasiaJava.src.gui;

import java.util.List;
import ApalakthkhErgasiaJava.src.core.*;
import javafx.event.EventHandler;
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

public class ClientWindowScene extends SceneCreator implements EventHandler<MouseEvent>{
	GridPane rootGridPane , inputFieldsPane;
	FlowPane BottomButtonFlow;
	
	Button addClientBtn,showAllBtn,searchBtn,deleteBtn,updateBtn,backBtn;
	Label IdLbl,clientLicenseNumLbl,clientNameLbl,clientSurnameLbl,clientEmailLbl,clientAddressLbl,clientPhoneNumLbl;
	TextField IdField,clientLicenseNumField,clientNameField,clientSurnameField,clientEmailField,clientAddressField,clientPhoneNumField;
	ApplicationFx c = new ApplicationFx();
	
	public ClientWindowScene(double width,double height) {
		super(width,height);
		//Setting up panes,buttons etc.
		rootGridPane = new GridPane();
		inputFieldsPane = new GridPane();
		BottomButtonFlow = new FlowPane();
		
		addClientBtn = new Button("Add Client");
		showAllBtn = new Button("Show All");
		searchBtn = new Button("Search");
		deleteBtn = new Button("Delete");
		updateBtn = new Button("Update Client");
		backBtn = new Button("Back");
		
		
		IdLbl = new Label("ID: ");
		clientLicenseNumLbl = new Label("License Number: ");
		clientNameLbl = new Label("Name: ");
		clientSurnameLbl = new Label("Surname: ");
		clientEmailLbl = new Label("Email: ");
		clientAddressLbl = new Label("Address: ");
		clientPhoneNumLbl = new Label("Phone Number: ");
		
		IdField = new TextField();
		clientLicenseNumField = new TextField();
		clientNameField = new TextField();
		clientSurnameField = new TextField();
		clientEmailField = new TextField();
		clientAddressField = new TextField();
		clientPhoneNumField = new TextField();
		
		BottomButtonFlow.setHgap(15);
		BottomButtonFlow.getChildren().add(addClientBtn);
		BottomButtonFlow.getChildren().add(showAllBtn);
		BottomButtonFlow.getChildren().add(updateBtn);
		BottomButtonFlow.getChildren().add(deleteBtn);
		BottomButtonFlow.setAlignment(Pos.BOTTOM_CENTER);
		
		c.clientTableView.setOnMouseClicked(this);
		addClientBtn.setOnMouseClicked(this);
		showAllBtn.setOnMouseClicked(this);
		searchBtn.setOnMouseClicked(this);
		deleteBtn.setOnMouseClicked(this);
		updateBtn.setOnMouseClicked(this);
		backBtn.setOnMouseClicked(this);
		//adding image to back button
		Image image = new Image(getClass().getResourceAsStream("Back_btn_Img.png"));
		backBtn.setGraphic(new ImageView(image));	
		
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(25);
		inputFieldsPane.setHgap(5);
		//placing fields,labels to the fieldPane
		inputFieldsPane.add(IdField, 1, 1);
		inputFieldsPane.add(clientLicenseNumField, 1, 2);
		inputFieldsPane.add(clientNameField, 1, 3);
		inputFieldsPane.add(clientSurnameField, 1, 4);
		inputFieldsPane.add(clientEmailField, 1, 5);
		inputFieldsPane.add(clientAddressField, 1, 6);
		inputFieldsPane.add(clientPhoneNumField, 1, 7);
		
		inputFieldsPane.add(IdLbl, 0, 1);
		inputFieldsPane.add(clientLicenseNumLbl, 0, 2);
		inputFieldsPane.add(clientNameLbl, 0, 3);
		inputFieldsPane.add(clientSurnameLbl, 0, 4);
		inputFieldsPane.add(clientEmailLbl, 0, 5);
		inputFieldsPane.add(clientAddressLbl, 0, 6);
		inputFieldsPane.add(clientPhoneNumLbl, 0, 7);
		inputFieldsPane.add(searchBtn, 0, 8);
		
		
		rootGridPane.setVgap(15);
		rootGridPane.setHgap(15);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(c.clientTableView, 0, 0);
		rootGridPane.add(BottomButtonFlow, 0, 1);
		rootGridPane.add(backBtn, 1, 1);
		//setting background color
		BackgroundFill myBF = new BackgroundFill(Color.ALICEBLUE, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		rootGridPane.setBackground(new Background(myBF));
		//creating columns in tableView and setting from which getter to get the needed data
		TableColumn<Client, String> idColumn = new TableColumn("Client ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("clientId"));
		c.clientTableView.getColumns().add(idColumn);
		
		TableColumn<Client, String> licenseColumn = new TableColumn("Licence");
		licenseColumn.setCellValueFactory(new PropertyValueFactory<>("clientLicenceNum"));
		c.clientTableView.getColumns().add(licenseColumn);
		
		
	}
	@Override
	Scene createScene() {
		return new Scene(rootGridPane , width, height);
	}

	@Override
	public void handle(MouseEvent event) {
		if(event.getSource() == c.clientTableView) {
			//Checking user selection on the tableView and filling the fields based on the selected objects details
			Client selection = c.clientTableView.getSelectionModel().getSelectedItem();
			if(selection != null) {
				IdField.setText(selection.getClientId());
				clientLicenseNumField.setText(selection.getClientLicenceNum());
				clientNameField.setText(selection.getClientName());
				clientSurnameField.setText(selection.getClientSurname());
				clientEmailField.setText(selection.getClientEmail());
				clientAddressField.setText(selection.getClientAddress());
				clientPhoneNumField.setText(String.valueOf(selection.getClientPhoneNum()));
			}
		}
		else if(event.getSource() == addClientBtn) {
			if(!IdField.getText().isEmpty() && !clientLicenseNumField.getText().isEmpty() && !clientNameField.getText().isEmpty() && !clientSurnameField.getText().isEmpty() && 	
			!clientEmailField.getText().isEmpty() && !clientAddressField.getText().isEmpty()) {
				
			createClient(IdField.getText(),clientLicenseNumField.getText(),clientNameField.getText(),clientSurnameField.getText(),clientEmailField.getText(),clientAddressField.getText(),clientPhoneNumField.getText());
			tableSync();
			clearTextFields();
			
			}
		}
		else if(event.getSource() == showAllBtn) {
			tableSync();
			clearTextFields();
		}
		else if(event.getSource() == searchBtn) {
			searchClient(IdField.getText());
		}
		else if(event.getSource() == backBtn) {
			ApplicationFx.mainStage.setTitle("Car Rental Service");
			ApplicationFx.mainStage.setScene(ApplicationFx.centerScene);
		}
		else if(event.getSource() == deleteBtn) {
			Client selectedClient = c.clientTableView.getSelectionModel().getSelectedItem();
			//Pop up window to validate users choice
			Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete the selected Client ?", ButtonType.YES, ButtonType.NO);
			alert.showAndWait();
			if(selectedClient != null) {
				if(alert.getResult() == ButtonType.YES) {
					ApplicationFx.clientsList.remove(selectedClient);
					tableSync();
					clearTextFields();
				}
				else {
					clearTextFields();
				}
				
			}
		}
		else if(event.getSource() == updateBtn) {
			updateClient();
			tableSync();
			clearTextFields();
		}
	}
	
	public void createClient(String id,String licenseNum, String clientName, String clientSurname, String clientEmail,String clientAddress,String clientPhoneNum) {
		Long p;
		//Checking if the given String can be converted to string or if the user has provided wrong data and checking if the user id and license number already exists
		try {
			p = Long.parseLong(clientPhoneNum);
			for (Client client : ApplicationFx.clientsList) {
		        if (client.getClientLicenceNum().equals(licenseNum) || client.getClientId().equals(id)) 
		        	return ;
		    }
			ApplicationFx.clientsList.add(new Client(id,licenseNum,clientName,clientSurname,clientEmail,clientAddress,p));
		}
		catch(NumberFormatException inputMismatchException){
			System.err.printf("\nException: %s\n",inputMismatchException);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
			alert.showAndWait();
		}
		
	}
	
	public void updateClient() {
		Client selectedClient = c.clientTableView.getSelectionModel().getSelectedItem();
		long p;
		if(selectedClient != null) {
			//Checking if the given String can be converted to integer or if the user has provided wrong data
			try {
				p= Long.parseLong(clientPhoneNumField.getText());
				selectedClient.setClientPhoneNum((int) p);
				selectedClient.setClientEmail(clientEmailField.getText());
				selectedClient.setClientName(clientNameField.getText());
				selectedClient.setClientSurname(clientSurnameField.getText());
				selectedClient.setClientAddress(clientAddressField.getText());
			}
			catch(NumberFormatException inputMismatchException){
				System.err.printf( "\nException: %s\n",inputMismatchException);
				Alert alert = new Alert(AlertType.CONFIRMATION, "Invalid input please try again", ButtonType.OK);
				alert.showAndWait();
			}
		}
	}
	
	public void searchClient(String id) {
		List<Client> items = c.clientTableView.getItems();
		items.clear();
		for (Client clientt : ApplicationFx.clientsList) {
			if(clientt.getClientId().equals(id)){
				items.clear();
				items.add(clientt);
				break;
			}
		}
	}
	
	public void clearTextFields() {
		clientNameField.setText("");
		clientSurnameField.setText("");
		clientEmailField.setText("");
		clientAddressField.setText("");
		clientPhoneNumField.setText("");
		IdField.setText("");
		clientLicenseNumField.setText("");
	}
	
	public void tableSync() {
		List<Client> items = c.clientTableView.getItems();
		items.clear();
		for (Client clientt : ApplicationFx.clientsList) {
			if(clientt instanceof Client) {
				items.add(clientt);
			}
		}
	}

}
