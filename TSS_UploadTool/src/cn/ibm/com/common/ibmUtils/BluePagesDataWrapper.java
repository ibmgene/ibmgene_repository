package cn.ibm.com.common.ibmUtils;

import com.ibm.bluepages.BPResults;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BluePagesDataWrapper {
	private final BPResults bpUserData;
	private final Map<String, String> normalizedBluePagesData;

	// keys for data access
	public final static String BP_COUNTRY_NAME_LONG = "COUNTRY";
	public final static String BP_PERSONNEL_NUMBER = "EMPNUM";
	public final static String BP_FULL_NAME = "NAME";
	public final static String BP_LOTUS_NOTES_ID = "NOTESID";
	public final static String BP_LOTUS_NOTES_MAIL = "NOTESEMAIL";
	public final static String BP_MANAGER_NAME = "MGRNUM";
	public final static String BP_TIE_LINE_PHONE_NUMBER = "TIE";
	public static final String BP_DIVISION = "DIV";
	public static final String BP_IS_MANAGER = "MGR";
	public static final String BP_EMPLOYEE_TYPE = "EMPTYPE";
	public static final String BP_EMAIL_ADDRESS = "INTERNET";
	public static final String BP_DEPARTMENT = "DEPT";
	public static final String BP_JOB_TITLE = "JOBRESPONSIB";
	public static final String BP_ORGCODE = "ORGCODE";
	public static final String BP_ORGDISPLAY = "ORGDISPLAY";
	public static final String BP_CNUM = "CNUM";
	public static final String BP_COUNTRY_CD = "MGRCC";
	public static final String BP_MANAGER_NUM = "MNUM";

	public final static String BP_NORMALIZED_FIRST_NAME = "HRFIRSTNAME";
	public final static String BP_NORMALIZED_LAST_NAME = "HRLASTNAME";
	public final static String BP_NORMALIZED_FULL_NAME = "FULL_NAME";

	public static final String NO_DATA_PROVIDED_BY_BP_FOR_FIELD = "No BP data provided";
	public static final String INVALID_BP_RESULT_OBJECT = "The Blue Pages Result object contains no data...";

	public BluePagesDataWrapper(BPResults userData)
			throws IllegalStateException {
		if (userData.succeeded() && userData.rows() > 0) {
			this.bpUserData = userData;
			this.normalizedBluePagesData = new HashMap<String, String>();
			this.parseAndStoreName();
		} else {
			throw new IllegalStateException(INVALID_BP_RESULT_OBJECT);
		}
	}

	public String getBluePagesDataByKey(String dataField) {
		return this.getData(dataField);
	}

	public String getNormalizedBluePagesDataByKey(String dataField) {
		return this.validateData(this.normalizedBluePagesData.get(dataField));
	}

	private String getData(String dataField) {
		List dataVector = this.bpUserData.getColumn(dataField);
		if (dataVector != null && (!(dataVector.isEmpty()))) {
			return this.validateData((String) dataVector.get(0));
		}
		return NO_DATA_PROVIDED_BY_BP_FOR_FIELD;
	}

	private String validateData(String fieldData) {
		if (fieldData == null || fieldData.length() == 0) {
			return NO_DATA_PROVIDED_BY_BP_FOR_FIELD;
		}
		return fieldData;
	}

	private void parseAndStoreName() {

		String fullName = this.getData(BP_FULL_NAME);
		String[] fullNameTokens = fullName.split("[,]");
		String lastName = fullNameTokens[0].trim();

		String notesId = this.getData(BP_LOTUS_NOTES_ID);

		String[] temp = notesId.split("[=/]");
		String[] firstNameTokens = temp[1].split("[ ]");
		String firstName = "";
		for (int i = 0; i < firstNameTokens.length - 1; i++) {
			firstName += firstNameTokens[i] + " ";
		}

		String notesIdNormalized = NO_DATA_PROVIDED_BY_BP_FOR_FIELD;
		if (notesId != null) {
			notesIdNormalized = notesId.replaceAll("CN=", "");
			notesIdNormalized = notesIdNormalized.replaceAll("OU=", "");
			notesIdNormalized = notesIdNormalized.replaceAll("O=", "");
		}
		this.normalizedBluePagesData.put(BP_NORMALIZED_FIRST_NAME, firstName);
		this.normalizedBluePagesData.put(BP_NORMALIZED_LAST_NAME, lastName);
		this.normalizedBluePagesData.put(BP_NORMALIZED_FULL_NAME, firstName
				+ " " + lastName);
		this.normalizedBluePagesData
				.put(BP_LOTUS_NOTES_MAIL, notesIdNormalized);
	}
}
