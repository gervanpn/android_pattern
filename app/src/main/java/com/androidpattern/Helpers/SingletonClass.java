package com.androidpattern.Helpers;

public class SingletonClass {
	String editValue;
	private static final SingletonClass ourInstance = new SingletonClass();
	public static SingletonClass getInstance() {
		return ourInstance;
	}
	private SingletonClass() { }
	public void setText(String editValue) {
		this.editValue = editValue;
	}
	public String getText() {
		return editValue;
	}
}