package com.rent.car.helper;

public class RentCarException extends Exception	{
	private String message;
	
	public RentCarException(String str)	{
		super(str);
		this.message = str;
	}
	
	@Override
	public String toString()	{
		return this.message;
	}
}
