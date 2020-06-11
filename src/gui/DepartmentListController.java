package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService service;

	public void setDeparmentService(DepartmentService service) {
		this.service = service;
	}

	@FXML
	private TableView<Department> tableViewDepartment;
	// referência a tableview.

	@FXML
	private TableColumn<Department, Integer> tableColumnId;

	@FXML
	private TableColumn<Department, String> tableColumnName;

	@FXML
	private Button btNew;

	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}

	private ObservableList<Department> obsListDepartment;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		// método responsável por inicializar corretamente o comportamento
		// das colunas da table.

		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		// maneira padrão do javafx para iniciar o comportmamento
		// das colunas de uma tableview.

		Stage stage = (Stage) Main.getMainScene().getWindow();
		// captura uma referência do stage na MainView, pegando
		// as propriedades da janela da mainscene.
		// (Como window é uma superclasse de Stage, é preciso fazer um downcasting
		// para Stage na atribuição da referência).

		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		// atribui as propriedades de altura da MainScene para a tableview.
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

		List<Department> list = service.findAll();
		obsListDepartment = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsListDepartment);
	}

}
