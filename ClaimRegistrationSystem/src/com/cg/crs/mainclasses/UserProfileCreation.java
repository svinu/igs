package com.cg.crs.mainclasses;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.crs.exception.CRSException;
import com.cg.crs.model.UserRole;
import com.cg.crs.service.CRSService;
import com.cg.crs.service.implementation.CRSServiceImpl;

public class UserProfileCreation {

	public static void profileCreation(UserRole user) throws CRSException,
			InputMismatchException {
		CRSService crsService = new CRSServiceImpl();
		Scanner scanner = null;
		UserRole userProfile = new UserRole();
		int roleCode = 0;
		boolean userFlag = false;
		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter New Username:");
			String userName = scanner.nextLine();
			System.out.println("Enter New Password:");
			String password = scanner.nextLine();

			boolean flag = false;
			do {
				scanner = new Scanner(System.in);
				System.out
						.println("Enter new role code from the following list");
				System.out.println("1.Insured\n2.Agent\n3.Admin");
				try {
					roleCode = scanner.nextInt();
					if (roleCode < 4 && roleCode > 0) {
						flag = true;
					} else {
						flag = false;
						System.err.println("Enter input from 1 to 4");
					}

				} catch (InputMismatchException e) {

					System.err.println("Enter valid digits");
					flag = false;
				}
			} while (!flag);

			switch (roleCode) {
			case 1:
				userProfile.setRoleCode("INSURED");
				flag = true;
				break;
			case 2:
				userProfile.setRoleCode("AGENT");
				flag = true;
				break;
			case 3:
				userProfile.setRoleCode("ADMIN");
				flag = true;
				break;
			default:
				flag = false;
				break;
			}

			userProfile.setUserName(userName);
			userProfile.setPassword(password);
			try {
				if (crsService.profileCreation(userProfile)) {
					userFlag = true;
					System.out.println("Profile Created Successfully");
					boolean previousMenuFlag = false;
					String previousMenu= null;
					do {
						scanner = new Scanner(System.in);
						System.out
								.println("Enter Yes/No or Y/N  to go back previous menu");
						 previousMenu = scanner.nextLine();
						if (previousMenu.equals("Yes")
								|| previousMenu.equals("yes")
								|| previousMenu.equals("Y")
								|| previousMenu.equals("y")) {
							previousMenuFlag = true;
							Admin.adminClient(user);
						} else if (previousMenu.equals("No")
								|| previousMenu.equals("no")
								|| previousMenu.equals("n")
								|| previousMenu.equals("N")) {
							previousMenuFlag = true;
							System.out.println("==============================Thank You==============================");
							System.out.println("\t\t\t Have a Great Day");
							System.exit(0);
						} else {
							previousMenuFlag = false;
							System.out.println("Enter only Yes or No or Y/N");
						}
					} while (!previousMenuFlag);
				} else {
					userFlag = false;
					System.out.println("User already existed");
				}
			} catch (CRSException e) {
				System.err.println("" + e.getMessage());

			}
		} while (!userFlag);

		scanner.close();
	}

}
