package cn.ibm.com.common.constants;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/** 
 * @author Yichao.HUANG 2006-6-29
 */
public class Constants {
	
	public final static Map AD_TO_AD_CATEGROY_MAP = new HashMap();
	
	static {
		AD_TO_AD_CATEGROY_MAP.put("002001", "001");
		AD_TO_AD_CATEGROY_MAP.put("003001", "002");
		AD_TO_AD_CATEGROY_MAP.put("003003", "003");
		AD_TO_AD_CATEGROY_MAP.put("003004", "003");
		AD_TO_AD_CATEGROY_MAP.put("004001", "004");
		AD_TO_AD_CATEGROY_MAP.put("004001", "999");
	}
	
	/*
	 * */
	public static final String GLOBAL_PARAM_NAMES = "sid&query&uuoid";
	
	/**
	 * 管理员操作记录,INSERT是增加操作，UPDATE是修改操作,DELETE是删除操作
	 * */
	
	public final static String ADMIN_LOG_INSERT = "INSERT";
	
	public final static String ADMIN_LOG_UPDATE = "UPDATE";
	
	public final static String ADMIN_LOG_DELETE = "DELETE";
	
	/**
	 * 广告显示的比率，1是给用户看的数据，0是管理员看的数据
	 * */
	
	public final static String AD_PERCENTAGE_FLAG_USER = "1";
	
	public final static String AD_PERCENTAGE_FLAG_ADMIN = "0";
	
	/**
	 * 悠悠村webMasterId
	 */
	public final static String UUCUN_WEBMASTER_ID = "UUCUNUUCUN";

	/**
	 * 悠悠村webMasterId
	 */
	public final static String UUCUN_ADMIN = "优告客服";

	/**
	 * 系统用户登录的Session名称
	 */
	public final static String SESSION_USER = "SESSION_USER_NAME";

	public final static String SESSION_LOGIN = "SESSION_LOGIN";

	public final static String SESSION_PASSWORD = "SESSION_PASSWORD";

	public final static String SESSION_LOGINTYPE = "loadType";

	/**
	 * 系统用户登录的Session后的权限名称
	 */
	public final static String SESSION_USER_POPEDOM = "SESSION_USER_POPEDOM_NAME";
	
	/**
	 * 系统管理员登录的Session后的权限名称
	 */
	public final static String SESSION_ADMIN_POPEDOM = "SESSION_ADMIN_POPEDOM_NAME";

	/**
	 * 系统管理员登录的Session名称
	 */
	public final static String SESSION_ADMIN = "SESSION_ADMIN_NAME";

	/**
	 * 前台WEB系统分页中每页最大记录数
	 */
	public final static int WEB_PAGE_SIZE = 10;
	
	/**
	 * 前台WEB系统宏观动态分页中每页最大记录数
	 */
	public final static int WEB_PAGE_SIZE_HGDT = 12;
	/**
	 * 前台WEB系统债券信息分页中每页最大记录数
	 */
	public final static int WEB_PAGE_SIZE_ZQXX= 25;

	/**
	 * 每日信息模块每页的最大页面数
	 */
	public final static int ADMIN_PAGE_SIZE = 20;
	
	/**
	 * 更多资讯页面最大记录数
	 */
	public final static int NEWSMORE_PAGE_SIZE = 50;

	/**
	 * WAP系统分页中每页最大记录数
	 */
	public final static int WAP_PAGE_SIZE = 8;
	/**
	 * WAP系统分页中每页最大记录数
	 */
	public final static int WAP_PAGE_SIZE1 = 7;

	/**
	 * 随机权重的最大值
	 */
	public final static int AD_RANDOM_MAX = 10000000;

	/**
	 * 随机权重的默认值
	 */
	public final static int AD_RANDOM_BASE = 5;

	/**
	 * 字符分割符号
	 */
	public final static String SPLIT_SIGN = "^";

	/**
	 * 参数前缀
	 */
	public final static String PARAM_PREFIX = "pf_";

	/**
	 * 优告系统域名
	 */
	public final static String BASE_URL = "http://gadv.uucun.com/";
	/**
	 * 优告老系统域名
	 */
	public final static String OLD_URL = "http://adv.uucun.com/";

	/**
	 * 广告系统统计入口地址
	 */
	public final static String ADV_URL = BASE_URL + "advclick.html";

	/**
	 * 广告系统统计入口广告ID参数名称
	 */
	public final static String ADV_ID = "advid";

	/** 广告主行业类型大类代码 */
	public final static String AD_MASTER_CALLING_TYPE = "001";

	/** 网站主行业大类代码 */
	public final static String WEB_MASTER_CALLING_TYPE = "002";

