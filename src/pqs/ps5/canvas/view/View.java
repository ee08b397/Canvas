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

public class View implements Listener {
  
  private Model model;
  private JFrame frame;
  private JPanel panel;
  private Point startPoint;
  
  public View(Model model) {
    this.model = model;
    model.addListener(this);
    
    this.frame = new JFrame("Canvas");
    this.panel = new JPanel(new BorderLayout());
    this.panel.setBackground(Color.WHITE);
    
    
    this.panel.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        handlePressed(new Point(e.getPoint()));
      }
    });
    
    this.panel.addMouseMotionListener(new MouseMotionAdapter() {
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
  
  public void handlePressed(Point startPoint) {
    this.startPoint = startPoint;
  }
  
  private void handleDragged(Point endPoint) {
    this.model.startDraw(this.startPoint, endPoint);
  }

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
