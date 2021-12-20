package FoodProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import java.awt.Canvas;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.List;
import javax.swing.JSpinner;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class Screen {
	public static String url = "./image.jpg";
	private RestaurantDB resDB = new RestaurantDB();
	private GoogleMaps gm = new GoogleMaps();
	private JFrame frame;
	private JPasswordField password_login;
	private JTextField textField_id_login;
	private JPasswordField password_reg;
	private JTextField textField_id_reg;
	private JTextField textField_name_reg;
	private JTextField textField_search;
	private Image background;
	static boolean buttonClick=false;
	private String imageUrl = "";
	private double coordX = 0.0, coordY = 0.0;
	private static int cnt = 0;
	
	// 라벨 입력 가져오기 변수
	private String restaurantName = "음식점 이름";
	
	
	// 지도 관련 변수
	private Panel googleMap;
	private JPanel panel_main;
	private JPanel panel_map_main;
	private ImageIcon icon;
	private JPanel panel_fav_main;
	
	// 메인 스크린 관련 변수
	private JButton btn_rec_main,btn_select_area,btn_area_main,btn_near_main;
	private JButton btn_fav_main,btn_search,btn_reg_login,btn_detail_main;
	private JButton btn_back_main, btn_reg_reg, btn_login_login, btn_back_reg;
	private JLabel label_fav;
	private JList list_fav;
	private JPanel panel_search_area;
	private JComboBox gu_area;
	private JComboBox dong_area;
	private JPanel panel_search_main;
	private JComboBox btn_area;
	private Panel panel_area_main;
	private JList list_area;
	private JLabel label_area;
	private JPanel panel_reg;
	private JLabel label_id_reg;
	private Panel panel_detail_main;
	private JPanel panel_login;
	private JLabel label_pass_reg, label_title1_reg, label_name_reg;
	private JLabel label_id_login, label_pass_login, label_title2_login, label_title1_login;
	
	private ArrayList<String> areaFoodInfos;
	// 상세조건 페이지 관련 변수
	private JPanel panel_main_detail_main;
	private JButton btn_kfood, btn_cfood, btn_afood, btn_tfood, btn_jfood;
	private JButton btn_cafe, btn_food, btn_snack, btn_fastfood;
    
	private JPanel panel_cfood_detail_main;
	private JButton btn_cfood_1, btn_cfood_2,  btn_cfood_3, btn_cfood_4;
	private JButton btn_cfood_5, btn_cfood_6,btn_cfood_7, btn_cfood_8;
	private JButton btn_cfood_menu;
	
	private JPanel panel_kfood_detail_main;
	private JButton btn_kfood_1, btn_kfood_2, btn_kfood_3, btn_kfood_4;
	private JButton btn_kfood_5, btn_kfood_6, btn_kfood_7, btn_kfood_8;
	
	private JButton btn_kfood_menu;	
	private JPanel panel_afood_detail_main;
	private JButton btn_afood_1, btn_afood_2, btn_afood_3, btn_afood_4;
	private JButton btn_afood_5, btn_afood_6, btn_afood_7, btn_afood_8;
	private JButton btn_afood_menu;
	
	private JPanel panel_tfood_detail_main;
	private JButton btn_tfood_1, btn_tfood_2, btn_tfood_3, btn_tfood_4;
	private JButton btn_tfood_5, btn_tfood_6, btn_tfood_7, btn_tfood_8;
	private JButton btn_tfood_menu;
	
	private JPanel panel_jfood_detail_main;
	private JButton btn_jfood_1, btn_jfood_2, btn_jfood_3, btn_jfood_4;
	private JButton btn_jfood_5, btn_jfood_6, btn_jfood_7, btn_jfood_8;
	private JButton btn_jfood_menu;
	
	private JPanel panel_fastfood_detail_main;
	private JButton btn_fastfood_1, btn_fastfood_2, btn_fastfood_3, btn_fastfood_4;
	private JButton btn_fastfood_5, btn_fastfood_6, btn_fastfood_7, btn_fastfood_8;
	private JButton btn_fastfood_menu;
	
	private JPanel panel_snack_detail_main;
	private JButton btn_snack_1, btn_snack_2, btn_snack_3, btn_snack_4;
	private JButton btn_snack_5, btn_snack_6, btn_snack_7, btn_snack_8;
	private JButton btn_snack_menu;
	
	private JPanel panel_cafe_detail_main;
	private JButton btn_cafe_1, btn_cafe_2, btn_cafe_3, btn_cafe_4;
	private JButton btn_cafe_5, btn_cafe_6, btn_cafe_7, btn_cafe_8;
    private JButton btn_cafe_menu;
	
    private JPanel panel_food_detail_main;
    private JButton btn_food_1, btn_food_2, btn_food_3, btn_food_4, btn_food_5;
    private JButton btn_food_6, btn_food_7, btn_food_8;
    private JButton btn_food_menu;
    
    // favorites frame 변수  즐변
    private JPanel fav_1, fav_2, fav_3, fav_4, fav_5;
    private JPanel fav_6, fav_7, fav_8, fav_9, fav_10;
    
    private JLabel label_area_1_1, label_area_2_1, label_area_3_1, label_area_4_1, label_area_5_1;
    private JLabel label_area_6_1, label_area_7_1, label_area_8_1, label_area_9_1, label_area_10_1;
    
    
    private JButton btn_area_1_1,btn_area_2_1,btn_area_3_1,btn_area_4_1,btn_area_5_1;
    private JButton btn_area_6_1, btn_area_7_1, btn_area_8_1, btn_area_9_1, btn_area_10_1;
    
    //Food Info Frame 변수
    private JButton btn_favorites_add;
    private JButton btn_favorites_delete;
    private JTextPane textPaneReview;
    private ArrayList<String> favoriteRestaurantName = new ArrayList<>();
    private JButton btn_open_review;
    private JButton btn_review_upload;
    private JRadioButton rd_1,rd_2,rd_3,rd_4,rd_5;
    //Favorite Frame 변수
    //Area Select 변수
    private JPanel area_1, area_2, area_3, area_4, area_5, area_6, area_7,area_8, area_9, area_10;
    
    private JLabel label_area_1,label_area_2,label_area_3,label_area_4,label_area_5;
    private JLabel label_area_6, label_area_7, label_area_8, label_area_9, label_area_10;
    
    private JButton btn_area_1, btn_area_2, btn_area_3, btn_area_4,btn_area_5;
    private JButton btn_area_6, btn_area_7, btn_area_8, btn_area_9, btn_area_10;
    
    
   
	public void draw() {
		frame.setVisible(true);
		
	}
	public Screen() {
		createFrame();
		mainPanel();
		conditionFrame();
		favoritesFrame();
		mainScreenButtonClick();
		areaSelectButtonClick();
		detailConditionButtonClick();
	
	}

	private void createFrame() {
		frame = new JFrame();
		frame.setForeground(Color.BLACK);
		frame.setBackground(Color.BLACK);
		frame.setTitle("맛집 자바먹는다!!");
		frame.setBounds(800, 400, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);  // 사이즈 고정 해제
		
	}
	private void mainPanel() {	
		panel_main = new JPanel();
		panel_main.setBounds(0, 0, 484, 461);
		frame.getContentPane().add(panel_main);
		panel_main.setLayout(null);
		
		panel_fav_main = new JPanel();
		panel_fav_main.setBackground(Color.GREEN);
		panel_fav_main.setBounds(120, 80, 350, 350);
		panel_main.add(panel_fav_main);
		panel_fav_main.setLayout(null);
		
		label_fav = new JLabel("즐겨찾기 리스트");
		label_fav.setFont(new Font("굴림체", Font.BOLD, 20));
		label_fav.setBounds(10, 10, 300, 30);
		panel_fav_main.add(label_fav);
	
		
		list_fav = new JList();
		list_fav.setBounds(10, 40, 330, 300);
		panel_fav_main.add(list_fav);
		
		panel_detail_main = new Panel();
		panel_detail_main.setBackground(new Color(0,200,0));
		panel_detail_main.setBounds(120, 80, 350, 350);
		panel_main.add(panel_detail_main);
		panel_detail_main.setLayout(null);
		
		panel_search_area = new JPanel();
		panel_search_area.setBounds(120, 30, 350, 30);
		panel_main.add(panel_search_area);
		panel_search_area.setLayout(null);
		
		String[] area = {"고양시","안양시","과천시","광주시","남양주시","부천시","성남시","안산시","안성시","양주시","양평군","여주시","오산시","용인시","의왕시","의정부시"};
		gu_area = new JComboBox(area);
		gu_area.setModel(new DefaultComboBoxModel(area));
		gu_area.setFont(new Font("굴림체", Font.BOLD, 15));
		gu_area.setBounds(0, 0, 100, 30);
		panel_search_area.add(gu_area);
		gu_area.setSelectedItem(null);
		
		dong_area = new JComboBox();
		dong_area.setFont(new Font("굴림체", Font.BOLD, 15));
		dong_area.setBounds(120, 0, 100, 30);
		panel_search_area.add(dong_area);
		
		btn_area = new JComboBox();
		btn_area.setFont(new Font("굴림체", Font.BOLD, 15));
		btn_area.setBounds(120, 0, 100, 30);
		panel_search_area.add(btn_area);
		
		btn_select_area = new JButton("지역선택");
		btn_select_area.setFont(new Font("굴림체", Font.BOLD, 15));
		btn_select_area.setBounds(250, 0, 100, 30);
		panel_search_area.add(btn_select_area);
		
		panel_area_main = new Panel();
		panel_area_main.setBounds(120, 80, 350, 350);
		panel_area_main.setBackground(Color.GRAY);
		panel_main.add(panel_area_main);
		panel_area_main.setLayout(null);
		
		//DefaultListModel model = new DefaultListModel();
		list_area = new JList();
		
		list_area.setBounds(10, 40, 330, 300);
		panel_area_main.add(list_area);
		
		label_area = new JLabel("지역 리스트");
		label_area.setFont(new Font("굴림체", Font.BOLD, 20));
		label_area.setBounds(10, 10, 300, 30);
		panel_area_main.add(label_area);
		
		btn_rec_main = new JButton("오늘의추천");
		btn_rec_main.setBounds(10, 80, 100, 40);
		btn_rec_main.setBackground(Color.LIGHT_GRAY);
		btn_rec_main.setFont(new Font("굴림체", Font.BOLD, 12));
		panel_main.add(btn_rec_main);
		
		btn_area_main = new JButton("지역선택");
		btn_area_main.setBounds(10, 140, 100, 40);
		btn_area_main.setBackground(Color.LIGHT_GRAY);
		btn_area_main.setFont(new Font("굴림체", Font.BOLD, 12));
		panel_main.add(btn_area_main);
		
		btn_near_main = new JButton("근처맛집");
		btn_near_main.setBounds(10, 200, 100, 40);
		btn_near_main.setBackground(Color.LIGHT_GRAY);
		btn_near_main.setFont(new Font("굴림체", Font.BOLD, 12));
		panel_main.add(btn_near_main);
		
		btn_fav_main = new JButton("즐겨찾기");
		btn_fav_main.setBounds(10, 260, 100, 40);
		btn_fav_main.setBackground(Color.LIGHT_GRAY);
		btn_fav_main.setFont(new Font("굴림체", Font.BOLD, 12));
		panel_main.add(btn_fav_main);
		
		btn_detail_main = new JButton("상세조건");
		btn_detail_main.setBounds(10, 320, 100, 40);
		btn_detail_main.setBackground(Color.LIGHT_GRAY);
		btn_detail_main.setFont(new Font("굴림체", Font.BOLD, 12));
		panel_main.add(btn_detail_main);
		
		btn_back_main = new JButton("뒤로가기");
		btn_back_main.setBounds(10, 380, 100, 40);
		btn_back_main.setFont(new Font("굴림체", Font.BOLD, 12));
		btn_back_main.setBackground(Color.LIGHT_GRAY);
		panel_main.add(btn_back_main);
		
		panel_search_main = new JPanel();
		panel_search_main.setBounds(120, 30, 350, 30);
		panel_main.add(panel_search_main);
		panel_search_main.setLayout(null);
		
		textField_search = new JTextField();
		textField_search.setColumns(10);
		textField_search.setBounds(0, 0, 290, 30);
		panel_search_main.add(textField_search);
		
		btn_search = new JButton("검색");
		btn_search.setFont(new Font("굴림체", Font.BOLD, 12));
		btn_search.setBackground(Color.LIGHT_GRAY);
		btn_search.setBounds(290, 0, 60, 30);
		panel_search_main.add(btn_search);
		
		panel_reg = new JPanel();
		panel_reg.setLayout(null);
		panel_reg.setBounds(0, 0, 484, 461);
		frame.getContentPane().add(panel_reg);
		
		label_id_reg = new JLabel("아이디");
		label_id_reg.setHorizontalAlignment(SwingConstants.CENTER);
		label_id_reg.setFont(new Font("굴림체", Font.BOLD, 18));
		label_id_reg.setBounds(160, 245, 100, 30);
		panel_reg.add(label_id_reg);
		
		label_pass_reg = new JLabel("비밀번호");
		label_pass_reg.setHorizontalAlignment(SwingConstants.CENTER);
		label_pass_reg.setFont(new Font("굴림체", Font.BOLD, 18));
		label_pass_reg.setBounds(160, 285, 100, 30);
		panel_reg.add(label_pass_reg);
		
		password_reg = new JPasswordField();
		password_reg.setBounds(260, 285, 120, 30);
		panel_reg.add(password_reg);
		
		textField_id_reg = new JTextField();
		textField_id_reg.setFont(new Font("굴림체", Font.PLAIN, 12));
		textField_id_reg.setColumns(10);
		textField_id_reg.setBounds(260, 245, 120, 30);
		panel_reg.add(textField_id_reg);
		
		label_title1_reg = new JLabel("회원가입");
		label_title1_reg.setHorizontalAlignment(SwingConstants.CENTER);
		label_title1_reg.setFont(new Font("여기어때 잘난체", Font.BOLD, 50));
		label_title1_reg.setBounds(100, 80, 300, 50);
		panel_reg.add(label_title1_reg);
		
		//회원가입 부분
		btn_reg_reg = new JButton("회원가입");
		btn_reg_reg.setBackground(Color.LIGHT_GRAY);
		btn_reg_reg.setFont(new Font("굴림체", Font.BOLD, 18));
		btn_reg_reg.setBounds(260, 350, 120, 40);
		panel_reg.add(btn_reg_reg);
		
		textField_name_reg = new JTextField();
		textField_name_reg.setFont(new Font("굴림체", Font.PLAIN, 12));
		textField_name_reg.setColumns(10);
		textField_name_reg.setBounds(260, 205, 120, 30);
		panel_reg.add(textField_name_reg);
		
		label_name_reg = new JLabel("이름");
		label_name_reg.setHorizontalAlignment(SwingConstants.CENTER);
		label_name_reg.setFont(new Font("굴림체", Font.BOLD, 18));
		label_name_reg.setBounds(160, 205, 100, 30);
		panel_reg.add(label_name_reg);
		
		btn_back_reg = new JButton("뒤로가기");
		btn_back_reg.setBackground(Color.LIGHT_GRAY);
		btn_back_reg.setFont(new Font("굴림체", Font.BOLD, 18));
		btn_back_reg.setBounds(120, 350, 120, 40);
		panel_reg.add(btn_back_reg);
		
		panel_login = new JPanel();
		panel_login.setBounds(0, 0, 484, 461);
		frame.getContentPane().add(panel_login);
		panel_login.setLayout(null);
		
		label_id_login = new JLabel("아이디");
		label_id_login.setHorizontalAlignment(SwingConstants.CENTER);
		label_id_login.setFont(new Font("굴림체", Font.BOLD, 18));
		label_id_login.setBounds(160, 245, 100, 30);
		panel_login.add(label_id_login);
		
		label_pass_login = new JLabel("비밀번호");
		label_pass_login.setHorizontalAlignment(SwingConstants.CENTER);
		label_pass_login.setFont(new Font("굴림체", Font.BOLD, 18));
		label_pass_login.setBounds(160, 285, 100, 30);
		panel_login.add(label_pass_login);
		
		password_login = new JPasswordField();
		password_login.setBounds(260, 285, 120, 30);
		panel_login.add(password_login);
		
		textField_id_login = new JTextField();
		textField_id_login.setFont(new Font("굴림체", Font.PLAIN, 12));
		textField_id_login.setColumns(10);
		textField_id_login.setBounds(260, 245, 120, 30);
		panel_login.add(textField_id_login);
		
		label_title2_login = new JLabel("자바먹는다!");
		label_title2_login.setHorizontalAlignment(SwingConstants.CENTER);
		label_title2_login.setFont(new Font("여기어때 잘난체", Font.BOLD, 50));
		label_title2_login.setBounds(100, 130, 300, 50);
		panel_login.add(label_title2_login);
		
		label_title1_login = new JLabel("맛집");
		label_title1_login.setHorizontalAlignment(SwingConstants.CENTER);
		label_title1_login.setFont(new Font("여기어때 잘난체", Font.BOLD, 50));
		label_title1_login.setBounds(180, 80, 120, 50);
		panel_login.add(label_title1_login);
		
		btn_reg_login = new JButton("회원가입");
		btn_reg_login.setBackground(Color.LIGHT_GRAY);
		btn_reg_login.setFont(new Font("굴림체", Font.BOLD, 18));
		btn_reg_login.setBounds(120, 350, 120, 40);
		panel_login.add(btn_reg_login);
		
		btn_login_login = new JButton("로그인");
		btn_login_login.setBackground(Color.LIGHT_GRAY);
		btn_login_login.setFont(new Font("굴림체", Font.BOLD, 18));
		btn_login_login.setBounds(260, 350, 120, 40);
		panel_login.add(btn_login_login);
		
		panel_reg.setVisible(false);
		panel_main.setVisible(false);
		panel_detail_main.setVisible(false);
		panel_search_area.setVisible(false);
		panel_area_main.setVisible(false);
		panel_fav_main.setVisible(false);
		
		
		panel_map_main = new JPanel() {
			ImageIcon icon = new ImageIcon((new ImageIcon(Screen.url)).getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH));
			public void paint(Graphics g) {
				g.drawImage(icon.getImage(),0,0,this);
				System.out.println("panel_map_main에서반복");
			}
		};
		panel_map_main.setBounds(120, 80, 350, 350);
		panel_map_main.setBackground(Color.WHITE);
		panel_main.add(panel_map_main);
		panel_map_main.revalidate();
		panel_main.revalidate();
	}
	private void conditionFrame() {
		panel_main_detail_main = new JPanel();
		panel_main_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_main_detail_main);
		panel_main_detail_main.setLayout(null);
		
		btn_kfood = new JButton("한식");
		btn_kfood.setBackground(Color.LIGHT_GRAY);
		btn_kfood.setBounds(10, 10, 100, 100);
		panel_main_detail_main.add(btn_kfood);
		
		btn_cfood = new JButton("중식");
		btn_cfood.setBackground(Color.LIGHT_GRAY);
		btn_cfood.setBounds(125, 10, 100, 100);
		panel_main_detail_main.add(btn_cfood);
		
		btn_afood = new JButton("양식");
		btn_afood.setBackground(Color.LIGHT_GRAY);
		btn_afood.setBounds(240, 10, 100, 100);
		panel_main_detail_main.add(btn_afood);
		
		btn_tfood = new JButton("분식");
		btn_tfood.setBackground(Color.LIGHT_GRAY);
		btn_tfood.setBounds(10, 125, 100, 100);
		panel_main_detail_main.add(btn_tfood);
		
		btn_jfood = new JButton("일식");
		btn_jfood.setBackground(Color.LIGHT_GRAY);
		btn_jfood.setBounds(240, 125, 100, 100);
		panel_main_detail_main.add(btn_jfood);
		
		btn_cafe = new JButton("디저트");
		btn_cafe.setBackground(Color.LIGHT_GRAY);
		btn_cafe.setBounds(240, 240, 100, 100);
		panel_main_detail_main.add(btn_cafe);
		
		btn_food = new JButton("기타");
		btn_food.setBackground(Color.LIGHT_GRAY);
		btn_food.setBounds(125, 125, 100, 100);
		panel_main_detail_main.add(btn_food);
		
		btn_snack = new JButton("술안주");
		btn_snack.setBackground(Color.LIGHT_GRAY);
		btn_snack.setBounds(125, 240, 100, 100);
		panel_main_detail_main.add(btn_snack);
		
		btn_fastfood = new JButton("패스트푸드");
		btn_fastfood.setBackground(Color.LIGHT_GRAY);
		btn_fastfood.setBounds(10, 240, 100, 100);
		panel_main_detail_main.add(btn_fastfood);
		
		panel_cfood_detail_main = new JPanel();
		panel_cfood_detail_main.setLayout(null);
		panel_cfood_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_cfood_detail_main);
		
		btn_cfood_1 = new JButton("짜장면");
		btn_cfood_1.setBackground(Color.GRAY);
		btn_cfood_1.setBounds(10, 10, 100, 100);
		panel_cfood_detail_main.add(btn_cfood_1);
		
		btn_cfood_2 = new JButton("짬뽕");
		btn_cfood_2.setBackground(Color.GRAY);
		btn_cfood_2.setBounds(125, 10, 100, 100);
		panel_cfood_detail_main.add(btn_cfood_2);
		
		btn_cfood_3 = new JButton("탕수육");
		btn_cfood_3.setBackground(Color.GRAY);
		btn_cfood_3.setBounds(240, 10, 100, 100);
		panel_cfood_detail_main.add(btn_cfood_3);
		
		btn_cfood_4 = new JButton("깐풍기");
		btn_cfood_4.setBackground(Color.GRAY);
		btn_cfood_4.setBounds(10, 125, 100, 100);
		panel_cfood_detail_main.add(btn_cfood_4);
		
		btn_cfood_5 = new JButton("양장피");
		btn_cfood_5.setBackground(Color.GRAY);
		btn_cfood_5.setBounds(240, 125, 100, 100);
		panel_cfood_detail_main.add(btn_cfood_5);
		
		btn_cfood_8 = new JButton("팔보채");
		btn_cfood_8.setBackground(Color.GRAY);
		btn_cfood_8.setBounds(240, 240, 100, 100);
		panel_cfood_detail_main.add(btn_cfood_8);
		
		btn_cfood_menu = new JButton("메뉴");
		btn_cfood_menu.setBackground(Color.LIGHT_GRAY);
		btn_cfood_menu.setBounds(125, 125, 100, 100);
		panel_cfood_detail_main.add(btn_cfood_menu);
		
		btn_cfood_7 = new JButton("마라탕");
		btn_cfood_7.setBackground(Color.GRAY);
		btn_cfood_7.setBounds(125, 240, 100, 100);
		panel_cfood_detail_main.add(btn_cfood_7);
		
		btn_cfood_6 = new JButton("양꼬치");
		btn_cfood_6.setBackground(Color.GRAY);
		btn_cfood_6.setBounds(10, 240, 100, 100);
		panel_cfood_detail_main.add(btn_cfood_6);
		
		panel_kfood_detail_main = new JPanel();
		panel_kfood_detail_main.setLayout(null);
		panel_kfood_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_kfood_detail_main);
		
		
		btn_kfood_1 = new JButton("국밥");
		btn_kfood_1.setBackground(Color.GRAY);
		btn_kfood_1.setBounds(10, 10, 100, 100);
		panel_kfood_detail_main.add(btn_kfood_1);
		
		btn_kfood_2 = new JButton("된장찌게");
		btn_kfood_2.setBackground(Color.GRAY);
		btn_kfood_2.setBounds(125, 10, 100, 100);
		panel_kfood_detail_main.add(btn_kfood_2);
		
		btn_kfood_3 = new JButton("비빔밥");
		btn_kfood_3.setBackground(Color.GRAY);
		btn_kfood_3.setBounds(240, 10, 100, 100);
		panel_kfood_detail_main.add(btn_kfood_3);
		
		btn_kfood_4 = new JButton("제육볶음");
		btn_kfood_4.setBackground(Color.GRAY);
		btn_kfood_4.setBounds(10, 125, 100, 100);
		panel_kfood_detail_main.add(btn_kfood_4);
		
		btn_kfood_5 = new JButton("칼국수");
		btn_kfood_5.setBackground(Color.GRAY);
		btn_kfood_5.setBounds(240, 125, 100, 100);
		panel_kfood_detail_main.add(btn_kfood_5);
		
		btn_kfood_8 = new JButton("백반");
		btn_kfood_8.setBackground(Color.GRAY);
		btn_kfood_8.setBounds(240, 240, 100, 100);
		panel_kfood_detail_main.add(btn_kfood_8);
		
		btn_kfood_menu = new JButton("메뉴");
		btn_kfood_menu.setBackground(Color.LIGHT_GRAY);
		btn_kfood_menu.setBounds(125, 125, 100, 100);
		panel_kfood_detail_main.add(btn_kfood_menu);
		
		btn_kfood_7 = new JButton("막창");
		btn_kfood_7.setBackground(Color.GRAY);
		btn_kfood_7.setBounds(125, 240, 100, 100);
		panel_kfood_detail_main.add(btn_kfood_7);
		
		btn_kfood_6 = new JButton("삼겹살");
		btn_kfood_6.setBackground(Color.GRAY);
		btn_kfood_6.setBounds(10, 240, 100, 100);
		panel_kfood_detail_main.add(btn_kfood_6);
		
		panel_afood_detail_main = new JPanel();
		panel_afood_detail_main.setLayout(null);
		panel_afood_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_afood_detail_main);
		
		btn_afood_1 = new JButton("샐러드");
		btn_afood_1.setBackground(Color.GRAY);
		btn_afood_1.setBounds(10, 10, 100, 100);
		panel_afood_detail_main.add(btn_afood_1);
		
		btn_afood_2 = new JButton("스테이크");
		btn_afood_2.setBackground(Color.GRAY);
		btn_afood_2.setBounds(125, 10, 100, 100);
		panel_afood_detail_main.add(btn_afood_2);
		
		btn_afood_3 = new JButton("파스타");
		btn_afood_3.setBackground(Color.GRAY);
		btn_afood_3.setBounds(240, 10, 100, 100);
		panel_afood_detail_main.add(btn_afood_3);
		
		btn_afood_4 = new JButton("리조또");
		btn_afood_4.setBackground(Color.GRAY);
		btn_afood_4.setBounds(10, 125, 100, 100);
		panel_afood_detail_main.add(btn_afood_4);
		
		btn_afood_5 = new JButton("수프");
		btn_afood_5.setBackground(Color.GRAY);
		btn_afood_5.setBounds(240, 125, 100, 100);
		panel_afood_detail_main.add(btn_afood_5);
		
		btn_afood_8 = new JButton("타코");
		btn_afood_8.setBackground(Color.GRAY);
		btn_afood_8.setBounds(240, 240, 100, 100);
		panel_afood_detail_main.add(btn_afood_8);
		
		btn_afood_menu = new JButton("메뉴");
		btn_afood_menu.setBackground(Color.LIGHT_GRAY);
		btn_afood_menu.setBounds(125, 125, 100, 100);
		panel_afood_detail_main.add(btn_afood_menu);
		
		btn_afood_7 = new JButton("케밥");
		btn_afood_7.setBackground(Color.GRAY);
		btn_afood_7.setBounds(125, 240, 100, 100);
		panel_afood_detail_main.add(btn_afood_7);
		
		btn_afood_6 = new JButton("랍스터");
		btn_afood_6.setBackground(Color.GRAY);
		btn_afood_6.setBounds(10, 240, 100, 100);
		panel_afood_detail_main.add(btn_afood_6);
		
		panel_tfood_detail_main = new JPanel();
		panel_tfood_detail_main.setLayout(null);
		panel_tfood_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_tfood_detail_main);
		
		btn_tfood_1 = new JButton("김밥");
		btn_tfood_1.setBackground(Color.GRAY);
		btn_tfood_1.setBounds(10, 10, 100, 100);
		panel_tfood_detail_main.add(btn_tfood_1);
		
		btn_tfood_2 = new JButton("떡볶이");
		btn_tfood_2.setBackground(Color.GRAY);
		btn_tfood_2.setBounds(125, 10, 100, 100);
		panel_tfood_detail_main.add(btn_tfood_2);
		
		btn_tfood_3 = new JButton("라면");
		btn_tfood_3.setBackground(Color.GRAY);
		btn_tfood_3.setBounds(240, 10, 100, 100);
		panel_tfood_detail_main.add(btn_tfood_3);
		
		btn_tfood_4 = new JButton("볶음밥");
		btn_tfood_4.setBackground(Color.GRAY);
		btn_tfood_4.setBounds(10, 125, 100, 100);
		panel_tfood_detail_main.add(btn_tfood_4);
		
		btn_tfood_5 = new JButton("어묵");
		btn_tfood_5.setBackground(Color.GRAY);
		btn_tfood_5.setBounds(240, 125, 100, 100);
		panel_tfood_detail_main.add(btn_tfood_5);
		
		btn_tfood_8 = new JButton("핫도그");
		btn_tfood_8.setBackground(Color.GRAY);
		btn_tfood_8.setBounds(240, 240, 100, 100);
		panel_tfood_detail_main.add(btn_tfood_8);
		
		btn_tfood_menu = new JButton("메뉴");
		btn_tfood_menu.setBackground(Color.LIGHT_GRAY);
		btn_tfood_menu.setBounds(125, 125, 100, 100);
		panel_tfood_detail_main.add(btn_tfood_menu);
		
		btn_tfood_7 = new JButton("순대");
		btn_tfood_7.setBackground(Color.GRAY);
		btn_tfood_7.setBounds(125, 240, 100, 100);
		panel_tfood_detail_main.add(btn_tfood_7);
		
		btn_tfood_6 = new JButton("튀김");
		btn_tfood_6.setBackground(Color.GRAY);
		btn_tfood_6.setBounds(10, 240, 100, 100);
		panel_tfood_detail_main.add(btn_tfood_6);
		
		panel_jfood_detail_main = new JPanel();
		panel_jfood_detail_main.setLayout(null);
		panel_jfood_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_jfood_detail_main);
		
		btn_jfood_1 = new JButton("초밥");
		btn_jfood_1.setBackground(Color.GRAY);
		btn_jfood_1.setBounds(10, 10, 100, 100);
		panel_jfood_detail_main.add(btn_jfood_1);
		
		btn_jfood_2 = new JButton("회");
		btn_jfood_2.setBackground(Color.GRAY);
		btn_jfood_2.setBounds(125, 10, 100, 100);
		panel_jfood_detail_main.add(btn_jfood_2);
		
		btn_jfood_3 = new JButton("타코야끼");
		btn_jfood_3.setBackground(Color.GRAY);
		btn_jfood_3.setBounds(240, 10, 100, 100);
		panel_jfood_detail_main.add(btn_jfood_3);
		
		btn_jfood_4 = new JButton("돈까스");
		btn_jfood_4.setBackground(Color.GRAY);
		btn_jfood_4.setBounds(10, 125, 100, 100);
		panel_jfood_detail_main.add(btn_jfood_4);
		
		btn_jfood_5 = new JButton("규동");
		btn_jfood_5.setBackground(Color.GRAY);
		btn_jfood_5.setBounds(240, 125, 100, 100);
		panel_jfood_detail_main.add(btn_jfood_5);
		
		btn_jfood_8 = new JButton("오므라이스");
		btn_jfood_8.setBackground(Color.GRAY);
		btn_jfood_8.setBounds(240, 240, 100, 100);
		panel_jfood_detail_main.add(btn_jfood_8);
		
		btn_jfood_menu = new JButton("메뉴");
		btn_jfood_menu.setBackground(Color.LIGHT_GRAY);
		btn_jfood_menu.setBounds(125, 125, 100, 100);
		panel_jfood_detail_main.add(btn_jfood_menu);
		
		btn_jfood_7 = new JButton("우동");
		btn_jfood_7.setBackground(Color.GRAY);
		btn_jfood_7.setBounds(125, 240, 100, 100);
		panel_jfood_detail_main.add(btn_jfood_7);
		
		btn_jfood_6 = new JButton("야끼소바");
		btn_jfood_6.setBackground(Color.GRAY);
		btn_jfood_6.setBounds(10, 240, 100, 100);
		panel_jfood_detail_main.add(btn_jfood_6);
		
		panel_fastfood_detail_main = new JPanel();
		panel_fastfood_detail_main.setLayout(null);
		panel_fastfood_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_fastfood_detail_main);
		
		btn_fastfood_1 = new JButton("치킨");
		btn_fastfood_1.setBackground(Color.GRAY);
		btn_fastfood_1.setBounds(10, 10, 100, 100);
		panel_fastfood_detail_main.add(btn_fastfood_1);
		
		btn_fastfood_2 = new JButton("피자");
		btn_fastfood_2.setBackground(Color.GRAY);
		btn_fastfood_2.setBounds(125, 10, 100, 100);
		panel_fastfood_detail_main.add(btn_fastfood_2);
		
		btn_fastfood_3 = new JButton("햄버거");
		btn_fastfood_3.setBackground(Color.GRAY);
		btn_fastfood_3.setBounds(240, 10, 100, 100);
		panel_fastfood_detail_main.add(btn_fastfood_3);
		
		btn_fastfood_4 = new JButton("토스트");
		btn_fastfood_4.setBackground(Color.GRAY);
		btn_fastfood_4.setBounds(10, 125, 100, 100);
		panel_fastfood_detail_main.add(btn_fastfood_4);
		
		btn_fastfood_5 = new JButton("샌드위치");
		btn_fastfood_5.setBackground(Color.GRAY);
		btn_fastfood_5.setBounds(240, 125, 100, 100);
		panel_fastfood_detail_main.add(btn_fastfood_5);
		
		btn_fastfood_8 = new JButton("소떡소떡");
		btn_fastfood_8.setBackground(Color.GRAY);
		btn_fastfood_8.setBounds(240, 240, 100, 100);
		panel_fastfood_detail_main.add(btn_fastfood_8);
		
		btn_fastfood_menu = new JButton("메뉴");
		btn_fastfood_menu.setBackground(Color.LIGHT_GRAY);
		btn_fastfood_menu.setBounds(125, 125, 100, 100);
		panel_fastfood_detail_main.add(btn_fastfood_menu);
		
		btn_fastfood_7 = new JButton("감자튀김");
		btn_fastfood_7.setBackground(Color.GRAY);
		btn_fastfood_7.setBounds(125, 240, 100, 100);
		panel_fastfood_detail_main.add(btn_fastfood_7);
		
		btn_fastfood_6 = new JButton("도너츠");
		btn_fastfood_6.setBackground(Color.GRAY);
		btn_fastfood_6.setBounds(10, 240, 100, 100);
		panel_fastfood_detail_main.add(btn_fastfood_6);
		
		panel_snack_detail_main = new JPanel();
		panel_snack_detail_main.setLayout(null);
		panel_snack_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_snack_detail_main);
		
		btn_snack_1 = new JButton("닭발");
		btn_snack_1.setBackground(Color.GRAY);
		btn_snack_1.setBounds(10, 10, 100, 100);
		panel_snack_detail_main.add(btn_snack_1);
		
		btn_snack_2 = new JButton("곱창");
		btn_snack_2.setBackground(Color.GRAY);
		btn_snack_2.setBounds(125, 10, 100, 100);
		panel_snack_detail_main.add(btn_snack_2);
		
		btn_snack_3 = new JButton("닭똥집");
		btn_snack_3.setBackground(Color.GRAY);
		btn_snack_3.setBounds(240, 10, 100, 100);
		panel_snack_detail_main.add(btn_snack_3);
		
		btn_snack_4 = new JButton("전");
		btn_snack_4.setBackground(Color.GRAY);
		btn_snack_4.setBounds(10, 125, 100, 100);
		panel_snack_detail_main.add(btn_snack_4);
		
		btn_snack_5 = new JButton("돼지껍데기");
		btn_snack_5.setBackground(Color.GRAY);
		btn_snack_5.setBounds(240, 125, 100, 100);
		panel_snack_detail_main.add(btn_snack_5);
		
		btn_snack_8 = new JButton("쥐포");
		btn_snack_8.setBackground(Color.GRAY);
		btn_snack_8.setBounds(240, 240, 100, 100);
		panel_snack_detail_main.add(btn_snack_8);
		
		btn_snack_menu = new JButton("메뉴");
		btn_snack_menu.setBackground(Color.LIGHT_GRAY);
		btn_snack_menu.setBounds(125, 125, 100, 100);
		panel_snack_detail_main.add(btn_snack_menu);
		
		btn_snack_7 = new JButton("육포");
		btn_snack_7.setBackground(Color.GRAY);
		btn_snack_7.setBounds(125, 240, 100, 100);
		panel_snack_detail_main.add(btn_snack_7);
		
		btn_snack_6 = new JButton("꼼장어");
		btn_snack_6.setBackground(Color.GRAY);
		btn_snack_6.setBounds(10, 240, 100, 100);
		panel_snack_detail_main.add(btn_snack_6);
		
		panel_cafe_detail_main = new JPanel();
		panel_cafe_detail_main.setLayout(null);
		panel_cafe_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_cafe_detail_main);
		
		btn_cafe_1 = new JButton("아이스크림");
		btn_cafe_1.setBackground(Color.GRAY);
		btn_cafe_1.setBounds(10, 10, 100, 100);
		panel_cafe_detail_main.add(btn_cafe_1);
		
		btn_cafe_2 = new JButton("케이크");
		btn_cafe_2.setBackground(Color.GRAY);
		btn_cafe_2.setBounds(125, 10, 100, 100);
		panel_cafe_detail_main.add(btn_cafe_2);
		
		btn_cafe_3 = new JButton("커피");
		btn_cafe_3.setBackground(Color.GRAY);
		btn_cafe_3.setBounds(240, 10, 100, 100);
		panel_cafe_detail_main.add(btn_cafe_3);
		
		btn_cafe_4 = new JButton("브라우니");
		btn_cafe_4.setBackground(Color.GRAY);
		btn_cafe_4.setBounds(10, 125, 100, 100);
		panel_cafe_detail_main.add(btn_cafe_4);
		
		btn_cafe_5 = new JButton("마카롱");
		btn_cafe_5.setBackground(Color.GRAY);
		btn_cafe_5.setBounds(240, 125, 100, 100);
		panel_cafe_detail_main.add(btn_cafe_5);
		
		btn_cafe_8 = new JButton("와플");
		btn_cafe_8.setBackground(Color.GRAY);
		btn_cafe_8.setBounds(240, 240, 100, 100);
		panel_cafe_detail_main.add(btn_cafe_8);
		
		btn_cafe_menu = new JButton("메뉴");
		btn_cafe_menu.setBackground(Color.LIGHT_GRAY);
		btn_cafe_menu.setBounds(125, 125, 100, 100);
		panel_cafe_detail_main.add(btn_cafe_menu);
		
		btn_cafe_7 = new JButton("빙수");
		btn_cafe_7.setBackground(Color.GRAY);
		btn_cafe_7.setBounds(125, 240, 100, 100);
		panel_cafe_detail_main.add(btn_cafe_7);
		
		btn_cafe_6 = new JButton("베이글");
		btn_cafe_6.setBackground(Color.GRAY);
		btn_cafe_6.setBounds(10, 240, 100, 100);
		panel_cafe_detail_main.add(btn_cafe_6);
		
		panel_food_detail_main = new JPanel();
		panel_food_detail_main.setLayout(null);
		panel_food_detail_main.setBounds(0, 0, 350, 350);
		panel_detail_main.add(panel_food_detail_main);
		
		btn_food_1 = new JButton("냉면");
		btn_food_1.setBackground(Color.GRAY);
		btn_food_1.setBounds(10, 10, 100, 100);
		panel_food_detail_main.add(btn_food_1);
		
		btn_food_2 = new JButton("컵밥");
		btn_food_2.setBackground(Color.GRAY);
		btn_food_2.setBounds(125, 10, 100, 100);
		panel_food_detail_main.add(btn_food_2);
		
		btn_food_3 = new JButton("커리");
		btn_food_3.setBackground(Color.GRAY);
		btn_food_3.setBounds(240, 10, 100, 100);
		panel_food_detail_main.add(btn_food_3);
		
		btn_food_4 = new JButton("월남쌈");
		btn_food_4.setBackground(Color.GRAY);
		btn_food_4.setBounds(10, 125, 100, 100);
		panel_food_detail_main.add(btn_food_4);
		
		btn_food_5 = new JButton("아구찜");
		btn_food_5.setBackground(Color.GRAY);
		btn_food_5.setBounds(240, 125, 100, 100);
		panel_food_detail_main.add(btn_food_5);
		
		btn_food_8 = new JButton("훈제오리");
		btn_food_8.setBackground(Color.GRAY);
		btn_food_8.setBounds(240, 240, 100, 100);
		panel_food_detail_main.add(btn_food_8);
		
		btn_food_menu = new JButton("메뉴");
		btn_food_menu.setBackground(Color.LIGHT_GRAY);
		btn_food_menu.setBounds(125, 125, 100, 100);
		panel_food_detail_main.add(btn_food_menu);
		
		btn_food_7 = new JButton("만두");
		btn_food_7.setBackground(Color.GRAY);
		btn_food_7.setBounds(125, 240, 100, 100);
		panel_food_detail_main.add(btn_food_7);
		
		btn_food_6 = new JButton("쌀국수");
		btn_food_6.setBackground(Color.GRAY);
		btn_food_6.setBounds(10, 240, 100, 100);
		panel_food_detail_main.add(btn_food_6);
	}

	private void mainScreenButtonClick() {	
		btn_back_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_main.setVisible(false);
				panel_login.setVisible(true);
				System.out.println("= = = 메인화면 = = =");
				resDB.setLoginCheck(false);
			}
			
		});
		
		btn_reg_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_login.setVisible(false);
				panel_reg.setVisible(true);
				System.out.println("= = = 회원가입 = = =");
			}
			
		});
		
		btn_login_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					resDB.connectDB();
					if(resDB.login(textField_id_login.getText(), password_login.getText())){
						panel_login.setVisible(false);
						panel_reg.setVisible(false);
						panel_main.setVisible(true);
						System.out.println("= = = 로그인 = = =");
						System.out.println("아이디 : " + textField_id_login.getText());
						System.out.println("비밀번호 : " + password_login.getText());
					}
					resDB.closeDB();
				}catch(Exception e) {
					System.out.println("로그인 디비 연결 실패");
					e.printStackTrace();
				}
			}
			
		});
		
		btn_reg_reg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					resDB.connectDB();
					cnt = 5;
					if(resDB.insertUserData(cnt++, textField_id_reg.getText(),password_reg.getText(), textField_name_reg.getText(), " ", " ")) {
						panel_login.setVisible(true);
						panel_reg.setVisible(false);
						System.out.println("= = = 회원등록 = = =");
						System.out.println("이름 : " + textField_name_reg.getText());
						System.out.println("아이디 : " + textField_id_reg.getText());
						System.out.println("비밀번호 : " + password_reg.getText());
					}
					resDB.closeDB();
				} catch(Exception e) {
					System.out.println("회원가입 디비 연결 실패");
					e.printStackTrace();
				}
			}
			
		});
		
		btn_back_reg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_login.setVisible(true);
				panel_reg.setVisible(false);
				System.out.println("= = = 메인화면 = = =");
				
				
			}
			
		});
		
		btn_detail_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_map_main.setVisible(false);
				panel_detail_main.setVisible(true);
				panel_search_main.setVisible(true);
				panel_search_area.setVisible(false);
				panel_area_main.setVisible(false);
				panel_fav_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =q");
			}
			
		});
		
		btn_rec_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_map_main.setVisible(true);
				panel_detail_main.setVisible(false);
				panel_search_main.setVisible(true);
				panel_search_area.setVisible(false);
				panel_area_main.setVisible(false);
				panel_fav_main.setVisible(false);
				System.out.println("= = = 오늘의추천 = = =");
			}
			
		});
		
		btn_area_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_map_main.setVisible(false);
				panel_detail_main.setVisible(false);
				panel_search_main.setVisible(false);
				panel_search_area.setVisible(true);
				panel_area_main.setVisible(true);
				panel_fav_main.setVisible(false);
				System.out.println("= = = 지역선택 = = =");
			}
			
		});
		
		btn_near_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_map_main.setVisible(true);
				panel_detail_main.setVisible(false);
				panel_search_main.setVisible(true);
				panel_search_area.setVisible(false);
				panel_area_main.setVisible(false);
				panel_fav_main.setVisible(false);
				System.out.println("= = = 근처맛집 = = =");
			}
			
		});
		
		btn_fav_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_map_main.setVisible(false);    // 껏다 키는거
				panel_detail_main.setVisible(false);  //
				panel_search_main.setVisible(true);
				panel_search_area.setVisible(false);
				panel_area_main.setVisible(false);
				panel_fav_main.setVisible(true);
				
				/*버튼 클릭시 라벨 이름 변경*/
				boolean[] labelState = {true,true,true,true,true,true,true,true,true,true};
				
				if(favoriteRestaurantName.size()<10) {
					int cnt=9;
					for(int i=0; i != 10 - favoriteRestaurantName.size();) {
						favoriteRestaurantName.add("맛집: "+ (favoriteRestaurantName.size()+1));
						labelState[cnt--]=false;
					}
				}
				if(labelState[0]==true) {
					label_area_1_1.setText(favoriteRestaurantName.get(0));
					System.out.println("테스트");
				}
				if(labelState[1]==true) label_area_2_1.setText(favoriteRestaurantName.get(1));
				if(labelState[2]==true) label_area_3_1.setText(favoriteRestaurantName.get(2));
				if(labelState[3]==true) label_area_4_1.setText(favoriteRestaurantName.get(3));
				if(labelState[4]==true) label_area_5_1.setText(favoriteRestaurantName.get(4));
				if(labelState[5]==true) label_area_6_1.setText(favoriteRestaurantName.get(5));
				if(labelState[6]==true) label_area_7_1.setText(favoriteRestaurantName.get(6));
				if(labelState[7]==true) label_area_8_1.setText(favoriteRestaurantName.get(7));
				if(labelState[8]==true) label_area_9_1.setText(favoriteRestaurantName.get(8));
				if(labelState[9]==true) label_area_10_1.setText(favoriteRestaurantName.get(9));
				
				for(int i=0; i<10; i++) {
					System.out.println("label"+i+":"+labelState[i]);
				}
				
				System.out.println("= = = 즐겨찾기 = = =");
			}
			
		});
		
		
		//검색 버튼 클릭
		btn_search.addActionListener(new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent e) {
			   
			   String data = textField_search.getText();
			   System.out.println("검색어:" + data);
			   try {
				   resDB.connectDB();
				   System.out.println(resDB.searchRestaurant(data));
				   resDB.searchFoodInfoData(data);
				   gm.setURL(resDB.getAddress());
			       
				   gm.loadMap();
				   setPanel();
				   createFoodInfoFrame(resDB.searchRestaurant(data));
				   System.out.println("btn_search-mouseClick: "+gm.getURL());
				   gm.deleteMap();
				   
				   resDB.closeDB();
				   System.out.println("검색버튼클릭");
			   } catch (Exception e1) {
				   System.out.println("검색버튼클릭에러");
				   e1.printStackTrace();
			   }
		   }
		});
		
		gu_area.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(gu_area.getSelectedItem().equals("안양시")) {
					dong_area.removeAllItems();
					dong_area.setSelectedItem(null);
					dong_area.addItem("만안구");
					dong_area.addItem("동안구");
				} else if(gu_area.getSelectedItem().equals("고양시")) {}
				else if(gu_area.getSelectedItem().equals("의정부시")) {}
				else if(gu_area.getSelectedItem().equals("용인시")) {}
				else if(gu_area.getSelectedItem().equals("의왕시")) {}
				else if(gu_area.getSelectedItem().equals("안산시")) {}
			}
		});
		btn_select_area.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				resDB.searchAreaFoodData(gu_area.getSelectedItem().toString(), dong_area.getSelectedItem().toString());
				System.out.println("지역 검색 실행");
				//지역검색
				areaFoodInfos = resDB.getAreaFoodInfos();
				switch(areaFoodInfos.size()) {
				case 10:
					label_area_10.setText(areaFoodInfos.get(9));
				case 9:
					label_area_9.setText(areaFoodInfos.get(8));
				case 8:
					label_area_8.setText(areaFoodInfos.get(7));
				case 7:
					label_area_7.setText(areaFoodInfos.get(6));
				case 6:
					label_area_6.setText(areaFoodInfos.get(5));
				case 5:
					label_area_5.setText(areaFoodInfos.get(4));
				case 4:
					label_area_4.setText(areaFoodInfos.get(3));
				case 3:
					label_area_3.setText(areaFoodInfos.get(2));
				case 2:
					label_area_2.setText(areaFoodInfos.get(1));
				case 1:
					label_area_1.setText(areaFoodInfos.get(0));
					break;
				}
					
				resDB.closeDB();
				
			}
		});
		btn_kfood_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("국밥"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
		btn_kfood_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("찌개"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
		btn_kfood_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("비빔밥"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
		btn_kfood_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("제육볶음"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
		btn_kfood_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("칼국수"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
		btn_kfood_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("삼겹살"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
		btn_kfood_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("막창"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
		btn_cfood_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("짜장면"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
		btn_cfood_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("짬뽕"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
		btn_cfood_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				try {
					createFoodInfoFrame(resDB.searchMenu("탕수육"));
				} catch (SQLException e1) {
					System.out.println("이름 틀림");
					e1.printStackTrace();
				}
				
				resDB.closeDB();
			}
		});
	}
	private void areaSelectButtonClick() {
		area_1 = new JPanel();
		area_1.setBackground(Color.LIGHT_GRAY);
		area_1.setBounds(12, 5, 306, 20);
		list_area.add(area_1);
		area_1.setLayout(null);
		
		label_area_1 = new JLabel("지역맛집1");
		label_area_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_1.setBounds(0, 0, 250, 20);
		area_1.add(label_area_1);
		
		btn_area_1 = new JButton("열기");
		btn_area_1.setBackground(Color.GRAY);
		btn_area_1.setBounds(250, 0, 60, 20);
		area_1.add(btn_area_1);
		
		area_2 = new JPanel();
		area_2.setLayout(null);
		area_2.setBackground(Color.LIGHT_GRAY);
		area_2.setBounds(12, 35, 306, 20);
		list_area.add(area_2);
		
		label_area_2 = new JLabel("지역맛집2");
		label_area_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_2.setBounds(0, 0, 250, 20);
		area_2.add(label_area_2);
		
		btn_area_2 = new JButton("열기");
		btn_area_2.setBackground(Color.GRAY);
		btn_area_2.setBounds(250, 0, 60, 20);
		area_2.add(btn_area_2);
		
		area_3 = new JPanel();
		area_3.setLayout(null);
		area_3.setBackground(Color.LIGHT_GRAY);
		area_3.setBounds(12, 65, 306, 20);
		list_area.add(area_3);
		
		label_area_3 = new JLabel("지역맛집3");
		label_area_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_3.setBounds(0, 0, 250, 20);
		area_3.add(label_area_3);
		
		btn_area_3 = new JButton("열기");
		btn_area_3.setBackground(Color.GRAY);
		btn_area_3.setBounds(250, 0, 60, 20);
		area_3.add(btn_area_3);
		
		area_4 = new JPanel();
		area_4.setLayout(null);
		area_4.setBackground(Color.LIGHT_GRAY);
		area_4.setBounds(12, 95, 306, 20);
		list_area.add(area_4);
		
		label_area_4 = new JLabel("지역맛집4");
		label_area_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_4.setBounds(0, 0, 250, 20);
		area_4.add(label_area_4);
		
		btn_area_4 = new JButton("열기");
		btn_area_4.setBackground(Color.GRAY);
		btn_area_4.setBounds(250, 0, 60, 20);
		area_4.add(btn_area_4);
		
		area_5 = new JPanel();
		area_5.setLayout(null);
		area_5.setBackground(Color.LIGHT_GRAY);
		area_5.setBounds(12, 125, 306, 20);
		list_area.add(area_5);
		
		label_area_5 = new JLabel("지역맛집5");
		label_area_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_5.setBounds(0, 0, 250, 20);
		area_5.add(label_area_5);
		
		btn_area_5 = new JButton("열기");
		btn_area_5.setBackground(Color.GRAY);
		btn_area_5.setBounds(250, 0, 60, 20);
		area_5.add(btn_area_5);
		
		area_6 = new JPanel();
		area_6.setLayout(null);
		area_6.setBackground(Color.LIGHT_GRAY);
		area_6.setBounds(12, 155, 306, 20);
		list_area.add(area_6);
		
		label_area_6 = new JLabel("지역맛집6");
		label_area_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_6.setBounds(0, 0, 250, 20);
		area_6.add(label_area_6);
		
		btn_area_6 = new JButton("열기");
		btn_area_6.setBackground(Color.GRAY);
		btn_area_6.setBounds(250, 0, 60, 20);
		area_6.add(btn_area_6);
		
		area_7 = new JPanel();
		area_7.setLayout(null);
		area_7.setBackground(Color.LIGHT_GRAY);
		area_7.setBounds(12, 185, 306, 20);
		list_area.add(area_7);
		
		label_area_7 = new JLabel("지역맛집7");
		label_area_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_7.setBounds(0, 0, 250, 20);
		area_7.add(label_area_7);
		
		btn_area_7 = new JButton("열기");
		btn_area_7.setBackground(Color.GRAY);
		btn_area_7.setBounds(250, 0, 60, 20);
		area_7.add(btn_area_7);
		
		area_8 = new JPanel();
		area_8.setLayout(null);
		area_8.setBackground(Color.LIGHT_GRAY);
		area_8.setBounds(12, 215, 306, 20);
		list_area.add(area_8);
		
		label_area_8 = new JLabel("지역맛집8");
		label_area_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_8.setBounds(0, 0, 250, 20);
		area_8.add(label_area_8);
		
		btn_area_8 = new JButton("열기");
		btn_area_8.setBackground(Color.GRAY);
		btn_area_8.setBounds(250, 0, 60, 20);
		area_8.add(btn_area_8);
		
		area_9 = new JPanel();
		area_9.setLayout(null);
		area_9.setBackground(Color.LIGHT_GRAY);
		area_9.setBounds(12, 245, 306, 20);
		list_area.add(area_9);
		
		label_area_9 = new JLabel("지역맛집9");
		label_area_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_9.setBounds(0, 0, 250, 20);
		area_9.add(label_area_9);
		
		btn_area_9 = new JButton("열기");
		btn_area_9.setBackground(Color.GRAY);
		btn_area_9.setBounds(250, 0, 60, 20);
		area_9.add(btn_area_9);
		
		area_10 = new JPanel();
		area_10.setLayout(null);
		area_10.setBackground(Color.LIGHT_GRAY);
		area_10.setBounds(12, 275, 306, 20);
		list_area.add(area_10);
		
		label_area_10 = new JLabel("지역맛집10");
		label_area_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_10.setBounds(0, 0, 250, 20);
		area_10.add(label_area_10);
		
		btn_area_10 = new JButton("열기");
		btn_area_10.setBackground(Color.GRAY);
		btn_area_10.setBounds(250, 0, 60, 20);
		area_10.add(btn_area_10);
		panel_area_main.setVisible(false);
	}
	private void detailConditionButtonClick() {
		btn_kfood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(false);
				panel_kfood_detail_main.setVisible(true);
				System.out.println("= = = 한식 = = =");
			}
			
		});
		
		btn_jfood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(false);
				panel_jfood_detail_main.setVisible(true);
				System.out.println("= = = 일식 = = =");
			}
			
		});
		
		btn_cfood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(false);
				panel_cfood_detail_main.setVisible(true);
				System.out.println("= = = 중식 = = =");
			}
			
		});
		
		btn_afood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(false);
				panel_afood_detail_main.setVisible(true);
				System.out.println("= = = 양식 = = =");
			}
			
		});
		
		btn_food.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(false);
				panel_food_detail_main.setVisible(true);
				System.out.println("= = = 기타 = = =");
			}
			
		});
		
		btn_cafe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(false);
				panel_cafe_detail_main.setVisible(true);
				System.out.println("= = = 디저트 = = =");
			}
			
		});
		
		btn_snack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(false);
				panel_snack_detail_main.setVisible(true);
				System.out.println("= = = 술안주 = = =");
			}
			
		});
		
		btn_tfood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(false);
				panel_tfood_detail_main.setVisible(true);
				System.out.println("= = = 분식 = = =");
			}
			
		});
		
		btn_fastfood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(false);
				panel_fastfood_detail_main.setVisible(true);
				System.out.println("= = = 패스트푸드 = = =");
			}
			
		});
		
		btn_kfood_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(true);
				panel_kfood_detail_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =");
			}
			
		});
		
		btn_cfood_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(true);
				panel_cfood_detail_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =");
			}
			
		});
	
		btn_jfood_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(true);
				panel_jfood_detail_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =");
			}
			
		});
		
		btn_afood_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(true);
				panel_afood_detail_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =");
			}
			
		});
		
		btn_food_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(true);
				panel_food_detail_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =");
			}
			
		});
		
		btn_fastfood_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(true);
				panel_fastfood_detail_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =");
			}
			
		});
		
		btn_tfood_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(true);
				panel_tfood_detail_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =");
			}
			
		});
		
		btn_cafe_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(true);
				panel_cafe_detail_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =");
			}
			
		});
		
		btn_snack_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_main_detail_main.setVisible(true);
				panel_snack_detail_main.setVisible(false);
				System.out.println("= = = 상세조건 = = =");
			}
			
		});
	}
	private void favoritesFrame() {
		fav_1 = new JPanel();
		fav_1.setLayout(null);
		fav_1.setBackground(Color.LIGHT_GRAY);
		fav_1.setBounds(12, 5, 306, 20);
		list_fav.add(fav_1);
		
		label_area_1_1 = new JLabel("맛집 1");
		label_area_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_1_1.setBounds(0, 0, 250, 20);
		fav_1.add(label_area_1_1);
		
		btn_area_1_1 = new JButton("열기");
		btn_area_1_1.setBackground(Color.GRAY);
		btn_area_1_1.setBounds(250, 0, 60, 20);
		fav_1.add(btn_area_1_1);
		
		fav_2 = new JPanel();
		fav_2.setLayout(null);
		fav_2.setBackground(Color.LIGHT_GRAY);
		fav_2.setBounds(12, 35, 306, 20);
		list_fav.add(fav_2);
		
		label_area_2_1 = new JLabel("맛집 2");
		label_area_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_2_1.setBounds(0, 0, 250, 20);
		fav_2.add(label_area_2_1);
		
		btn_area_2_1 = new JButton("열기");
		btn_area_2_1.setBackground(Color.GRAY);
		btn_area_2_1.setBounds(250, 0, 60, 20);
		fav_2.add(btn_area_2_1);
		
		fav_3 = new JPanel();
		fav_3.setLayout(null);
		fav_3.setBackground(Color.LIGHT_GRAY);
		fav_3.setBounds(12, 65, 306, 20);
		list_fav.add(fav_3);
		
		label_area_3_1 = new JLabel("맛집 3");
		label_area_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_3_1.setBounds(0, 0, 250, 20);
		fav_3.add(label_area_3_1);
		
		btn_area_3_1 = new JButton("열기");
		btn_area_3_1.setBackground(Color.GRAY);
		btn_area_3_1.setBounds(250, 0, 60, 20);
		fav_3.add(btn_area_3_1);
		
		fav_4 = new JPanel();
		fav_4.setLayout(null);
		fav_4.setBackground(Color.LIGHT_GRAY);
		fav_4.setBounds(12, 95, 306, 20);
		list_fav.add(fav_4);
		
		label_area_4_1 = new JLabel("맛집 4");
		label_area_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_4_1.setBounds(0, 0, 250, 20);
		fav_4.add(label_area_4_1);
		
		btn_area_4_1 = new JButton("열기");
		btn_area_4_1.setBackground(Color.GRAY);
		btn_area_4_1.setBounds(250, 0, 60, 20);
		fav_4.add(btn_area_4_1);
		
		fav_5 = new JPanel();
		fav_5.setLayout(null);
		fav_5.setBackground(Color.LIGHT_GRAY);
		fav_5.setBounds(12, 125, 306, 20);
		list_fav.add(fav_5);
		
		label_area_5_1 = new JLabel("맛집 5");
		label_area_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_5_1.setBounds(0, 0, 250, 20);
		fav_5.add(label_area_5_1);
		
		btn_area_5_1 = new JButton("열기");
		btn_area_5_1.setBackground(Color.GRAY);
		btn_area_5_1.setBounds(250, 0, 60, 20);
		fav_5.add(btn_area_5_1);
		
		fav_6 = new JPanel();
		fav_6.setLayout(null);
		fav_6.setBackground(Color.LIGHT_GRAY);
		fav_6.setBounds(12, 155, 306, 20);
		list_fav.add(fav_6);
		
		label_area_6_1 = new JLabel("맛집 6");
		label_area_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_6_1.setBounds(0, 0, 250, 20);
		fav_6.add(label_area_6_1);
		
		btn_area_6_1 = new JButton("열기");
		btn_area_6_1.setBackground(Color.GRAY);
		btn_area_6_1.setBounds(250, 0, 60, 20);
		fav_6.add(btn_area_6_1);
		
		fav_7 = new JPanel();
		fav_7.setLayout(null);
		fav_7.setBackground(Color.LIGHT_GRAY);
		fav_7.setBounds(12, 185, 306, 20);
		list_fav.add(fav_7);
		
		label_area_7_1 = new JLabel("맛집 7");
		label_area_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_7_1.setBounds(0, 0, 250, 20);
		fav_7.add(label_area_7_1);
		
		btn_area_7_1 = new JButton("열기");
		btn_area_7_1.setBackground(Color.GRAY);
		btn_area_7_1.setBounds(250, 0, 60, 20);
		fav_7.add(btn_area_7_1);
		
		fav_8 = new JPanel();
		fav_8.setLayout(null);
		fav_8.setBackground(Color.LIGHT_GRAY);
		fav_8.setBounds(12, 215, 306, 20);
		list_fav.add(fav_8);
		
		label_area_8_1 = new JLabel("맛집 8");
		label_area_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_8_1.setBounds(0, 0, 250, 20);
		fav_8.add(label_area_8_1);
		
		btn_area_8_1 = new JButton("열기");
		btn_area_8_1.setBackground(Color.GRAY);
		btn_area_8_1.setBounds(250, 0, 60, 20);
		fav_8.add(btn_area_8_1);
		
		fav_9 = new JPanel();
		fav_9.setLayout(null);
		fav_9.setBackground(Color.LIGHT_GRAY);
		fav_9.setBounds(12, 245, 306, 20);
		list_fav.add(fav_9);
		
		label_area_9_1 = new JLabel("맛집 9");
		label_area_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_9_1.setBounds(0, 0, 250, 20);
		fav_9.add(label_area_9_1);
		
		btn_area_9_1 = new JButton("열기");
		btn_area_9_1.setBackground(Color.GRAY);
		btn_area_9_1.setBounds(250, 0, 60, 20);
		fav_9.add(btn_area_9_1);
		
		fav_10 = new JPanel();
		fav_10.setLayout(null);
		fav_10.setBackground(Color.LIGHT_GRAY);
		fav_10.setBounds(12, 275, 306, 20);
		list_fav.add(fav_10);
		
		label_area_10_1 = new JLabel("맛집 10");
		label_area_10_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_area_10_1.setBounds(0, 0, 250, 20);
		fav_10.add(label_area_10_1);
		
		btn_area_10_1 = new JButton("열기");
		btn_area_10_1.setBackground(Color.GRAY);
		btn_area_10_1.setBounds(250, 0, 60, 20);
		fav_10.add(btn_area_10_1);
		panel_fav_main.setVisible(false);
	}
	
	public void setPanel() {
		System.out.println("setPanel() 실행");
		googleMap = new Panel() {
			ImageIcon icon = new ImageIcon((new ImageIcon(Screen.url)).getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH));
			public void paint(Graphics g) {
				super.paint(g);
				g.drawImage(icon.getImage(),0,0,this);
				System.out.println("패널에서 안바뀜:"+resDB.getAddress());

			}
		
		};
		googleMap.setBounds(120, 80, 350, 350);
		googleMap.setBackground(Color.WHITE);
		panel_main.add(googleMap);
		googleMap.revalidate();
		panel_main.revalidate();
	
		
	}
	public void createFoodInfoFrame(String restaurantName) {
		System.out.println("음식정보프레임 생성");
	
		resDB.connectDB();
		
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(12, 10, 460, 30);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_name = new JLabel(restaurantName);
		label_name.setHorizontalAlignment(SwingConstants.CENTER);
		label_name.setFont(new Font("굴림", Font.PLAIN, 20));
		label_name.setBounds(0, 0, 350, 30);
		panel.add(label_name);
		
		btn_favorites_add = new JButton("즐겨찾기 추가");
		btn_favorites_add.setFont(new Font("굴림", Font.PLAIN, 12));
		btn_favorites_add.setBackground(new Color(204, 255, 204));
		btn_favorites_add.setBounds(290, 0, 110, 30);
		panel.add(btn_favorites_add);
		
		btn_favorites_delete = new JButton("해제");
		btn_favorites_delete.setFont(new Font("굴림", Font.PLAIN, 12));
		btn_favorites_delete.setBackground(new Color(204, 255, 204));
		btn_favorites_delete.setBounds(400, 0, 60, 30);
		panel.add(btn_favorites_delete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBounds(12, 50, 460, 100);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbMenu = new JLabel("메뉴");
		lbMenu.setFont(new Font("굴림", Font.PLAIN, 15));
		lbMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lbMenu.setBounds(0, 0, 60, 100);
		panel_1.add(lbMenu);
		
		JLabel lbMenuExplain = new JLabel(resDB.getFoodInfoFrameData(restaurantName).signatureFood + "    가격:" + resDB.getFoodInfoFrameData(restaurantName).foodPrice);
		lbMenuExplain.setFont(new Font("굴림", Font.PLAIN, 18));
		lbMenuExplain.setBackground(new Color(255,255,255));
		lbMenuExplain.setBounds(60, 0, 400, 100);
		panel_1.add(lbMenuExplain);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		panel_2.setBounds(12, 160, 160, 30);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbTel = new JLabel("전화 :");
		lbTel.setHorizontalAlignment(SwingConstants.CENTER);
		lbTel.setFont(new Font("굴림", Font.PLAIN, 15));
		lbTel.setBounds(0, 0, 50, 30);
		panel_2.add(lbTel);
		
		System.out.println("영업시간"+resDB.getFoodInfoFrameData(restaurantName).telNo);
		JLabel lbTelInput = new JLabel(resDB.getFoodInfoFrameData(restaurantName).telNo);
		lbTelInput.setFont(new Font("굴림", Font.PLAIN, 15));
		lbTelInput.setBounds(50, 0, 110, 30);
		panel_2.add(lbTelInput);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 204));
		panel_3.setBounds(12, 200, 160, 100);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbBusinessHour = new JLabel("영업시간 : ");
		lbBusinessHour.setHorizontalAlignment(SwingConstants.CENTER);
		lbBusinessHour.setBounds(0, 0, 70, 20);
		panel_3.add(lbBusinessHour);
		
		
		System.out.println("영업시간"+resDB.getFoodInfoFrameData(restaurantName).businessHour);
		JLabel lbBusinessHourInput = new JLabel(resDB.getFoodInfoFrameData(restaurantName).businessHour);
		lbBusinessHourInput.setHorizontalAlignment(SwingConstants.CENTER);
		lbBusinessHourInput.setBounds(0, 20, 160, 80);
		panel_3.add(lbBusinessHourInput);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(12, 310, 160, 41);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lbDelivery = new JLabel("배달 가능");
		lbDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lbDelivery.setBounds(0, 0, 75, 41);
		panel_4.add(lbDelivery);
		
		System.out.println("배달상태"+resDB.getFoodInfoFrameData(restaurantName).deliveryState);
		JLabel lbDeliveryState = new JLabel(resDB.getFoodInfoFrameData(restaurantName).deliveryState);
		lbDeliveryState.setHorizontalAlignment(SwingConstants.CENTER);
		lbDeliveryState.setBounds(0,0, 200, 41);
		panel_4.add(lbDeliveryState);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 204, 204));
		panel_5.setBounds(184, 160, 288, 191);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lbReview = new JLabel("리뷰");
		lbReview.setFont(new Font("굴림", Font.PLAIN, 15));
		lbReview.setHorizontalAlignment(SwingConstants.LEFT);
		lbReview.setBounds(12, 10, 50, 20);
		panel_5.add(lbReview);
		
		btn_open_review = new JButton("리뷰확인");
		btn_open_review.setBounds(180,10,100,20);
		panel_5.add(btn_open_review);
		
		textPaneReview = new JTextPane();
		textPaneReview.setBounds(12, 30, 264, 100);
		panel_5.add(textPaneReview);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(12, 136, 264, 20);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		rd_1 = new JRadioButton("1점");
		rd_1.setBackground(new Color(255, 255, 255));
		rd_1.setBounds(0, 0, 50, 20);
		panel_6.add(rd_1);
		
		rd_2 = new JRadioButton("2점");
		rd_2.setBackground(new Color(255, 255, 255));
		rd_2.setBounds(52, 0, 50, 20);
		panel_6.add(rd_2);
		
		rd_3 = new JRadioButton("3점");
		rd_3.setBackground(new Color(255, 255, 255));
		rd_3.setBounds(104, 0, 50, 20);
		panel_6.add(rd_3);
		
		rd_4 = new JRadioButton("4점");
		rd_4.setBackground(new Color(255, 255, 255));
		rd_4.setBounds(156, 0, 50, 20);
		panel_6.add(rd_4);
		
		rd_5 = new JRadioButton("5점");
		rd_5.setBackground(new Color(255, 255, 255));
		rd_5.setSelected(true);
		rd_5.setBounds(208, 0, 50, 20);
		panel_6.add(rd_5);
		
		ButtonGroup  group = new ButtonGroup();
		group.add(rd_1);
		group.add(rd_2);
		group.add(rd_3);
		group.add(rd_4);
		group.add(rd_5);
		
		btn_review_upload = new JButton("리뷰 남기기");
		btn_review_upload.setBackground(new Color(204, 255, 204));
		btn_review_upload.setBounds(94, 162, 100, 23);
		panel_5.add(btn_review_upload);
		foodInfoFrameClick(restaurantName);
		resDB.closeDB();
	}
	public void foodInfoFrameClick(String restaurantName) {
		btn_favorites_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				favoriteRestaurantName.add(restaurantName);
				System.out.println("즐겨찾기가 등록되었습니다");
			}
			
		});
		btn_favorites_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				favoriteRestaurantName.remove(restaurantName);
				System.out.println("즐겨찾기가 해제되었습니다");
			}
			
		});
		btn_review_upload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resDB.connectDB();
				int radioNo = 0;
				if(rd_1.isSelected()) radioNo = 1;
				else if(rd_2.isSelected()) radioNo = 2;
				else if(rd_3.isSelected()) radioNo = 3;
				else if(rd_4.isSelected()) radioNo = 4;
				else if(rd_5.isSelected()) radioNo = 5;
				resDB.updateReviewUpload(restaurantName, textPaneReview.getSelectedText(), radioNo);
				resDB.closeDB();
				System.out.println("리뷰를 등록하였습니다.");
			}
		});
		btn_open_review.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("리뷰 정보");
				frame.setBounds(800, 400, 500, 500);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				resDB.connectDB();

				String reviewContent = resDB.getFoodInfoFrameData(restaurantName).reviewContent;
				int reviewHoroscope = resDB.getFoodInfoFrameData(restaurantName).reviewHoroscope;
				if(reviewContent==null) reviewContent="없음";
				JPanel reviewPanel = new JPanel();
				reviewPanel.setBounds(10,10,500,500);
				reviewPanel.setBackground(new Color(100,50,100));
				reviewPanel.setLayout(null);
			
				frame.add(reviewPanel);
				
				JPanel reviewPanel2 = new JPanel();
				reviewPanel2.setBounds(20,20,400,400);
				reviewPanel2.setBackground(new Color(100,240,100));
				reviewPanel2.setLayout(null);
				reviewPanel.add(reviewPanel2);
				
				JLabel lbReviewShow = new JLabel("리뷰 글:"+ reviewContent);
				lbReviewShow.setBounds(10,10,200,200);
				lbReviewShow.setBackground(new Color(255,255,255));
				reviewPanel2.add(lbReviewShow);
				
				JLabel lbReviewStar = new JLabel("평점:" + reviewHoroscope);
				lbReviewStar.setBounds(10,50,50,50);
				lbReviewStar.setBackground(new Color(255,255,255));
				reviewPanel2.add(lbReviewStar);
	
				

				
				
				frame.setVisible(true);
				
				resDB.closeDB();
				System.out.println("review Frame 실행");
			}
		});
	}
	
	public void closeDB() {
		System.out.println("디비 닫힘");
		resDB.closeDB();
	}
}
