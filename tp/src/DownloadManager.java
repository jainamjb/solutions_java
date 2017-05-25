//package pkg;
import java.util.Observer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DownloadManager implements Observer {
	
	Download download;
	JProgressBar jb;
	JFrame frame = new JFrame("Internet Download Manager.");
	JTextField link = new JTextField(50);
	JPanel jap = new JPanel() ;
	JButton go = new JButton("GO!");
	JButton Download= new JButton("DOWNLOAD!");
	JButton Pause= new JButton("PAUSE!");	
	JButton Resume= new JButton("RESUME!");
	JButton Delete= new JButton("Delete!");
	JTable table;
	//Object[][] rows;
Object row[]=new Object[4];
DefaultTableModel model = new DefaultTableModel();
	final String[] column1 = {"FileName", "Size", "Status","Progress"};
	JScrollPane Scroll_Table;
	
	JLabel link_text = new JLabel("Enter the link of File to Download...");	
	DownloadManager(){
															//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    													//frame.setBounds(0,0,screenSize.width, screenSize.height);
	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);			//frame.pack();
	frame.setLayout(null);												//frame.setSize();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//jap.setLocation(150, 200);
	//jap.setSize(200, 20);
	link_text.setBounds(273,93,300,10);
	
	
	
	jap.add(link_text);
	jap.add(link);
	jap.setBounds(200, 120, 700, 30); 

	table = new JTable(model);
	model.setColumnIdentifiers(column1);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.setBounds(270, 220, 900, 170);
	
	Scroll_Table = new JScrollPane(table);
	Scroll_Table.setBounds(270, 230, 900, 170);
	
	Download.setBounds(50, 150, 120, 30);
	Download.setBackground(Color.green);
	
	Pause.setBounds(50, 200, 120, 30);
	Pause.setBackground(Color.BLACK);
	Pause.setForeground(Color.WHITE);

	Resume.setBounds(50, 250, 120, 30);
	Resume.setBackground(Color.GRAY);
	Resume.setForeground(Color.WHITE);
	
	Delete.setBounds(50, 300, 120, 30);
	Delete.setBackground(Color.red);
	
	go.setBounds(925, 120, 75, 30); 
	go.setBackground(Color.cyan);
	 go.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        Add();
	      }
	    });
	
	frame.getContentPane().add(jap);
	frame.add(go);
	frame.add(Download);
	frame.add(Resume);
	frame.add(Pause);
	frame.add(Delete);
	frame.add(jap);
	frame.add(link_text);
	frame.add(Scroll_Table);
	frame.setVisible(true);
	jb=new JProgressBar();
    jb.setValue(0);
    jb.setBorderPainted(true);
    jb.setBounds(50, 500, 200, 50);
    jb.setStringPainted(true);
    jb.setVisible(true);
    frame.add(jb);
	}
protected void Add() {
		
		URL verifiedUrl = verifyUrl(link.getText());
		if (verifiedUrl != null) {
			addDownload(new Download(verifiedUrl));
			link.setText("");// reset add text field
		} else {
		link.setText("");// reset add text field
		JOptionPane.showMessageDialog(frame,
		"Invalid Download URL", "Error",
		JOptionPane.ERROR_MESSAGE);
		 /*if(download.status== download.COMPLETE){
			JOptionPane.showMessageDialog(frame,
					"Download Complete!", "Error",
					JOptionPane.ERROR_MESSAGE);
			go.setEnabled(true);*/
		}
		}
		
public void addDownload ( Download download1) {
	//go.setEnabled(false);
	download1.addObserver(this);
	
	row[0]=download1.getFileName(download1.url);
	row[1]=download1.getSize();
	row[2]=download1.getStatus();
	row[3]=jb;
	//while(download1.progress!=100)
		//{jb.setValue(download1.progress);}
	model.addRow(row);
	//downloadobj.addObserver(UI.this);
	//go.setEnabled(true);
	download.downloadList.add(download1);
	//tableModel.fireTableRowsInserted(table.getRowCount() - 1, table.getRowCount() - 1);
	}
