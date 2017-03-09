package it.yamble.lorenz;

import java.awt.geom.Point2D;

/*
 * Un generico punto in uno spazio 3-dimensionale 
 * 
 * */


public class PBPoint2d{
	private Double x;
	private Double y;
	

	
	public PBPoint2d(Double x, Double y) {
		this.setX(x);
		this.setY(y);
	}
	
	public PBPoint2d(){
		this.setX(0d);
		this.setY(0d);
	}

	public void setY(Double y) {
		if(y.equals(-0d)){
			y = -1 * y;
		}
		this.y = y;
	}

	public Double getY() {
		return y;
	}

	public void setX(Double x) {
		if(x.equals(-0d)){
			x = -1 * x;
		}
		this.x = x;
	}

	public Double getX() {
		return x;
	}
	
	
	public boolean equals(Object point) {
		
		 if ( this == point ) return true;
		 
		 if ( !(point instanceof PBPoint2d) ) return false;
		 PBPoint2d aPoint = (PBPoint2d)point;
		 return (aPoint.getX().compareTo(this.getX()) == 0) &&
		 		(aPoint.getY().compareTo(this.getY()) == 0);
				
	}

	public Point2D toPoint2D() {
		return new Point2D.Double(this.getX(), this.getY());
	}
	
	public String toString(){
		return "PBPoint2D[" + this.getX().toString() + ", " + this.getY().toString() + "]";
	}	
}
