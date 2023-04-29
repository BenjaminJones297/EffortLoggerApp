package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane; //***
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application{
	
public static void main(String[] args) {
        launch(args);
}

/*********************************************************
Puts list of projects in textfile into arrayList of projects
 * @throws IOException 
 **********************************************************/
public static void populate(String p, ArrayList<Project> pL) throws IOException {
	EncryptOrDecrypt(p);
	int count = 0;
	File file = new File(p);
    Scanner sc = new Scanner(file);
    String line = "";
    while (sc.hasNextLine()) {
    	line = sc.nextLine();
    	if (line.equals(".")) {
    		count++;
    	}
    }
    Project pr;
	for (int i = 1; i <= count; i++) {
		pr = new Project(i);
		pL.add(pr);
	}
	
	return;
}

public static void EncryptOrDecrypt(String fileName) 
{
    
    byte[] key = {0x42, 0x75, 0x67, 0x73, 0x61, 0x72, 0x65, 0x69, 0x6E, 0x79, 0x6F, 0x75, 0x6E, 0x6F, 0x77, 0x21};
    ;
	try 
	{
		byte[] content = Files.readAllBytes(Paths.get(fileName));
	    byte[] encryptedBytes = new byte[content.length]; 
	    for (int i = 0; i < content.length; i++)
	    {
	    	
	    	encryptedBytes[i] = (byte)(content[i] ^ key[i % 16]);
	    }
		Files.write(Paths.get(fileName), encryptedBytes);
		
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}

  }

	//****** Declarations of items in full scope ********************************
	long startTime = 0;
	long elapsedTime = 0;
	long elapsedSeconds = elapsedTime / 1000;
	long secondsDisplay = elapsedSeconds % 60;
	long elapsedMinutes = elapsedSeconds / 60;
	long elapsedHours = 0;
	long hoursDisplay = 0;
	long minutesDisplay = 0;
	Project curP;
	int pI = 0;
	int dI = 0;
	Defect curD;
	BackLogItem curBl;
	int bLI = 0;
	ArrayList<Project> ListOfProjects = new ArrayList<Project>();
	String path = "C:\\Users\\benja\\Documents\\CSE360\\EffortLogger\\Projectoriginal\\CSE360-Project\\CSE360-Project\\project.txt";
	final int win_x_size = 500, win_y_size = 200;
	Label timePunch = new Label("You are not clocked in");
    String username;				
    String password;
    Button authenticateBtn = new Button("Log in");
    TextField usernameTxtFld = new TextField();
    TextField passwordTxtFld = new TextField();
    UserAuthPane userAuthPane = new UserAuthPane();
	GridPane defectsPane = new GridPane();		
	GridPane effortLogEditor = new GridPane();
	TabPane tabPane = new TabPane();					
	Tab mainTab = new Tab();					
	Tab defectTab = new Tab();
	Tab effortLogEditorTab = new Tab();
	Tab backlogTab = new Tab();
    Scene scene = new Scene(tabPane);
	Stage primaryStage = new Stage();
	GridPane pane = new GridPane();
	ComboBox<String> ProjectList = new ComboBox<String>();	
	ComboBox<String> BackLogItem = new ComboBox<String>();
	ComboBox<String> Defect = new ComboBox<String>();
	ComboBox<String> LifeCycleList = new ComboBox<String>();
	ComboBox<String> EffortCat = new ComboBox<String>();
	ComboBox<String> EffortCat2 = new ComboBox<String>();
	Label header = new Label("Effort Logger Console");
	Button clockInBtn = new Button("Clock In");	
	Label projLabel = new Label("Project: ");
	Label backlogLabel = new Label("BackLogItem: ");
	Label defectLabel = new Label("Defect: ");
	Label lifeCycleLabel = new Label("Life Cycle Step:");
	Label effortCatLabel = new Label("Effort Category:");
	Button clockOutBtn = new Button("Clock out");
	Button mainSubmitBtn = new Button("Submit");
	GridPane backlogPane = new GridPane();
	RadioButton existingProj = new RadioButton("Existing Project");
	RadioButton newProj = new RadioButton("New Project");
	ToggleGroup projectOptions = new ToggleGroup();
	Button enterbtn = new Button("Enter");
	TextArea toDisplay = new TextArea();
	String projName;
	int difficulty, defects, time;
	TextField projNameFld = new TextField();
	TextField difficultyFld = new TextField();
	TextField defectsFld = new TextField();
	TextField timeFld = new TextField();
	/*****************************
	BackLog Items textFields and Labels
	//****************************/
	TextField bLDifTF;
	TextField bLTimeTF;
	TextField blNameTF;
	TextField bLDesTF;
	TextField bLTimeETF;
	TextField bLCurTimeETF;
	TextField bLTimeRTF;
	
	Label bLTimeLbl = new Label("Time (in hours): ");
	Label bLNameLbl = new Label("BackLog Item Name: ");
	Label bLDifLbl = new Label("Difficulty Level (/10): ");
	Label bLDesLbl = new Label("Description: ");
	Label bLTimeELbl = new Label("Time worked on: ");
	Label bLCurTimeELbl = new Label("Time worked on this sprint: ");
	Label bLTimeRLbl = new Label("Estimated time remaining");
	/*****************************
	Defect textFields and Labels
	//****************************/
	TextField dDifTF;
	TextField dTimeTF;
	TextField dRecTF;
	TextField dNameTF;
	TextField dTimeETF;
	TextField dCurTimeETF;
	TextField dTimeRTF;
	TextField dCauseTF;
	TextField dSymTF;
	TextField dSolTF;
	
	Label dTimeLbl = new Label("Time (in hours): ");
	Label dNameLbl = new Label("Defect Name: ");
	Label dDifLbl = new Label("Difficulty Level (/10): ");
	Label dRecLbl = new Label("Likelyhood of recurrence: ");
	Label dTimeELbl = new Label("Time worked on: ");
	Label dCurTimeELbl = new Label("Time worked on this sprint: ");
	Label dTimeRLbl = new Label("Estimated time remaining");
	Label dCauseLbl = new Label("Cause: ");
	Label dSymLbl = new Label("Symptom(s): ");
	Label dSolLbl = new Label("Solution: ");
	
	
	Button newProjBtn = new Button("Create Project");
	Label projNameLbl = new Label("Project Name: ");
	Label projDiffLbl = new Label("Project Difficulty Level: ");
	Label projDefectsLbl = new Label("Project Defects: ");
	Label bLNumDefectsLbl = new Label("Project number of Defects: ");
	Label projTimeLbl = new Label("Time (in hours): ");
	// getting path
	TextField pathTF = new TextField();
	Label pathLbl = new Label("Please enter the path: ");
	// temps
	BackLogItem bL;
	Defect d;
	
	//****** START OF MAIN TAB FEATURES ********************************
	public void start(Stage primaryStage) throws IOException{
		populate(path, ListOfProjects);
		curP = ListOfProjects.get(0);
		curBl = curP.backLogItems.get(0);
		curD = curBl.defects.get(0);
		// Create a GridPane object and set its properties
		pane.setAlignment(Pos.CENTER); //center the GridPane
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5); //set horizontal gap between columns
		pane.setVgap(5.5); //set vertical gap between rows
		pane.setPrefWidth(win_x_size);
		pane.setPrefHeight(win_y_size);
	
		pane.add(header, 2, 0);				//add to pane in location 2,0
		GridPane.setHalignment(header, HPos.CENTER);		//set horizontal alignment
		
		timePunch.setTextFill(Color.RED);
		pane.add(timePunch, 2, 1);				//set position
		
		pane.add(clockInBtn, 1, 1);						//add to pane and set position
		clockInBtn.setOnAction(new InButtonHandler());	//tie button to an event handler
		
		/************************************
		 populate drop down menu with list of projects
		 *************************************/
		
		pane.add(projLabel, 0, 5);				//add to pane and set position
		/*ProjectList.getItems().addAll(
				"project1",
				"project2",
				"project3");*/
		for (int i = 0; i < ListOfProjects.size(); i++) {
			ProjectList.getItems().add(ListOfProjects.get(i).getName());
		}
		ProjectList.getSelectionModel().select(0);
		pane.add(ProjectList, 1, 5);			//add to pane and set position
		ProjectList.setOnAction(new projectComboHandler());
		
		pane.add(lifeCycleLabel, 2, 5);			//add to pane and set position
		GridPane.setHalignment(lifeCycleLabel, HPos.RIGHT);			//set alignment for more visually pleasing
		LifeCycleList.getItems().addAll(
				"work",
				"work2",
				"work3");
		pane.add(LifeCycleList, 3, 5);				//add to the pane and set position
		
		pane.add(effortCatLabel, 0, 6);
		EffortCat.getItems().addAll(
				"effort1",
				"effort2",
				"effort3");
		pane.add(EffortCat, 1, 6);			//add to pane and set position
		
		EffortCat2.getItems().addAll(
				"placeholder",
				"placeholder",
				"placeholder");
		pane.add(EffortCat2, 3, 6);				//add to pane and set position

		

		pane.add(clockOutBtn, 1, 7);					//add to pane and set position
		clockOutBtn.setOnAction(new OutButtonHandler());		//tie button to event handler
		
		pane.add(mainSubmitBtn, 3, 7 );
		mainSubmitBtn.setOnAction(new SubmitBtnMainHandler());

		//********************** END OF MAIN TAB CODE *********************
		
		
		//********************** START OF CONNECTING PANES CODE ************
		mainTab.setText("Effort Console");
		mainTab.setContent(pane);
		defectTab.setText("Defect Console");
		defectTab.setContent(defectsPane);
		effortLogEditorTab.setText("Effort Log Editor");
		effortLogEditorTab.setContent(effortLogEditor);
		backlogTab.setText("Backlog Items Catalog");
		backlogTab.setContent(backlogPane);
		tabPane.getSelectionModel().select(0);				//add the tabs to the pane
        tabPane.getTabs().addAll(mainTab, backlogTab, defectTab, effortLogEditorTab);
		Scene userAuthScene = new Scene(userAuthPane);

        //**************************END OF CONNECTING PANES CODE ****************

        
        //*************************START OF AUTHENTICATION PANE CODE *************
        userAuthPane.setAlignment(Pos.CENTER); //center the GridPane
        userAuthPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        userAuthPane.setHgap(5.5); //set horizontal gap between columns
        userAuthPane.setVgap(5.5); //set vertical gap between rows
        userAuthPane.setPrefWidth(win_x_size);
        userAuthPane.setPrefHeight(win_y_size);

        Label usernameLbl = new Label("Username: ");
        Label passwordLbl = new Label("Password: ");
        userAuthPane.add(usernameLbl, 1, 2);
        userAuthPane.add((usernameTxtFld), 2, 2);
        userAuthPane.add(passwordLbl, 1, 3);
        userAuthPane.add((passwordTxtFld), 2, 3);
    	userAuthPane.add(authenticateBtn, 2, 4);	
    	authenticateBtn.setOnAction(new AuthenticateBtnHandler());
    	
		
        primaryStage.setTitle("Log In"); // Set the stage title
		primaryStage.setScene(userAuthScene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
        //*****************END OF AUTHENTICATION PANE CODE ************
		
		
		//*****************START OF BACKLOG PANE CODE ***********************
		backlogPane.add(backlogLabel, 0, 5);				//add to pane and set position
		for (int i = 0; i < curP.backLogItems.size(); i++) {
			BackLogItem.getItems().add(curP.backLogItems.get(i).getName());
		}
		BackLogItem.getSelectionModel().select(0);
		backlogPane.add(BackLogItem, 1, 5);			//add to pane and set position
		BackLogItem.setOnAction(new backlogComboHandler());
		
		bLDifTF = new TextField("" + curBl.getDif());
		bLTimeTF = new TextField("" + curBl.getTime());
		bLDesTF = new TextField("" + curBl.getDescription());
		bLTimeETF = new TextField("" + curBl.getTimeE());
		bLCurTimeETF = new TextField("0 seconds");
		bLCurTimeETF.setEditable(false);
		bLTimeRTF = new TextField("" + curBl.getTimeR());
		bLTimeRTF.setEditable(false);
		bLTimeETF = new TextField("" + curBl.getTimeE());
		bLTimeETF.setEditable(false);
		
		bLDifTF.setOnAction(new backLogTextFieldHandler());
		bLTimeTF.setOnAction(new backLogTextFieldHandler());
		bLDesTF.setOnAction(new backLogTextFieldHandler());
		
		
		backlogPane.add(bLDifLbl, 3, 5);
		backlogPane.add(bLDifTF, 3, 6);
		backlogPane.add(bLTimeLbl, 4, 5);
		backlogPane.add(bLTimeTF, 4, 6);
		backlogPane.add(bLDesLbl, 5, 5);
		backlogPane.add(bLDesTF, 5, 6);
		backlogPane.add(bLTimeELbl, 6, 5);
		backlogPane.add(bLTimeETF, 6, 6);
		backlogPane.add(bLCurTimeELbl, 7, 5);
		backlogPane.add(bLCurTimeETF, 7, 6);
		backlogPane.add(bLTimeRLbl, 8, 5);
		backlogPane.add(bLTimeRTF, 8, 6);
		/*existingProj.setToggleGroup(projectOptions);
		newProj.setToggleGroup(projectOptions);
		backlogPane.add(existingProj, 2, 2);
		backlogPane.add(newProj, 2, 3);
		backlogPane.add(enterbtn, 2, 4);
		enterbtn.setOnAction(new enterBtnHandler());
		toDisplay.setEditable(false);*/
		
		
		//****************END OF BACKLOG PANE CODE *************************
		
		//*****************START OF Defect PANE CODE ***********************
				defectsPane.add(defectLabel, 0, 5);				//add to pane and set position
				for (int i = 0; i < curBl.defects.size(); i++) {
					Defect.getItems().add(curBl.defects.get(i).getName());
				}
				Defect.getSelectionModel().select(0);
				defectsPane.add(Defect, 1, 5);	 //add to pane and set position
				Defect.setOnAction(new defectComboHandler());
				
				dDifTF = new TextField("" + curD.getDif());
				dTimeTF = new TextField("" + curD.getTime());
				dRecTF = new TextField("" + curD.getRec());
				dSymTF = new TextField(curD.getSymptoms());
				dSolTF = new TextField(curD.getSolution());
				dCauseTF = new TextField("" + curD.getCause());
				dTimeETF = new TextField("" + curD.getTimeE());
				dCurTimeETF = new TextField("0 seconds");
				dCurTimeETF.setEditable(false);
				dTimeRTF = new TextField("" + curD.getTimeR());
				dTimeRTF.setEditable(false);
				dTimeETF = new TextField("" + curD.getTimeE());
				dTimeETF.setEditable(false);
				
				dDifTF.setOnAction(new backLogTextFieldHandler());
				dTimeTF.setOnAction(new backLogTextFieldHandler());
				dRecTF.setOnAction(new backLogTextFieldHandler());
				dSymTF.setOnAction(new backLogTextFieldHandler());
				dSolTF.setOnAction(new backLogTextFieldHandler());
				dCauseTF.setOnAction(new backLogTextFieldHandler());
				
				defectsPane.add(dDifLbl, 3, 5);
				defectsPane.add(dDifTF, 3, 6);
				defectsPane.add(dTimeLbl, 4, 5);
				defectsPane.add(dTimeTF, 4, 6);
				defectsPane.add(dRecLbl, 5, 5);
				defectsPane.add(dRecTF, 5, 6);
				defectsPane.add(dTimeELbl, 6, 5);
				defectsPane.add(dTimeETF, 6, 6);
				defectsPane.add(dCurTimeELbl, 7, 5);
				defectsPane.add(dCurTimeETF, 7, 6);
				defectsPane.add(dTimeRLbl, 8, 5);
				defectsPane.add(dTimeRTF, 8, 6);
				defectsPane.add(dSymLbl, 3, 8);
				defectsPane.add(dSymTF, 3, 9);
				defectsPane.add(dCauseLbl, 4, 8);
				defectsPane.add(dCauseTF, 4, 9);
				defectsPane.add(dSolLbl, 5, 8);
				defectsPane.add(dSolTF, 5, 9);
				
				
				
				//****************END OF Defect PANE CODE *************************
		
		
	}
	
	//**********************Button Handling intensifies************************
	
		private class InButtonHandler implements EventHandler<ActionEvent>{		//Clock in button handler
			public void handle(ActionEvent e) {	
				timePunch.setText("You are clocked in");		//sets the text to clocked in
				timePunch.setTextFill(Color.GREEN);				//changes to green text
				startTime = System.currentTimeMillis();
			}
		}
		private class OutButtonHandler implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e) {
				timePunch.setText("You are not clocked in");
				timePunch.setTextFill(Color.RED);
				elapsedTime = System.currentTimeMillis() - startTime;
				elapsedSeconds = elapsedTime / 1000;
				elapsedMinutes = elapsedSeconds / 60;
				elapsedHours = elapsedMinutes / 60;
				secondsDisplay = elapsedSeconds % 60;
				minutesDisplay = elapsedMinutes % 60;
				hoursDisplay = elapsedHours;
				bLCurTimeETF.setText(hoursDisplay + ":" + minutesDisplay + ":" + secondsDisplay);
				curBl.addTime(elapsedSeconds);
				//curP.backLogItems.get(bLI).addTime(elapsedSeconds);
				bLTimeRTF.setText(curBl.getTimeR()+ " seconds");
				bLTimeETF.setText(curBl.getTimeE()+ " seconds");
				/*********************
				 ANDREW: you will want to somehow know if we are working on the defect or the backlog item selected
				 here I assumed the backlog item, once you add another button or someway to decide you will add something similar
				 */
			}
		}	
		private class AuthenticateBtnHandler implements EventHandler<ActionEvent>{
			private static boolean authenticate(String username, String password) throws IOException {
				File UserData = new File("C:\\Users\\benja\\Documents\\CSE360\\EffortLogger\\Projectoriginal\\CSE360-Project\\userData.txt"); //currently using a txt file to store user data once the SQL database has been established this will be updated
		        BufferedReader br = new BufferedReader(new FileReader(UserData));
		        Scanner scanner = new Scanner(UserData);
		        Scanner input = new Scanner(System.in);
		        try {
		            String line;
		            while ((line = br.readLine()) != null) {
		                // process the line
		                if(username.equals(line)){
		                    if(password.equals(br.readLine())) {
		                    	return true;
		                    }
		                }
		            }

		        } finally {}
				
				return false;
			}
			public void handle(ActionEvent e) {
		    	username = usernameTxtFld.getText();
		    	password = passwordTxtFld.getText();
		    	boolean validUser = true;
		    	//ANDREW: added validation
		    	try {
					validUser = authenticate(username, password);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	if (validUser) {							//if user is valid, go to system screen
		    		primaryStage.setScene(scene);
		    		primaryStage.show();
		    	}
		    	else {
		    		Label wrongInfo = new Label("Sorry, this info is incorrect");  		//if not correct, show an error message
		    		wrongInfo.setTextFill(Color.RED);
		    		userAuthPane.add(wrongInfo, 2, 5);
		    	}
			}
		}
		
		private class SubmitBtnMainHandler implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e) {
				Label submission = new Label("Submitted.");
				pane.add(submission, 2, 8);
				/*ProjectList.getSelectionModel().clearSelection();
				LifeCycleList.getSelectionModel().clearSelection();
				EffortCat.getSelectionModel().clearSelection();
				EffortCat2.getSelectionModel().clearSelection();*/
				
				//BEN: if we do want to actually make a submitable form, i can set it so before it 
				//clears the boxes, the choices get set to variables, or we can just leave it as is to make it seem like working
				/*******************************
				 Save Project(s)
				 */
				for (int i = 0; i < ListOfProjects.size(); i++) {
					try {
						if (i == 0) {
							ListOfProjects.get(i).save(false, path);
						}
						else {
							ListOfProjects.get(i).save(true, path);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				try {
					ListOfProjects.get(0).makeReport("C:\\Users\\benja\\Documents\\report.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				EncryptOrDecrypt(path);
			}
		}
		
		private class projectComboHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent e) {
				pI = ProjectList.getSelectionModel().getSelectedIndex();
				curP = new Project();
				curP = ListOfProjects.get(pI);
				/*********************
				 Populate backLogItem list
				 */
				BackLogItem.getItems().clear();
				for (int i = 0; i < curP.backLogItems.size(); i++) {
					BackLogItem.getItems().add(curP.backLogItems.get(i).getName());
				}
				BackLogItem.getSelectionModel().select(0);
			}
		}
		
		private class backlogComboHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent e) {
				bLI = BackLogItem.getSelectionModel().getSelectedIndex();
				curBl = new BackLogItem();
				if (bLI == -1) {
					bLI = 0;
				}
				curBl = curP.backLogItems.get(bLI);
				bLDifTF.setText(curBl.getDif() + "");
				bLTimeTF.setText(curBl.getTime() + "");
				bLTimeETF.setText("" + curBl.getTimeE());
				bLDesTF.setText(curBl.getDescription());
				bLTimeRTF.setText("" + curBl.getTimeR());
				/*********************
				 Populate defect list
				 */
				Defect.getItems().clear();
				for (int i = 0; i < curBl.defects.size(); i++) {
					Defect.getItems().add(curBl.defects.get(i).getName());
				}
				Defect.getSelectionModel().select(0);
			}
		}
		
		private class defectComboHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent e) {
				dI = Defect.getSelectionModel().getSelectedIndex();
				curD = new Defect();
				if (dI == -1) {
					dI = 0;
				}
				curD = curBl.defects.get(dI);
				dDifTF.setText(curD.getDif() + "");
				dTimeTF.setText(curD.getTime() + "");
				dRecTF.setText(curD.getRec() + "");
				dTimeETF.setText("" + curD.getTimeE());
				dCauseTF.setText(curD.getCause());
				dTimeRTF.setText("" + curD.getTimeR());
				dSymTF.setText(curD.getSymptoms());
				dSolTF.setText(curD.getSolution());
			}
		}
		
		private class enterBtnHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent e) {
				//BEN: this would be the spot to have methods producing strings to 
				//output text based on what options your backlog program uses, the .setText takes a string parameter 
				//and displays it
				if(existingProj.isSelected()) {
					
				}
				else if(newProj.isSelected()) {
					
				}
			}
		}
		
		private class backLogTextFieldHandler implements EventHandler<ActionEvent> {
			
			public void handle(ActionEvent e) {
				if (e.getSource().equals(blNameTF)) {
					curBl.setName(blNameTF.getText().toString());
					curP.backLogItems.get(bLI).setName(curBl.getName());
				}
				else if (e.getSource().equals(bLTimeTF)) {
					curBl.setTime(Integer.parseInt(bLTimeTF.getText().toString()));
					curP.backLogItems.get(bLI).setDif(Integer.parseInt(bLTimeTF.getText().toString()));
				}
				else if (e.getSource().equals(bLDifTF)) {
					curBl.setDif(Integer.parseInt(bLDifTF.getText().toString()));
					curP.backLogItems.get(bLI).setDif(Integer.parseInt(bLDifTF.getText().toString()));
				}
				else if (e.getSource().equals(dNameTF)) {
					curD.setName(dNameTF.getText().toString());
					curBl.defects.get(dI).setName(curD.getName());
				}
				else if (e.getSource().equals(dTimeTF)) {
					curD.setTime(Integer.parseInt(dTimeTF.getText().toString()));
					curBl.defects.get(dI).setDif(Integer.parseInt(dTimeTF.getText().toString()));
				}
				else if (e.getSource().equals(dDifTF)) {
					curD.setDif(Integer.parseInt(dDifTF.getText().toString()));
					curBl.defects.get(dI).setDif(Integer.parseInt(dDifTF.getText().toString()));
				}
				else if (e.getSource().equals(dRecTF)) {
					curD.setDif(Integer.parseInt(dRecTF.getText().toString()));
					curBl.defects.get(dI).setDif(Integer.parseInt(dRecTF.getText().toString()));
				}
				else if (e.getSource().equals(bLDesTF)) {
					curBl.setDescription(bLDesTF.getText().toString());
					curP.backLogItems.get(bLI).setDescription(curBl.getDescription());
				}
				else if (e.getSource().equals(dSymTF)) {
					curD.setSymptoms(dSymTF.getText().toString());
					curBl.defects.get(dI).setSymptoms(curD.getSymptoms());
				}
				else if (e.getSource().equals(dCauseTF)) {
					curD.setName(dCauseTF.getText().toString());
					curBl.defects.get(dI).setCause(curD.getCause());
				}
				else if (e.getSource().equals(dSolTF)) {
					curD.setSolution(dSolTF.getText().toString());
					curBl.defects.get(dI).setSolution(curD.getSolution());
				}
				/*else if (e.getSource().equals(pathTF)) {
					path = pathTF.getText().toString();
				}*/
				
			}
		}
		
		private class newProjBtnHandler implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e) {
				projName = projNameFld.getText();
				//difficulty = Integer.parseInt(difficultyFld.getText());
				//defects = Integer.parseInt(defectsFld.getText());
				//time = Integer.parseInt(timeFld.getText());
				//ANDREW: please set to variables
				Project p = new Project(); // FIXME: must also take in backlog items
				p.setName(projName);
				
				ListOfProjects.add(p);
				
				
			}
		}
}
