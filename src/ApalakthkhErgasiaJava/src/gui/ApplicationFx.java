package ApalakthkhErgasiaJava.src.gui;



import java.util.ArrayList;
import ApalakthkhErgasiaJava.src.core.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class ApplicationFx extends Application implements EventHandler<MouseEvent>{
	static Stage mainStage;
	
	static Scene centerScene,citiesScene,storeScene,vehicleScene,clientScene,rentalScene;
	TableView<City> cityTableView = new TableView<>();
	TableView<Store> storeTableView = new TableView<>();
	TableView<Vehicle> vehicleTableView = new TableView<>();
	TableView<Client> clientTableView = new TableView<>();
	TableView<Rental> rentalTableView = new TableView<>();
	
	static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	static ArrayList<City> citiesList = new ArrayList<City>() ;
	static ArrayList<Store> storeArrayList = new ArrayList<Store>();
	static ArrayList<Client> clientsList = new ArrayList<Client>();
	static ArrayList<Rental> rentalList = new ArrayList<Rental>();
	
	public static void main(String[] args) {
	    launch(args);
	}

	public void start(Stage primaryStage) {
		mainStage = primaryStage;
	    
		SceneCreator centerSceneCreator = new CenterWindowScene( 650, 300);
		centerScene = centerSceneCreator.createScene();
	    
		SceneCreator citiesSceneCreator = new CitiesWindowScene( 650, 305);
		citiesScene = citiesSceneCreator.createScene();
		
		SceneCreator storesSceneCreator = new StoreWindowScene( 650, 305);
		storeScene = storesSceneCreator.createScene();
		
		SceneCreator vehiclesSceneCreator = new VehicleWindowScene(1205, 430);
		vehicleScene = vehiclesSceneCreator.createScene();
		
		SceneCreator clientSceneCreator = new ClientWindowScene(680, 447);
		clientScene = clientSceneCreator.createScene();
		
		SceneCreator rentalSceneCreator = new RentalWindowScene(1000, 430);
		rentalScene = rentalSceneCreator.createScene();
		
	    mainStage.setTitle("Car Rental Service");
	    mainStage.setScene(centerScene);
	    mainStage.show();

	}
	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
