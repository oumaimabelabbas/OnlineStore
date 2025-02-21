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

public class MeatController implements Initializable{

    @FXML
    private Spinner<Integer> beefspin;

    @FXML
    private Spinner<Integer> mincedmeatspin;

    @FXML
    private Spinner<Integer> sausagespin;

    @FXML
    private Spinner<Integer> turkeyspin;
    
    @FXML
    private Button beefbtn;

    @FXML
    private Label beefname;

    @FXML
    private Label beefprice;

    @FXML
    private Button meatbtn;

    @FXML
    private Label meatname;

    @FXML
    private Label meatprice;
    
    @FXML
    private Button sausagebtn;

    @FXML
    private Label sausagename;

    @FXML
    private Label sausageprice;
    
    @FXML
    private Button turkeybtn;

    @FXML
    private Label turkeyname;

    @FXML
    private Label turkeyprice;
    
    private ShopController shopController; // Reference to the ShopController

    public void setShopController(ShopController shopController) {
        this.shopController = shopController;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//set the value factory of the spinners of the fruits items
		SpinnerValueFactory<Integer> valuefactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		beefspin.setValueFactory(valuefactory1);
		
		SpinnerValueFactory<Integer> valuefactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		mincedmeatspin.setValueFactory(valuefactory2);
		
		SpinnerValueFactory<Integer> valuefactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		sausagespin.setValueFactory(valuefactory3);
		
		SpinnerValueFactory<Integer> valuefactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		turkeyspin.setValueFactory(valuefactory4);
	}
	@FXML
    void addbeef(ActionEvent event) {
		boolean exist = false;
		String name = beefname.getText();
        String priceString = beefprice.getText().replace("DH", "").trim();
        double price = Double.parseDouble(priceString);
        int quantity = beefspin.getValue();

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
    void addmeat(ActionEvent event) {
    	boolean exist = false;
    	String name = meatname.getText();
        String priceString = meatprice.getText().replace("DH", "").trim();
        double price = Double.parseDouble(priceString);
        int quantity = mincedmeatspin.getValue();

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
    void addsausage(ActionEvent event) {
    	boolean exist = false;
    	String name = sausagename.getText();
        String priceString = sausageprice.getText().replace("DH", "").trim();
        double price = Double.parseDouble(priceString);
        int quantity = sausagespin.getValue();

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
    void addturkey(ActionEvent event) {
    	boolean exist = false;
    	String name = turkeyname.getText();
        String priceString = turkeyprice.getText().replace("DH", "").trim();
        double price = Double.parseDouble(priceString);
        int quantity = turkeyspin.getValue();
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
