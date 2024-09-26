package view;

import java.sql.SQLException;

import connector.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Cart;
import model.TransactionHeader;

public class CartScene implements EventHandler<ActionEvent>{
	ObservableList<Cart> cList = FXCollections.observableArrayList();
	ObservableList<TransactionHeader> thList = FXCollections.observableArrayList();
	BorderPane border;
	GridPane grid;
	Scene scene;
	Label title, gPrice;
	TableView<Cart> table;
	Button co;
	MenuBar menuBar;
	Menu menu1, menu2;
	MenuItem menuItem1, menuItem2, menuItem3;
	
	int total;
	private Connect connect;
	private mainpage.Main main;
	
	public void initialize() {
		border = new BorderPane();
		grid = new GridPane();
		scene = new Scene(border, 750, 700);
		
		title = new Label("Your Cart");
		gPrice = new Label();
		
		table = new TableView<Cart>();
		
		co = new Button("Check Out");
		
		menuBar = new MenuBar();
		menu1 = new Menu("Dashboard");
		menu2 = new Menu("Log Out");
		
		menuItem1 = new MenuItem("Home");
		menuItem2 = new MenuItem("Cart");
		menuItem3 = new MenuItem("Log Out");
		
		connect = Connect.getInstance();
	}
	
	public void addComponent() {
		menuBar.getMenus().addAll(menu1, menu2);
    	menu1.getItems().addAll(menuItem1, menuItem2);
    	menu2.getItems().add(menuItem3);
    	
    	grid.addRow(0, title);
    	grid.addRow(1, table);
    	grid.addRow(2, gPrice);
    	grid.addRow(3, co);
	}
	
	public void arrange() {
		grid.setAlignment(Pos.CENTER);
		GridPane.setHalignment(title, HPos.CENTER);
		GridPane.setHalignment(table, HPos.CENTER);
		GridPane.setHalignment(gPrice, HPos.CENTER);
		GridPane.setHalignment(co, HPos.CENTER);
		title.setStyle("-fx-font-weight: bold; -fx-font-size: 28;");
		gPrice.setStyle("-fx-font-size: 25;");
		
        co.setStyle("-fx-font-size: 18;"); 
        co.setMinSize(150, 40); 
        co.setMaxSize(150, 40);
		
		border.setTop(menuBar);
		border.setCenter(grid);
		
		grid.setMinWidth(500);
		grid.setMaxWidth(500);
		
		table.setMinWidth(500);
		table.setMaxHeight(250);
	}
	
	private void getCart() {
		String query = "SELECT cart.GameID, GameName, Price, Quantity, Price*Quantity AS Total FROM game \n"
				+ "JOIN cart ON game.GameID = cart.GameID\n"
				+ "WHERE cart.UserID = '%s'";
		query = String.format(query, LoginScene.getId);
		connect.execQueryGetData(query);
		
		try {
			while(connect.rs.next()) {
				String gameId = connect.rs.getString("GameId");
				String gameName = connect.rs.getString("GameName");
				int gamePrice = connect.rs.getInt("Price");
				int qty = connect.rs.getInt("Quantity");
				int tot = connect.rs.getInt("Total");
				
				Cart c = new Cart(gameId, gameName, gamePrice, qty, tot);
				cList.add(c);
				table.setItems(cList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getTransactionHeader() {
		String query = "SELECT * FROM transactionheader";
		connect.rs = connect.execQueryGetData(query);
		
		try {
			while (connect.rs.next()) {
				String id = connect.rs.getString("TransactionID");
				String userId = connect.rs.getString("UserID");

				TransactionHeader th = new TransactionHeader(id, userId);
				thList.add(th);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String idTransaction() {
		int count = thList.size() + 1;
		String id = "TR" + String.format("%03d", count);
		count++;
		return id;
	}
	
	public void addGame(String gameId, String gameName, String gameDescription, int price) {
		String query = String.format("INSERT INTO game VALUES('%s', '%s', '%s', %d)", gameId, gameName, gameDescription, price);
		connect.execQueryInUp(query);
	}
	
	public void addTransaction(String transactionId, String userId) {
		String query = String.format("INSERT INTO transactionheader VALUES ('%s', '%s')", transactionId, userId);
		connect.execQueryInUp(query);
	}
	
	public void addTranDetail(String transactionId, String gameId, int quantity) {
		String query = String.format("INSERT INTO transactiondetail VALUES ('%s', '%s', %d)", transactionId, gameId, quantity);
		connect.execQueryInUp(query);
	}
	
	private void updateTotalLabel() {
		total = cList.stream().mapToInt(Cart::getTotal).sum();
	    gPrice.setText("Gross Price: " + String.valueOf(total));
	}
	
	private void deleteTable(String userId) {
		String query = String.format("DELETE FROM cart WHERE UserID = '%s'", userId);
		connect.execQueryInUp(query);
	}
	
	public void setTable() {
		TableColumn<Cart, String> gnameColumn = new TableColumn<Cart, String>("Name");
		gnameColumn.setCellValueFactory(new PropertyValueFactory<Cart, String>("gameName"));
		gnameColumn.setMinWidth(308);
		gnameColumn.setMaxWidth(308);
		
		TableColumn<Cart, Integer> priceColumn = new TableColumn<Cart, Integer>("Price");
		priceColumn.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("gamePrice"));
		priceColumn.setMinWidth(60);
		priceColumn.setMaxWidth(60);
		
		TableColumn<Cart, Integer> qtyColumn = new TableColumn<Cart, Integer>("Quantity");
		qtyColumn.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("quantity"));
		qtyColumn.setMinWidth(70);
		qtyColumn.setMaxWidth(70);

		TableColumn<Cart, Integer> totColumn = new TableColumn<Cart, Integer>("Total");
		totColumn.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("total"));
		totColumn.setMinWidth(60);
		totColumn.setMaxWidth(60);
		
		table.getColumns().addAll(gnameColumn, priceColumn, qtyColumn, totColumn);
	}
	
	
	
	public void setEventHandler() {
		co.setOnAction(this);
		menuItem1.setOnAction(this);
		menuItem2.setOnAction(this);
		menuItem3.setOnAction(this);
	}
	
	public Scene returnScene() {
		return scene;
	}

	public CartScene(mainpage.Main main) {
		this.main = main;		
		initialize();
		addComponent();
		setEventHandler();
		setTable();
		getCart();
		arrange();
		updateTotalLabel();
		getTransactionHeader();
		
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == co) {
			if(cList.isEmpty()) {
	    	 	Alert alert = new Alert(AlertType.WARNING);
	    	 	alert.setTitle("Invalid Request");
				alert.setHeaderText("Cart is empty");
				alert.setContentText("Transaction is not possible");
				alert.show();
			}
			else {
				String id = idTransaction();
				String userId = LoginScene.getId;
				
				addTransaction(id, userId);
				
				for (Cart c : cList) {
					addTranDetail(id, c.getGameId(), c.getQuantity());
				}
	    	 	Alert alert = new Alert(AlertType.INFORMATION);
	    	 	alert.setTitle("Request Successfull");
				alert.setHeaderText("Transaction Complete");
				alert.setContentText("Transaction has been finished, Thank You");
				alert.show();
				
				deleteTable(userId);
				
				cList.clear();
				table.setItems(cList);
				
				updateTotalLabel();
			}
		}
		
		else if(event.getSource() == menuItem1) {
			main.showHomeScene();
		}
		
		else if(event.getSource() == menuItem2) {
			main.showCartScene();
		}
		
		else if(event.getSource() == menuItem3) {
			main.showLoginScene();
		}
		
	}
}
