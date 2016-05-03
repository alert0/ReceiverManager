package tznin.com.receivermanager;


import com.mqzst_shitangzhen.base.config.Constant;
import com.mqzst_shitangzhen.base.https.NetworkManager;
import com.mqzst_shitangzhen.model.base.User;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 *@author  linchenqiao
 *@time     2015年5月20日下午12:23:03
 */
public class App extends Application {

	/**
	 * 日志的TAG
	 */
	private static final String TAG = App.class.getSimpleName();
	/**
	 * 保存一静态全局实例
	 */
	private static App context;

	public static App getInstance() {
		return context;
	}


	//public User getUser() {
	//	return user;
	//}

	//public void setUser(User user) {
	//	this.user = user;
	//}

	//private User user ;



	@Override
	public void onCreate() {
		super.onCreate();
		if (context == null) {
			context = this;



		}



	}


	/**
	 * 
	 * @Title: isConnetNet
	 * @Description: 判断是否连接网络
	 * @param @param paramContext 上下文
	 * @param @return true 为网络已连接 false为网络断开
	 * @return boolean
	 * @throws
	 */
	public static  boolean isConnetNet(Context paramContext) {


		ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		return networkInfo != null && networkInfo.isAvailable();

	}

//	/**
//	 * 设置是否记住登录密码
//	 */
//	public void setIsChecked(String rememberStr) {
//		//要保存的用户信息
//		SharedPreferences isCheckedInfo = getSharedPreferences(Constant.REMEMBER_PWD, Context.MODE_PRIVATE);
//
//		SharedPreferences.Editor editor = isCheckedInfo.edit();
//		editor.putString("rememberStr", rememberStr);
//		editor.commit();
//	}
//
//	/** bn
//	 * 获取是否记住登录密码
//	 */
//	public String getIsChecked() {
//
//		try {
//			SharedPreferences isCheckedInfo = getSharedPreferences(Constant.REMEMBER_PWD, Context.MODE_PRIVATE);
//			return isCheckedInfo.getString("rememberStr", "");
//
//		} catch (Exception e) {
//			return  "0";
//		}
//
//
//	}
//	/**
//	 * 设置登录信息
//	 */
//	public void setLoginInfo(String loginName, String loginPwd){
//		//要保存的用户信息
//		SharedPreferences userInfo = getSharedPreferences(Constant.LOGIN_INFO, Context.MODE_PRIVATE);
//
//		SharedPreferences.Editor editor = userInfo.edit();
//		editor.putString("loginName", loginName);
//		editor.putString("loginPwd", loginPwd);
//		editor.commit();
//
//	}
//
//	/**
//	 * 获得登录信息
//	 */
//	public String[] getLoginInfo(){
//		SharedPreferences userInfo = getSharedPreferences(Constant.LOGIN_INFO, Context.MODE_PRIVATE);
//		String loginName = userInfo.getString("loginName", "");
//		String loginPwd = userInfo.getString("loginPwd", "");
//		String Info[] = {loginName, loginPwd};
//		return Info;
//	}
//
//	/**
//	 * 用户所属部门
//	 */
//	public void setUserDepart(String departId, String depart){
//		//要保存的部门信息
//		SharedPreferences userDepart = getSharedPreferences(Constant.USER_DEPART, Context.MODE_PRIVATE);
//
//		SharedPreferences.Editor editor = userDepart.edit();
//		editor.putString("departId", departId);
//		editor.putString("depart", depart);
//		editor.commit();
//	}
//
//	public String[] getUserDepart(){
//		SharedPreferences userInfo = getSharedPreferences(Constant.USER_DEPART, Context.MODE_PRIVATE);
//		String departId = userInfo.getString("departId", "");
//		String depart = userInfo.getString("depart", "");
//		String Info[] = {departId, depart};
//		return Info;
//	}
//
//
//	/**
//	 * 用户岗位
//	 */
//
//	public void setUserPost(String post){
//
//		SharedPreferences userPost = getSharedPreferences(Constant.USER_POST, Context.MODE_PRIVATE);
//
//		SharedPreferences.Editor editor = userPost.edit();
//		editor.putString("post", post);
//		editor.commit();
//	}
//
//	public String getUserPost(){
//
//		SharedPreferences userPost = getSharedPreferences(Constant.USER_POST, Context.MODE_PRIVATE);
//		String post = userPost.getString("post", "");
//		return post;
//	}
//
//
//	/**
//	 * 选择人
//	 */
//	public void setSelectedPerson(String person) {
//		//保存选择的人
//		SharedPreferences personSelected = getSharedPreferences(Constant.PERSON_SELECTED, Context.MODE_PRIVATE);
//
//		SharedPreferences.Editor editor = personSelected.edit();
//		editor.putString("person", person);
//		editor.commit();
//	}
//
//
//	/*获得选择人*/
//	public String  getSelectedPerson() {
//		SharedPreferences personSelected = getSharedPreferences(Constant.PERSON_SELECTED, Context.MODE_PRIVATE);
//		String selectedPerson = personSelected.getString("person", "");
//
//		return selectedPerson;
//	}
	
}
