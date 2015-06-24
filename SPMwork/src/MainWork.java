import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class MainWork extends Application{
	public ArrayList<Satellite> list = new ArrayList<Satellite>();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
		

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane root = new AnchorPane();
		Text hello = new Text("Please input the new satellite or check for collision");
		Button but1 = new Button("commit");
		Button but2 = new Button(" check");
		Text i_a = new Text("Semiminor:");
		Text i_b = new Text("Semimajor:");
		Text i_c = new Text("True—anomaly:");
		Text i_name = new Text("name:");
		TextField ta = new TextField();
		TextField tb = new TextField();
		TextField tc = new TextField();
		TextField tname = new TextField();
		//location for text and textfield
		AnchorPane.setLeftAnchor(hello, 50.);
		AnchorPane.setTopAnchor(hello, 50.);
		AnchorPane.setLeftAnchor(i_a, 70.);
		AnchorPane.setTopAnchor(i_a, 80.);
		AnchorPane.setLeftAnchor(ta,170.);
		AnchorPane.setTopAnchor(ta, 80.);
		AnchorPane.setLeftAnchor(i_b,70.);
		AnchorPane.setTopAnchor(i_b, 110.);
		AnchorPane.setLeftAnchor(tb,170.);
		AnchorPane.setTopAnchor(tb, 110.);
		AnchorPane.setLeftAnchor(i_c,70.);
		AnchorPane.setTopAnchor(i_c, 140.);
		AnchorPane.setLeftAnchor(tc,170.);
		AnchorPane.setTopAnchor(tc, 140.);
		
		AnchorPane.setLeftAnchor(i_name,70.);
		AnchorPane.setTopAnchor(i_name, 170.);
		AnchorPane.setLeftAnchor(tname,170.);
		AnchorPane.setTopAnchor(tname, 170.);
		//location for buttons
		AnchorPane.setLeftAnchor(but1,170.);
		AnchorPane.setTopAnchor(but1,200.);
		AnchorPane.setLeftAnchor(but2,270.);
		AnchorPane.setTopAnchor(but2, 200.);
		//warining place
		Text text = new Text("massage zone");
		AnchorPane.setLeftAnchor(text, 170.);
		AnchorPane.setTopAnchor(text, 250.);
		//for new satellite data input commit
		but1.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				String ia = ta.getText();
				String ib = tb.getText();
				String ic = tc.getText();
				String iname = tname.getText();
				try{
					Workbook book = Workbook.getWorkbook(new File("c:\\test.xls"));
					WritableWorkbook book1 = Workbook.createWorkbook(new File("c:\\test.xls"), book);
					WritableSheet sheet = book1.getSheet(0);
					Label label1 = new Label(0,sheet.getColumns()-1,iname);
					Label label2 = new Label(1,sheet.getColumns()-1,ia);
					Label label3 = new Label(2,sheet.getColumns()-1,ib);
					Label label4 = new Label(3,sheet.getColumns()-1,ic);
					sheet.addCell(label1);
					sheet.addCell(label2);
					sheet.addCell(label3);
					sheet.addCell(label4);
					book1.write();
					book1.close();
					book.close();
				}catch(Exception e){
					System.out.println(e);
				}
			}
		});
		//for collision check 
		but2.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				read();
				int num = 0;
				for(int j = 0;j<list.size();j++){
					for(int index = j+1;index<list.size();index++){
						System.out.println("waiting...");
						if(list.get(j).checkForCollison(list.get(index))){
							text.setText(list.get(j).name+" and "+list.get(index).name+" will have a collision in five days.");;
							num+=1;
						}
					}
				}
				if(num == 0){
					text.setText("no collision will happen.");
				}
				System.out.println("finish checking.");
			}
			
		});
		
		root.getChildren().addAll(hello,i_a,ta,i_b,tb,i_c,tc,but1,but2,tname,i_name,text);
		stage.setScene(new Scene(root,400.,300.));
		stage.show();
	}
	public void read(){
		try{
			Workbook book = Workbook.getWorkbook(new File("c:\\test.xls"));
			Sheet sheet = book.getSheet(0);
			System.out.println(""+sheet.getRows());
			int count = 0;
			for(int i= 0 ;i<sheet.getRows();i++){
				Cell[] cells = sheet.getRow(i);
				String name = cells[0].getContents().toString();
				double a = Double.parseDouble(cells[1].getContents());
				double b = Double.parseDouble(cells[2].getContents());
				double c = Double.parseDouble(cells[3].getContents());
				Satellite temp = new Satellite(name,a,b,c);
				System.out.println(name+" "+a+" "+b+" "+c);			   
			    list.add(count,temp);
			    count+=1;
			}
			book.close();
			System.out.println("finish reading data");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
