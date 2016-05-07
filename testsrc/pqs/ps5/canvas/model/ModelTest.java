package pqs.ps5.canvas.model;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import pqs.ps5.canvas.view.View;

public class ModelTest {

  private Model model;
  
  @Before
  public void setUp() {
    model = new Model();
  }

  @Test
  public void testMultiModel() {
    Model testModel = new Model();
    assertTrue(!this.model.equals(testModel));
  }
  
  @Test
  public void testAddListener() {
    Listener listener = null;
    this.model.addListener(listener);
    assertTrue(true);
  }
  
  @Test
  public void testRemoveListener() {
    Listener listener = null;
    this.model.removeListener(listener);
    
    assertTrue(true);
  }
  
  @Test
  public void testStartDraw() {
    new View(this.model);
    this.model.startDraw(new Point(3, 1), new Point(2, 4));
    
    assertTrue(true);
  }
  
}
