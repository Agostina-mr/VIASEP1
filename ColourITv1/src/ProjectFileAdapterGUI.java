import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ButtonType;

/**
 * A user interface that allows for displaying and modifying information about projects.
 * @author Luis Fernandez
 * @version 1.0
 */

public class ProjectFileAdapterGUI extends Application
{
  private ProjectFileAdapter adapter;

  private VBox mainPane;

  private TabPane tabPane;
  private ProjectTab projectTab;

  private MenuBar menuBar;

  private Menu fileMenu;
  private Menu aboutMenu;

  private MenuItem exitMenuItem;
  private MenuItem aboutMenuItem;

  private CheckMenuItem editTableMenuItem;
  private CheckMenuItem editFieldsMenuItem;

  private MyActionListener listener;
  private MyTabListener tabListener;

  /**
   * @param window The Stage object that will be displayed
   */
  public void start(Stage window)
  {
    window.setTitle("ColourIT Project Manager");

    String file = "C:\\Users\\lfpon\\OneDrive - ViaUC\\sdj\\lesson25\\Car\\projects.bin";

    adapter = new ProjectFileAdapter(file);

    listener = new MyActionListener();
    tabListener = new MyTabListener();

    tabPane = new TabPane();
    tabPane.getSelectionModel().selectedItemProperty().addListener(tabListener);

    projectTab = new ProjectTab("Projects", adapter);

    tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
    tabPane.getTabs().add(projectTab);

    exitMenuItem = new MenuItem("Exit");
    exitMenuItem.setOnAction(listener);

    aboutMenuItem = new MenuItem("About");
    aboutMenuItem.setOnAction(listener);

    editTableMenuItem = new CheckMenuItem("Select in student table");
    editTableMenuItem.setSelected(true);
    editTableMenuItem.setOnAction(listener);

    editFieldsMenuItem = new CheckMenuItem("Edit name fields");
    editFieldsMenuItem.setOnAction(listener);

    fileMenu = new Menu("File");
    aboutMenu = new Menu("About");

    fileMenu.getItems().add(exitMenuItem);

    aboutMenu.getItems().add(aboutMenuItem);

    menuBar = new MenuBar();

    menuBar.getMenus().add(fileMenu);
    menuBar.getMenus().add(aboutMenu);

    mainPane = new VBox();
    mainPane.getChildren().add(menuBar);
    mainPane.getChildren().add(tabPane);

    Scene scene = new Scene(mainPane, 800, 400);

    window.setScene(scene);
    window.setResizable(false);
    window.show();
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
      if (e.getSource() == exitMenuItem)
      {
        Alert alert = new Alert(AlertType.CONFIRMATION,
            "Do you really want to exit the program?",
            ButtonType.YES, ButtonType.NO);
        alert.setTitle("Exit");
        alert.setHeaderText(null);

        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES)
        {
          System.exit(0);
        }
      }

      else if (e.getSource() == aboutMenuItem)
      {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("ColourIT Project Manager.");
        alert.showAndWait();
      }
    }
  }

  /*
   * Inner change listener class
   * @author Luis Fernandez
   * @version 1.0
   */
  private class MyTabListener implements ChangeListener<Tab>
  {
    public void changed(ObservableValue<? extends Tab> tab, Tab oldTab, Tab newTab)
    {
      if (newTab == projectTab)
      {
        projectTab.updateProjectsTable();
      }
    }
  }
}
