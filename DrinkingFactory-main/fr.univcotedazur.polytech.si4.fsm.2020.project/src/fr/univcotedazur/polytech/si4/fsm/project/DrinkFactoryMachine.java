package fr.univcotedazur.polytech.si4.fsm.project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import fr.univcotedazur.polytech.si4.fsm.project.mvp.IMVPStatemachine.SCInterface;
import fr.univcotedazur.polytech.si4.fsm.project.mvp.IMVPStatemachine.SCInterfaceListener;
import fr.univcotedazur.polytech.si4.fsm.project.mvp.MVPStatemachine;



class MVPControlerInterfaceImplementation implements SCInterfaceListener{
	DrinkFactoryMachine theMachine;
	public MVPControlerInterfaceImplementation(DrinkFactoryMachine tm) {
		this.theMachine = tm;
	}
	@Override
	public void onCancelRaised() {
		theMachine.cancel();
		
	}
	@Override
	public void onNotHotEnoughRaised() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onHotEnoughOutRaised() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGiveBackMoneyRaised() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGobeletIsReadyRaised() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGobeletIsTakenRaised() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDoTransactionRaised() {
		this.theMachine.doTransaction();
		this.theMachine.startDrinkPrep();
	}
	@Override
	public void onCoffeeChosedRaised() {
		theMachine.chooseDrink(Drink.COFFEE);
		theMachine.setMoneyGoal(35);
	}
	@Override
	public void onTeaChosedRaised() {
		theMachine.chooseDrink(Drink.TEA);
		theMachine.setMoneyGoal(40);
	}
	@Override
	public void onExpressoChosedRaised() {
		theMachine.chooseDrink(Drink.EXPRESSO);
		theMachine.setMoneyGoal(50);
		
	}
	@Override
	public void onCoin10InsertedRaised() {
		theMachine.insertMoney(10);
		
	}
	@Override
	public void onCoin25InsertedRaised() {
		theMachine.insertMoney(25);
		
	}
	@Override
	public void onCoin50InsertedRaised() {
		theMachine.insertMoney(50);
		
	}
	@Override
	public void onNFCPaymentRaised() {
		theMachine.nfc();
		
	}
	@Override
	public void onBagPlacedRaised() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSeedGrindedRaised() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPodPlacedRaised() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onWaterHeatedRaised() {
		// TODO Auto-generated method stub
		
	}

}

enum Drink{
	NONE,
	COFFEE,
	TEA,
	EXPRESSO
}
enum Size{
	SHORT,
	NORMAL,
	LONG
}
enum Temperature{
	AMBIENT,
	GENTLE,
	HOT,
	VERY_HOT
}


