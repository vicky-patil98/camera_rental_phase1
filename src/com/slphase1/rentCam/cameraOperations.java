package com.slphase1.rentCam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class cameraOperations {
    private static ArrayList<Camera> cameraList = new ArrayList<>();
    private static Wallet wallet = new Wallet();
    
    static void addInitialData() {
        cameraList.add(new Camera("NIKON", "DSLR-D7500", 500.0));
        cameraList.add(new Camera("Sony", "DSLR12", 200.0));
        cameraList.add(new Camera("Panasonic", "XC", 500.0));
        cameraList.add(new Camera("Canon", "XLR", 800.0));
        cameraList.add(new Camera("Samsung", "Galaxy", 1000.0));
        cameraList.add(new Camera("Sony", "HD226", 500.0));
        cameraList.add(new Camera("LG", "L123", 500.0));
        cameraList.add(new Camera("Chroma", "Zune", 700.0));
    }

	
    static void addCamera(Scanner scanner) {
        //System.out.println("\nAdding a new camera:");
    	try {
    		
	        // Read camera details from the user
			System.out.print("ENTER CAMERA BRAND - ");
	        String brand = scanner.next().toUpperCase();
	        System.out.print("ENTER CAMERA MODEL - ");
	        String model = scanner.next().toUpperCase();
	        System.out.print("ENTER THE PER DAY PRICE (INR) - ");
	        double rentalAmount = scanner.nextDouble();
	
	        // Create a new Camera object with the provided details
	        Camera newCamera = new Camera(brand, model, rentalAmount);
	        cameraList.add(newCamera);
	
	        // Print confirmation message
	        System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");

    	}
    	catch(Exception e1){
    		System.out.println("FAILED TO ADD THE CAMERA, PLEASE TRY AGAIN BY ENTERING CORRECT INPUT VALUES");
    	}
    	scanner.nextLine();//clears the buffer
    }

    static void viewAllCameras() {
        //System.out.println("\nAll Cameras:");
        System.out.println("==============================================================================");
        System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\t\tSTATUS");
        System.out.println("==============================================================================");
        for (Camera camera : cameraList) {
            System.out.printf("%-10d\t%-10s\t%-10s\t%-10.2f\t\t%s%n",
                    camera.getSerialNumber(), camera.getBrand(), camera.getModel(),
                    camera.getRentalAmount(), camera.getStatus());
        }
        System.out.println("==============================================================================");
    }

    static void manageWallet(Scanner scanner) {
        // Display current wallet balance
        System.out.println("\nYOUR CURRENT WALLET BALANCE IS - INR." + wallet.getBalance());

        // Ask user if they want to deposit more amount
        System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET? (1.YES 2.NO) - ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            // Prompt user to enter amount
            System.out.print("ENTER THE AMOUNT TO DEPOSIT - ");
            double amount = scanner.nextDouble();
            wallet.deposit(amount);

            // Print confirmation message and updated balance
            System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR."+ wallet.getBalance());
            System.out.println(" ");
        }
    }

    static void rentCamera(Scanner scanner) {
        // Display all cameras
        viewAllCameras();
        // Ask user to enter camera ID
        System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT - ");
        int cameraID = scanner.nextInt();
        // Find the camera with the given ID
        Camera selectedCamera = null;
        for (Camera camera : cameraList) {
            if (camera.getSerialNumber() == cameraID) {
                selectedCamera = camera;
                break;
            }
        }
        // If the camera with the given ID is found
        if (selectedCamera != null) {
            // Check if wallet balance is sufficient for renting the camera
            if (wallet.getBalance() >= selectedCamera.getRentalAmount()) {
                // Update camera status to rented
                selectedCamera.setStatus("RENTED");
                // Complete the transaction
                wallet.deposit(-selectedCamera.getRentalAmount()); // Deduct rental amount from wallet balance
                System.out.println("YOUR TRANSACTION FOR CAMERA - " + selectedCamera.getBrand() + " " + selectedCamera.getModel() +
                        " with rent INR." + selectedCamera.getRentalAmount() + " HAS SUCCESSFULLY COMPLETED.");
            } else {
                // Insufficient balance
                System.out.println("ERROR: TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET ");
            }
        } else {
            // Camera with the given ID not found
            System.out.println("ERROR: CAMERA WITH ID" + cameraID + " NOT FOUND.");
        }
    }

    static void removeCamera(Scanner scanner) {
        // Display all cameras
        viewAllCameras();
        // Ask user to enter camera ID to remove
        System.out.print("ENTER THE CAMERA ID YOU WANT TO REMOVE - ");
        int cameraId = scanner.nextInt();
        // Iterator to iterate over the cameraList and remove the camera with the entered ID
        Iterator<Camera> iterator = cameraList.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Camera camera = iterator.next();
            // Camera with the given ID not found
            if (camera.getSerialNumber() == cameraId) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
        } else {
            System.out.println("CAMERA ID NOT FOUND. NO CAMERA REMOVED.");
        }
    } 

}
