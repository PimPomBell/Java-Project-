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

public class LoginScene implements EventHandler<ActionEvent> {

	ObservableList<User> userList = FXCollections.observableArrayList();
	BorderPane borderPane;
	Scene scene;
	Label emailLbl, passLbl, titleLbl, loginLbl;
	GridPane gridPane;
	TextField textField;
	PasswordField passField;
	Button signInButton;
	MenuBar menuBar;
	Menu menu;
	MenuItem menuItem1, menuItem2;
	String userRole;
	static String getName;
	static String getId;

	private Connect connect;
	private mainpage.Main main;

	public void initialize() {
		borderPane = new BorderPane();
		gridPane = new GridPane();
		scene = new Scene(borderPane, 750, 700);

		loginLbl = new Label("LOGIN");
		emailLbl = new Label("Email");
		passLbl = new Label("Password");

		textField = new TextField();
		passField = new PasswordField();

		signInButton = new Button();

		menuBar = new MenuBar();
		menu = new Menu("Menu");

		menuItem1 = new MenuItem("Login");
		menuItem2 = new MenuItem("Register");

		connect = Connect.getInstance();
	}

	public void addComponent() {
		signInButton.setText("Sign In");

		menuBar.getMenus().add(menu);
		menu.getItems().addAll(menuItem1, menuItem2);

		gridPane.addRow(0, loginLbl);
		gridPane.addRow(1, emailLbl);
		gridPane.addRow(2, textField);
		gridPane.addRow(3, passLbl);
		gridPane.addRow(4, passField);
		gridPane.addRow(5, signInButton);
	}

	public void arrange() {
		gridPane.setPadding(new Insets(20));
		gridPane.setAlignment(Pos.CENTER);
		GridPane.setHalignment(signInButton, HPos.CENTER);
		GridPane.setHalignment(loginLbl, HPos.CENTER);
		loginLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 40;");
		gridPane.setVgap(5);

		// bingung
		textField.setPrefWidth(200);
		passField.setPrefWidth(200);
		
		signInButton.setMinHeight(30);
		signInButton.setMinWidth(60);

		borderPane.setCenter(gridPane);
		borderPane.setTop(menuBar);
	}

	public Scene returnScene() {
		return scene;
	}

	public void setEventHandler() {
		signInButton.setOnAction(this);
		menuItem1.setOnAction(this);
		menuItem2.setOnAction(this);
	}

	public LoginScene(mainpage.Main main) {
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

	@Override
	public void handle(ActionEvent event) {    
		boolean bool = false;
		if (event.getSource() == signInButton) {
			for (User user : userList) {
				bool = false;
				if (user.getEmail().equals(textField.getText()) && user.getPassword().equals(passField.getText())) {
					bool = true;
					userRole = user.getRole();
					getName = user.getUsername();
					getId = user.getUserId();
					break;
				}
			}
			
			if(bool == false) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Request");
				alert.setHeaderText("Wrong Credentials");
				alert.setContentText("Email or password is invalid");
				alert.show();
			}
		
			else if(userRole.equals("customer")) {
				main.showHomeScene();
			}
			
			else if(userRole.equals("admin")) {
				main.showAdmHomeScene();
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