	/** 广告主行业类型大类代码 */
	public final static String AD_CONTENT_CALLING_TYPE = "003";

	/** 广告第一次被门户页面拉出 */
	public final static String AD_CLICK_TYPE_PV1 = "001001";

	/** 广告第二次被门户页面拉出，即点到广告跳转页 */
	public final static String AD_CLICK_TYPE_PV2 = "001002";

	/** 广告进入advclick.html统计时产生 */
	public final static String AD_CLICK_TYPE_CV = "002001";

	/** 广告成果数产生 */
	public final static String AD_CLICK_TYPE_VV = "003001";

	/** 广告独立用户数产生 */
	public final static String AD_CLICK_TYPE_UV = "004001";
	
	/** 广告分类代码-免费地带 */
	public final static String AD_CATEGORY_FREEZONE = "003004";

	//
	public final static String TBL_MOBILE_TYPE = "TBL_MOBILE_TYPE";

	public final static String TBL_AD_PUT_AREA = "TBL_AD_PUT_AREA";

	public final static String TBL_MOBILE_SCREEN = "TBL_MOBILE_SCREEN";

	public final static String TBL_CALLING_TYPE = "TBL_CALLING_TYPE";

	public final static String TBL_GIVEN_WEB_SITE = "TBL_GIVEN_WEB_SITE";

	public final static String TBL_AD_CHARACTER = "TBL_AD_CHARACTER";

	public final static String TBL_AD_PICTURE = "TBL_AD_PICTURE";

	public final static String TBL_DAY_PERIOD = "TBL_DAY_PERIOD";

	public final static String PATTERN_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";

	public final static String DEFAULT_TIMEZONE = "GMT+8";

	public final static Locale DEFAULT_LOCALE = Locale.CHINA;

	public final static String DEFAULT_ENCODINIG = "UTF-8";

	public final static String DATABASE_CHARSET = "UTF-8";

	public final static int DEFAULT_SESSION_TIMEOUT = 600; // second

	public final static int CAT_SPAN_LENGTH = 3;

	public final static int AD_CODE_PK_LENGTH = 6;

	public final static String DEFAULT_CAT_START = "001";

	public final static int DATA_STRING = 0;

	public final static int DATA_INTEGER = 1;

	public final static int DATA_LONG = 2;

	public final static int DATA_DOUBLE = 3;

	public final static int DATA_DATE = 4;

	public final static int TASK_STATUS_ERROR = 0;

	public final static int TASK_STATUS_ACCEPTED = 1;

	public final static int TASK_STATUS_EXECUTING = 2;

	public final static int TASK_STATUS_FILE_CREATED = 3;

	public final static int TASK_STATUS_PARTIAL_COMPLETED = 4;

	public final static int TASK_STATUS_ALL_COMPLETED = 5;

	public final static int TASK_STATUS_CACELED = 6;

	// 操作动作
	public final static String ACTION_INSERT = "i";

	public final static String ACTION_DELETE = "d";

	public final static String ACTION_QUERY = "q";

	public final static String ACTION_FORBIDDEN = "f";

	public final static String ACTION_ACTIVE = "a";

	public final static String ACTION_PASS = "p";

	public final static String ACTION_HOLD_BACK = "h";
	// 流量记录类型
	public final static String CLICK_ACTION_TYPE_ = "h";
    //客户端
	public final static String ACTION_CLIENT_PASS = "Z";
	// 记录状态
	public final static int STATUS_NORMAL = 0; // 正常

	public final static int STATUS_IS_CHECKING = 1; // 等待审核

	public final static int STATUS_NOT_PASS = 2; // 审核未通过

	public final static int STATUS_OVERDUE = 7; // 已过期

	public final static int STATUS_FORBIDDEN = 8; // 禁用,冻结

	public final static int STATUS_DELETED = 9; // 删除

	// result dao code
	public final static int CODE_DEFAULT_RESULT = -1;

	public final static int CODE_DAO_SUCCESS = 1;

	public final static int CODE_DAO_FAILURE = -1;
    //client manager
	public final static String CODE_CLINET_APPLY="500";
	// result code
	public final static String CODE_SUCCESS = "0";
    
	public final static String CODE_PARAMETER_ERROR = "1";

	public final static String CODE_DATABASE_ACCESS_ERROR = "2";

	public final static String CODE_UNSUPPORTED_COMMAND_ERROR = "3";

	public final static String CODE_NO_PERMISSION_ERROR = "4";

	public final static String CODE_INVALID = "5";

	public final static String CODE_MAXLENGTH = "6";

	public final static String CODE_MINLENGTH = "7";

