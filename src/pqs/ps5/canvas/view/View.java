package pqs.ps5.canvas.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pqs.ps5.canvas.model.Listener;
import pqs.ps5.canvas.model.Model;

/**
 * View of multi-window canvas app. It implements the Listener interface and
 * add itself to model listener list hearing updates. Create a new View by
 * <code>new View();</code>. Default view size is 400 by 400. 
 * <p>
 * Use default Equals(), toString(), hashCode() as default is good.
 * 
 * @author Songxiao Zhang
 * @version   1.0
 */
public class View implements Listener {
  
  /** 
   * model is an implementation of Model in Observer pattern, it listens. 
   */
  private Model model;
  
  /** java.swing components */
  private JFrame frame;
  private JPanel panel;
  
  /** The start point of a new line */
  private Point startPoint;
  
  public View(Model model) {
    this.model = model;
    model.addListener(this);
    
    this.frame = new JFrame("Canvas");
    this.panel = new JPanel(new BorderLayout());
    this.panel.setBackground(Color.WHITE);
    
    this.panel.addMouseListener(new MouseAdapter() {
      
      @Override
      public void mousePressed(MouseEvent e) {
        handlePressed(new Point(e.getPoint()));
      }
    });
    
    this.panel.addMouseMotionListener(new MouseMotionAdapter() {
      
      @Override
      public void mouseDragged(MouseEvent e) {
        handleDragged(new Point(e.getPoint()));
      }
    });
    
    this.frame.getContentPane().add(panel);
    this.frame.setSize(400, 400);
    this.frame.setResizable(false);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setVisible(true);
  }
  
  /**
   * Handles the mouse pressed event. It set the pressed point as the start
   * point of a line to draw. 
   * 
   * @param startPoint the start point of the line to draw
   */
  private void handlePressed(Point startPoint) {
    this.startPoint = startPoint;
  }
  
  /**
   * Handles the mouse dragged event. It set the pressed point as the end
   * point of a line to draw. 
   * 
   * @param endPoint   the end point of the line to draw
   */
  private void handleDragged(Point endPoint) {
    this.model.startDraw(this.startPoint, endPoint);
  }

  /* (non-Javadoc)
   * @see pqs.ps5.canvas.model.Listener#draw(java.awt.Point, java.awt.Point)
   */
  @Override
  public void draw(Point startPoint, Point endPoint) {
    Graphics graphics = this.panel.getGraphics();
    Graphics2D graphics2D = (Graphics2D) graphics;
    graphics2D.setStroke(new BasicStroke(4));
    graphics2D.draw(new Line2D.Float(startPoint.x, startPoint.y, endPoint.x, 
        endPoint.y));
    
    this.startPoint = endPoint;
    graphics.dispose();
  }
  
}
