package view;

import java.sql.SQLException;

import connector.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.User;


public class RegisterScene implements EventHandler<ActionEvent>{

	ObservableList<User> userList = FXCollections.observableArrayList();
	BorderPane borderPane;
	GridPane gridPane;
	Scene scene;
	Label regLbl, userLbl, emailLbl, passLbl, conPassLbl, phoLbl;
	TextField emailField, userField, phoField;
	PasswordField passField, conPassField;
	Button regisButton;
	MenuBar menuBar;
	Menu menu;
	MenuItem menuItem1, menuItem2;
	
	private Connect connect;
	private mainpage.Main main;
		
	public void initialize() {
		borderPane = new BorderPane();
		gridPane = new GridPane();
		scene = new Scene(borderPane, 750, 700);
		
		regLbl = new Label("REGISTER");
		userLbl = new Label("Username");
		emailLbl = new Label("Email");
		passLbl = new Label("Password");
		conPassLbl = new Label("Confirm Password");
		phoLbl = new Label("Phone Number");
		
		userField = new TextField();
		emailField = new TextField();
		passField = new PasswordField();
		conPassField = new PasswordField();
		phoField = new TextField();
		
		regisButton = new Button("Sign Up");
		
		menuBar = new MenuBar();
		menu = new Menu("Menu");
		
    	menuItem1 = new MenuItem("Login");
    	menuItem2 = new MenuItem("Register");
		
    	connect = Connect.getInstance();
	}
	
	public void addComponent() {
    	menuBar.getMenus().add(menu);
    	menu.getItems().addAll(menuItem1, menuItem2);
		
		gridPane.addRow(0, regLbl);
		gridPane.addRow(1, userLbl);
		gridPane.addRow(2, userField);
		gridPane.addRow(3, emailLbl);
		gridPane.addRow(4, emailField);
		gridPane.addRow(5, passLbl);
		gridPane.addRow(6, passField);
		gridPane.addRow(7, conPassLbl);
		gridPane.addRow(8, conPassField);
		gridPane.addRow(9, phoLbl);
		gridPane.addRow(10, phoField);
		gridPane.addRow(11, regisButton);
	}
	
	public void arrange() {
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(regLbl, HPos.CENTER);
        GridPane.setHalignment(regisButton, HPos.CENTER);
        regLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 54;");
        gridPane.setVgap(5);

        userField.setPrefWidth(200); 
        emailField.setPrefWidth(200); 
        passField.setPrefWidth(200); 
        conPassField.setPrefWidth(200); 
        phoField.setPrefWidth(200); 
        
        regisButton.setMinHeight(30);
        regisButton.setMinWidth(60);
        
        borderPane.setCenter(gridPane);
        borderPane.setTop(menuBar);
	}
	
	public Scene returnScene() {
		return scene;
	}
	
	public void setEventHandler() {
		regisButton.setOnAction(this);
		menuItem1.setOnAction(this);
		menuItem2.setOnAction(this);
	}
	
	public RegisterScene(mainpage.Main main) {
		this.main = main;
		initialize();
		addComponent();
		arrange();
		setEventHandler();
		getUser();
	}

	private void getUser() {
		String query = "SELECT * FROM user";
		connect.rs = connect.execQueryGetData(query);

		try {
			while (connect.rs.next()) {
				String id = connect.rs.getString("UserID");
				String name = connect.rs.getString("Username");
				String password = connect.rs.getString("Password");
				String phoneNum = connect.rs.getString("PhoneNumber");
				String email = connect.rs.getString("Email");
				String role = connect.rs.getString("Role");

				User user = new User(id, name, password, phoneNum, email, role);
				userList.addAll(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void insertUser(String userId, String username, String password, String phonenumber, String email, String role) {
		String query = "INSERT INTO user " 
				+ "VALUES('"+userId+"','"+username+"', '"+password+"', '"+phonenumber+"', '"+email+"', '"+role+"' )";
		connect.execQueryInUp(query);
	}
	
	private String setId() {
		String id;
		int count = userList.size() + 1;
		id = "AC" + String.format("%03d", count);
		count++;
		return id;
	}
	
	@Override
	public void handle(ActionEvent event) {
		boolean bool = false;
		if(event.getSource() == regisButton) {
		     for (User user : userList) {
		    	 bool = false;
				if(user.getEmail().equals(emailField.getText())) {
					bool = true;
					break;
				}
			}
		     
		     if(userField.getText().length() < 4 || userField.getText().length() > 20 ) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Invalid Input");
					alert.setHeaderText("Username is invalid");
					alert.setContentText("Username must contain 4-20 characters");
					alert.show();
		     }
		     
		     else if(!emailField.getText().contains("@")) {
		    		Alert alert = new Alert(AlertType.WARNING);
		    		alert.setTitle("Invalid Input");
					alert.setHeaderText("Email is invalid");
					alert.setContentText("Email must contains  \"@\" in it");
					alert.show();
		     }
		     
		     else if(bool == true) {
		    	 	Alert alert = new Alert(AlertType.WARNING);
		    	 	alert.setTitle("Invalid Input");
					alert.setHeaderText("Email is invalid");
					alert.setContentText("Email must be unique");
					alert.show();
		     }
		     
		     else if(passField.getText().length() < 6 || passField.getText().length() > 20) {
		    	 	Alert alert = new Alert(AlertType.WARNING);
		    	 	alert.setTitle("Invalid Input");
					alert.setHeaderText("Password is invalid");
					alert.setContentText("Password must contain 6 – 20 characters");
					alert.show();
		     }
		     
		     else if(!passField.getText().matches("^[a-zA-Z0-9]+$")) {
			    	 Alert alert = new Alert(AlertType.WARNING);
			    	 alert.setTitle("Invalid Input");
			    	 alert.setHeaderText("Password is invalid");
			    	 alert.setContentText("Password must be alphanumeric");
			    	 alert.show();
		     }
		     
		     else if(!conPassField.getText().equals(passField.getText())) {
			    	 Alert alert = new Alert(AlertType.WARNING);
			    	 alert.setTitle("Invalid Input");
			    	 alert.setHeaderText("Confirm Password is invalid");
			    	 alert.setContentText("Confirm Password must be the same as Password");
			    	 alert.show();		    	 
		     }
		     
		     else if(!phoField.getText().matches("\\d+")) {
			    	 Alert alert = new Alert(AlertType.WARNING);
			    	 alert.setTitle("Invalid Input");
			    	 alert.setHeaderText("Phone number is invalid");
			    	 alert.setContentText("Phone Number can only be numeric");
			    	 alert.show();		    	 		    	 
		     }
		     
		     else if(phoField.getText().length() < 9 || phoField.getText().length() > 20) {
			    	 Alert alert = new Alert(AlertType.WARNING);
			    	 alert.setTitle("Invalid Input");
			    	 alert.setHeaderText("Phone number is invalid");
			    	 alert.setContentText("Phone Number must be 9 – 20 numbers");
			    	 alert.show();
		     }
		     
		     else {
		    	 insertUser(setId(), userField.getText().toString(), passField.getText().toString(), 
		    			 	phoField.getText().toString(), emailField.getText().toString(), "customer");
		    	 getUser();
		    	 
		    	 Alert alert = new Alert(AlertType.INFORMATION);
		    	 alert.setHeaderText("Account created");
		    	 alert.setContentText("Your account has been registered");
		    	 alert.show();
		     
		    	 main.showLoginScene();
		     }
		     
		  
		}
		
		else if (event.getSource() == menuItem1) {
			main.showLoginScene();
		} 
		else if (event.getSource() == menuItem2) {
			main.showRegistScene();
		}
		
	}

}
