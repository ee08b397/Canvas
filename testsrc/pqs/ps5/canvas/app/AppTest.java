package pqs.ps5.canvas.app;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

  private App canvasApp;
  
  @Before
  public void setUp() {
    canvasApp = App.getInstance();
  }
  
  @Test
  public void testStartGame() {
    this.canvasApp.startGame();
    assertTrue(true);
  }
  
  @Test
  public void testSameApp() {
    App testApp = App.getInstance();
    assertTrue(this.canvasApp.equals(testApp));
  }
}
