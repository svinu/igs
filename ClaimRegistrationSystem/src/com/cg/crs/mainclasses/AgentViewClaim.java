package com.cg.crs.mainclasses;

import java.util.List;
import java.util.Scanner;

import com.cg.crs.exception.CRSException;
import com.cg.crs.model.AgentClaim;
import com.cg.crs.model.UserRole;
import com.cg.crs.service.CRSService;
import com.cg.crs.service.implementation.CRSServiceImpl;

public class AgentViewClaim {
	public static void agentViewClaim(UserRole user) {
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.nextLine();
		System.out.println("Your Customer's Claiming Details");
		CRSService service = new CRSServiceImpl();
		service = new CRSServiceImpl();
		List<AgentClaim> list;
		try {
			list = service.claimData(userName);
			for (AgentClaim entity : list) {
				System.out.println("Claim Number\tClaim Reason\tStreet\tCity\tState\tZip\tClaim Type\tPolicyNumber");
				System.out.println(entity.getAgentClaimNumber() + "\t" + entity.getAgentClaimReason()
						+ "\t" + entity.getAgentAccidentLocationStreet() + "\t"
						+ entity.getAgentAccidentCity() + "\t" + entity.getAgentAccidentState() + "\t"
						+ entity.getAgentAccidentZip() + "\t" + entity.getAgentClaimType() + "\t"
						+ entity.getAgentPolicyNumber());
			}
			
		} catch (CRSException e) {

			System.err.println("Problem Occured while viewing customer claim status ");
		}
		scanner.close();
	}

}
