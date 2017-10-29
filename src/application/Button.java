package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Button {
	StringProperty Expression = new SimpleStringProperty();
	StringProperty Result = new SimpleStringProperty();
	
	Button(){
		
	}
	Button(String Expression, String Result){
		setExpression(Expression);
		setResult(Result);
	}
	StringProperty getExpression(){
		return Expression;
	}
	StringProperty getResult(){
		return Result;
	}
	void setExpression(String E){
		Expression.set(E);
	}
	void setResult(String R){
		Result.set(R);
	}
}
