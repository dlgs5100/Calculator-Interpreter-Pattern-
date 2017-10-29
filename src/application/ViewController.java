package application;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.GridPane;

public class ViewController {
	@FXML
	private AnchorPane AnchorTable;
	@FXML
	private TextField White_Text;
	@FXML
	private TextField Black_Text;
	@FXML
	private GridPane GridTable;
	@FXML
	private Button B_7;
	@FXML
	private Button B_8;
	@FXML
	private Button B_9;
	@FXML
	private Button B_Add;
	@FXML
	private Button B_Mins;
	@FXML
	private Button B_4;
	@FXML
	private Button B_5;
	@FXML
	private Button B_6;
	@FXML
	private Button B_Mul;
	@FXML
	private Button B_1;
	@FXML
	private Button B_2;
	@FXML
	private Button B_3;
	@FXML
	private Button B_00;
	@FXML
	private Button B_0;
	@FXML
	private Button B_Point;
	@FXML
	private Button B_Empty;
	@FXML
	private Button B_Div;
	@FXML
	private Button B_Basic;
	@FXML
	private Button B_BackSpace;

	private Main main;
	private int count = 0;				//按c變0
	private double num1, num2, result;
	private boolean OPUse = false, Point = false ,Error = false;
	private String value;
	private Number n = new Number();
	private Operator o;
	public ArrayList<Key> All = new ArrayList<Key>();
	public ArrayList<Key> num = new ArrayList<Key>();
	public ArrayList<Key> digit = new ArrayList<Key>();
	public ArrayList<Key> op = new ArrayList<Key>();
	public ArrayList<Double> Ans = new ArrayList<Double>();
	
