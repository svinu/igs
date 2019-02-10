package com.cg.crs.mainclasses;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.crs.exception.CRSException;
import com.cg.crs.model.Report;
import com.cg.crs.model.UserRole;
import com.cg.crs.service.CRSService;
import com.cg.crs.service.implementation.CRSServiceImpl;

public class ReportGeneration {
	public static void reportGeneration(UserRole user) throws CRSException {

		Report report = new Report();
		CRSService crsService = new CRSServiceImpl();
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		Integer decision = 0;
		boolean flag2 = false;
		List<Report> list = new ArrayList<>();
		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter username");
			String userName = scanner.nextLine();
			if (crsService.userExists(userName)) {
				flag = true;

				try {
					list = crsService.reportGeneration(userName);
					System.out
							.println("1.Policy Number\t2.Claim Number\t3.Claim Type\t4.User Name");
					for (Report report1 : list) {

						System.out.println(report1.getPolicyNumber() + "\t"
								+ report1.getClaimNumber() + "\t"
								+ report1.getClaimType() + "\t" + userName);
						report.setPolicyNumber(report1.getPolicyNumber());
					}
					do {
						scanner = new Scanner(System.in);
						System.out.println("Do you want detailed view");

						try {
							System.out.println("1.Yes\n2.No");
							decision = scanner.nextInt();
							if (decision > 2) {
								flag = false;
								System.err
										.println("Enter values from the below list ");
							} else {
								flag = true;
							}
						} catch (InputMismatchException e) {
							// TODO: handle exception
							flag = false;
							System.err
									.println("Enter digits from the below list");
						}

						switch (decision) {
						case 1:
							flag = true;
							System.out.println("Enter Policy Number");
							do {
								scanner = new Scanner(System.in);

								try {
									Long policyNumber = scanner.nextLong();
									if (Pattern.matches("[0-9]{10}$",
											policyNumber.toString())) {
										for (Report report2 : list) {

											if (report2.getPolicyNumber()
													.equals(policyNumber)) {
												flag2 = true;
												report.setPolicyNumber(policyNumber);
												break;
											} else {
												System.err
														.println("Enter valid policy number which you are eligible for");
											}
										}
									} else {
										flag2 = false;

										System.err
												.println("Enter 10 digit policy number");
									}

								} catch (InputMismatchException e) {
									// TODO: handle exception
									System.err.println("Enter digits");
									flag2 = false;
								}
							} while (!flag2);

							list = crsService.detailedView(report);
							int count = 0;
							for (Report report3 : list) {
								count++;
								System.out.println("1.ClaimReason\t: "
										+ report3.getClaimReason()
										+ "\n2.Accident Street: "
										+ report3.getAccidentStreet()
										+ "\n3.Accident City\t: "
										+ report3.getAccidentCity()
										+ "\n4.Accident Zip\t: "
										+ report3.getAccidentZip()
										+ "\n5.Accident State: "
										+ report3.getAccidentState()
										+ "\n6.Claim Type\t: "
										+ report3.getClaimType());
								if (count > 0) {
									break;
								}
							}
							System.out.println("\n7.Question\t\t\tAnswer\n");
							count = 0;
							for (Report report2 : list) {

								if (count == 0) {
									System.out.println(report2
											.getClaimQuesDesc1()
											+ "\t\t\t"
											+ report2.getClaimQuesAns1());
								} else {
									System.out
											.println("\n"
													+ report2
															.getClaimQuesDesc1()
													+ "\t"
													+ report2
															.getClaimQuesAns1());
								}
								count++;
							}

							break;
						case 2:
						default:
							break;
						}
					} while (!flag);

				} catch (CRSException e) {

					System.err.println(e.getMessage());
				}
			}
			else
			{
				flag=false;
				System.err.println("Enter Valid Username");
			}
		}
		while (!flag);
		scanner.close();
	}
}
