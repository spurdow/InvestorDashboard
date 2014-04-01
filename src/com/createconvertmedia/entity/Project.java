package com.createconvertmedia.entity;

import com.google.gson.annotations.SerializedName;

public class Project {
	/**
	 Quarter table
	 id 								long primary key ai
	 server_name 						text
	 server_year 						text
	 server_q_quarter 					int
	 server_q_operational 				real
	 server_q_netearning 				real
	 server_q_cadnetearning 			real
	 server_q_aggregated 				real
	 server_q_dividend					real
	 server_q_compound 					real
	 server_q_dividendpershare 			real
	 server_q_compoundpershare 			real
	 server_q_dividendshare  			real
	 server_q_compoundshare 			real
	 server_q_totalshare 				real
	 server_status 						integer 0 seen/client, 1 new/server	 */
	
	public static final class DatabaseKey{
		public String ID = "id";
		public String SERVER_NAME = "server_name";
		public String SERVER_YEAR = "server_year";
		public String SERVER_Q_QUARTER = "server_q_quarter";
		public String SERVER_Q_OPERATIONAL = "server_q_operational";
		public String SERVER_Q_NETEARNING  = "server_q_netearning";
		public String SERVER_Q_CADNETEARNING = "server_q_cadnetearning";
		public String SERVER_Q_AGGREGATED = "server_q_aggregated";
		public String SERVER_Q_DIVIDEND = "server_q_dividend";
		public String SERVER_Q_COMPOUND = "server_q_compound";
		public String SERVER_Q_DIVIDENDPERSHARE = "server_q_dividendpershare";
		public String SERVER_Q_COMPOUNDPERSHARE = "server_q_compoundpershare";
		public String SERVER_Q_DIVIDENDSHARE = "server_q_dividendshare";
		public String SERVER_Q_COMPOUNDSHARE = "server_q_compoundshare";
		public String SERVER_Q_TOTALSHARE = "server_q_totalshare";
		public String SERVER_STATUS = "server_status";
		
		public String TABLE = "quarter_share";
		public String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + SERVER_NAME + " TEXT , " + SERVER_YEAR + " TEXT , " + SERVER_Q_QUARTER + " INTEGER ,"
				+ SERVER_Q_OPERATIONAL + " REAL , " + SERVER_Q_NETEARNING + " REAL , " + SERVER_Q_CADNETEARNING + " REAL , "
				+ SERVER_Q_AGGREGATED +  " REAL , " + SERVER_Q_DIVIDEND + " REAL , " + SERVER_Q_COMPOUND + " REAL , " + SERVER_Q_DIVIDENDSHARE + " REAL , " + SERVER_Q_COMPOUNDSHARE + " REAL ,"
				+ SERVER_Q_DIVIDENDPERSHARE + " REAL , " + SERVER_Q_COMPOUNDPERSHARE + " REAL , " + SERVER_Q_TOTALSHARE + " REAL , "
				+ SERVER_STATUS + " INTEGER );";
		
		public String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE;
		
		public String COL_NAME_INDEX = "CREATE INDEX " + TABLE + "_" + SERVER_NAME + "_IDX ON " + TABLE +"(" + SERVER_NAME+")" ;
		
		public String COL_QUARTER_INDEX = "CREATE INDEX " + TABLE + "_" + SERVER_Q_QUARTER + "_IDX ON " + TABLE +"(" + SERVER_Q_QUARTER+")" ;
		
		public String COL_YEAR_INDEX = "CREATE INDEX " + TABLE + "_" + SERVER_YEAR + "_IDX ON " + TABLE +"(" + SERVER_YEAR + ")" ;
		
	}
	
	private long id;
	
	@SerializedName("server_name")
	private String server_name;
	
	@SerializedName("server_year")
	private String server_year;
	
	@SerializedName("server_q_quarter")
	private int server_q_quarter;
	
	@SerializedName("server_q_operational")
	private double server_q_operational;
	
	@SerializedName("server_q_netearning")
	private double server_q_netearning;
	
	@SerializedName("server_q_cadnetearning")
	private double server_q_cadnetearning;
	
	@SerializedName("server_q_aggregated")
	private double server_q_aggregated;
	
	@SerializedName("server_q_dividend")
	private double server_q_dividend;
	
	@SerializedName("server_q_compound")
	private double server_q_compound;
	
	@SerializedName("server_q_dividendpershare")
	private double server_q_dividendpershare;
	
	@SerializedName("server_q_compoundpershare")
	private double server_q_compoundpershare;
	