	public void setMain(Main main){
		Ans.add((double) 0);
		
		this.main = main;
	}
	@FXML
	private void OnClickNum(ActionEvent event){
		if(Error == false){
		DecimalFormat mDecimalFormat = new DecimalFormat("0.000000");
        
		value = ((Button)event.getSource()).getText();
		White_Text.setText(White_Text.getText() + value);
		Key word = new Key(value);
		All.add(word);
		num.add(word);
		digit = (ArrayList<Key>)num.clone();
		if (count == 0){
			n.parse(digit);
			num1 = n.value;
			Black_Text.setText(String.valueOf(mDecimalFormat.format(num1)));
			Ans.add(num1);
			OPUse = false;
		}
		else if (count == 1){
			n.parse(digit);
			num2 = n.value;
			result = o.eval(num1, num2);
			Black_Text.setText(String.valueOf(mDecimalFormat.format(result)));
			Ans.add(result);
			OPUse = false;
		}
		else if (count == 2){
			n.parse(digit);
			num1 = result;
			num2 = n.value;
			result = o.eval(num1, num2);
			Black_Text.setText(String.valueOf(mDecimalFormat.format(result)));
			Ans.add(result);
			count = 1;
			OPUse = false;
		}
		}
	}
	@FXML
	private void OnClick00(ActionEvent event){
		if(Error == false){
		DecimalFormat mDecimalFormat = new DecimalFormat("0.000000");
		
		value = ((Button)event.getSource()).getText();
		White_Text.setText(White_Text.getText() + value);
		Key word1 = new Key(value);
		Key word2 = new Key(value);
		All.add(word1);
		//All.add(word2);
		num.add(word1);
		num.add(word2);
		digit = (ArrayList<Key>)num.clone();
		if (count == 0){
			n.parse(digit);
			num1 = n.value;
			Black_Text.setText(String.valueOf(mDecimalFormat.format(num1)));
			Ans.add(num1);
			OPUse = false;
		}
		else if (count == 1){
			n.parse(digit);
			num2 = n.value;
			result = o.eval(num1, num2);
			Black_Text.setText(String.valueOf(mDecimalFormat.format(result)));	
			Ans.add(result);
			OPUse = false;
		}
		else if (count == 2){
			n.parse(digit);
			num1 = result;
			num2 = n.value;
			result = o.eval(num1, num2);
			Black_Text.setText(String.valueOf(mDecimalFormat.format(result)));
			Ans.add(result);
			count = 1;
			OPUse = false;
		}
		}
	}
	@FXML
	private void OnClickDecPoint(ActionEvent event){
		if(Point == false){
		value = ((Button)event.getSource()).getText();
		White_Text.setText(White_Text.getText() + value);
		Key word = new Key(value);
		All.add(word);
		num.add(word);
		Point = true;
		}
		else{
			Black_Text.setText("Error!");
			Error = true;
		}
	}
	@FXML
	private void OnClickOP(ActionEvent event){
		if(OPUse == false){
		value = ((Button)event.getSource()).getText();
		White_Text.setText(White_Text.getText() + value);
		Key word = new Key(value);
		All.add(word);
		op.add(word);
		num.clear();
		o = new Operator(value);
		//Black_Text.setText(String.valueOf(count));
		
		o.parse(op);
		count++;
		
		OPUse = true;
		Point = false;
		}
		else{
			Black_Text.setText("Error!");
			Error = true;
		}
	}
	@FXML
	private void OnClickBackSpace(ActionEvent event){						//運算沒處理
		/*if(Character.isDigit(All.get(All.size()-1).ch.charAt(0))){
			
			All.remove(All.size()-1);
			String s = "";
			for(Key a : All){
				s+= a.ch;
			}
			White_Text.setText(s);
			
			
			Ans.remove(Ans.size()-1);
			Black_Text.setText(String.valueOf(Ans.get(Ans.size()-1)));
			
			result = Ans.get(Ans.size()-1);
		}
		else{
			All.remove(All.size()-1);
			String s = "";
			for(Key a : All){
				s+= a.ch;
			}
			White_Text.setText(s);
		}*/
		DecimalFormat mDecimalFormat = new DecimalFormat("0.000000");
		
		String s = "";
		count = 0;
		num1 = 0;
		num2 = 0;
		result = 0;
		num.clear();
		Ans.clear();
		op.clear();
		OPUse = false;
		Point = false;
		Error = false;
		if(All.size() > 0){
			All.remove(All.size()-1);
			ArrayList<Key> i = new ArrayList<Key>();
			i = (ArrayList<Key>)All.clone();
			if(All.size() > 0)
			{
			for(Key a : i){
				s += a.ch;
				if(Character.isDigit(a.ch.charAt(0))){
					num.add(a);
					digit = (ArrayList<Key>)num.clone();
					if (count == 0){
						n.parse(digit);
						num1 = n.value;
						Black_Text.setText(String.valueOf(mDecimalFormat.format(num1)));
						Ans.add(num1);
					}
					else if (count == 1){
						n.parse(digit);
						num2 = n.value;
						result = o.eval(num1, num2);
						Black_Text.setText(String.valueOf(mDecimalFormat.format(result)));
						Ans.add(result);
						//num1 = result;			//?
					}
					else if (count == 2){
						n.parse(digit);
						num1 = result;
						num2 = n.value;
						result = o.eval(num1, num2);
						Black_Text.setText(String.valueOf(mDecimalFormat.format(result)));
						Ans.add(result);
						count = 1;
					}
				}
				else if(a.ch.charAt(0) == '.'){
					num.add(a);
				}
				else{
					op.add(a);
					num.clear();
					o = new Operator(a.ch);
					//Black_Text.setText(String.valueOf(count));
					
					o.parse(op);
					count++;
				}				
			}
			}
			else{
				White_Text.setText("");
				Black_Text.setText("");
			}
			White_Text.setText(s);
		}
		
	}
	@FXML
	private void OnClickClear(ActionEvent event){
		value = "";
		count = 0;
		num1 = 0;
		num2 = 0;
		result = 0;
		OPUse = false;
		Point = false;
		Error = false;
		All.clear();
		num.clear();
		digit.clear();
		op.clear();
		Ans.clear();
		White_Text.setText("");
		Black_Text.setText("");
		Ans.add((double) 0);
	}
}
