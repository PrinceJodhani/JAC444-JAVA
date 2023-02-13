/**********************************************
Workshop 5
Course: JAC444 - 4th
Last Name: Jodhani
First Name: Prince
ID: 149455206
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature : Prince
Date: 26/06/2022
**********************************************/

package application;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class Main extends Application 
{

    File f_file;
    int cnt = 0;

    ArrayList<String> first_name = new ArrayList<>();
    ArrayList<String> last_name = new ArrayList<>();
    ArrayList<String> m_city = new ArrayList<>();
    ArrayList<String> m_prv = new ArrayList<>();
    ArrayList<String> m_postal = new ArrayList<>();

    public void start(Stage prime_Stage) 
    {
        GridPane m_root = new GridPane();
        GridPane BtnGr = new GridPane();
        GridPane m_GrName = new GridPane();
        GridPane m_AddGr = new GridPane();

        m_root.setGridLinesVisible(false);
        m_GrName.setGridLinesVisible(false);

       
        Text tb1 = new Text("First Name:");
        Text tb2 = new Text("Last Name:");
        Text tb3 = new Text("City:");
        Text tb4 = new Text("Province:");
        Text tb5 = new Text("Postal Code:");

        
        TextField fd1 = new TextField();
        TextField fd2 = new TextField();
        TextField fd3 = new TextField();
        TextField fd5 = new TextField();

        
        Button InsertBtn = new Button("Add");
        Button m_FirstBtn = new Button("First");
        Button NxtBtn = new Button("Next");
        Button Prv_Btn = new Button("Previous");
        Button m_LastBtn = new Button("Last");
        Button UpdtBtn = new Button("Update");

        InsertBtn.setPrefWidth(90);
        m_FirstBtn.setPrefWidth(90);
        NxtBtn.setPrefWidth(90);
        Prv_Btn.setPrefWidth(90);
        m_LastBtn.setPrefWidth(90);
        UpdtBtn.setPrefWidth(90);

        ChoiceBox<String> fld4 = new ChoiceBox();
        
        fld4.setValue("Province");
        fld4.getItems().addAll("NL", "PE", "NS", "NB", "QC", "ON", "MB", "SK", "AB", "BC", "YT", "NT", "NU");

        m_root.setPadding(new Insets(10, 10, 10, 10));
        m_GrName.setPadding(new Insets(10, 10, 10, 10));
        m_AddGr.setPadding(new Insets(10, 10, 10, 10));
        BtnGr.setPadding(new Insets(10, 10, 10, 10));

        m_GrName.setVgap(5);
        m_GrName.setHgap(5);
        BtnGr.setVgap(5);
        BtnGr.setHgap(9);
        m_AddGr.setVgap(5);
        m_AddGr.setHgap(5);

        m_root.setAlignment(Pos.TOP_LEFT);
        BtnGr.setAlignment(Pos.TOP_CENTER);

        m_GrName.add(tb1, 1, 1);
        m_GrName.add(fd1, 2, 1, 100, 1);
        m_GrName.add(tb2, 1, 4);
        m_GrName.add(fd2, 2, 4, 100, 1);

        m_root.add(m_GrName, 1, 1);
        m_AddGr.add(tb3, 1, 1);
        m_AddGr.add(fd3, 2, 1);
        m_AddGr.add(tb4, 3, 1);
        m_AddGr.add(fld4, 4, 1);
        m_AddGr.add(tb5, 5, 1);
        m_AddGr.add(fd5, 6, 1);

        m_root.add(m_AddGr, 1, 2);
        BtnGr.add(InsertBtn, 1, 1);
        BtnGr.add(m_FirstBtn, 2, 1);
        BtnGr.add(NxtBtn, 3, 1);
        
        BtnGr.add(Prv_Btn, 4, 1);
        BtnGr.add(m_LastBtn, 5, 1);
        BtnGr.add(UpdtBtn, 6, 1);

        m_root.add(BtnGr, 1, 3);
        
        prime_Stage.setTitle("Address Book");        
        Scene scene = new Scene(m_root, 590, 210);
        
        prime_Stage.setScene(scene);
        prime_Stage.show();
        
        InsertBtn.setOnAction( e -> 
        {
            System.out.println("ADD button pressed.");
            
            storeInfo(fd1.getText(), fd2.getText(), fd3.getText(), fld4.getValue(), fd5.getText());
        });
  
        m_FirstBtn.setOnAction(e -> {
        	
            System.out.println("FIRST button pressed.");
            
            fd1.setText(first_name.get(0));
            fd2.setText(last_name.get(0));
            fd3.setText(m_city.get(0));
            fld4.setValue(m_prv.get(0));
            fd5.setText(m_postal.get(0));
            
            cnt = 0;
            
            String data = "First contact: " + first_name.get(0) + " " + last_name.get(0) + " " + m_city.get(0) + " " + m_prv.get(0) + " " + m_postal.get(0);
            
            System.out.println(data);
        });
        
        NxtBtn.setOnAction(e -> {
            cnt++;
            System.out.println("Next button pressed.");
            
            fd1.setText(first_name.get(cnt));
            fd2.setText(last_name.get(cnt));
            fd3.setText(m_city.get(cnt));
            fld4.setValue(m_prv.get(cnt));
            fd5.setText(m_postal.get(cnt));
            
            String data = "Next contact: " + first_name.get(cnt) + " " + last_name.get(cnt) + " " + m_city.get(cnt) + " " + m_prv.get(cnt) + " " + m_postal.get(cnt);
            
            System.out.println(data);
        });
        
        Prv_Btn.setOnAction( e -> {
            cnt--;
            
            System.out.println("Previous button pressed.");
            
            fd1.setText(first_name.get(cnt));
            fd2.setText(last_name.get(cnt));
            fd3.setText(m_city.get(cnt));
            fld4.setValue(m_prv.get(cnt));
            fd5.setText(m_postal.get(cnt));
            
            String data = "Previous contact: " + first_name.get(cnt) + " " + last_name.get(cnt) + " " + m_city.get(cnt) + " " + m_prv.get(cnt) + " " + m_postal.get(cnt);
            System.out.println(data);
            
        });
       
        m_LastBtn.setOnAction( e -> {
        	
            System.out.println("Last button pressed.");
            
            fd1.setText(first_name.get(first_name.size()-1));
            fd2.setText(last_name.get(last_name.size()-1));
            fd3.setText(m_city.get(m_city.size()-1));
            fld4.setValue(m_prv.get(m_prv.size()-1));
            fd5.setText(m_postal.get(m_postal.size()-1));
            
            String data = "Last contact: " + first_name.get(first_name.size()-1) + " " + last_name.get(last_name.size()-1) + " " + m_city.get(m_city.size()-1) + " " + m_prv.get(m_prv.size()-1) + " " + m_postal.get(m_postal.size()-1);
            
            System.out.println(data);
            
        });
        
        UpdtBtn.setOnAction( e -> {
            System.out.println("UPDATE button pressed.");
            
            first_name.set(cnt, fd1.getText());
            last_name.set(cnt, fd2.getText());
            m_city.set(cnt, fd3.getText());
            m_prv.set(cnt, fld4.getValue());
            m_postal.set(cnt, fd5.getText());
            
            String data = "Contact updated: " + fd1.getText() + " " + fd2.getText() + " " + fd3.getText() + " " + fld4.getValue() + " " + fd5.getText();
            
            System.out.println(data);
            
            fileWriting();
            
        });
    }

    public void storeInfo(String firstName, String lastName, String City, String Province, String pcode)
    {
    	
        first_name.add(firstName);
        last_name.add(lastName);
        m_city.add(City);
        m_prv.add(Province);
        m_postal.add(pcode);
        
        String data = "Contact added: " + firstName + " " + lastName + " " + City + " " + Province + " " + pcode;
        
        System.out.println(data);
        cnt++;
        
        fileWriting();
        
    }

    private void fileWriting() 
    {
        try 
        {
            f_file = new File ("StoredData.txt");
            
            if (f_file.createNewFile()) 
            {
                System.out.println("New File created.");
            }
            else 
            {
                System.out.println("File already exists.");
            }
        } 
        catch (IOException e) 
        {
        	
            System.out.println("Error!!");
            e.printStackTrace();
        }

        try 
        {
        	
            RandomAccessFile m_rafile = new RandomAccessFile(f_file, "rw");
            String[] str = new String[first_name.size()];
            
            for (int i = 0; i < first_name.size(); i++) 
            {
                str[i] = first_name.get(i) + " " + last_name.get(i) + " " + m_city.get(i) + " " + m_prv.get(i) + " ";
            }

            for (int j = 0; j < first_name.size(); j++) 
            {
                m_rafile.write(str[j].getBytes());
                m_rafile.write(m_postal.get(j).getBytes());
                m_rafile.writeBytes("\n"); 
            }
            m_rafile.close();
        } 
        catch(IOException ex) 
        {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) 
    {
        launch(args);
    }

}