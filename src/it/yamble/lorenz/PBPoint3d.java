package it.yamble.lorenz;

/*
 * Un generico punto in uno spazio 3-dimensionale 
 * 
 * */


public class PBPoint3d {
	private Double x;
	private Double y;
	private Double z;
	

	
	public PBPoint3d(Double x, Double y, Double z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	
	public PBPoint3d(){
		this.setX(0d);
		this.setY(0d);
		this.setZ(0d);
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getY() {
		return y;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getX() {
		return x;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public Double getZ() {
		return z;
	}
	
	public boolean equals(Object point) {
		
		 if ( this == point ) return true;
		 
		 if ( !(point instanceof PBPoint3d) ) return false;
		 PBPoint3d aPoint = (PBPoint3d)point;
		 return (aPoint.getZ().compareTo(this.getZ()) == 0) &&
		 		(aPoint.getX().compareTo(this.getX()) == 0) &&
		 		(aPoint.getY().compareTo(this.getY()) == 0);
				
	}
	
	public String toString(){
		return "PBPoint3D[" + this.getX().toString() + ", "  + this.getY().toString() + ", " + this.getZ().toString() + "]";
	}
		
		
}
