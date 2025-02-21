package jvafx_projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP830G5
 */
public class ShopController implements Initializable {
	
	 @FXML
	 private Button paybtn;

    @FXML
    private Button Logout;
    
    @FXML
    private Button close;
    
    @FXML
    private Button vegetablebtn;

    @FXML
    private Button fruitbtn;

    @FXML
    private Button meatbtn;

    @FXML
    private Button menubtn;
    
    @FXML
    private Label total_lbl;
    
    @FXML
    private BorderPane pane;
    @FXML
    private TableColumn<Item, String> namecolumn;
    @FXML
    private TableColumn<Item, Double> pricecolumn;

    @FXML
    private TableColumn<Item, Integer> quantitycolumn;

    @FXML
    private TableView<Item> tableview;

    private ObservableList<Item> itemList = FXCollections.observableArrayList();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	FxmlLoader object = new FxmlLoader();
        // Get the FXML loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        try {
            // Load the FXML and get the controller
            Pane scene = loader.load();
            MenuController controller = loader.getController();

            // Set the shopController reference
            // Set the scene in the center of the pane
            pane.setCenter(scene);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Vegetables.fxml");
        }
    	
    	// Set up TableView columns
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantitycolumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Set the TableView to display the itemList
        itemList=DataBase.getItems();
        tableview.setItems(itemList);
        
        
    	 
        
    }
    public void addItemToTable(Item item) {
        itemList.add(item);  // Add item directly to the observable list
    }
    public void refreshtableview() {
    	tableview.refresh(); //refresh the tableview
    }
    public ObservableList<Item> getitems(){
    	return tableview.getItems(); //get the list of items of the tableview
    }
    @FXML
    //switch the center to the fruit scene
    void switchFruit(ActionEvent event) {
    	FxmlLoader object = new FxmlLoader();
        // Get the FXML loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Fruits.fxml"));
        try {
            // Load the FXML and get the controller
            Pane scene = loader.load();
            FruitsController controller = loader.getController();

            // Set the shopController reference
            controller.setShopController(this);

            // Set the scene in the center of the pane
            pane.setCenter(scene);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Fruits.fxml");
        }

    }

    @FXML
    //switch the center to the meat scene
    void switchMeat(ActionEvent event) {
    	FxmlLoader object = new FxmlLoader();
        // Get the FXML loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Meat.fxml"));
        try {
            // Load the FXML and get the controller
            Pane scene = loader.load();
            MeatController controller = loader.getController();

            // Set the shopController reference
            controller.setShopController(this);

            // Set the scene in the center of the pane
            pane.setCenter(scene);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Meat.fxml");
        }


    }
    
    //switch to menu
    @FXML
    void switchMenu(ActionEvent event) {
    	FxmlLoader object = new FxmlLoader();
        // Get the FXML loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        try {
            // Load the FXML and get the controller
            Pane scene = loader.load();
            // Set the scene in the center of the pane
            pane.setCenter(scene);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Menu.fxml");
        }

    }

    @FXML
    //switch the center to the vegetables scene
    void switchVegetable(ActionEvent event) {
    	FxmlLoader object = new FxmlLoader();
        // Get the FXML loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Vegetables.fxml"));
        try {
            // Load the FXML and get the controller
            Pane scene = loader.load();
            VegetablesController controller = loader.getController();

            // Set the shopController reference
            controller.setShopController(this);

            // Set the scene in the center of the pane
            pane.setCenter(scene);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Vegetables.fxml");
        }

    }
    //button to Logout and go to Login scene
    @FXML
    private void logout(ActionEvent event) {
        try{
        Parent root2 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root2);
        stage2.setTitle("Login");
        stage2.setScene(scene2);
        stage2.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //button to close our window
    @FXML
    private void closewindow(ActionEvent event) {
        Stage stage3 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage3.close();
    }
    
    @FXML
    void total(ActionEvent event) {
    	total_lbl.setText(String.format("%.2f", DataBase.gettotal())+"DH");
    }
    
    @FXML
    void clear(ActionEvent event) {
    	DataBase.clear();
    	tableview.getItems().clear();
    	total_lbl.setText("0.00DH");

    }
    
    @FXML
    void pay(ActionEvent event) throws IOException {
    	if(total_lbl.getText().equals("0.00DH")){
    		Alert alert = new Alert(AlertType.WARNING,
        			"Please Add Items To Your Cart Before Proceeding" 
        	);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.show();
    	}
    	else {
    	Alert alert = new Alert(AlertType.INFORMATION,
    			"Your total comes to "+ total_lbl.getText()+
    			"\nYour order is now on its way and will arrive shortly " 
    	,ButtonType.OK);
        alert.setTitle("Paying");
        alert.setHeaderText("Have a wonderful day!");
        alert.show();
    	}
        //set our scene
      

    }
    
}

