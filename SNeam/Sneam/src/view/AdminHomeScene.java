package view;

import java.sql.SQLException;
import java.util.Optional;
import connector.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Game;


public class AdminHomeScene implements EventHandler<ActionEvent>{
	ObservableList<Game> gList = FXCollections.observableArrayList();
	BorderPane border1, border2;
	GridPane grid1;
	VBox vbox1, vbox2, vbox3, vbox4, vbox5;
	HBox hbox1, hbox2;
	ScrollPane scrollPane;
	Scene scene;
	Label greetTitle, gName, gDesc, gPrice;
	Label admTitle, cgTitle, cgDesc, cgPrice;
	ListView<Game> gameList; 
	Button add, updt, dlt;
	TextField gNameField, gPriceField;
	TextArea gDescArea;
	MenuBar menuBar;
	Menu menu;
	MenuItem menuItem;
	
	private String temp = null;
	private Connect connect;
	private mainpage.Main main;
	
	public void initialize() {
		border1 = new BorderPane();
		border2 = new BorderPane();
		grid1 = new GridPane();
		scrollPane = new ScrollPane(border1);
		
		vbox1 = new VBox();
		vbox2 = new VBox();
		vbox3 = new VBox();
		vbox4 = new VBox();
		vbox5 = new VBox();
		
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		
		scene = new Scene(scrollPane, 750, 700);
		
		greetTitle = new Label("Hello, " + LoginScene.getName);
		gName = new Label();
		gDesc = new Label();
		gPrice = new Label();
		
		admTitle = new Label("Admin Menu");
		cgTitle = new Label("Game Title");
		cgDesc = new Label("Game Descrption");
		cgPrice = new Label("Game Price");
		
		gameList = new ListView<Game>();
		
		add = new Button("Add Game");
		updt = new Button("Update Game");
		dlt = new Button("Delete Game");
		
		gNameField = new TextField();
		gPriceField = new TextField();
		
		gDescArea = new TextArea();
		
		menuBar = new MenuBar();
		menu = new Menu("Log Out");
		menuItem = new MenuItem("Log Out");
		
		connect = Connect.getInstance();
	}
	
	public void addComponent() {
		menuBar.getMenus().add(menu);
		menu.getItems().add(menuItem);
		
		vbox1.getChildren().add(gameList);
		vbox2.getChildren().addAll(gName, gDesc, gPrice);
		vbox3.getChildren().add(admTitle);
		vbox4.getChildren().addAll(cgTitle, gNameField, cgDesc, gDescArea, cgPrice, gPriceField);
		vbox5.getChildren().addAll(add, updt, dlt);
	
		hbox1.getChildren().addAll(vbox1, vbox2);
		hbox2.getChildren().addAll(vbox4, vbox5);
		
		grid1.add(hbox1, 0, 0);
		grid1.add(vbox3, 0, 1);
		grid1.add(hbox2, 0, 2);
	}
	
	public void arrange() {
		grid1.setAlignment(Pos.CENTER);
		greetTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 30;");
		admTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 18;");
		BorderPane.setAlignment(greetTitle, Pos.CENTER);
		vbox3.setAlignment(Pos.CENTER);
		vbox2.setAlignment(Pos.CENTER);
		gName.setWrapText(true);
		gDesc.setWrapText(true);
		gDescArea.setWrapText(true);
		gName.setAlignment(Pos.CENTER);
		
		vbox5.setPadding(new Insets(40,0,0,10));
		vbox4.setPadding(new Insets(0,0,0,0));
		vbox2.setSpacing(10);
		vbox5.setSpacing(20);
		hbox1.setSpacing(10);

		border1.setCenter(border2);
		border2.setCenter(grid1);
		
		border1.setTop(menuBar);
		border2.setTop(greetTitle);
		
		gName.setStyle("-fx-font-weight: bold; -fx-font-size: 22;");		
		
		add.setPrefWidth(100); 
	    add.setPrefHeight(50);
	    
	    updt.setPrefWidth(100); 
	    updt.setPrefHeight(50);
	    
	    dlt.setPrefWidth(100); 
	    dlt.setPrefHeight(50);
	    
	    gName.setPrefWidth(250);
	    gDesc.setPrefWidth(250);
	    
	    scrollPane.setMaxWidth(730);
	    scrollPane.setMinWidth(730);
		border1.setMinWidth(735);
	}

