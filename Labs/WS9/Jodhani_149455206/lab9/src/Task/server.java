/**********************************************
Workshop 9
Course: JAC444 - 4th
Last Name: Jodhani
First Name: Prince
ID: 149455206
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature : Prince
Date: 31/07/2022
**********************************************/

package Task;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class server extends JFrame 
{
	
	private static final long m_serialVersion = 1L;
	
	private JTextArea t_res = new JTextArea();
	private ArrayList<Client> arr_client = new ArrayList<>();
 
	public server() 
	{
		setLayout(new BorderLayout());
		
		t_res.append("MultiThreadServer Started at " + DateTimeFormatter.ofPattern("EEEE MMMM d - kk:mm:ss z u").format(ZonedDateTime.now(ZoneId.systemDefault())) +"\n");
		t_res.setEditable(false);
		
		JScrollPane scroll_pane = new JScrollPane(t_res);
    
		add(scroll_pane, BorderLayout.CENTER);
		setTitle("Multi-thread Server");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
		setLocationRelativeTo(null);

		try 
		{

			try (ServerSocket serverSocket = new ServerSocket(8000))
			{
				while(true)
				{
					Socket socket = serverSocket.accept();
					Client new_Client = new Client(socket);
					arr_client.add(new_Client);
				}
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
 
	class Client implements Runnable 
	{
		private Socket socket;
		private PrintWriter print_Client;
  
		public Client(Socket socket) 
		{
			this.socket = socket;
			Thread thread = new Thread(this);
			thread.start();
			
		}
  
		public void run() 
		{
			try 
			{

				try (Scanner fromClient = new Scanner(socket.getInputStream())) 
				{
					print_Client = new PrintWriter(socket.getOutputStream());
					t_res.append("\nConnection from  " + socket + " at " + DateTimeFormatter.ofPattern("EEEE MMMM d - kk:mm:ss z u").format(ZonedDateTime.now(ZoneId.systemDefault())) + "\n");
					
					while(true)
					{
						String s_text = fromClient.nextLine();
						display(s_text, 's');
						
						for (Client newClient : arr_client) 
							newClient.display(s_text, 'c');
						
					}
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			catch (NoSuchElementException e) 
			{
				System.out.println("User exit");
			};
			
		}
  
		public void display(String s_text, char val)
		{
			
			if (val == 'c') 
			{
				print_Client.println("\n" + s_text);
				print_Client.flush();
				
			} 
			else if (val == 's')
			{
				t_res.append("\n" + s_text + "\n");
			}
		}
  
	}

	public static void main(String[] args)
	{
		new server();
	}
}