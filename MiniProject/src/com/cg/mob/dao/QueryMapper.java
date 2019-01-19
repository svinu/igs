package com.cg.mob.dao;

public interface QueryMapper {

	public final static String selectAllMobiles = "Select * from programs_scheduled";
	public final static String insertApplication = "INSERT INTO APPLICATIONN VALUES(APPLICATIONS_ID_SEQUENCE.NEXTVAL,?,?,?,?,?,?,?,?,SYSDATE+1)";
	public final static String getApplicationId= "SELECT APPLICATIONS_ID_SEQUENCE.CURRVAL FROM DUAL";
	public static final String selectOnApplicationId = "select * from APPLICATIONN where APPLICATION_ID=?"; 

}