	public void setEventHandler() {
		add.setOnAction(this);
		updt.setOnAction(this);
		dlt.setOnAction(this);
		menuItem.setOnAction(this);
		
		gameList.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getSource() == gameList) {
					Game selectGame = gameList.getSelectionModel().getSelectedItem();
					if(selectGame != null) {
						gName.setText(selectGame.getGameName());
						gDesc.setText(selectGame.getGameDescription());
						gPrice.setText("Rp" + selectGame.getPrice());
					    gNameField.setText(selectGame.getGameName());
			            gDescArea.setText(selectGame.getGameDescription());
			            gPriceField.setText(String.valueOf(selectGame.getPrice()));
			            temp = selectGame.getGameId();
					}
				}
				
			}
		});	
	}
	
	public Scene returnScene() {
		return scene;
	}
	private void getGame() {
		gList.clear();
		
		String query = "SELECT * FROM game";
		connect.rs = connect.execQueryGetData(query);
		
		try {
			while(connect.rs.next()) {
				String gameId = connect.rs.getString("GameID");
				String gameName = connect.rs.getString("GameName");
				String gameDesc = connect.rs.getString("GameDescription");
				Integer gamePrice = connect.rs.getInt("Price");
				
				Game game = new Game(gameId, gameName, gameDesc, gamePrice);
				gList.addAll(game);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gameList.setItems(gList);
	    gameList.setCellFactory(param -> new javafx.scene.control.ListCell<Game>() {
	        @Override
	        protected void updateItem(Game item, boolean empty) {
	            super.updateItem(item, empty);

	            if (empty || item == null || item.getGameName() == null) {
	                setText(null);
	            } else {
	                setText(item.getGameName());
	            }
	        }
	    });
	}
	

	private String setId() {
		    int count = gList.size() + 1;
		    String id;
		    
		    String query = "SELECT GameID FROM game ORDER BY GameID DESC LIMIT 1";
		    connect.rs = connect.execQueryGetData(query);
		    
		    try {
		        if (connect.rs.next()) {
		            String latestId = connect.rs.getString("GameID");
		            int latestCount = Integer.parseInt(latestId.substring(2));
		            count = Math.max(count, latestCount + 1);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    id = "GA" + String.format("%03d", count);
		    return id;
	}
	
	public void refreshField() {
		gNameField.setText("");
		gDescArea.setText("");
		gPriceField.setText("");
		
		temp = null;
	}
	
	public void refreshList() {
		getGame();
		ObservableList<Game> newgList = FXCollections.observableArrayList(gList);
		gameList.setItems(newgList);
		
		refreshField();
	}
	
	public void addGame(String gameId, String gameName, String gameDescription, int price) {
		String query = String.format("INSERT INTO game VALUES('%s', '%s', '%s', %d)", gameId, gameName, gameDescription, price);
		connect.execQueryInUp(query);
	}
	
	public void updateGame(String gameId, String gameName, String gameDescription, int price) {
		String query = "UPDATE game\n"
				+ "SET GameName = '%s', GameDescription = '%s', Price = %d\n"
				+ "WHERE GameID = '%s'";
	
		query = String.format(query, gameName, gameDescription, price, gameId);
		connect.execQueryInUp(query);	
	}
	
	public void deleteGame(String temp){
		String query = "DELETE FROM game\n"
						+ " WHERE GameID = '%s'";
		
		query = String.format(query, temp);
		connect.execQueryInUp(query);
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == add) {
			if(gNameField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("No Game Name Warning");
				alert.setHeaderText("You haven't inputted a game name");
				alert.setContentText("Please fill the game name form");
				alert.show();
			}
			
			else if(gDescArea.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("No Game Description Warning");
				alert.setHeaderText("You haven't inputted a game description");
				alert.setContentText("Please fill the game description form");
				alert.show();
			}
			
			else if(gPriceField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("No Game Price Warning");
				alert.setHeaderText("You haven't inputted a game price");
				alert.setContentText("Please fill the game price");
				alert.show();
			}
			
			else if(gDescArea.getText().length() > 250) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Input");
				alert.setHeaderText("Game Descrption is invalid");
				alert.setContentText("Game Description cannot exceed 250 characters");
				alert.show();
			}
			
			else if(gNameField.getText().length() > 50) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Input");
				alert.setHeaderText("Game Name is invalid");
				alert.setContentText("Game Name cannot exceed 50 characters");
				alert.show();
			}
			
			else if(!gPriceField.getText().matches("\\d+")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Input");
				alert.setHeaderText("Game Price is invalid");
				alert.setContentText("Game Price must be numeric");
				alert.show();
			}
			
			else if(gPriceField.getText().length() > 10) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Input");
				alert.setHeaderText("Game Price is invalid");
				alert.setContentText("Game Price cannot exceed 10 characters");
				alert.show();
			}
			
			else {
				String newgId = setId();
				String newgName = gNameField.getText();
				String newgDesc = gDescArea.getText();
				int newgPrice = Integer.valueOf(gPriceField.getText());
			
				addGame(newgId, newgName, newgDesc, newgPrice);
				refreshList();	
			}
		}
		
		else if(event.getSource() == updt) {
			if(gDescArea.getText().length() > 250) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Input");
				alert.setHeaderText("Game Descrption is invalid");
				alert.setContentText("Game Description cannot exceed 250 characters");
				alert.show();
			}
			
			else if(gNameField.getText().length() > 50) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Input");
				alert.setHeaderText("Game Name is invalid");
				alert.setContentText("Game Name cannot exceed 50 characters");
				alert.show();
			}
			
			else if(!gPriceField.getText().matches("\\d+")) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Input");
				alert.setHeaderText("Game Price is invalid");
				alert.setContentText("Game Price must be numeric");
				alert.show();
			}
			
			else if(gPriceField.getText().length() > 10) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Input");
				alert.setHeaderText("Price cannot exceed 9999999999");
				alert.setContentText("Price is too high");
				alert.show();
			}
			
			else {
				String newgName = gNameField.getText();
				String newgDesc = gDescArea.getText();
				int newgPrice = Integer.valueOf(gPriceField.getText());
			
				updateGame(temp, newgName, newgDesc, newgPrice);
				refreshList();
			}
		}
		
		else if(event.getSource() == dlt) {
		    Game selectedGame = gameList.getSelectionModel().getSelectedItem();

		    if (selectedGame != null) {
		        Alert alert = new Alert(AlertType.CONFIRMATION);
		        alert.setTitle("Delete Game");
		        alert.setHeaderText("Delete Confirmation");
		        alert.setContentText("Are you sure you want to delete this game?");
		       
		        Optional<ButtonType> result = alert.showAndWait();

		        if (result.isPresent() && result.get() == ButtonType.OK) {
		            deleteGame(temp);
		            refreshList();
		            
		            gNameField.clear();
		            gDescArea.clear();
		            gPriceField.clear();
		            
		            gName.setText("");
		            gDesc.setText("");
		            gPrice.setText("");
		        }
		    } else {
		        Alert alert = new Alert(AlertType.WARNING);
		        alert.setTitle("No Game Selected");
		        alert.setHeaderText("Delete Warning");
		        alert.setContentText("Please select a game to delete.");
		        alert.show();
		    }
		}

		
		else if(event.getSource() == menuItem) {
			main.showLoginScene();
		}
	}

	
	public AdminHomeScene(mainpage.Main main) {
		this.main = main;
		initialize();
		addComponent();
		arrange();
		setEventHandler();
		refreshList();
	}

}