URL verifyUrl(String url) {  

	 if (!url.toLowerCase().startsWith("http://"))
		 return null;
		 // Verify format of URL.
		 URL verifiedUrl = null;
		 try {
		 verifiedUrl = new URL(url);
		 } catch (Exception e) {
		 return null;
		 }
		 // Make sure URL specifies a file.
		 if (verifiedUrl.getFile().length() < 2)
		 return null;
		 return verifiedUrl;
	}
public Download getDownload(int row) {
    return (Download) download.downloadList.get(row);
  }
@Override
public void update(Observable o, Object arg1) {
         jb.setValue((int)download.getProgress());  
//jb.setValue(download1.progress);
	//model.addRow(row);
}
	
	
public static void main(String[] args){
	DownloadManager u = new DownloadManager();
}
}


class Download extends Observable implements Runnable {

private static final int BUFFER_SIZE = 1024;
//statuses
public static final String STATUSES[] = {"Downloading",
"Paused", "Complete", "Cancelled", "Error"};
public ArrayList<Download> downloadList = new ArrayList<Download>();
public  final int DOWNLOADING = 0;
public  final int PAUSED = 1;
public  final int COMPLETE = 2;
public  final int CANCELLED = 3;
public final int ERROR = 4;
public URL url; // download URL
int progress;
protected int size; // size of download in bytes
private int downloaded; // number of bytes downloaded
public int status; // current status of download
Download(URL url){
	downloaded = 0;
	status = DOWNLOADING;
	this.url=url;
start();	
}
protected void start() {
	//size=-1;
Thread t = new Thread(this);
status=DOWNLOADING;
t.start();
}
public void run() {
FileOutputStream file = null;
BufferedInputStream stream = null;
try {
//Open connection to URL
HttpURLConnection connection =(HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
connection.setDoInput(true);
connection.connect();
//200 response code is for invalid file.


if (connection.getResponseCode() / 100 != 2) {
error();
}
stream=new BufferedInputStream(connection.getInputStream());//get stream
int contentLength = connection.getContentLength();
//Open file and seek.
file = new FileOutputStream(getFileName(url));

byte[] buffer= new byte[BUFFER_SIZE];
int len=0;
downloaded=0;
len=stream.read(buffer);

while (len != -1) {
//adjusting buffer
file.write(buffer,0,len);
len=stream.read(buffer) ;
downloaded+=len;
progress = downloaded/contentLength;
//setValue(progress);
stateChanged();

}
size=contentLength;
file.flush();
//Close file.
if (file != null) {
try {
file.close();
} 
catch (Exception e) {}
}
//Close connection 
if (stream != null) {
try {
stream.close();
} catch (Exception e) {}
}

/* Change status to complete if this point was
reached because downloading has finished. */
status = COMPLETE;
stateChanged();

} 
catch (Exception e) {
error();
}
}

public URL getUrl() {
return url;
}
//Get this download's size.
public int getSize() {
return size;
}
//Get this download's progress.
public float getProgress() {
return ((float) downloaded / size) * 100;
}
//Get this download's status.
public int getStatus() {
return status;
}
//Pause this download.
public void pause() {
status = PAUSED;
stateChanged();
}
//Resume this download.
public void resume() {
status = DOWNLOADING;
stateChanged();
start();
}
//Cancel this download.
public void cancel() {
status = CANCELLED;
stateChanged();
}
//Mark this download as having an error.
private void error() {
status = ERROR;
stateChanged();
}

public Download getDownload(int row) {
  return (Download) downloadList.get(row);
}

//Notify observers that this download's status has changed.
private void stateChanged() {
setChanged();
notifyObservers();
}
protected String getFileName(URL url) {
String fileName = url.getFile();
return fileName.substring(fileName.lastIndexOf('/') + 1);
}
}
