package pqs.ps5.canvas.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Model {
  
  private List<Listener> listeners = new ArrayList<Listener>();
  
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
  
  public void startDraw(Point startPoint, Point endPoint) {
    for (Listener listener : this.listeners) {
      listener.draw(startPoint, endPoint);
    }
  }
  
}
