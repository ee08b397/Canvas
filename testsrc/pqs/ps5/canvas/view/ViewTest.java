package pqs.ps5.canvas.view;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import pqs.ps5.canvas.model.Model;

public class ViewTest {

  private Model model;
  private View view;
  
  @Before
  public void setUp() {
    model = new Model();
    view = new View(this.model);
  }

  @Test
  public void testHandlePressed() {
    view.handlePressed(new Point(3, 1));
    
    assertEquals(view.getStartPoint().x, 3);
    assertEquals(view.getStartPoint().y, 1);
  }
  
  @Test
  public void testHandleDragged() {
    view.handlePressed(new Point(3, 1));
    view.handleDragged(new Point(2, 4));
    
    assertEquals(view.getStartPoint().x, 2);
    assertEquals(view.getStartPoint().y, 4);
  }
  
  @Test
  public void testGetStartPoint() {
    this.model.startDraw(new Point(3, 1), new Point(2, 4));
    
    assertEquals(view.getStartPoint().x, 2);
  }

}
