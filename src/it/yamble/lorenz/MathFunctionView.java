package it.yamble.lorenz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;




public class MathFunctionView extends javax.swing.JFrame  {
	

	private static final long serialVersionUID = -642950141916102086L;
	
	private Dimension screenSize = new Dimension(1024, 768);
	private Point2D centerPoint = new Point2D.Double((screenSize.width/2), screenSize.height/2);
	private double zoomLevel = 1d;
	private Color currentPointColor = Color.white;
	
	   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MathFunctionView();
            }
        });
    }
    
    public MathFunctionView() {
		this.setSize(screenSize);
		this.setBackground(Color.black);
		this.setVisible(true);
	}
	
	public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        PerspectiveProjection projector = new PerspectiveProjection();
        Point2D nextPoint = new Point2D.Double(0d,0d);
        Line2D nextPointLine = new Line2D.Double(nextPoint, nextPoint);
        Lorenz lorenzAttractor = new Lorenz();
               
        try {
			projector.setViewerPosition(new PBPoint3d(0d, 0d, 2d));
		} catch (ViewerCantStayAtOriginException e) {
			e.printStackTrace();
		}
		
        lorenzAttractor.setMaxIterations(100000);
        
        Point2D pointToPlot;
        while (lorenzAttractor.hasMorePoints()) {
           	pointToPlot = projector.project(lorenzAttractor.getNextPoint()).toPoint2D();
			pointToPlot.setLocation(centerPoint.getX() + (pointToPlot.getX() * zoomLevel),
        							centerPoint.getY() + (pointToPlot.getY() * zoomLevel));
        	
        	nextPointLine.setLine(pointToPlot, pointToPlot);
        	currentPointColor = new Color(currentPointColor.getRGB() + 0xF); 
        	g2.setColor(currentPointColor);
        	g2.draw(nextPointLine);			
		}
        
    }
}

