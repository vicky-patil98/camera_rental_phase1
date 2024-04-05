package com.slphase1.rentCam;

import java.util.Scanner;

public class CameraRentalApp {

    public static void main(String[] args) {
        // Display welcome message
        System.out.println("--------------------------------");
        System.out.println("| WELCOME TO CAMERA RENTAL APP |");
        System.out.println("--------------------------------");
        System.out.println("");

        // Ask user to enter username
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLEASE LOGIN TO CONTINUE - ");
        System.out.print("USERNAME -  ");
        String username = scanner.nextLine();

        // Display options
        System.out.println("\nHELLO, " + username + "! WELCOME TO THE APPLICATION.");
        System.out.println("\n");
        //Add initial camera's into the system.
        cameraOperations.addInitialData();
        int choice = 0;
        do {
            System.out.println("PLEASE SELECT AN OPTION - ");
            System.out.println("1. MY CAMERA");
            System.out.println("2. RENT A CAMERA");
            System.out.println("3. VIEW ALL CAMERAS");
            System.out.println("4. MY WALLET");
            System.out.println("5. EXIT");
            
            try {
	            // Read user's choice
	            choice = scanner.nextInt();
	
	            switch (choice) {
	                case 1:
	                    myCameraOptions(scanner);
	                    break;
	                case 2:
	                    //System.out.println("Option 2 selected: RENT A CAMERA");
	                    // Implement RENT A CAMERA logic
	                    cameraOperations.rentCamera(scanner);
	                    break;
	                case 3:
	                	cameraOperations.viewAllCameras();
	                    break;
	                case 4:
	                	cameraOperations.manageWallet(scanner);
	                    break;
	                case 5:
	                    System.out.println("Exiting application...");
	                    // Implement EXIT logic
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please select a valid option.");
	            }
            }
            catch(Exception e)
            {
            	System.out.println("ERROR : ENTER THE VALID OPTION NUMBER - "+e);
            }
            scanner.nextLine();
        }while (choice != 5);
    }

    private static void myCameraOptions(Scanner scanner) {
        int choice=0;
        do{
            System.out.println("\nMY CAMERA OPTIONS - ");
            System.out.println("1. ADD");
            System.out.println("2. REMOVE");
            System.out.println("3. VIEW MY CAMERAS");
            System.out.println("4. GO TO PREVIOUS MENU");

            try {
	            // Read user's choice
	            System.out.print("ENTER YOUR CHOICE - ");
	            choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                	cameraOperations.addCamera(scanner);
	                	//System.out.println("Came here again");
	                    break;
	                case 2:
	                    //System.out.println("Option 2 selected: REMOVE");
	                    // Implement REMOVE logic
	                    cameraOperations.removeCamera(scanner);
	                    break;
	                case 3:
	                    //System.out.println("Option 3 selected: VIEW MY CAMERAS");
	                    // Implement VIEW MY CAMERAS logic
	                    cameraOperations.viewAllCameras();
	                    break;
	                case 4:
	                    System.out.println("GOING BACK TO THE PREVIOUS MENU...");
	                    return; // Go back to the previous menu
	                    // No action needed, will return to the previous menu
	                default:
	                    System.out.println("INVALID CHOICE. PLEASE SELECT A VALID OPTION.");
	            }
            }
            catch(Exception e)
            {
            	System.out.println("ERROR : ENTER THE VALID OPTION NUMBER - "+e);
            }
            scanner.nextLine();//clears the buffer
        }while(choice !=4);

    }
}

