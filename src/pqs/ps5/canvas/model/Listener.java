package pqs.ps5.canvas.model;

import java.awt.Point;

/**
 * Observer pattern Listener interfaces between model and views. 
 *  
 * @author Songxiao Zhang
 * @version   1.0
 */
public interface Listener {
  
  /**
   * This method is called whenever a new line is about to draw in all viewers.
   * 
   * @param startPoint the start point of the line to draw
   * @param endPoint   the end point of the line to draw
   */
  void draw(Point startPoint, Point endPoint);
  
}
