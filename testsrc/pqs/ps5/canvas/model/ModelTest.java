package pqs.ps5.canvas.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
    assertEquals(this.model.listeners.size(), 0);
    assertEquals(testModel.listeners.size(), 0);
  }
  
  @Test
  public void testAddNullListener() {
    Listener listener = null;
    this.model.addListener(listener);
    assertEquals(this.model.listeners.size(), 1);
    assertNull(this.model.listeners.get(0));
  }
  
  @Test
  public void testAddListener() {
    View view1 = new View(this.model);
    assertEquals(this.model.listeners.size(), 1);
    assertEquals(this.model.listeners.get(0), view1);
    
    View view2 = new View(this.model);
    assertEquals(this.model.listeners.size(), 2);
    assertEquals(this.model.listeners.get(1), view2);
  }
  
  @Test
  public void testRemoveListener() {
    View view = new View(this.model);
    assertEquals(this.model.listeners.size(), 1);
    this.model.removeListener(view);
    assertEquals(this.model.listeners.size(), 0);
  }
  
  @Test
  public void testRemoveEmptyListenerList() {
    this.model.removeListener(null);
    assertEquals(this.model.listeners.size(), 0);
  }
  
  @Test
  public void testStartDraw() {
    View view1 = new View(this.model);
    View view2 = new View(this.model);
    this.model.startDraw(new Point(3, 1), new Point(2, 4));
    
    assertEquals(view1.getStartPoint().x, 2);
    assertEquals(view1.getStartPoint().y, 4);
    assertEquals(view2.getStartPoint().x, 2);
    assertEquals(view2.getStartPoint().y, 4);
  }
  
}
