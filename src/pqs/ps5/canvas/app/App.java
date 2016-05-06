package pqs.ps5.canvas.app;

import pqs.ps5.canvas.model.Model;
import pqs.ps5.canvas.view.View;

public class App {
  
  private final static App instance = new App();
  
  private App() {
    
  }
  
  public static App getInstance() {
    return instance;
  }

  private void startGame() {
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
