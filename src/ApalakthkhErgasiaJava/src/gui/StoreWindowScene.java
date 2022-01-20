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

public class StoreWindowScene extends SceneCreator implements EventHandler<MouseEvent>{
	GridPane rootGridPaneStore , inputFieldsPaneStore;
	FlowPane BottomButtonFlowStore;
	Button addStoreBtn,showAllStoreBtn,updateStoreBtn,deleteStoreBtn,backBtn,searchFieldBtn;
	Label storeNameLbl,cityNameLbl;
	TextField storeNameField,searchField,cityNameField;
	ApplicationFx c = new ApplicationFx();
	public StoreWindowScene(double width, double height) {
		super(width,height);
		
		
		rootGridPaneStore = new GridPane();
		inputFieldsPaneStore = new GridPane();
		BottomButtonFlowStore = new FlowPane();
		
		addStoreBtn = new Button("Add");
		showAllStoreBtn = new Button("Show All");
		updateStoreBtn = new Button("Update");
		deleteStoreBtn = new Button("Delete");
		searchFieldBtn = new Button("Search");
		backBtn = new Button("Back");
		
		storeNameLbl = new Label("Store: ");
		cityNameLbl = new Label("City: ");
		
		storeNameField = new TextField();
		searchField = new TextField();
		cityNameField = new TextField();
		
		addStoreBtn.setOnMouseClicked(this);
		showAllStoreBtn.setOnMouseClicked(this);
		updateStoreBtn.setOnMouseClicked(this);
		deleteStoreBtn.setOnMouseClicked(this);
		backBtn.setOnMouseClicked(this);
		searchFieldBtn.setOnMouseClicked(this);
		
		Image image = new Image(getClass().getResourceAsStream("Back_btn_Img.png"));
		backBtn.setGraphic(new ImageView(image));	
		
		BottomButtonFlowStore.setHgap(10);
		BottomButtonFlowStore.setVgap(10);
		BottomButtonFlowStore.setAlignment(Pos.BOTTOM_CENTER);
		BottomButtonFlowStore.getChildren().add(addStoreBtn);
		BottomButtonFlowStore.getChildren().add(showAllStoreBtn);
		BottomButtonFlowStore.getChildren().add(updateStoreBtn);
		BottomButtonFlowStore.getChildren().add(deleteStoreBtn);
		BottomButtonFlowStore.getChildren().add(searchFieldBtn);
		
		inputFieldsPaneStore.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPaneStore.setVgap(25);
		inputFieldsPaneStore.setHgap(5);
		inputFieldsPaneStore.add(cityNameLbl, 0, 1);
		inputFieldsPaneStore.add(cityNameField, 1, 1);
		inputFieldsPaneStore.add(searchFieldBtn, 0, 7);
		inputFieldsPaneStore.add(searchField, 1, 7);
		inputFieldsPaneStore.add(storeNameField, 1, 2);
		inputFieldsPaneStore.add(storeNameLbl, 0,2);
		
		rootGridPaneStore.setHgap(5);
		rootGridPaneStore.setVgap(5);
		rootGridPaneStore.add(BottomButtonFlowStore, 0, 1);
		rootGridPaneStore.add(inputFieldsPaneStore, 1, 0);
		rootGridPaneStore.add(c.storeTableView, 0, 0);
		rootGridPaneStore.add(backBtn, 1, 1);
		
		 BackgroundFill myBF = new BackgroundFill(Color.ALICEBLUE, new CornerRadii(1),
		            new Insets(0.0,0.0,0.0,0.0));
		    rootGridPaneStore.setBackground(new Background(myBF));
		
		
		//Table View
		TableColumn<Store, String> storeidColumn = new TableColumn("Store Code");
		storeidColumn.setCellValueFactory(new PropertyValueFactory<>("uniqueIdStore"));
		c.storeTableView.getColumns().add(storeidColumn);
		
		TableColumn<Store, String> storeNameColumn = new TableColumn("Store Name");
		storeNameColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
		c.storeTableView.getColumns().add(storeNameColumn);
		
		TableColumn<Store, String> cityNameColumn = new TableColumn("City Name");
		cityNameColumn.setCellValueFactory(new PropertyValueFactory<>("CityName"));
		c.storeTableView.getColumns().add(cityNameColumn);
		

	}
	
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getSource() == addStoreBtn) {
			if(!cityNameField.getText().isEmpty() && !storeNameField.getText().isEmpty()) {
				createStore(cityNameField.getText(),storeNameField.getText());
				tableSync();
				clearTextFields();
			}
		}
		else if (event.getSource() == backBtn) {
			ApplicationFx.mainStage.setTitle("Car Rental Service");
			ApplicationFx.mainStage.setScene(ApplicationFx.centerScene);
		}
		else if(event.getSource() == updateStoreBtn) {
			Store selectedStore = c.storeTableView.getSelectionModel().getSelectedItem();
			if( !cityNameField.getText().isEmpty() && !storeNameField.getText().isEmpty() ) {
			  		selectedStore.setBrand(storeNameField.getText());
			}
		    tableSync();
		    clearTextFields();
		}
		else if (event.getSource() == showAllStoreBtn) {
			 	tableSync();
	            clearTextFields();
		}
		else if(event.getSource() == searchFieldBtn) {
			if(!(searchField.getText().isBlank())) {
				searchStore(searchField.getText());
				clearTextFields();
			}
		}
		else if (event.getSource() == deleteStoreBtn) {
			Store selectedStore = c.storeTableView.getSelectionModel().getSelectedItem();
			Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete the selected Store ?", ButtonType.YES, ButtonType.NO);
			alert.showAndWait();
			if(selectedStore != null) {
				if(alert.getResult() == ButtonType.YES) {
					ApplicationFx.storeArrayList.remove(selectedStore);
					tableSync();
					clearTextFields();
				}
				else clearTextFields();
				
			}
		}
}
	public void createStore(String cityName,String storeName) {
		//Checking if the given city name already exists and if so then create the store
		for(City city : ApplicationFx.citiesList) {
			if (city.getCityName().equals(cityName)) 
				ApplicationFx.storeArrayList.add(new Store(cityName,storeName));
		}
	}
	
	public void clearTextFields() {
		cityNameField.setText("");
		searchField.setText("");
		storeNameField.setText("");
	}
	
	public void searchStore(String name) {
		for (Store s : ApplicationFx.storeArrayList) {
			if(s.getBrand().equals(name)) {
				List<Store> items = c.storeTableView.getItems();
				items.clear();
				items.add(s);
				break;
			}
		}
	}
	
	public void tableSync() {
		List<Store> items = c.storeTableView.getItems();
		items.clear();
		for (Store s : ApplicationFx.storeArrayList) {
			if(s instanceof Store) {
				items.add(s);
				
			}
		}
	}
	@Override
	Scene createScene() {
		// TODO Auto-generated method stub
		return new Scene(rootGridPaneStore,width,height);
	}

}
