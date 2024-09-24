package view;

import java.sql.ResultSet;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.Window;
import model.Game;
import model.User;

public class HomeScene implements EventHandler<ActionEvent>{
	ObservableList<Game> gList = FXCollections.observableArrayList();
	ObservableList<User> uList = FXCollections.observableArrayList();
	BorderPane border1, border2;
	GridPane grid;
	VBox vbox1, vbox2;
	HBox hbox;
	Scene scene;
	Label greetTitle, gName, gDesc, gPrice;
	ListView<Game> gameList;
	Button add;
	MenuBar menuBar;
	Menu menu1, menu2;
	MenuItem menuItem1, menuItem2, menuItem3;
	
	private Connect connect;
	private mainpage.Main main;
	
	public void initialize() {
		border1 = new BorderPane();
		border2 = new BorderPane();
		grid = new GridPane();
		vbox1 = new VBox();
		vbox2 = new VBox();
		hbox = new HBox();
		
		scene = new Scene(border1, 750, 700);
		
		greetTitle = new Label("Hello, " + LoginScene.getName);
		gName = new Label();
		gDesc = new Label();
		gPrice = new Label();
	
		gameList = new ListView<Game>();
		
		add = new Button("Add To Cart");
		add.setVisible(false);
		
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
   
    	vbox1.getChildren().add(gameList);
    	vbox2.getChildren().addAll(gName, gDesc, gPrice, add);
    	
    	
    	
    	hbox.getChildren().addAll(vbox1, vbox2);
    	
    	grid.add(hbox, 0, 0);
    	
	}
	