	public final static String CODE_RANGE = "8";

	public final static String CODE_REQUIRED = "9";

	public final static String CODE_BYTE = "10";

	public final static String CODE_DATE = "11";

	public final static String CODE_DOUBLE = "12";

	public final static String CODE_FLOAT = "13";

	public final static String CODE_INTEGER = "14";

	public final static String CODE_LONG = "15";

	public final static String CODE_SHORT = "16";

	public final static String CODE_CREDITCARD = "17";

	public final static String CODE_EMAIL = "18";

	public final static String CODE_NOT_EXISTS = "19";

	public final static String CODE_UNIQUE = "20";

	public final static String CODE_USERNAME_PASSWORD_NOT_MATCH = "21";

	public final static String CODE_NEED_LOGIN = "22";

	public final static String CODE_NO_MATCHED_RECORD = "23";

	public final static String CODE_INVALID_LICENSE = "24";

	public final static String CODE_CAMERA_AMOUNT_EXCEED = "25";

	public final static String CODE_USER_AMOUNT_EXCEED = "26";

	public final static String CODE_IN_USING = "27";

	public final static String CODE_CANNOT_BE_DELETE = "28";

	public final static String CODE_XML_INVALID = "29";

	public final static String CODE_CANNOT_GET_JDBC_CONNECTION = "30";

	public final static String CODE_PARAMETER_REQUIRE = "31";

	public final static String CODE_UNKNOWN_ERROR = "99";

	// Exception code from gpio
	public final static String CODE_GPIO_INVALID = "100";

	public final static String CODE_DELETE_AREA_WITH_SUBITEM_ERROR = "101";

	public final static String CODE_CANNOT_DELETE_ROOT_AREA = "102";

	public final static String CODE_NEED_STOP_ALL_TASK_BEFORE_DELETE_SA = "105";

	public final static String CODE_NOT_APPOINT_AREA = "106";

	public final static String CODE_PAIR_PARAMS_NOT_EQUALS = "200";

	public final static String CODE_SA_EERORS = "201";

	public final static String CODE_NOT_THE_SAME = "202";

	public final static String CODE_CAMEREA_IN_OTHER_GROUPS = "203";

	public final static String CODE_NEED_BACKUP_BEFORE_CLEAN = "204";

	public final static String CODE_TASK_HAS_BEEN_CANCELED = "205";

	public final static String CODE_TIME_OUT_RANGE = "206";

	public final static String CODE_START_TIME_LARGER = "207";

	// Exception Code from CSG
	public final static String CODE_CONTROLPTZ_FAILED = "300";

	public final static String CODE_DELETEVSUSER_FAILED = "301";

	public final static String CODE_SETVSIMAGEADJUSTING_FAILED = "302";

	public final static String CODE_SETVSIMAGEFORMAT_FAILED = "303";

	public final static String CODE_SETVSSERIALPORT_FAILED = "304";

	public final static String CODE_SETVSUSER_FAILED = "305";

	public final static String CODE_SETVSVIDEO_FAILED = "306";

	public final static String CODE_SUBSCRIBEALARM_FAILED = "307";

	public final static String CODE_VISIT_NVS_ERROR = "308";

	public final static String CODE_UNSUPPORTED_PTZ_PROTOCOL = "309";

	public final static String CODE_UNSUPPORTED_PTZ_PROTOCOL_COMMAND = "310";

	public final static String CODE_UNSUPPORTED_ACTION = "311";

	public final static String CODE_SETVSIMGPARAM_FAILED = "312";

	public final static String CODE_VS_AUTHENTICATE_FAILED = "313";

	public final static String CODE_SETVSIPINFO_FAILED = "314";

	public final static String CODE_SETGPIODEVICE_FAILED = "315";

	public final static String CODE_SETVSTIME_FAILED = "316";

	public final static String CODE_UNSUPPORT_VS_VENDOR = "317";

	public final static String CODE_SETDECODER_FAILED = "318";

	public final static String CODE_CONTROLVS_FAILED = "319";

	public final static String CODE_SET_VS_LOCAL_STORAGE_TASK_FAILED = "320";

	public final static String CODE_STOP_VS_LOCAL_STORAGE_TASK_FAILED = "321";
	
	public final static String CODE_ISEMPTY = "00";

    //Pattern
	public final static String PATTERN_EMAIL = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";// 邮件地址表达式
	public final static String PATTERN_TEL = "^([0-9]{3,4}-)?[0-9]{7,8}$";// 固定电话 表达式
	public final static String PATTERN_MOBILE = "^(\\+86)?0?1[3|5]\\d{9}$";// 移动电话 表达式
}
