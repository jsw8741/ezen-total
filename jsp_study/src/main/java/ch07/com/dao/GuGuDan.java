package ch07.com.dao;

public class GuGuDan {
	private StringBuilder result = new StringBuilder();
	
	String t1 = null;
	String t2 = "";
	String t3 = "TTTTTT";
	
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	public StringBuilder getResult() {
		return result;
	}

	public void setResult(StringBuilder result) {
		this.result = result;
	}
	
	public String process(int num) {
		
		for(int i=1;i<=9;i++){
			result.append(num + " * " + i + " = " + num*i + "<br>");
		}
		if(true) {
			
			result.append(t3);
		}
		
		return result.toString();
		
	}
}
