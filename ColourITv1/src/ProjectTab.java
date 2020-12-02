import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A GUI tab containing components for handling projects.
 *
 * @author Luis Fernandez
 * @version 1.0
 */
public class ProjectTab extends Tab
{
  private VBox projectPane;
  private HBox projectTopPane;
  private FlowPane listPane;

  private Label idLabel;
  private Label titleLabel;
  private Label descriptionLabel;

  private GridPane projectInputPane;

  private TableView<Project> allProjectsTable;
  private TableView.TableViewSelectionModel<Project> defaultSelectionModel;
  private TableColumn<Project, String> idColumn;
  private TableColumn<Project, String> titleColumn;
  private TableColumn<Project, String> descriptionColumn;

  private TextField idField;
  private TextField titleField;
  private TextField descriptionField;

  private FlowPane imagePane;
  private Image logo;
  private ImageView logoView;

  private Button createButton;

  private MyActionListener listener;
  private MyListListener listListener;

  private ProjectFileAdapter adapter;

  /**
   * Constructor initializing the GUI components
   *
   * @param title   The title of the tab
   * @param adapter ProjectFileAdapter object used for retrieving and storing project information
   */
  public ProjectTab(String title, ProjectFileAdapter adapter)
  {
    super(title);

    this.adapter = adapter;

    listener = new MyActionListener();
    listListener = new MyListListener();

    createButton = new Button("Update");
    createButton.setOnAction(listener);

    projectPane = new VBox(20);
    projectPane.setPadding(new Insets(10));

    projectTopPane = new HBox(20);

    allProjectsTable = new TableView<Project>();
    defaultSelectionModel = allProjectsTable.getSelectionModel();
    allProjectsTable.setPrefHeight(290);

    idColumn = new TableColumn<Project, String>("Project ID");
    idColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("id"));
    idColumn.setPrefWidth(165);

    titleColumn = new TableColumn<Project, String>("Title");
    titleColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("title"));
    titleColumn.setPrefWidth(165);

    descriptionColumn = new TableColumn<Project, String>("Description");
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("Description"));
    descriptionColumn.setPrefWidth(165);

    allProjectsTable.getColumns().add(idColumn);
    allProjectsTable.getColumns().add(titleColumn);
    allProjectsTable.getColumns().add(descriptionColumn);

    listPane = new FlowPane();
    listPane.setAlignment(Pos.BASELINE_RIGHT);
    listPane.setPrefWidth(200);
    listPane.getChildren().add(allProjectsTable);

    idLabel = new Label("Project ID:");
    titleLabel = new Label("Title:");
    descriptionLabel = new Label("Description:");

    idField = new TextField();
    titleField = new TextField();
    descriptionField = new TextField();

    projectInputPane = new GridPane();
    projectInputPane.setHgap(5);
    projectInputPane.setVgap(5);
    projectInputPane.addRow(0, idLabel, idField);
    projectInputPane.addRow(1, titleLabel, titleField);
    projectInputPane.addRow(2, descriptionLabel, descriptionField);

    projectTopPane.getChildren().add(projectInputPane);
    projectTopPane.getChildren().add(allProjectsTable);
/*
    logo = new Image("file:img/vialogoah.gif");
    logoView = new ImageView(logo);
    imagePane = new FlowPane();
    imagePane.setPrefHeight(200);
    imagePane.setAlignment(Pos.BOTTOM_CENTER);
    imagePane.getChildren().add(logoView);
*/
    projectPane.getChildren().add(projectTopPane);
    projectPane.getChildren().add(createButton);

    //projectPane.getChildren().add(imagePane);

    super.setContent(projectPane);
  }


  /**
   * Updates the studentListView ListView with information from the students file
   */
  public void updateProjectsTable()
  {
    int currentIndex = allProjectsTable.getSelectionModel().getSelectedIndex();

    allProjectsTable.getItems().clear();

    ProjectList students = adapter.getAllProjects();
    for (int i = 0; i < students.size(); i++)
    {
      allProjectsTable.getItems().add(students.getProject(i));
    }

    if (currentIndex == -1 && allProjectsTable.getItems().size() > 0)
    {
      allProjectsTable.getSelectionModel().select(0);
    }
    else
    {
      allProjectsTable.getSelectionModel().select(currentIndex);
    }
  }

  /*
   * Inner action listener class
   * @author Luis Fernandez
   * @version 1.0
   */
  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if (e.getSource() == createButton)
      {
        String id = idField.getText();
        String title = titleField.getText();
        String description = descriptionField.getText();

        if (description.equals(""))
        {
          description = "?";
        }

        Project project = new Project(id, title, description);

        adapter.addProject(project);
        updateProjectsTable();
        idField.setText("");
        titleField.setText("");
        descriptionField.setText("");
      }
    }
  }

  /*
   * Inner change listener class for the ListView
   * @author Luis Fernandez
   * @version 1.0
   */
  private class MyListListener implements ChangeListener<Project>
  {
    public void changed(ObservableValue<? extends Project> project,
        Project oldProject, Project newProject)
    {
      Project temp = allProjectsTable.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        idField.setText(temp.getId());
        titleField.setText(temp.getTitle());
        descriptionField.setPromptText(temp.getDescription());
      }
    }
  }
}

