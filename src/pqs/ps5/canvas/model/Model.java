package pqs.ps5.canvas.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.google.common.annotations.VisibleForTesting;

/**
 * Model of multi-window canvas app. Model is in Observer pattern and it powers 
 * the game and communicate with viewers by listener interfaces. Create a new 
 * Model by <code>new Model();</code>. 
 * <p>
 * Use default Equals(), toString(), hashCode() as default is good.
 * 
 * @author Songxiao Zhang
 * @version   1.0
 */
public class Model {
  
  /** 
   * listeners list keeps track of all listeners hearing model's Listener
   * interface. 
   */
  @VisibleForTesting List<Listener> listeners = new ArrayList<Listener>();
  
  /**
   * Add listener to listening list via Listener interface
   * 
   * @param listener    listener implementing Listener interface in Observer 
   *                    pattern
   */
  public void addListener(Listener listener) {
    this.listeners.add(listener);
  }
  
  /**
   * Remove listener from listening list via Listener interface
   * 
   * @param listener    listener implementing Listener interface in Observer 
   *                    pattern
   */
  public void removeListener(Listener listener) {
    this.listeners.remove(listener);
  }
  
  /**
   * When a view receives user command to draw a line with a start point and 
   * end point, this function informs all views to draw this line. 
   * 
   * @param startPoint the start point of the line to draw
   * @param endPoint   the end point of the line to draw
   */
  public void startDraw(Point startPoint, Point endPoint) {
    for (Listener listener : this.listeners) {
      listener.draw(startPoint, endPoint);
    }
  }
  
}
