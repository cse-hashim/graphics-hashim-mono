import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;


public class Pan extends JPanel {
	double depth=10;
	Rectangle r1;
	Rectangle r2;
	/**
	 * Create the panel.
	 */
	public Pan() {
//		constructBasis();
	}
	private void constructBasis(){
		Rectangle pb=this.getParent().getBounds();
		this.setBounds(pb);
		Dimension center = new Dimension((int)(pb.getWidth()/2),(int)(pb.getHeight()/2));
		r1 =new Rectangle(100,100);
		r1.setLocation(center.width-r1.width/2,center.height-r1.height/2);
		r2 = rescale(r1, 0.5);
		////
		Dimension loc= new Dimension(center.width-r2.width/2,center.height-r2.height/2);
//		r2.setLocation((int)(loc.width+loc.width*.1),(int)(loc.width+loc.width*.3));
		r2.setLocation((int)(loc.width+5),(int)(loc.height+15));
//		r2.setLocation((int)(loc.height+5),(int)(loc.width+15));
	}
	public Rectangle rescale(Rectangle r,double p){
		return new Rectangle((int)(r.getWidth()*p),(int)(r.getHeight()*p));
	}
	boolean launched = false;
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(!launched){
			constructBasis();
			launched = true;
		}else{
			
		}
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(r1);
		g2d.draw(r2);
		g2d.fill(r2);
		drawComplementaryLines(g2d);
		
	}
	
	private void drawComplementaryLines(Graphics2D g2d) {
		g2d.drawLine((int)r1.getMaxX(), (int)r1.getMaxY(), (int)r2.getMaxX(), (int)r2.getMaxY());
		g2d.drawLine((int)r1.getMaxX(), (int)r1.getMinY(), (int)r2.getMaxX(), (int)r2.getMinY());
		g2d.drawLine((int)r1.getMinX(), (int)r1.getMaxY(), (int)r2.getMinX(), (int)r2.getMaxY());
		g2d.drawLine((int)r1.getMinX(), (int)r1.getMinY(), (int)r2.getMinX(), (int)r2.getMinY());		
	}
	
	public void moveLeft() {
		Rectangle pb=this.getParent().getBounds();
		this.setBounds(pb);
		Dimension center = new Dimension((int)(pb.getWidth()/2),(int)(pb.getHeight()/2));
//		r1 =new Rectangle(100,100);
		r1.setLocation(center.width-r1.width/2,center.height-r1.height/2);
//		r2 = rescale(r1, 0.5);
		Dimension loc= new Dimension(center.width-r2.width/2,center.height-r2.height/2);
		
//		r2.setLocation((int)(loc.width+5),(int)(loc.height+15));
//		
	
		
		r2.setLocation(r2.getLocation().x-1, r2.getLocation().y);
		r1.setLocation(r1.getLocation().x+1, r1.getLocation().y);
		repaint();
	}
	public void moveRight() {
		Rectangle pb=this.getParent().getBounds();
		this.setBounds(pb);
		Dimension center = new Dimension((int)(pb.getWidth()/2),(int)(pb.getHeight()/2));
//		r1 =new Rectangle(100,100);
		r1.setLocation(center.width-r1.width/2,center.height-r1.height/2);
//		r2 = rescale(r1, 0.5);
		Dimension loc= new Dimension(center.width-r2.width/2,center.height-r2.height/2);
		
//		r2.setLocation((int)(loc.width+5),(int)(loc.height+15));
		
		r2.setLocation(r2.getLocation().x+1, r2.getLocation().y);
		r1.setLocation(r1.getLocation().x-1, r1.getLocation().y);
		repaint();
		
	}
	
	public void moveUp() {
		Rectangle pb=this.getParent().getBounds();
		this.setBounds(pb);
		Dimension center = new Dimension((int)(pb.getWidth()/2),(int)(pb.getHeight()/2));
//		r1 =new Rectangle(100,100);
		r1.setLocation(center.width-r1.width/2,center.height-r1.height/2);
//		r2 = rescale(r1, 0.5);
		Dimension loc= new Dimension(center.width-r2.width/2,center.height-r2.height/2);
		
//		r2.setLocation((int)(loc.width+5),(int)(loc.height+15));
		
		
		r2.setLocation(r2.getLocation().x, r2.getLocation().y+1);
		r1.setLocation(r1.getLocation().x, r1.getLocation().y-1);
		repaint();
	}
	public void moveDown() {
		Rectangle pb=this.getParent().getBounds();
		this.setBounds(pb);
		Dimension center = new Dimension((int)(pb.getWidth()/2),(int)(pb.getHeight()/2));
//		r1 =new Rectangle(100,100);
		r1.setLocation(center.width-r1.width/2,center.height-r1.height/2);
//		r2 = rescale(r1, 0.5);
		Dimension loc= new Dimension(center.width-r2.width/2,center.height-r2.height/2);
		
//		r2.setLocation((int)(loc.width+5),(int)(loc.height+15));
		
		
		
		r2.setLocation(r2.getLocation().x, r2.getLocation().y-1);
		r1.setLocation(r1.getLocation().x, r1.getLocation().y+1);
		repaint();
	}
	public void rotateRight() {
		//
	}
	public void rotateLeft() {
		//
		
	}

}
