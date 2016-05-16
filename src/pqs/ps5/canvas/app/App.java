package pqs.ps5.canvas.app;

import pqs.ps5.canvas.model.Model;
import pqs.ps5.canvas.view.View;

/**
 * This is a multi-window canvas app where users can paint on a canvas using 
 * the mouse. There is a single model of the canvas and all windows can see 
 * changes made to the canvas in any other window. Model is in Observer pattern 
 * and it powers the game and viewers communicate with model by listener 
 * interfaces. 
 * <p>
 * Make a new application by get instance from singleton. E.g., <code>
 * App canvasApp = App.getInstance();</code> and startGame(). 
 * <p>
 * Use default toString() and hashCode() is good enough. Equals() will not be 
 * used as it is singleton. v1 Game is unit testted under testsrc/ and 94.9% 
 * code coverage. 
 * 
 * @author    Songxiao Zhang
 * @version   1.0
 */
public class App {
  
  /**
   * Singleton canvas application
   */
  private final static App instance = new App();
  
  private App() {
    
  }
  
  /**
   * Get singleton canvas application
   * 
   * @return    Return singleton canvas application instance. 
   */
  public static App getInstance() {
    return instance;
  }

  /**
   * Start canvas game application! Make a new Model E.g., <code>Model 
   * model = new Model();</code> and add viewer(s). startGame() at last.
   */
  public void startGame() {
    Model model = new Model();
    new View(model);
    new View(model);
    new View(model);
  }
  
  public static void main(String[] args) {
    App canvasApp = App.getInstance();
    canvasApp.startGame();
  }
  
}