public class DrinkFactoryMachine extends JFrame {
	
	
	private Drink drinkSelected = Drink.NONE;
	private JLabel messagesToUser;
	private String welcomeMessage = "<html>Welcome<br>chose your drink <br>or insert money";
	private int moneyInserted = 0;
	private int moneyToReach = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2030629304432075314L;
	private JPanel contentPane;
	private MVPStatemachine theFSM;
	/**
	 * @wbp.nonvisual location=311,475
	 */
	private final ImageIcon imageIcon = new ImageIcon();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrinkFactoryMachine frame = new DrinkFactoryMachine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrinkFactoryMachine() {
		theFSM = new MVPStatemachine();
		TimerService timer = new TimerService();
		theFSM.setTimer(timer);
		theFSM.init();
		theFSM.enter();
		theFSM.getSCInterface().getListeners().add(
				new MVPControlerInterfaceImplementation(this)
				);
		setForeground(Color.WHITE);
		setFont(new Font("Cantarell", Font.BOLD, 22));
		setBackground(Color.DARK_GRAY);
		setTitle("Drinking Factory Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		messagesToUser = new JLabel(welcomeMessage);
		messagesToUser.setForeground(Color.WHITE);
		messagesToUser.setHorizontalAlignment(SwingConstants.LEFT);
		messagesToUser.setVerticalAlignment(SwingConstants.TOP);
		messagesToUser.setToolTipText("message to the user");
		messagesToUser.setBackground(Color.WHITE);
		messagesToUser.setBounds(126, 34, 165, 175);
		contentPane.add(messagesToUser);

		JLabel lblCoins = new JLabel("Coins");
		lblCoins.setForeground(Color.WHITE);
		lblCoins.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoins.setBounds(538, 12, 44, 15);
		contentPane.add(lblCoins);

		JButton coffeeButton = new JButton("Coffee");
		coffeeButton.setForeground(Color.WHITE);
		coffeeButton.setBackground(Color.DARK_GRAY);
		coffeeButton.setBounds(12, 34, 96, 25);
		coffeeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseCoffeeButton();
			}
		});
		contentPane.add(coffeeButton);

		JButton expressoButton = new JButton("Expresso");
		expressoButton.setForeground(Color.WHITE);
		expressoButton.setBackground(Color.DARK_GRAY);
		expressoButton.setBounds(12, 71, 96, 25);
		expressoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseExpressoButton();
			}
		});
		contentPane.add(expressoButton);

		JButton teaButton = new JButton("Tea");
		teaButton.setForeground(Color.WHITE);
		teaButton.setBackground(Color.DARK_GRAY);
		teaButton.setBounds(12, 108, 96, 25);
		teaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseTeaButton();
			}
		});
		contentPane.add(teaButton);

		JButton soupButton = new JButton("Soup");
		soupButton.setForeground(Color.WHITE);
		soupButton.setBackground(Color.DARK_GRAY);
		soupButton.setBounds(12, 145, 96, 25);
		contentPane.add(soupButton);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(10);
		progressBar.setForeground(Color.LIGHT_GRAY);
		progressBar.setBackground(Color.DARK_GRAY);
		progressBar.setBounds(12, 254, 622, 26);
		contentPane.add(progressBar);

		JSlider sugarSlider = new JSlider();
		sugarSlider.setValue(1);
		sugarSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sugarSlider.setBackground(Color.DARK_GRAY);
		sugarSlider.setForeground(Color.WHITE);
		sugarSlider.setPaintTicks(true);
		sugarSlider.setMinorTickSpacing(1);
		sugarSlider.setMajorTickSpacing(1);
		sugarSlider.setMaximum(4);
		sugarSlider.setBounds(301, 51, 200, 36);
		contentPane.add(sugarSlider);

		JSlider sizeSlider = new JSlider();
		sizeSlider.setPaintTicks(true);
		sizeSlider.setValue(1);
		sizeSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sizeSlider.setBackground(Color.DARK_GRAY);
		sizeSlider.setForeground(Color.WHITE);
		sizeSlider.setMinorTickSpacing(1);
		sizeSlider.setMaximum(2);
		sizeSlider.setMajorTickSpacing(1);
		sizeSlider.setBounds(301, 125, 200, 36);
		contentPane.add(sizeSlider);

		JSlider temperatureSlider = new JSlider();
		temperatureSlider.setPaintLabels(true);
		temperatureSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		temperatureSlider.setValue(2);
		temperatureSlider.setBackground(Color.DARK_GRAY);
		temperatureSlider.setForeground(Color.WHITE);
		temperatureSlider.setPaintTicks(true);
		temperatureSlider.setMajorTickSpacing(1);
		temperatureSlider.setMaximum(3);
		temperatureSlider.setBounds(301, 188, 200, 54);

		Hashtable<Integer, JLabel> temperatureTable = new Hashtable<Integer, JLabel>();
		temperatureTable.put(0, new JLabel("20°C"));
		temperatureTable.put(1, new JLabel("35°C"));
		temperatureTable.put(2, new JLabel("60°C"));
		temperatureTable.put(3, new JLabel("85°C"));
		for (JLabel l : temperatureTable.values()) {
			l.setForeground(Color.WHITE);
		}
		temperatureSlider.setLabelTable(temperatureTable);

		contentPane.add(temperatureSlider);

		JButton icedTeaButton = new JButton("Iced Tea");
		icedTeaButton.setForeground(Color.WHITE);
		icedTeaButton.setBackground(Color.DARK_GRAY);
		icedTeaButton.setBounds(12, 182, 96, 25);
		contentPane.add(icedTeaButton);

		JLabel lblSugar = new JLabel("Sugar");
		lblSugar.setForeground(Color.WHITE);
		lblSugar.setBackground(Color.DARK_GRAY);
		lblSugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSugar.setBounds(380, 34, 44, 15);
		contentPane.add(lblSugar);

		JLabel lblSize = new JLabel("Size");
		lblSize.setForeground(Color.WHITE);
		lblSize.setBackground(Color.DARK_GRAY);
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setBounds(380, 113, 44, 15);
		contentPane.add(lblSize);

		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setForeground(Color.WHITE);
		lblTemperature.setBackground(Color.DARK_GRAY);
		lblTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature.setBounds(363, 173, 96, 15);
		contentPane.add(lblTemperature);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		lblCoins.setLabelFor(panel);
		panel.setBounds(538, 25, 96, 97);
		contentPane.add(panel);

		JButton money50centsButton = new JButton("0.50 €");
		money50centsButton.setForeground(Color.WHITE);
		money50centsButton.setBackground(Color.DARK_GRAY);
		money50centsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseInsertCoin50();
			}
		});
		panel.add(money50centsButton);

		JButton money25centsButton = new JButton("0.25 €");
		money25centsButton.setForeground(Color.WHITE);
		money25centsButton.setBackground(Color.DARK_GRAY);
		money25centsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseInsertCoin25();
			}
		});
		panel.add(money25centsButton);

		JButton money10centsButton = new JButton("0.10 €");
		money10centsButton.setForeground(Color.WHITE);
		money10centsButton.setBackground(Color.DARK_GRAY);
		money10centsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseInsertCoin10();
			}
		});
		panel.add(money10centsButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(538, 154, 96, 40);
		contentPane.add(panel_1);

		JButton nfcBiiiipButton = new JButton("biiip");
		nfcBiiiipButton.setForeground(Color.WHITE);
		nfcBiiiipButton.setBackground(Color.DARK_GRAY);
		nfcBiiiipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseNFC();
			}
		});
		panel_1.add(nfcBiiiipButton);

		JLabel lblNfc = new JLabel("NFC");
		lblNfc.setForeground(Color.WHITE);
		lblNfc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNfc.setBounds(541, 139, 41, 15);
		contentPane.add(lblNfc);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 292, 622, 15);
		contentPane.add(separator);

		JButton addCupButton = new JButton("Add cup");
		addCupButton.setForeground(Color.WHITE);
		addCupButton.setBackground(Color.DARK_GRAY);
		addCupButton.setBounds(45, 336, 96, 25);
		contentPane.add(addCupButton);

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("./picts/vide2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel labelForPictures = new JLabel(new ImageIcon(myPicture));
		labelForPictures.setBounds(175, 319, 286, 260);
		contentPane.add(labelForPictures);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(538, 217, 96, 33);
		contentPane.add(panel_2);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.DARK_GRAY);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseCancelButton();
			}
		});
		panel_2.add(cancelButton);

		// listeners
		addCupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BufferedImage myPicture = null;
				try {
					myPicture = ImageIO.read(new File("./picts/ownCup.jpg"));
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				labelForPictures.setIcon(new ImageIcon(myPicture));
			}
		});

	}
	
	void setMoneyGoal(int d) {
		this.moneyToReach = d;
		updateMessage();
		checkIfMoneyGoal();
	}
	
	void insertMoney(int added) {
		this.moneyInserted += added;
		updateMessage();
		checkIfMoneyGoal();
	}
	
	void nfc() {
		insertMoney(50);
	}
	
	void chooseDrink(Drink drink){
		this.drinkSelected = drink;
		updateMessage();
		checkIfMoneyGoal();
	}
	
	void cancel() {
		this.messagesToUser.setText(welcomeMessage);
		this.drinkSelected = Drink.NONE;
		giveBackMoney();
	}
	
	void giveBackMoney(){
		if (this.moneyInserted > this.moneyToReach) {
		//physically give back money method here
		}
		this.moneyInserted = 0;
		this.moneyToReach = 0;
	}

	
	void checkIfMoneyGoal() {
		if (this.moneyToReach >0 && this.moneyInserted >= this.moneyToReach) {
			theFSM.getSCInterface().raiseEnoughMoneyInserted();
		}
	}
	
	void updateMessage() {
		double mti = (this.moneyToReach - this.moneyInserted)*0.01;
		String smi = String.valueOf(this.moneyInserted*0.01);
		String smti;
		if (mti > 0) {
			smti = String.valueOf(mti);
		} else {
			smti = "0.00";
		}
		if (smi.length()>4) smi = smi.substring(0,4);
		if (smti.length()>4) smti = smti.substring(0,4);
		if (smi.length()<4) smi+="0";
		if (smti.length()<4) smti += "0";
		if (drinkSelected!=Drink.NONE) {
			this.messagesToUser.setText("<html>"+drinkSelected.toString().toLowerCase() + " selected<br>" +"Money to insert: " + smti +"€");
		} else {
			this.messagesToUser.setText("<html>No drink selected<br>"+"Money inserted: " + smi +"€");
		}
	}
	
	void startDrinkPrep() {
		this.messagesToUser.setText("Drink in preparation ...");
	}
	
	void doTransaction() {
		this.moneyInserted -= this.moneyToReach;
		giveBackMoney();
	}
}

