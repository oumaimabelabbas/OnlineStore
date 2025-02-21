package jvafx_projet;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class FruitsController implements Initializable{
	    @FXML
	    private Spinner<Integer> applespin;

	    @FXML
	    private Spinner<Integer> avocadospin;

	    @FXML
	    private Spinner<Integer> bananaspin;

	    @FXML
	    private Spinner<Integer> orangespin;
	    
	    @FXML
	    private Button applebtn;

	    @FXML
	    private Label applename;

	    @FXML
	    private Label appleprice;
	    
	    @FXML
	    private Button avocadobtn;

	    @FXML
	    private Label avocadoname;

	    @FXML
	    private Label avocadoprice;
	    
	    @FXML
	    private Button bananabtn;

	    @FXML
	    private Label banananame;

	    @FXML
	    private Label bananaprice;
	    
	    @FXML
	    private Button orangebtn;

	    @FXML
	    private Label orangename;

	    @FXML
	    private Label orangeprice;

	    private ShopController shopController; // Reference to the ShopController

	    public void setShopController(ShopController shopController) {
	        this.shopController = shopController;
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			//set the value factory of the spinners of the fruits items
			SpinnerValueFactory<Integer> valuefactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
			applespin.setValueFactory(valuefactory1);
			
			SpinnerValueFactory<Integer> valuefactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
			avocadospin.setValueFactory(valuefactory2);
			
			SpinnerValueFactory<Integer> valuefactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
			bananaspin.setValueFactory(valuefactory3);
			
			SpinnerValueFactory<Integer> valuefactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
			orangespin.setValueFactory(valuefactory4);
		}
		
		@FXML
	    void addavocado(ActionEvent event) {
			boolean exist = false;
			String name = avocadoname.getText();
	        String priceString = avocadoprice.getText().replace("DH", "").trim();
	        double price = Double.parseDouble(priceString);
	        int quantity = avocadospin.getValue();

	        for(Item item : shopController.getitems()) {
	        	if(item.getName().equals(name)) {
	        		exist=true;
	        		item.setQuantity(quantity);
	        		DataBase.updateQuantity(name, quantity);
	        		shopController.refreshtableview();
	        		break; //leave when we found the item exists
	        	}
	        }
	        if(!exist) {
	        // Insert into the database
	        DataBase.insertItem(name, price, quantity);
	        //insert the item in the list of items
	        shopController.addItemToTable(new Item(name,price,quantity)); 
	        //refresh our tableview
	        shopController.refreshtableview();
	        }
	    }
		
		@FXML
	    void addapple(ActionEvent event) {
			boolean exist = false;
			String name = applename.getText();
	        String priceString = appleprice.getText().replace("DH", "").trim();
	        double price = Double.parseDouble(priceString);
	        int quantity = applespin.getValue();
	        for(Item item : shopController.getitems()) {
	        	if(item.getName().equals(name)) {
	        		exist=true;
	        		item.setQuantity(quantity);
	        		DataBase.updateQuantity(name, quantity);
	        		shopController.refreshtableview();
	        		break; //leave when we found the item exists
	        	}
	        }
	        if(!exist) {
	        // Insert into the database
	        DataBase.insertItem(name, price, quantity);
	        //insert the item in the list of items
	        shopController.addItemToTable(new Item(name,price,quantity)); 
	        //refresh our tableview
	        shopController.refreshtableview();
	        }
	    }
		
		@FXML
	    void addbanana(ActionEvent event) {
			boolean exist = false;
			String name = banananame.getText();
	        String priceString = bananaprice.getText().replace("DH", "").trim();
	        double price = Double.parseDouble(priceString);
	        int quantity = bananaspin.getValue();
	        for(Item item : shopController.getitems()) {
	        	if(item.getName().equals(name)) {
	        		exist=true;
	        		item.setQuantity(quantity);
	        		DataBase.updateQuantity(name, quantity);
	        		shopController.refreshtableview();
	        		break; //leave when we found the item exists
	        	}
	        }
	        if(!exist) {
	        // Insert into the database
	        DataBase.insertItem(name, price, quantity);
	        //insert the item in the list of items
	        shopController.addItemToTable(new Item(name,price,quantity)); 
	        //refresh our tableview
	        shopController.refreshtableview();
	        }

	        
	    }

	    @FXML
	    void addorange(ActionEvent event) {
	    	boolean exist = false;
	    	String name = orangename.getText();
	        String priceString = orangeprice.getText().replace("DH", "").trim();
	        double price = Double.parseDouble(priceString);
	        int quantity = orangespin.getValue();

	        for(Item item : shopController.getitems()) {
	        	if(item.getName().equals(name)) {
	        		exist=true;
	        		item.setQuantity(quantity);
	        		DataBase.updateQuantity(name, quantity);
	        		shopController.refreshtableview();
	        		break; //leave when we found the item exists
	        	}
	        }
	        if(!exist) {
	        // Insert into the database
	        DataBase.insertItem(name, price, quantity);
	        //insert the item in the list of items
	        shopController.addItemToTable(new Item(name,price,quantity)); 
	        //refresh our tableview
	        shopController.refreshtableview();
	        }
	    }


}
