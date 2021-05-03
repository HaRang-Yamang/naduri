package com.harang.naduri.jdbc.spot.model.vo;

import java.io.Serializable;


public class LatLng implements Serializable{
	
	private static final long serialVersionUID = 1818L;

	
	private double swlat;
	private double swlng;
	private	double nelat;
	private double nelng;
	
	
	public LatLng() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LatLng(double swlat, double swlng, double nelat, double nelng) {
		super();
		this.swlat = swlat;
		this.swlng = swlng;
		this.nelat = nelat;
		this.nelng = nelng;
	}


	@Override
	public String toString() {
		return "LatLng [swlat=" + swlat + ", swlng=" + swlng + ", nelat=" + nelat + ", nelng=" + nelng + "]";
	}


	public double getSwlat() {
		return swlat;
	}


	public void setSwlat(double swlat) {
		this.swlat = swlat;
	}


	public double getSwlng() {
		return swlng;
	}


	public void setSwlng(double swlng) {
		this.swlng = swlng;
	}


	public double getNelat() {
		return nelat;
	}


	public void setNelat(double nelat) {
		this.nelat = nelat;
	}


	public double getNelng() {
		return nelng;
	}


	public void setNelng(double nelng) {
		this.nelng = nelng;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
