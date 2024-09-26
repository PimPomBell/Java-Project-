package mainpage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	Stage stage;
	Scene scene;

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		showLoginScene();
	}

	public void showLoginScene() {
		view.LoginScene login = new view.LoginScene(this);
		scene = login.returnScene();
        stage.setTitle("SNeam");
        stage.setScene(scene);
        stage.show();
	}
		public void showRegistScene() {
		view.RegisterScene regis = new view.RegisterScene(this);
		scene = regis.returnScene();
        stage.setTitle("SNeam");
        stage.setScene(scene);
        stage.show();
	}
	
	public void showHomeScene() {
		view.HomeScene home = new view.HomeScene(this);
		scene = home.returnScene();
		stage.setTitle("SNeam");
		stage.setScene(scene);
		stage.show();
	}
	
	public void showCartScene() {
		view.CartScene home = new view.CartScene(this);
		scene = home.returnScene();
		stage.setTitle("SNeam");
		stage.setScene(scene);
		stage.show();
	}
	
	public void showAdmHomeScene() {
		view.AdminHomeScene home = new view.AdminHomeScene(this);
		scene = home.returnScene();
		stage.setTitle("SNeam");
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
