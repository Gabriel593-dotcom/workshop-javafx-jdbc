package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;
	// padr�o para declara��o de elementos MenuItem

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

		System.out.println("onMenuItemDepartmentAction");
	}

	@FXML
	private void onMenuItemAboutAction() {

		System.out.println("onMenuItemAboutAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

}