package tznin.com.receivermanager;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.mqzst_shitangzhen.App;
import com.mqzst_shitangzhen.base.config.Constant;
import com.mqzst_shitangzhen.base.update.Constants;
import com.mqzst_shitangzhen.model.base.User;

/**
 * Created by kaisy on 2016/1/8.
 */
public class Storage {



	public static final  String POST = "住村干部";
	/**
	 * 记住登录信息
	 */
	public static final String LOGIN_INFO = "LoginInfo";


	public static final String USER_INFO = "user_info";
//
	/**
	 * 记住登录密码
	 */
	public static final String REMEMBER_PWD = "rememberPwd";
//
//	/**
//	 * 用户所属部门
//	 */
//	public static final String USER_DEPART = "userDepart";
//
//	/**
//	 * 用户岗位
//	 */
//	public static final String USER_POST = "userPost";
//

	public static final String USER_NAME  = "user_name";

//	public static final  String USER_ID = "userId";
//
//	public static final  String ORG_ID = "org_id";
//
//	public static final  String ORG_NAME = "org_name";
//
//	public static final  String POSTIDS = "postid";





//    public static SharedPreferences getSharedPreferences(){
//        return getSharedPreferences(Constants.USER_PREFS);
//    }

    private static SharedPreferences getSharedPreferences(String name){
        Context ctx = App.getInstance();
        return ctx.getSharedPreferences(name, Context.MODE_PRIVATE);
    }


    	/**
	 * 设置是否记住登录密码
	 */
	public static void setIsChecked(String rememberStr) {
		//要保存的用户信息
		SharedPreferences isCheckedInfo = getSharedPreferences(REMEMBER_PWD);

		SharedPreferences.Editor editor = isCheckedInfo.edit();
		editor.putString("rememberStr", rememberStr);
		editor.commit();
	}

	/**
	 * 获取是否记住登录密码
	 */
	public static  String getIsChecked() {
			SharedPreferences isCheckedInfo = getSharedPreferences(REMEMBER_PWD);
			return isCheckedInfo.getString("rememberStr", "");


	}
	/**
	 * 设置登录信息
	 */
	public static void setLoginInfo(String loginName, String loginPwd){
		//要保存的用户信息
		SharedPreferences userInfo = getSharedPreferences(LOGIN_INFO);

		SharedPreferences.Editor editor = userInfo.edit();
		editor.putString("loginName", loginName);
		editor.putString("loginPwd", loginPwd);
		editor.commit();

	}


	/**
	 * 设置用户信息
	 */
	public static void setUserInfo(User user ){

		//要保存的用户信息
		SharedPreferences userInfo = getSharedPreferences(USER_INFO);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(user);

		SharedPreferences.Editor editor = userInfo.edit();
		editor.putString(USER_NAME, jsonStr);

		editor.commit();

	}



	/**
	 * get 用户信息
	 */
	public  static User  getUserInfo( ){
		//要保存的用户信息
		SharedPreferences userInfo = getSharedPreferences(USER_INFO);


		Gson gson = new Gson();
		User user = gson.fromJson(userInfo.getString(USER_NAME,""), User.class);

//
//		userInfo.getString(USER_ID,""),
//		userInfo.getString(USER_NAME,""),
//		userInfo.getString(ORG_ID,""),
//		userInfo.getString(ORG_NAME,"") ,
//		userInfo.getString(POSTIDS,""),
//		userInfo.getString(POSTIDS,"") );

	     return user;
	}




	/**
	 * 获得登录信息
	 */
	public static String[] getLoginInfo(){
		SharedPreferences userInfo = getSharedPreferences(LOGIN_INFO);
		String loginName = userInfo.getString("loginName", "");
		String loginPwd = userInfo.getString("loginPwd", "");
		String Info[] = {loginName, loginPwd};
		return Info;
	}






}
