package FoodProject;

import java.sql.*;
import java.util.ArrayList;
public class RestaurantDB {
    Connection con = null;
    Statement state = null;
    ResultSet rs = null;
    //Data data = new Data();
    String address = "";
    String restaurantName = "";
    boolean buttonClick = false;
    boolean loginCheck = false;
    static int favoriteCode = 1;
    ArrayList<String> areaFoodInfos = new ArrayList<>();
	public RestaurantDB() {
		System.out.println("디비 열림");
		try {
	        String url = "jdbc:mysql://localhost:3306/restaurant_db";
	        String name = "root";
	        String password = "";
	        Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url, name, password); 
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :" + e.toString());
		} catch (SQLException e) {
			System.out.println("DB 접속실패 : " + e.toString());
		} catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();
		}
	}
	public void connectDB() {
		System.out.println("디비 연결됨");
		try {
	        String url = "jdbc:mysql://localhost:3306/restaurant_db";
	        String name = "root";
	        String password = "";
	        Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url, name, password); 
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :" + e.toString());
		} catch (SQLException e) {
			System.out.println("DB 접속실패 : " + e.toString());
		} catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();
		}
	}
	public String searchRestaurant(String keyword) throws SQLException{
		String restaurantName="";
		try {
			String sql = "SELECT restaurant_name FROM t_food_info WHERE restaurant_name LIKE '%" + keyword + "%' LIMIT 1";
			state=con.createStatement();
			rs = state.executeQuery(sql);
	
			while(rs.next()) {
				restaurantName = rs.getString("restaurant_name");
				
			}
		} catch(Exception e){
			System.out.println("검색 에러");
			e.printStackTrace();
		}
		return restaurantName; 
	}
	public String searchMenu(String keyword) throws SQLException{
		String restaurantName="";
		try {
			String sql = "SELECT restaurant_name FROM t_favorites WHERE signature_food LIKE '%" + keyword + "%' LIMIT 1";
			state=con.createStatement();
			rs = state.executeQuery(sql);
	
			while(rs.next()) {
				restaurantName = rs.getString("restaurant_name");
				
			}
		} catch(Exception e){
			System.out.println("검색 에러");
			e.printStackTrace();
		}
		return restaurantName;
	}
	public void searchFoodInfoData(String restaurantName) throws SQLException {
		try {
			String sql = "SELECT address FROM t_food_info WHERE restaurant_name LIKE '%" + restaurantName + "%' LIMIT 1";
			state=con.createStatement();
			rs = state.executeQuery(sql);
	
			while(rs.next()) {
				String address = rs.getString("address");
				this.address=address;
			}
		} catch(Exception e){
			System.out.println("검색 에러");
			e.printStackTrace();
		}

	}
	public boolean insertUserData(int code, String id, String pw, String name, String area1, String area2) throws SQLException {
		try {
			String sql = "INSERT INTO t_user(user_code,user_id,user_password,user_name,user_area1,user_area2) VALUES('"+ code +"','" +id +"','"+pw+"','"+name+"','"+area1+"','"+area2+"');";
			
			state=con.createStatement();
		
			state.executeUpdate(sql);
			String sqlInsertCheck = "SELECT COUNT(*) FROM t_user WHERE user_code=" + code + ";";
			state=con.createStatement();
			rs = state.executeQuery(sqlInsertCheck);
			int rowCount=0;
			if(rs.next()) rowCount=rs.getInt(1);
			
			if(rowCount>0) {
				System.out.println("찾음");
				return true;
			}
		} catch(Exception e) {
			System.out.println("유저 정보 입력 에러");
			e.printStackTrace();
		}
		return false;
	}
	public void deleteUserData(String id) {
		try {
			String sql = "DELETE FROM t_user WHERE user_id='" + id + "';";
			state=con.createStatement();
			rs = state.executeQuery(sql);
		} catch(Exception e) {
			System.out.println("유저 정보 삭제 에러");
			e.printStackTrace();
		}
	}
	public boolean login(String id, String pw) {
		try {
			String sql = "SELECT COUNT(*) FROM t_user WHERE user_id='"+id+"' AND user_password='"+pw+ "'";
			state=con.createStatement();
			rs = state.executeQuery(sql);
			int rowCount=0;
			if(rs.next()) rowCount=rs.getInt(1);
			
			if(rowCount>0) {
				this.loginCheck=true;
				System.out.println("찾음");
			}
			
		} catch(Exception e) {
			System.out.println("로그인 에러");
			e.printStackTrace();
		}
		return this.loginCheck;
	}
	
	public void searchAreaFoodData(String area1, String area2) {
		try {
			String sql = "SELECT restaurant_name FROM t_food_info WHERE address LIKE '%"+area1+"%' AND address LIKE '%"+ area2 +"%' LIMIT 10";
			state=con.createStatement();
			rs = state.executeQuery(sql);
			this.areaFoodInfos.clear();
			
			while(rs.next()) {
				String restaurantName = rs.getString("restaurant_name");
				this.areaFoodInfos.add(restaurantName);
			}
			// 지역선택 범위 넓여야됨 
			// 만안구 안양8동 X
			// 안양시 동안구 O
			// DB도 수정해야됨
			
			System.out.println("searchAreaFood sql 데이터 개수:" + this.areaFoodInfos.size());
		} catch(Exception e){
			System.out.println("검색 에러");
			e.printStackTrace();
		}
	}
	public void updateReviewUpload(String restaurantName, String reviewContent, int reviewHoroscope) {
		try {
			String sql = "UPDATE t_favorites SET review_content ='"+reviewContent+"', review_horoscope = '" + reviewHoroscope + "' WHERE restaurant_name = '" +restaurantName + "';";
			state=con.createStatement();
			rs = state.executeQuery(sql);
		} catch(Exception e) {
			System.out.println("리뷰 입력 에러");
			e.printStackTrace();
		}
	}
	public FavoritesInfo getFoodInfoFrameData(String restaurantName) {
		Data info = new Data();
		try {
			String sql = "SELECT * FROM t_favorites WHERE restaurant_name='" + restaurantName + "' LIMIT 1"; 
			state=con.createStatement();
			rs = state.executeQuery(sql);
			while(rs.next()) {
				String resName = rs.getString("restaurant_name");
				String telNo = rs.getString("tel_no");
				String signatureFood = rs.getString("signature_food");
				String businessHour = rs.getString("business_hour");
				String foodPrice = rs.getString("food_price");
				String deliveryState = rs.getString("delivery_state");
				String reviewContent = rs.getString("review_content");
				int reviewHoroscope = rs.getInt("review_horoscope");
				info=new Data(resName,telNo,signatureFood,businessHour,foodPrice,deliveryState,reviewContent,reviewHoroscope);
			}			
			System.out.println("getFoodInfoFrameData실행:" + info.getFavoriteInfo().foodPrice);
		} catch(Exception e) {
			System.out.println("음식점 정보 가져오기 실패");
			e.printStackTrace();
		}	
		return info.getFavoriteInfo();
	}
	public String getAddress() {
		return this.address;
	}
	
	public Boolean getButtonState() {
		return this.buttonClick;
	}
	public ArrayList<String> getAreaFoodInfos(){
		return this.areaFoodInfos;
	}
	public void setLoginCheck(boolean check) {
		this.loginCheck=check;
	}
	public void closeDB() {
		try {
			if(rs!=null) this.rs.close();
			if(state!=null) this.state.close();
			if(con!=null) this.con.close();
		} catch(Exception e) {
			System.out.println("DB종료 에러");
			e.printStackTrace();
		}
	}
}
class Data {
	LocationOnly locationOnly = new LocationOnly();
	FavoritesInfo favorites = new FavoritesInfo();
	public Data() {}
	public Data(String restaurantName, String telNo, String signatureFood, String businessHour, String foodPrice, String deliveryState, String reviewContent, int reviewHoroscope) {
		this.favorites.restaurantName = restaurantName;
		this.favorites.telNo = telNo;
		this.favorites.signatureFood = signatureFood;
		this.favorites.businessHour = businessHour;
		this.favorites.foodPrice = foodPrice;
		this.favorites.deliveryState = deliveryState;
		this.favorites.reviewContent = reviewContent;
		this.favorites.reviewHoroscope = reviewHoroscope;
	}
	
	void setLocationOnly(double latitude, double longitude) {
		this.locationOnly.latitude = latitude;
		this.locationOnly.longitude = longitude;
	}
	LocationOnly getLocationOnly() {
		return this.locationOnly;
	}
	FavoritesInfo getFavoriteInfo() {
		return this.favorites;
	}
}
class LocationOnly{
	public double latitude;
	public double longitude;
	LocationOnly(){}
}
class FavoritesInfo{
	public String restaurantName;
	public String telNo;
	public String signatureFood;
	public String businessHour;
	public String foodPrice;
	public String deliveryState;
	public String reviewContent;
	public int reviewHoroscope;
	FavoritesInfo(){}
}