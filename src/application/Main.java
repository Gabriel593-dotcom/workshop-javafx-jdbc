package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Scene mainScene;

	@Override
	public void start(Stage stage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			// chamar o arquivo atrav�s de uma inst�ncia permite que manipular a tela antes
			// de carregar.
			ScrollPane scrollPane = loader.load();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			mainScene = new Scene(scrollPane);
			stage.setScene(mainScene);
			stage.setTitle("Sample example for main view");

			stage.show();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
