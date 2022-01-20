package ApalakthkhErgasiaJava.src.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
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

import java.util.List;
import ApalakthkhErgasiaJava.src.core.*;


public class CitiesWindowScene extends SceneCreator implements EventHandler<MouseEvent> {
	GridPane rootGridPane , inputFieldsPane;
	FlowPane BottomButtonFlow;
	
	Button AddCityBtn,ShowAllCitiesBtn,UpdateCityBtn,DeleteCityBtn,BackBtn,searchFieldBtn;
	Label cityNameLbl;
	TextField cityNameField,searchField;
	ApplicationFx c = new ApplicationFx();
	
	public CitiesWindowScene(double width, double height) {
		super(width, height);	
		
		//initializing panes,textFields,button and labels
		rootGridPane = new GridPane();
		inputFieldsPane = new GridPane();
		BottomButtonFlow = new FlowPane();
		
		cityNameField = new TextField();
		searchField = new TextField();
		searchFieldBtn = new Button("Search City");
		
		AddCityBtn = new Button("Add");
		ShowAllCitiesBtn  = new Button("Show All");
		UpdateCityBtn = new Button("Update");
		DeleteCityBtn = new Button("Delete");
		BackBtn = new Button("Back");
		
		cityNameLbl = new Label("City:");
		//Setting the background color
		 BackgroundFill myBF = new BackgroundFill(Color.ALICEBLUE, new CornerRadii(1),
		            new Insets(0.0,0.0,0.0,0.0));
		    rootGridPane.setBackground(new Background(myBF));
		
		//Setting up Bottom Center Buttons
		BottomButtonFlow.setAlignment(Pos.BOTTOM_CENTER);
		BottomButtonFlow.setHgap(15);
		BottomButtonFlow.setVgap(15);
		BottomButtonFlow.getChildren().add(AddCityBtn);
		BottomButtonFlow.getChildren().add(ShowAllCitiesBtn);
		BottomButtonFlow.getChildren().add(UpdateCityBtn);
		BottomButtonFlow.getChildren().add(DeleteCityBtn);
		BottomButtonFlow.getChildren().add(searchFieldBtn);
		
		
		//making button detect when they are pressed
		AddCityBtn.setOnMouseClicked(this);
		ShowAllCitiesBtn.setOnMouseClicked(this);
		UpdateCityBtn.setOnMouseClicked(this);
		DeleteCityBtn.setOnMouseClicked(this);
		BackBtn.setOnMouseClicked(this);
		searchFieldBtn.setOnMouseClicked(this);
		c.cityTableView.setOnMouseClicked(this);
		//Adding image to back button
		Image image = new Image(getClass().getResourceAsStream("Back_btn_Img.png"));
		BackBtn.setGraphic(new ImageView(image));	
		
		
		//Setting up input Fields
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(25);
		inputFieldsPane.setHgap(5);
		inputFieldsPane.add(cityNameLbl, 0, 1);
		inputFieldsPane.add(cityNameField, 1, 1);
		inputFieldsPane.add(searchFieldBtn, 0, 8);
		inputFieldsPane.add(searchField, 1, 8);
		//Customizing root Scene 2
		rootGridPane.setVgap(15);
		rootGridPane.setHgap(15);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(c.cityTableView,0,0);
		rootGridPane.add(BottomButtonFlow,0,1);
		rootGridPane.add(BackBtn,1,1);
		
		//creating columns in tableView and setting from which getter to get the needed data
		TableColumn<City, String> nameColumn = new TableColumn("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
		c.cityTableView.getColumns().add(nameColumn);
		
		TableColumn<City, String> idColumn = new TableColumn("UniqueID");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("uniqueId"));
		c.cityTableView.getColumns().add(idColumn);
		 	
		

	}

	@Override
	public void handle(MouseEvent event) {
		//Actions to take when each button is pressed
		if(event.getSource() == BackBtn) {
			ApplicationFx.mainStage.setTitle("Car Rental Service");
			ApplicationFx.mainStage.setScene(ApplicationFx.centerScene);
		}
		else if (event.getSource() == AddCityBtn) {
			if(!cityNameField.getText().isEmpty()) {
				createCity(cityNameField.getText());
				tableSync();
				clearTextFields();
			}
		}
		else if(event.getSource() == UpdateCityBtn) {
			City selectedCity = c.cityTableView.getSelectionModel().getSelectedItem();
			  if(!cityNameField.getText().isEmpty()) {
		            selectedCity.setCityName(cityNameField.getText());
		            tableSync();
		            clearTextFields();
		           }
		}
		else if (event.getSource() == searchFieldBtn) {
			if(searchField.getText().isEmpty() == false) {
				searchCity(searchField.getText());
				clearTextFields();
			}
		}
		else if (event.getSource() == ShowAllCitiesBtn) {
			tableSync();
		}
		else if (event.getSource() == DeleteCityBtn) {
				City selectedCity = c.cityTableView.getSelectionModel().getSelectedItem();
				Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete the selected City ?", ButtonType.YES, ButtonType.NO);
				alert.showAndWait();
				if(selectedCity != null) {
					if(alert.getResult() == ButtonType.YES) {
						ApplicationFx.citiesList.remove(selectedCity);
						tableSync();
						clearTextFields();
					}
					else {
						clearTextFields();
					}
					
				}
		}
		else if(event.getSource() == c.cityTableView) {
			City selectedCity = c.cityTableView.getSelectionModel().getSelectedItem();
			if(selectedCity != null) {
				cityNameField.setText(selectedCity.getCityName());
			}
			
		}
	}
	//Needed methods for updating the table,clearing text fields etc.
	public void clearTextFields() {
		cityNameField.setText("");
		searchField.setText("");
	}
	public void tableSync() {
		List<City> items = c.cityTableView.getItems();
		items.clear();
		for (City c : ApplicationFx.citiesList) {
			if(c instanceof City) {
				items.add(c);
				
			}
		}
	}
	
	public void searchCity(String name) {
		List<City> items = c.cityTableView.getItems();
		for (City c : ApplicationFx.citiesList) {
			if(c.getCityName().equals(name)) {
				items.clear();
				items.add(c);
				break;
			}
		}
	}
	public void createCity(String name) {
		//checking if the provided city name already exists
		    for (City city : ApplicationFx.citiesList) {
		        if (city.getCityName().equals(name)) return ;
		    }
		    ApplicationFx.citiesList.add(new City(name));
		}

		
			
		
	
	
	@Override
	Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}

}
