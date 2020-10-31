package snackapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Snack {

	private JFrame frame;
	private JTextField disp;
	private JTextField txtMainDish;
	private JTextField txtSideDish;
	private JTextField txtDessert;
	private JTextField txtDrink;
	private JTextField txtCurrency;
	private double firstNum;
	private double secondNum;
	private String operation;
	private JLabel lblClock1;
	
	
	double euro = 47.0383206;
	double pound_sterling = 51.8532903;
	double dollar = 39.824771;
	double inr = 1.85625555;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Snack window = new Snack();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//The clock function is not working....
	//---------------------------- CLOCK FUNCTION - GregorianCalendar class ------------------------------
	public void dateTime()
	{
		
		Thread dateTime = new Thread()
		{
			public void run()
			{
				try
				{
					//infinite loop
					for(;;)
					{
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						
						int seconds = cal.get(Calendar.SECOND);
						int minutes = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						
						lblClock1.setText("Time " + hour + ":" + minutes + ":" + seconds + System.lineSeparator() + "  Date " + day + "/" + month + "/" + year);
						
						sleep(1000);
						
					}
					
					
					
					
					
					
				}catch(Exception e)
				{
					
				}
			}
		};
		
		dateTime.start();
		
	}
	//--------------------------------------------------------------------------------------------

	/**
	 * Create the application.
	 */
	public Snack() {
		initialize();
		dateTime();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1550, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panel.setBounds(10, 49, 480, 684);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 460, 662);
		panel.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Calculator", null, panel_3, null);
		panel_3.setLayout(null);
		
		disp = new JTextField();
		disp.setHorizontalAlignment(SwingConstants.RIGHT);
		disp.setFont(new Font("Tahoma", Font.BOLD, 17));
		disp.setColumns(10);
		disp.setBounds(10, 28, 431, 53);
		panel_3.add(disp);
		
		JButton btnBackSpace = new JButton("<-");
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(disp.getText().length() > 0)
				{
					String backspace = null;
					StringBuilder strB = new StringBuilder(disp.getText());
					strB.deleteCharAt(disp.getText().length() - 1);
					backspace = strB.toString();
					disp.setText(backspace); 
					
				}else
				{
					
				}
				
				
			
			}
		});
		btnBackSpace.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnBackSpace.setBounds(10, 92, 105, 86);
		panel_3.add(btnBackSpace);
		
		
		
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				disp.setText(null);
			}
		});
		btnC.setForeground(Color.BLACK);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnC.setBackground(SystemColor.activeCaption);
		btnC.setBounds(125, 92, 100, 88);
		panel_3.add(btnC);
		
		final JButton btnMod = new JButton("%");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				firstNum = Double.parseDouble(disp.getText());
				disp.setText("");
				operation = btnMod.getText();
				//disp.setText(operation);
			}
		});
		btnMod.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnMod.setBackground(SystemColor.activeCaption);
		btnMod.setBounds(235, 92, 99, 88);
		panel_3.add(btnMod);
		
		final JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+ btn9.getText();
				disp.setText(enterValue);
			}
		});
		btn9.setForeground(Color.BLACK);
		btn9.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn9.setBackground(SystemColor.activeCaption);
		btn9.setBounds(10, 191, 105, 88);
		panel_3.add(btn9);
		
		final JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				firstNum = Double.parseDouble(disp.getText());
				disp.setText("");
				operation = btnPlus.getText();
				//disp.setText(operation);
			}
		});
		btnPlus.setForeground(Color.BLACK);
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnPlus.setBackground(SystemColor.activeCaption);
		btnPlus.setBounds(344, 92, 97, 88);
		panel_3.add(btnPlus);
		
		final JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				firstNum = Double.parseDouble(disp.getText());
				disp.setText("");
				operation = btnMinus.getText();
				//disp.setText(operation);
			}
		});
		btnMinus.setForeground(Color.BLACK);
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnMinus.setBackground(SystemColor.activeCaption);
		btnMinus.setBounds(346, 191, 95, 88);
		panel_3.add(btnMinus);
		
		final JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+btn7.getText();
				disp.setText(enterValue);
			}
		});
		btn7.setForeground(Color.BLACK);
		btn7.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn7.setBackground(SystemColor.activeCaption);
		btn7.setBounds(235, 191, 99, 88);
		panel_3.add(btn7);
		
		final JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+btn8.getText();
				disp.setText(enterValue);
			}
		});
		btn8.setForeground(Color.BLACK);
		btn8.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn8.setBackground(SystemColor.activeCaption);
		btn8.setBounds(125, 191, 100, 88);
		panel_3.add(btn8);
		
		final JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+ btn6.getText();
				disp.setText(enterValue);
			}
		});
		btn6.setForeground(Color.BLACK);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn6.setBackground(SystemColor.activeCaption);
		btn6.setBounds(10, 290, 105, 88);
		panel_3.add(btn6);
		
		final JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+ btn5.getText();
				disp.setText(enterValue);
			}
		});
		btn5.setForeground(Color.BLACK);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn5.setBackground(SystemColor.activeCaption);
		btn5.setBounds(125, 290, 100, 88);
		panel_3.add(btn5);
		
		final JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+ btn4.getText();
				disp.setText(enterValue);
			}
		});
		btn4.setForeground(Color.BLACK);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn4.setBackground(SystemColor.activeCaption);
		btn4.setBounds(235, 290, 99, 88);
		panel_3.add(btn4);
		
		final JButton btnMul = new JButton("x");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				firstNum = Double.parseDouble(disp.getText());
				disp.setText("");
				operation = btnMul.getText();
				//disp.setText(operation);
			}
		});
		btnMul.setForeground(Color.BLACK);
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnMul.setBackground(SystemColor.activeCaption);
		btnMul.setBounds(346, 290, 95, 88);
		panel_3.add(btnMul);
		
		final JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+ btn3.getText();
				disp.setText(enterValue);
			}
		});
		btn3.setForeground(Color.BLACK);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn3.setBackground(SystemColor.activeCaption);
		btn3.setBounds(10, 390, 105, 88);
		panel_3.add(btn3);
		
		final JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+ btn2.getText();
				disp.setText(enterValue);
			}
		});
		btn2.setForeground(Color.BLACK);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn2.setBackground(SystemColor.activeCaption);
		btn2.setBounds(125, 390, 100, 88);
		panel_3.add(btn2);
		
		final JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+ btn1.getText();
				disp.setText(enterValue);
			}
		});
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn1.setBackground(SystemColor.activeCaption);
		btn1.setBounds(235, 390, 99, 88);
		panel_3.add(btn1);
		
		final JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				firstNum = Double.parseDouble(disp.getText());
				disp.setText("");
				operation = btnDiv.getText();
				//disp.setText(operation);
			}
		});
		btnDiv.setForeground(Color.BLACK);
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnDiv.setBackground(SystemColor.activeCaption);
		btnDiv.setBounds(344, 390, 97, 88);
		panel_3.add(btnDiv);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				double answer = 0.0;
				secondNum = Double.parseDouble(disp.getText());
				switch(operation)
				{
					case "+" :
						answer = firstNum + secondNum;
						break;
					case "-" :
						answer = firstNum - secondNum;
						break;
					
					case "x":
						answer = firstNum * secondNum;
						break;
					
					case "/":
						answer = firstNum / secondNum;
						break;
					
					case "%":
						answer = firstNum % secondNum;
						break;
						
				}
				
				disp.setText(Double.toString(answer));
			}
		});
		btnEqual.setForeground(Color.BLACK);
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnEqual.setBackground(SystemColor.activeCaption);
		btnEqual.setBounds(344, 489, 97, 88);
		panel_3.add(btnEqual);
		
		JButton btnPM = new JButton("\u00B1");
		btnPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				double plusminus = Double.parseDouble(disp.getText());
				plusminus *= -1;
				disp.setText(Double.toString(plusminus));
			}
		});
		btnPM.setForeground(Color.BLACK);
		btnPM.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnPM.setBackground(SystemColor.activeCaption);
		btnPM.setBounds(235, 489, 99, 88);
		panel_3.add(btnPM);
		
		final JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+ btnDot.getText();
				disp.setText(enterValue);
			}
		});
		btnDot.setForeground(Color.BLACK);
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnDot.setBackground(SystemColor.activeCaption);
		btnDot.setBounds(125, 489, 100, 88);
		panel_3.add(btnDot);
		
		final JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String enterValue = disp.getText()+ btn0.getText();
				disp.setText(enterValue);
			}
		});
		btn0.setForeground(Color.BLACK);
		btn0.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn0.setBackground(SystemColor.activeCaption);
		btn0.setBounds(10, 489, 105, 88);
		panel_3.add(btn0);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Receipt", null, panel_4, null);
		panel_4.setLayout(null);
		
		final JTextArea receiptArea = new JTextArea();
		receiptArea.setBounds(10, 11, 435, 612);
		panel_4.add(receiptArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(499, 193, 1025, 327);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panel_1.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(0, 0, 255));
		lblMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblMenu.setBounds(102, 11, 95, 27);
		panel_1.add(lblMenu);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setForeground(new Color(0, 0, 255));
		lblQty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblQty.setBounds(306, 11, 95, 27);
		panel_1.add(lblQty);
		
		JLabel lblPriceRs = new JLabel("Price Rs");
		lblPriceRs.setForeground(new Color(0, 0, 255));
		lblPriceRs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPriceRs.setBounds(411, 11, 95, 27);
		panel_1.add(lblPriceRs);
		
		final JComboBox mainDishCombo = new JComboBox();
		mainDishCombo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mainDishCombo.setModel(new DefaultComboBoxModel(new String[] {"Main Dish", "Plain Rice", "Fried Rice", "Fried Noodle"}));
		mainDishCombo.setBounds(24, 49, 236, 37);
		panel_1.add(mainDishCombo);
		
		final JComboBox dessertCombo = new JComboBox();
		dessertCombo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dessertCombo.setModel(new DefaultComboBoxModel(new String[] {"Desserts", "Apple Pie", "Coconut Jelly"}));
		dessertCombo.setBounds(26, 145, 234, 37);
		panel_1.add(dessertCombo);
		
		final JComboBox sideDishCombo = new JComboBox();
		sideDishCombo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sideDishCombo.setModel(new DefaultComboBoxModel(new String[] {"Side Dish", "ChickenChopSuey", "Beef Thai", "Fish", "Chips"}));
		sideDishCombo.setBounds(26, 97, 234, 37);
		panel_1.add(sideDishCombo);
		
		txtMainDish = new JTextField();
		txtMainDish.setHorizontalAlignment(SwingConstants.CENTER);
		txtMainDish.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtMainDish.setBounds(270, 49, 115, 37);
		panel_1.add(txtMainDish);
		txtMainDish.setColumns(10);
		
		txtSideDish = new JTextField();
		txtSideDish.setHorizontalAlignment(SwingConstants.CENTER);
		txtSideDish.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtSideDish.setColumns(10);
		txtSideDish.setBounds(270, 97, 115, 37);
		panel_1.add(txtSideDish);
		
		txtDessert = new JTextField();
		txtDessert.setHorizontalAlignment(SwingConstants.CENTER);
		txtDessert.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtDessert.setColumns(10);
		txtDessert.setBounds(270, 145, 115, 37);
		panel_1.add(txtDessert);
		
		final JLabel txtPriceMain = new JLabel("_");
		txtPriceMain.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtPriceMain.setBounds(432, 60, 98, 26);
		panel_1.add(txtPriceMain);
		
		final JLabel txtPriceSideDish = new JLabel("_");
		txtPriceSideDish.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtPriceSideDish.setBounds(432, 98, 98, 26);
		panel_1.add(txtPriceSideDish);
		
		final JLabel txtPriceDessert = new JLabel("_");
		txtPriceDessert.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtPriceDessert.setBounds(432, 146, 98, 26);
		panel_1.add(txtPriceDessert);
		
		final JComboBox drinkCombo = new JComboBox();
		drinkCombo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		drinkCombo.setModel(new DefaultComboBoxModel(new String[] {"Choose a drink", "Coca Cola", "Fanta", "Heneikan"}));
		drinkCombo.setBounds(24, 191, 234, 37);
		panel_1.add(drinkCombo);
		
		txtDrink = new JTextField();
		txtDrink.setHorizontalAlignment(SwingConstants.CENTER);
		txtDrink.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtDrink.setColumns(10);
		txtDrink.setBounds(270, 193, 115, 37);
		panel_1.add(txtDrink);
		
		final JLabel txtPriceDrink = new JLabel("_");
		txtPriceDrink.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtPriceDrink.setBounds(432, 204, 98, 26);
		panel_1.add(txtPriceDrink);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(540, 11, 1, 283);
		panel_1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(516, 296, 1, -287);
		panel_1.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(160, 160, 160));
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(509, 286, 13, -260);
		panel_1.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(540, 23, 13, 283);
		panel_1.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 239, 500, 1);
		panel_1.add(separator_6);
		
		final JComboBox tableCombo = new JComboBox();
		tableCombo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableCombo.setModel(new DefaultComboBoxModel(new String[] {"Table", "L1", "L2", "R1", "R2"}));
		tableCombo.setBounds(24, 251, 236, 20);
		panel_1.add(tableCombo);
		
		final JCheckBox delCheck = new JCheckBox("Delivery");
		delCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delCheck.setBounds(19, 283, 97, 23);
		panel_1.add(delCheck);
		
		final JCheckBox taxCheck = new JCheckBox("Tax");
		taxCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taxCheck.setBounds(163, 283, 97, 23);
		panel_1.add(taxCheck);
		

		

		JLabel lblCurrencyConverter = new JLabel("********* Currency Converter*********");
		lblCurrencyConverter.setForeground(new Color(153, 51, 0));
		lblCurrencyConverter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblCurrencyConverter.setBounds(540, 11, 456, 42);
		panel_1.add(lblCurrencyConverter);
		
		final JComboBox comboCurrency = new JComboBox();
		comboCurrency.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboCurrency.setModel(new DefaultComboBoxModel(new String[] {"Choose Currencies", "Euro", "Pound Sterling", "Dollar (US)", "INR"}));
		comboCurrency.setBounds(647, 59, 191, 27);
		panel_1.add(comboCurrency);
		
		txtCurrency = new JTextField();
		txtCurrency.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurrency.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtCurrency.setColumns(10);
		txtCurrency.setBounds(647, 107, 191, 37);
		panel_1.add(txtCurrency);
		
		final JLabel txtCurrencyOutput = new JLabel("");
		txtCurrencyOutput.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurrencyOutput.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtCurrencyOutput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtCurrencyOutput.setBounds(647, 180, 191, 37);
		panel_1.add(txtCurrencyOutput);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double mur = Double.parseDouble(txtCurrency.getText());
				double amount_currency_in_mur = Double.parseDouble(txtCurrency.getText());
				double converted_currency = 0.0;
				
				if(comboCurrency.getSelectedItem().equals("Euro"))
				{
						converted_currency = mur / euro;
						txtCurrencyOutput.setText(String.format("€ %.2f", converted_currency));
						
				}
				
				if(comboCurrency.getSelectedItem().equals("Dollar (US)"))
				{
						converted_currency = mur / dollar;
						txtCurrencyOutput.setText(String.format("$ %.2f", converted_currency));
						
				}
				
				if(comboCurrency.getSelectedItem().equals("Pound Sterling"))
				{
						converted_currency = mur / pound_sterling;
						txtCurrencyOutput.setText(String.format("£ %.2f", converted_currency));
						
				}
				if(comboCurrency.getSelectedItem().equals("INR"))
				{
						converted_currency = mur * inr;
						txtCurrencyOutput.setText(String.format("₹ %.2f", converted_currency));
						
				}
				
			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConvert.setBounds(647, 269, 115, 37);
		panel_1.add(btnConvert);
		
		JButton btnReset2 = new JButton("Reset");
		btnReset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboCurrency.setSelectedItem("Choose Currencies");
				txtCurrency.setText(null);
				txtCurrencyOutput.setText(null);
			}
		});
		btnReset2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset2.setBounds(768, 269, 115, 37);
		panel_1.add(btnReset2);
		
		JPanel txtTotalMeal = new JPanel();
		txtTotalMeal.setBounds(499, 522, 1025, 211);
		frame.getContentPane().add(txtTotalMeal);
		txtTotalMeal.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		txtTotalMeal.setLayout(null);
		
		JLabel totalMeal = new JLabel("Total cost of Meal");
		totalMeal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		totalMeal.setBounds(23, 30, 179, 32);
		txtTotalMeal.add(totalMeal);
		
		JLabel totalDrink = new JLabel("Total cost of Drink");
		totalDrink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		totalDrink.setBounds(23, 74, 179, 32);
		txtTotalMeal.add(totalDrink);
		
		JLabel totalDel = new JLabel("Cost Of Delivery");
		totalDel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		totalDel.setBounds(23, 119, 179, 32);
		txtTotalMeal.add(totalDel);
		
		final JLabel txtMeal = new JLabel("");
		txtMeal.setHorizontalAlignment(SwingConstants.CENTER);
		txtMeal.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtMeal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtMeal.setBounds(223, 30, 245, 37);
		txtTotalMeal.add(txtMeal);
		
		final JLabel txtTotalDrink = new JLabel("");
		txtTotalDrink.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDrink.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTotalDrink.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtTotalDrink.setBounds(223, 74, 245, 37);
		txtTotalMeal.add(txtTotalDrink);
		
		final JLabel txtTotalDel = new JLabel("");
		txtTotalDel.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDel.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTotalDel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtTotalDel.setBounds(223, 119, 245, 37);
		txtTotalMeal.add(txtTotalDel);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(533, 11, 13, 189);
		txtTotalMeal.add(separator_7);
		
		JLabel tax = new JLabel("Tax");
		tax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tax.setBounds(551, 30, 64, 32);
		txtTotalMeal.add(tax);
		
		JLabel subTotal = new JLabel("Sub Total");
		subTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subTotal.setBounds(546, 74, 103, 32);
		txtTotalMeal.add(subTotal);
		
		JLabel total = new JLabel("Total");
		total.setForeground(new Color(30, 144, 255));
		total.setFont(new Font("Tahoma", Font.BOLD, 20));
		total.setBounds(556, 119, 92, 32);
		txtTotalMeal.add(total);
		
		final JLabel txtTax = new JLabel("");
		txtTax.setHorizontalAlignment(SwingConstants.CENTER);
		txtTax.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTax.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtTax.setBounds(654, 30, 245, 37);
		txtTotalMeal.add(txtTax);
		
		final JLabel txtSubTotal = new JLabel("");
		txtSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtSubTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtSubTotal.setBounds(654, 74, 245, 37);
		txtTotalMeal.add(txtSubTotal);
		
		final JLabel txtTotal = new JLabel("");
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtTotal.setBounds(654, 114, 245, 37);
		txtTotalMeal.add(txtTotal);
		
		JLabel lblClock1 = new JLabel("Time");
		lblClock1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClock1.setBackground(Color.CYAN);
		lblClock1.setBounds(654, 162, 245, 26);
		lblClock1.setVisible(true);
		txtTotalMeal.add(lblClock1);
		
		JLabel lblNewLabel = new JLabel("Restaurant Management System");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel.setBounds(503, 49, 971, 126);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1474, 38);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Receipt");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				Plain Rice
