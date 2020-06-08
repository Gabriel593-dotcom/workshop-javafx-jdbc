package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));

			// chamar o arquivo através de uma instância permite que manipular a tela antes
			// de carregar.
			Parent parent = loader.load();
			Scene mainScene = new Scene(parent);
			stage.setScene(mainScene);
			stage.setTitle("Sample example for main view");

			stage.show();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
