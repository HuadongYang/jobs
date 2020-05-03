package com.practice.prac6;

public class CalculateBean {
	private String op1;
	private String op2;
	private String operator;
	private Double result;
	
	public CalculateBean() {}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public Double getResult() {
		return result;
	}
	
	public void setResult(Double result) {
		this.result = result;
	}
	
	public String calculate(String var1, String var2, String operator) {
		if (var1==null || var2 == null || operator == null) {
			return "0";
		}
		double v1 = Double.parseDouble(var1);
		double v2 = Double.parseDouble(var2);
		try {
		if("+".equals(operator))
			this.result=v1+v2;
		if("-".equals(operator))
			this.result=v1-v2;
		if("*".equals(operator))
			this.result=v1*v2;
		if("/".equals(operator))
			this.result=v1/v2;
		}catch(Exception e) {
			System.out.print(e);
		}
		return String.valueOf(this.result);
	}
	
	

}
