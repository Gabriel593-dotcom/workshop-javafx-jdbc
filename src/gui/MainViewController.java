package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	private void onMenuItemSellerAction() {

		System.out.println("onMenuItemSellerAction");
	}

	@FXML
	private void onMenuItemDepartmentAction() {

		loadView2("/gui/DepartmentList.fxml");
	}

	@FXML
	private void onMenuItemAboutAction() {

		loadView("/gui/About.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

	private synchronized void loadView(String absoluteName) {

		// a palavra reservsada synchronized garante que esse trecho de código não seja
		// interrompido durante o multi threading.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			// faz uma referência a mainScene.
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			// o método getRoot() pega o primeiro elemento da MainView. O cast feito pra
			// ScrollPane
			// se dá pelo fato do primeiro elemento da view ser um ScrollPane, depois um
			// cast
			// pra VBox porque a variável que vai receber esse elemento é um
			// VBox. O método getContent referencia os elementos dentro do bloco <content/>
			// no Mainview, capturando
			// uma referência para o VBox que tá na MainView.

			Node mainMenu = mainVBox.getChildren().get(0);
			// guarda uma referência do MenuBar
			mainVBox.getChildren().clear();
			// Limpa todos os componentes filhos do VBox da MainView
			mainVBox.getChildren().add(mainMenu);
			// Adiciona o menubar já existente no MainMenu
			mainVBox.getChildren().addAll(newVBox.getChildren());
			// Insere o VBox com conteúdo da view que foi passada como parâmetro
		}

		catch (Exception e) {
			Alerts.showAlert("IO Exception", "Error loading View", e.getMessage(), AlertType.ERROR);
		}
	}

	private synchronized void loadView2(String absoluteName) {

		// a palavra reservsada synchronized garante que esse trecho de código não seja
		// interrompido durante o multi threading.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			// faz uma referência a mainScene.
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			// o método getRoot() pega o primeiro elemento da MainView. O cast feito pra
			// ScrollPane
			// se dá pelo fato do primeiro elemento da view ser um ScrollPane, depois um
			// cast
			// pra VBox porque a variável que vai receber esse elemento é um
			// VBox. O método getContent referencia os elementos dentro do bloco <content/>
			// no Mainview, capturando
			// uma referência para o VBox que tá na MainView.

			Node mainMenu = mainVBox.getChildren().get(0);
			// guarda uma referência do MenuBar
			mainVBox.getChildren().clear();
			// Limpa todos os componentes filhos do VBox da MainView
			mainVBox.getChildren().add(mainMenu);
			// Adiciona o menubar já existente no MainMenu
			mainVBox.getChildren().addAll(newVBox.getChildren());
			// Insere o VBox com conteúdo da view que foi passada como parâmetro

			DepartmentListController controller = loader.getController();
			// a partir do objeto loader da classe FXMLLoader, podemos tanto
			// carregar uma view como também acesser o seu controller.
			controller.setDeparmentService(new DepartmentService());
			controller.updateTableView();
		}

		catch (Exception e) {
			Alerts.showAlert("IO Exception", "Error loading View", e.getMessage(), AlertType.ERROR);
		}
	}

}
