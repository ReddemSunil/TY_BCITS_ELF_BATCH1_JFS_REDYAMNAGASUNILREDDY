package com.sunil.AssesmentOnStrings;
public class Student
{
	private String name;
	private int id;
	private String branch;
	public Student(String name, int id, String branch)
	{
		this.name = name;
		this.id = id;
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", branch=" + branch + "]";
	}
	
}