//				Fried Rice
//				Fried Noodle
				
				Double Invoice1 = Double.parseDouble(txtPriceMain.getText());
				Double Invoice2 = Double.parseDouble(txtPriceDrink.getText());
				Double Invoice3 = Double.parseDouble(txtPriceDessert.getText());
				String selectedDish = (String)mainDishCombo.getSelectedItem();
				String qty_meal = txtMainDish.getText();
				String qty_drink = txtDrink.getText();
				String qty_dessert = txtDessert.getText();
		
				
				receiptArea.append(
						"\t\n*************** Restaurant Management System: ***************************\n"
						+ "\n " + mainDishCombo.getSelectedItem() + " * " + qty_meal +    " :\t\t" + Invoice1
						+ "\n " + drinkCombo.getSelectedItem() +    " * " + qty_drink +   " :\t\t" + Invoice1
						+ "\n " + dessertCombo.getSelectedItem() +  " * " + qty_dessert + " :\t\t" + Invoice3	
						+ "\nTotal : \t\t "                      +         txtTotal.getText()
						+ "\n\nWelcome and Thanks you for your patronage"
						
						
						);
				
				
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMainDish.setText(null);
				txtSideDish.setText(null);
				txtDessert.setText(null);
				txtDrink.setText(null);
				txtPriceMain.setText(null);
				txtPriceSideDish.setText(null);
				txtPriceDessert.setText(null);
				txtPriceDrink.setText(null);
				txtMeal.setText(null);
				txtTotalDrink.setText(null);
				txtTotalDel.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				comboCurrency.setSelectedItem("Choose Currency");
				txtCurrency.setText(null);
				txtCurrencyOutput.setText(null);
				receiptArea.setText(null);
				delCheck.setSelected(false);
				taxCheck.setSelected(false);
				mainDishCombo.setSelectedItem("Main Dish");
				sideDishCombo.setSelectedItem("Side Dish");
				dessertCombo.setSelectedItem("Desserts");
				drinkCombo.setSelectedItem("Choose a drink");
				tableCombo.setSelectedItem("Table");
				receiptArea.setText(null);
			}
		});
		mntmReset.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu_1.add(mntmReset);
		
		JMenuItem mntmConvert = new JMenuItem("Convert");
		mntmConvert.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu.add(mntmConvert);
		
		JMenuItem mntmTotal = new JMenuItem("Total");
		mntmTotal.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu.add(mntmTotal);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mntmRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMainDish.setText(null);
				txtSideDish.setText(null);
				txtDessert.setText(null);
				txtDrink.setText(null);
				txtPriceMain.setText(null);
				txtPriceSideDish.setText(null);
				txtPriceDessert.setText(null);
				txtPriceDrink.setText(null);
				txtMeal.setText(null);
				txtTotalDrink.setText(null);
				txtTotalDel.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				comboCurrency.setSelectedItem("Choose Currency");
				txtCurrency.setText(null);
				txtCurrencyOutput.setText(null);
				receiptArea.setText(null);
				delCheck.setSelected(false);
				taxCheck.setSelected(false);
				mainDishCombo.setSelectedItem("Main Dish");
				sideDishCombo.setSelectedItem("Side Dish");
				dessertCombo.setSelectedItem("Desserts");
				drinkCombo.setSelectedItem("Choose a drink");
				tableCombo.setSelectedItem("Table");
				receiptArea.setText(null);
			}
		});
		mntmRefresh.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu.add(mntmRefresh);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					System.exit(0);
				
			}
			
		});
		mntmExit.setForeground(new Color(255, 0, 0));
		mntmExit.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu.add(mntmExit);
		
		JMenu mnNewMenu_2 = new JMenu("Convert");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnTotal = new JMenu("Total");
		mnTotal.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnTotal);
		
		JMenu mnReset = new JMenu("Reset");
		mnReset.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnReset);
		
		JMenu mnReceipt = new JMenu("Receipt");
		mnReceipt.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnReceipt);
		
		JMenu mnExit = new JMenu("Exit");
		mnExit.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnExit);
		
		
		
		//==================== Submit Button ============================
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				
				//====================Drinks=========================
				 double drink = Double.parseDouble(txtDrink.getText());
				 double cocaCola = 50*drink;
				 double fanta = 50*drink;
				 double heineken = 90*drink;
				 double totalDrink = 0;
				 
				 String selectedDrink = (String) drinkCombo.getSelectedItem();
				 
				 switch(selectedDrink)
				 {
				 	case "Coca Cola":
				 		String pCoca_cola = String.format("%.2f",cocaCola);
				 		txtPriceDrink.setText(pCoca_cola);
				 		txtTotalDrink.setText(pCoca_cola);
				 		totalDrink = cocaCola;
				 		break;
				 	case "Fanta":
				 		String pFanta = String.format("%.2f",fanta);
				 		txtPriceDrink.setText(pFanta);
				 		txtTotalDrink.setText(pFanta);
				 		totalDrink = fanta;
				 		break;
				 	case "Heneikan":
				 		String pHeneiken = String.format("%.2f",heineken);
				 		txtPriceDrink.setText(pHeneiken);
				 		txtTotalDrink.setText(pHeneiken);
				 		totalDrink = heineken;
				 		break;
				 	
				 }
				 
					//====================SideDish=========================
				 double sideDish = Double.parseDouble(txtSideDish.getText());
				 double chicken = 90*sideDish;
				 double beef = 50*sideDish;
				 double fish = 190*sideDish;
				 double chips = 90*sideDish;
				 double sideDishTotal=0;
				 
				 String selectedSideDish = (String)sideDishCombo.getSelectedItem();
				 
				 switch(selectedSideDish)
				 {
				 	case "ChickenChopSuey":
				 		String pCChicken = String.format("%.2f",sideDishTotal);
				 		txtPriceSideDish.setText(pCChicken);
				 		sideDishTotal = chicken;
				 		break;
				 	case "Beef Thai":
				 		String pBeef = String.format("%.2f",beef);
				 		txtPriceSideDish.setText(pBeef);
				 		sideDishTotal = beef;
				 		break;
				 	case "Fish":
				 		String pFish = String.format("%.2f",fish);
				 		txtPriceSideDish.setText(pFish);
				 		sideDishTotal = fish;
				 		break;
				 		
				 	case "Chips":
				 		String pChips = String.format("%.2f",chips);
				 		txtPriceSideDish.setText(pChips);
				 		sideDishTotal = chips;
				 		break;
				 	
				 }
				 
				 
				//====================Main Dish=========================
				 double mainDishQty = Double.parseDouble(txtMainDish.getText());
				 double plainRice = 90 * mainDishQty;
				 double friedRice = 150*mainDishQty;
				 double friedNoodle = 150*mainDishQty;
				 double totalMeal=0;
				 
				 String selectedMainDish = (String) mainDishCombo.getSelectedItem();
				 
				 switch(selectedMainDish)
				 {
				 	case "Plain Rice":
				 		String pPRice = String.format("%.2f",plainRice);
				 		txtPriceMain.setText(pPRice);
				 		totalMeal = plainRice;
				 		break;
				 	case "Fried Rice":
				 		String pFRice = String.format("%.2f",friedRice);
				 		txtPriceMain.setText(pFRice);
				 		totalMeal = friedRice;
				 		break;
				 	case "Fried Noodle":
				 		String pFNoodle = String.format("%.2f",friedRice);
				 		txtPriceMain.setText(pFNoodle);
				 		totalMeal = friedNoodle;
				 		break;
				 	
				 }
				 
					//====================Desserts=========================
				 double dessertQty = Double.parseDouble(txtDessert.getText());
				 double applePie = 50*dessertQty;
				 double coconutJelly = 50*dessertQty;
				 double totalDessert=0;
				 
				 
				 String selectedDessert = (String) dessertCombo.getSelectedItem();
				 
				 switch(selectedDessert)
				 {
				 	case "Apple Pie":
				 		String pApie = String.format("%.2f",applePie);
				 		txtPriceDessert.setText(pApie);
				 		totalDessert = applePie;
				 		break;
				 	case "Coconut Jelly":
				 		String pCoconutJel = String.format("%.2f",coconutJelly);
				 		txtPriceDessert.setText(pCoconutJel);
				 		totalDessert = coconutJelly;
				 		break;
				 	
				 }
				 
				 
				 double grandTotalMeal = sideDishTotal + totalMeal + totalDessert;
				 
				 txtMeal.setText(String.format("%.3f", grandTotalMeal)); 
				 
				 
				 //============================== Delivery Cost=============================
				 double deliverycost =0;
				 
				 if(delCheck.isSelected())
				 {
					 deliverycost = 50;
					 txtTotalDel.setText(String.format("%.2f", deliverycost));
				 }else
				 {
					 txtTotalDel.setText("0.00");
				 }
				 
				 //======================== Tax ================================
				 
				 double tva = 0.15;
				 double subTotalBeforeTax = totalMeal + totalDessert + sideDishTotal;
				 double totalTva = subTotalBeforeTax/3 * tva;
				 double netTotal = 0;
				 
				 if(taxCheck.isSelected())
				 {
					 String totalTax = String.format("%.1f",totalTva);
					 txtTax.setText(totalTax + " %");
					 double subTotalWithTax = (subTotalBeforeTax * tva) + subTotalBeforeTax;
					 String subTotal = String.format("%.2f",subTotalWithTax);
					 txtSubTotal.setText("Rs. " + subTotal);
					 netTotal = subTotalWithTax + totalDrink + deliverycost;
					 
				 }else
				 {
					 txtTax.setText(String.format("0.00"));
					 String subTotal = String.format("%.2f",subTotalBeforeTax);
					 txtSubTotal.setText("Rs. " + subTotal);
					 netTotal = subTotalBeforeTax + totalDrink + deliverycost;
					 
				 }
					 
				
				 String totalPrice = String.format("%.2f",netTotal);
				 txtTotal.setText("Rs. " + totalPrice);
				 
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBounds(270, 269, 115, 37);
		panel_1.add(btnSubmit);
		
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMainDish.setText(null);
				txtSideDish.setText(null);
				txtDessert.setText(null);
				txtDrink.setText(null);
				txtPriceMain.setText(null);
				txtPriceSideDish.setText(null);
				txtPriceDessert.setText(null);
				txtPriceDrink.setText(null);
				txtMeal.setText(null);
				txtTotalDrink.setText(null);
				txtTotalDel.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				comboCurrency.setSelectedItem("Choose Currencies");
				txtCurrency.setText(null);
				txtCurrencyOutput.setText(null);
				receiptArea.setText(null);
				delCheck.setSelected(false);
				taxCheck.setSelected(false);
				mainDishCombo.setSelectedItem("Main Dish");
				sideDishCombo.setSelectedItem("Side Dish");
				dessertCombo.setSelectedItem("Desserts");
				drinkCombo.setSelectedItem("Choose a drink");
				tableCombo.setSelectedItem("Table");
				receiptArea.setText(null);
				
				
				
				
				
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(391, 269, 115, 37);
		panel_1.add(btnReset);
		
		
		
		
		
		
		
	}
}