	public void arrange() {
		 grid.setPadding(new Insets(10,10,10,125));
		 BorderPane.setAlignment(greetTitle, Pos.CENTER);
		 vbox2.setAlignment(Pos.CENTER);
		 gName.setAlignment(Pos.CENTER);
		 hbox.setSpacing(10);
		 vbox2.setSpacing(10);
		 greetTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 28;");
		 gName.setStyle("-fx-font-weight: bold; -fx-font-size: 22;");
	     gName.setWrapText(true);
		 gDesc.setWrapText(true);
	    
	     add.setPrefWidth(240); 
	     add.setPrefHeight(35);
	     
	     gName.setPrefWidth(250);
	     gDesc.setPrefWidth(250);
		 	     
		 border1.setTop(menuBar);
		 border2.setTop(greetTitle);
		 border1.setCenter(border2);
		 border2.setCenter(grid);
	}
	

	
	public void setEventHandler() {
		add.setOnAction(this);
		menuItem1.setOnAction(this);
		menuItem2.setOnAction(this);
		menuItem3.setOnAction(this);
		
		gameList.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getSource() == gameList) {
					Game selectGame = gameList.getSelectionModel().getSelectedItem();
					if(selectGame != null) {
						gName.setText(selectGame.getGameName());
						gDesc.setText(selectGame.getGameDescription());
						gPrice.setText("Rp" + selectGame.getPrice());
						add.setVisible(true);
					}
					else if (selectGame == null){
						gName.setText("");
						gDesc.setText("");
						gPrice.setText("");
						add.setVisible(false);
					}
				}
			}
			
		});
	}

	public Scene returnScene() {
		return scene;
	}
	
	private void getGame() {
		String query = "SELECT * FROM game";
		connect.rs = connect.execQueryGetData(query);
		
		try {
			while(connect.rs.next()) {
				String gameId = connect.rs.getString("GameID");
				String gameName = connect.rs.getString("GameName");
				String gameDesc = connect.rs.getString("GameDescription");
				int gamePrice = connect.rs.getInt("Price");
				
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
	
	   private int getCartQuantity(Game game) {
           String checkQuery = String.format("SELECT Quantity FROM cart WHERE UserID = '%s' AND GameID = '%s'",
                   LoginScene.getId, game.getGameId());

           ResultSet resultSet = connect.execQueryGetData(checkQuery);

           try {
               if (resultSet.next()) {
                   return resultSet.getInt("Quantity");
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return 0;
       }
	   
	public void showWindow() {
		    //Initialize
		    Stage stage1 = new Stage();
		    Window window = new Window();
		    BorderPane border1 = new BorderPane();
		    GridPane grid1 = new GridPane();
		    VBox vbox = new VBox();
		    Label takegName = new Label();
		    Label takegDesc = new Label();
		    Label takegPrice = new Label();
		    Button add2 = new Button("Add To Cart");
		    Spinner<Integer> qty = new Spinner<>(0, 10, 0);
		    Pane pane = new Pane();
		    
		    //Add Component
		    grid1.add(takegName, 0, 0);
		    grid1.add(takegDesc, 0, 1);

		    vbox.getChildren().addAll(takegPrice, qty, add2);

		    window.setContentPane(border1);

		    Scene scene1 = new Scene(pane, 300, 420);
		    window.setPrefSize(300, 420);
		     
		    window.setMovable(false);
		    
		    window.setTitle("Add To Cart");
		    
		    //Arrange
		    grid1.setVgap(10);
		    vbox.setSpacing(10);
		    border1.setPadding(new Insets(10));
		    border1.setTop(grid1);
		    border1.setBottom(vbox);
		    
		    BorderPane.setAlignment(grid1, Pos.CENTER);
		    grid1.setAlignment(Pos.CENTER);
		    vbox.setAlignment(Pos.CENTER);
		    
		    GridPane.setHalignment(takegName, HPos.CENTER);
		    GridPane.setHalignment(takegDesc, HPos.CENTER);
		    
		    takegName.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
		    takegDesc.setStyle("-fx-font-size: 19;");
		    takegPrice.setStyle("-fx-font-size: 17;");
		    
		    takegDesc.setWrapText(true);
		    
		    Game selectGame = gameList.getSelectionModel().getSelectedItem();

		    int initialQuantity = getCartQuantity(selectGame);
	        qty.getValueFactory().setValue(initialQuantity);
		    
		    takegName.setText(selectGame.getGameName());
		    takegDesc.setText(selectGame.getGameDescription());
		    takegPrice.setText("Rp" + selectGame.getPrice());   
		    
		    pane.getChildren().add(window);
		    
		    stage1.setScene(scene1);
		    stage1.show();
		    
		    add2.setOnAction(new EventHandler<ActionEvent>() {
	
		    private boolean insideCart(Game game) {
		        String checkQuery = String.format("SELECT * FROM cart WHERE UserID = '%s' AND GameID = '%s'",
		                LoginScene.getId, game.getGameId());

		        ResultSet resultSet = connect.execQueryGetData(checkQuery);

		        try {
		            return resultSet.next();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return false;
		        }
		    }

		    private void insertCart(Game game, int quantity) {
		        String insertQuery = String.format("INSERT INTO cart VALUES('%s', '%s', %d)",
		                LoginScene.getId, game.getGameId(), quantity);

		        connect.execQueryInUp(insertQuery);
		    }
		    
		    private void updateCartQuantity(Game game, int newQuantity) {
		        String updateQuery = String.format("UPDATE cart SET Quantity = %d WHERE UserID = '%s' AND GameID = '%s'",
		                newQuantity, LoginScene.getId, game.getGameId());

		        connect.execQueryInUp(updateQuery);
		    }

		    private void deleteCart(Game game) {
		        String deleteQuery = String.format("DELETE FROM cart WHERE UserID = '%s' AND GameID = '%s'",
		                LoginScene.getId, game.getGameId());

		        connect.execQueryInUp(deleteQuery);
		    }

		     @Override
		        public void handle(ActionEvent event) {
		            int quantity = qty.getValue();
		            if (quantity == 0) {
		                if (insideCart(selectGame)) {
		                    deleteCart(selectGame);
		                }
		                stage1.close();
		            } else {
		                if (insideCart(selectGame)) {
		                    updateCartQuantity(selectGame, quantity);
		                } 
		                else {
		                    insertCart(selectGame, quantity);
		                }

		                main.showCartScene();
		                stage1.close();
		            }
		        }
		    });
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == add) {
			showWindow();
			
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
	
	public HomeScene(mainpage.Main main) {
		this.main = main;
		initialize();
		addComponent();
		arrange();
		getGame();
		setEventHandler();
		
	}
}