	@SerializedName("server_q_dividendshare")
	private double server_q_dividendshare;
	
	@SerializedName("server_q_compoundshare")
	private double server_q_compoundshare;
	
	@SerializedName("server_q_totalshare")
	private double server_q_totalshare;
	
	@SerializedName("server_status")
	private int server_status;
	
	

	public Project() {
	}


	public Project(long id, String server_name ,String server_year, int server_q_quarter,
			double server_q_operational, double server_q_netearning,
			double server_q_cadnetearning, double server_q_aggregated,
			double server_q_dividend, double server_q_compound,
			double server_q_dividendpershare, double server_q_compoundpershare,
			double server_q_dividendshare, double server_q_compoundshare,
			double server_q_totalshare, int server_status) {
		super();
		this.id = id;
		this.server_name = server_name;
		this.server_year = server_year;
		this.server_q_quarter = server_q_quarter;
		this.server_q_operational = server_q_operational;
		this.server_q_netearning = server_q_netearning;
		this.server_q_cadnetearning = server_q_cadnetearning;
		this.server_q_aggregated = server_q_aggregated;
		this.server_q_dividend = server_q_dividend;
		this.server_q_compound = server_q_compound;
		this.server_q_dividendpershare = server_q_dividendpershare;
		this.server_q_compoundpershare = server_q_compoundpershare;
		this.server_q_dividendshare = server_q_dividendshare;
		this.server_q_compoundshare = server_q_compoundshare;
		this.server_q_totalshare = server_q_totalshare;
		this.server_status = server_status;
	}



	

	public String getServer_name() {
		return server_name;
	}


	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServer_year() {
		return server_year;
	}

	public void setServer_year(String server_year) {
		this.server_year = server_year;
	}
	
	

	public int getServer_q_quarter() {
		return server_q_quarter;
	}



	public void setServer_q_quarter(int server_q_quarter) {
		this.server_q_quarter = server_q_quarter;
	}



	public double getServer_q_operational() {
		return server_q_operational;
	}

	public void setServer_q_operational(double server_q_operational) {
		this.server_q_operational = server_q_operational;
	}

	public double getServer_q_netearning() {
		return server_q_netearning;
	}

	public void setServer_q_netearning(double server_q_netearning) {
		this.server_q_netearning = server_q_netearning;
	}

	public double getServer_q_cadnetearning() {
		return server_q_cadnetearning;
	}

	public void setServer_q_cadnetearning(double server_q_cadnetearning) {
		this.server_q_cadnetearning = server_q_cadnetearning;
	}

	public double getServer_q_aggregated() {
		return server_q_aggregated;
	}

	public void setServer_q_aggregated(double server_q_aggregated) {
		this.server_q_aggregated = server_q_aggregated;
	}

	public double getServer_q_dividend() {
		return server_q_dividend;
	}

	public void setServer_q_dividend(double server_q_dividend) {
		this.server_q_dividend = server_q_dividend;
	}

	public double getServer_q_compound() {
		return server_q_compound;
	}

	public void setServer_q_compound(double server_q_compound) {
		this.server_q_compound = server_q_compound;
	}

	public double getServer_q_dividendpershare() {
		return server_q_dividendpershare;
	}

	public void setServer_q_dividendpershare(double server_q_dividendpershare) {
		this.server_q_dividendpershare = server_q_dividendpershare;
	}

	public double getServer_q_compoundpershare() {
		return server_q_compoundpershare;
	}

	public void setServer_q_compoundpershare(double server_q_compoundpershare) {
		this.server_q_compoundpershare = server_q_compoundpershare;
	}

	public double getServer_q_dividendshare() {
		return server_q_dividendshare;
	}

	public void setServer_q_dividendshare(double server_q_dividendshare) {
		this.server_q_dividendshare = server_q_dividendshare;
	}

	public double getServer_q_compoundshare() {
		return server_q_compoundshare;
	}

	public void setServer_q_compoundshare(double server_q_compoundshare) {
		this.server_q_compoundshare = server_q_compoundshare;
	}

	public double getServer_q_totalshare() {
		return server_q_totalshare;
	}

	public void setServer_q_totalshare(double server_q_totalshare) {
		this.server_q_totalshare = server_q_totalshare;
	}

	public double getServer_status() {
		return server_status;
	}

	public void setServer_status(int server_status) {
		this.server_status = server_status;
	}
	
	public String toString(){
		return "quarter = " + this.server_q_quarter + " , cadnetearning = " + this.server_q_cadnetearning + " , name = " + this.server_name; 
	}

}
