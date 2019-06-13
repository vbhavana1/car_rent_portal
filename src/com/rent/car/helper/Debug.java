package com.rent.car.helper;

public class Debug {
	private boolean printLog;
	
	public Debug()	{
		this.printLog = false;
	}
	
	public Debug(boolean printStatus)	{
		this.printLog = printStatus;
	}
	
	public boolean setPrintLog(boolean val)	{
		return this.printLog = val;
	}
	
	public void printMessage(String funcName, String message)	{
		if(printLog)	{
			System.out.println("[" + funcName + "] " + message);
		}
	}
}
