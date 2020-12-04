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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		theMachine.cancel(false);
	}

	@Override
	public void onDoTransactionRaised() {
		this.theMachine.doTransaction();
	}
	@Override
	public void onCoffeeChosedRaised() {
		theMachine.chooseDrink(Drink.COFFEE);
		theMachine.setMoneyGoal(35);
		theMachine.setOptionButtons(0, 1, 2);
	}
	@Override
	public void onTeaChosedRaised() {
		theMachine.chooseDrink(Drink.TEA);
		theMachine.setMoneyGoal(40);
		theMachine.setOptionButtons(0, -1, -1);
	}
	@Override
	public void onExpressoChosedRaised() {
		theMachine.chooseDrink(Drink.EXPRESSO);
		theMachine.setMoneyGoal(50);
		theMachine.setOptionButtons(0, 1, 2);
		
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
	public void onAddSugarRaised() {
		 //
	}
	
	@Override
	public void onSeedPackingRaised() {
		theMachine.packSeed();
	}
	@Override
	public void onCupPlacingRaised() {
		 theMachine.placeCup();
	}
	@Override
	public void onBagPlacingRaised() {
		 theMachine.bagPlacement();
		
	}
	@Override
	public void onSeedGrindingRaised() {
		 theMachine.seedGrind();
		
	}
	@Override
	public void onPodPlacingRaised() {
		 theMachine.podPlacement();
	}
	@Override
	public void onWaitForWaterPouredRaised() {
		 theMachine.startToPour();
	}
	@Override
	public void onWaitForWaterHeatedRaised() {
		 //nothing
	}
	@Override
	public void onVanillaChosedRaised() {
		 theMachine.addOption(Option.VANILLA, 60);
	}

	@Override
	public void onCrustChosedRaised() {
		theMachine.addOption(Option.CRUST, 30);
		
	}
	@Override
	public void onBeginWaterHeatRaised() {
		 theMachine.beginWaterHeat();
		
	}
	@Override
	public void onMilkChosedRaised() {
		theMachine.addOption(Option.MILK, 10);
	}
	@Override
	public void onDisableMissingIngredientsRaised() {
		 theMachine.checkIngredient();
	}
	@Override
	public void onBeginMachineCleaningRaised() {
		 theMachine.cleanMachine();
	}
	@Override
	public void onEndThirdStepRaised() {
		 theMachine.teaOrVanillaOrElse();
	}
	@Override
	public void onBeginFirstStepRaised() {
		 theMachine.firstStepDifference();
	}
	@Override
	public void onBeginSecondStepRaised() {
		 theMachine.secondStepDifference();
	}
	@Override
	public void onPourMilkRaised() {
		 theMachine.pourMilk();
	}
	@Override
	public void onCheckMilkOptionRaised() {
		 theMachine.milkOrNot();
	}
	@Override
	public void onSyrupChosedRaised() {
		theMachine.addOption(Option.MAPPLE_SYRUP, 10);
	}
	@Override
	public void onAutomaticCancelRaised() {
		theMachine.cancel(true);
		
	}
	@Override
	public void onSugarOrSyrupRaised() {
		theMachine.sugarOrSyrup();
	}
	@Override
	public void onPourAndMixVanillaRaised() {
		theMachine.pourAndMixVanilla();
	}
	@Override
	public void onIcedTeaChosedRaised() {
		theMachine.chooseDrink(Drink.ICED_TEA);
		theMachine.setMoneyGoal(50);
		theMachine.setOptionButtons(-1, -1, -1);
		
	}
	@Override
	public void onLockDoorRaised() {
		theMachine.lockDoor();
		
	}
	@Override
	public void onCoolRaised() {
		theMachine.cool();
		
	}
	@Override
	public void onStartUnlockingDoorsRaised() {
		theMachine.unlockDoor();
		
	}
}

enum Drink{
	NONE,
	COFFEE,
	TEA,
	EXPRESSO,
	SOUP,
	ICED_TEA
}

enum Option{
	MAPPLE_SYRUP(2), CRUST(3), MILK(0), VANILLA(1);
	private final int value;
	private Option(int value) {
		this.value=value;
	}
	public int getValue() {
		return value;
	}
}

enum Size{
	SHORT(1),NORMAL(2),LONG(3);
	private final int value;
	private Size(int value) {
		this.value=value;
	}
	public int getValue() {
		return value;
	}
}
enum Temperature{
	AMBIENT(20),GENTLE(35),HOT(60),VERY_HOT(85);
	private final int value;
	private Temperature(int value) {
		this.value=value;
	}
	public int getValue() {
		return value;
	}
}

enum IcedTemperature{
	AMBIENT(0),GENTLE(5),HOT(8),VERY_HOT(12);
	private final int value;
	private IcedTemperature(int value) {
		this.value=value;
	}
	public int getValue() {
		return value;
	}
}


public class DrinkFactoryMachine extends JFrame {
	private HashMap<String, Integer> leftOver = new HashMap<String, Integer>();
	private Timer globalTimer1;
	private Timer globalTimer2;
	private Timer globalTimer3;
	private Timer globalTimer4;
	private Drink drinkSelected = Drink.NONE;
	private ArrayList<Option> optionsSelected = new ArrayList<Option>();
	private JLabel messagesToUser;
	private String welcomeMessage = "<html>Welcome<br>chose your drink <br>or insert money";
	private int moneyInserted = 0;
	private int moneyToReach = 0;
	private ArrayList<ActionListener> actionsForOptionButton = new ArrayList<ActionListener>();
	private ArrayList<JButton> optionButtons = new ArrayList<JButton>();
	private ArrayList<JButton> drinkButtons = new ArrayList<JButton>();
	private Option[] optionNames = {Option.MILK,Option.VANILLA,Option.MAPPLE_SYRUP, Option.CRUST};
	private Drink[] drinkNames = {Drink.COFFEE, Drink.EXPRESSO, Drink.TEA, Drink.SOUP, Drink.ICED_TEA};
	private Boolean NFCPayment = false;
	private JTextField cardLabel;
	private HashMap<String, ArrayList<Integer>> NFCsHistory;
	private Boolean freeOrder=false;
	private Size size = null;
	private Temperature temperature = null;
	private IcedTemperature icedTemperature = null;
	private int sugarDose;
	private JSlider sizeSlider;
	private JSlider temperatureSlider;
	private JSlider sugarSlider;
	private JLabel labelForPictures;
	private JButton takeFullCupButton;
	private JButton addCupButton;
	private JSlider lowTemperatureSlider;
	  
	 
	private static final long serialVersionUID = 2030629304432075314L;
	private JPanel contentPane;
	private MVPStatemachine theFSM;
	private final ImageIcon imageIcon = new ImageIcon();


	 
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

	
	 




	public DrinkFactoryMachine() {
		theFSM = new MVPStatemachine();
		TimerService timer = new TimerService();
		theFSM.setTimer(timer);		
		
		setForeground(Color.WHITE);
		setFont(new Font("Cantarell", Font.BOLD, 22));
		setBackground(Color.DARK_GRAY);
		setTitle("Drinking Factory Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		NFCsHistory = new HashMap<String, ArrayList<Integer>>();
		//for testing purpose
		ArrayList<Integer> customerPaymentTest = new ArrayList<Integer>(Arrays.asList(120,30,40,50, 70, 60, 120, 110, 60, 50));
		NFCsHistory.put("0000", customerPaymentTest);
		
		messagesToUser = new JLabel(welcomeMessage);
		messagesToUser.setForeground(Color.WHITE);
		messagesToUser.setHorizontalAlignment(SwingConstants.LEFT);
		messagesToUser.setVerticalAlignment(SwingConstants.TOP);
		messagesToUser.setToolTipText("message to the user");
		messagesToUser.setBackground(Color.WHITE);
		messagesToUser.setBounds(126, 34, 165, 75);
		contentPane.add(messagesToUser);
		leftOver.put("COFFEE", 1);
		leftOver.put("TEA", 2);
		leftOver.put("SOUP", 2);
		leftOver.put("EXPRESSO", 2);
		leftOver.put("ICED_TEA", 2);
		leftOver.put("CRUST", 2);
		leftOver.put("VANILLA", 2);
		leftOver.put("MAPPLE_SYRUP", 2);
		leftOver.put("MILK", 2);
		
		
		
		ActionListener milkOption = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseMilkButton();
			}
		};
		actionsForOptionButton.add(milkOption);
		
		ActionListener vanillaOption = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseVanillaButton();
			}
		};
		actionsForOptionButton.add(vanillaOption);
		
		ActionListener mappleSyrupOption = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseSyrupButton();
			}
		};
		actionsForOptionButton.add(mappleSyrupOption);
		
		ActionListener crustOption = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseCrustButton();
			}
		};
		actionsForOptionButton.add(crustOption);
		
		
		
		ActionListener idle = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};
		actionsForOptionButton.add(idle);
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(Color.DARK_GRAY);
		panel_0.setBounds(140, 110, 96, 100);
		contentPane.add(panel_0);
		
		JButton option1Button = new JButton("Option 1");
		option1Button.setForeground(Color.WHITE);
		option1Button.setBackground(Color.BLACK);
		option1Button.setEnabled(false);
		option1Button.setBounds(140, 102, 120, 25);
		option1Button.addActionListener(idle);
		panel_0.add(option1Button);
		optionButtons.add(option1Button);
		
		JButton option2Button = new JButton("Option 2");
		option2Button.setForeground(Color.WHITE);
		option2Button.setBackground(Color.BLACK);
		option2Button.setEnabled(false);
		option2Button.setBounds(140, 145, 120, 25);
		option2Button.addActionListener(idle);
		panel_0.add(option2Button);
		optionButtons.add(option2Button);
		
		JButton option3Button = new JButton("Option 3");
		option3Button.setForeground(Color.WHITE);
		option3Button.setBackground(Color.BLACK);
		option3Button.setEnabled(false);
		option3Button.setBounds(140, 182, 120, 25);
		option3Button.addActionListener(idle);
		panel_0.add(option3Button);
		optionButtons.add(option3Button);

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

		sugarSlider = new JSlider();
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

		sizeSlider = new JSlider();
		sizeSlider.setPaintTicks(true);
		sizeSlider.setValue(1);
		sizeSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sizeSlider.setBackground(Color.DARK_GRAY);
		sizeSlider.setForeground(Color.WHITE);
		sizeSlider.setMinorTickSpacing(1);
		sizeSlider.setMaximum(2);
		sizeSlider.setMajorTickSpacing(1);
		sizeSlider.setBounds(301, 125, 200, 36);
		sizeSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (drinkSelected == Drink.ICED_TEA) {
					if (moneyToReach==50) {;
						setMoneyGoal(75);
					} else {
						setMoneyGoal(50);
					}
				}
			}
			
		});
		contentPane.add(sizeSlider);

		temperatureSlider = new JSlider();
		temperatureSlider.setPaintLabels(true);
		temperatureSlider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		temperatureSlider.setValue(2);
		temperatureSlider.setBackground(Color.DARK_GRAY);
		temperatureSlider.setForeground(Color.WHITE);
		temperatureSlider.setPaintTicks(true);
		temperatureSlider.setMajorTickSpacing(1);
		temperatureSlider.setMaximum(3);
		temperatureSlider.setBounds(301, 188, 200, 54);

		Hashtable<Integer,JLabel> temperatureTable = new Hashtable<Integer,JLabel>();
		temperatureTable.put(0, new JLabel("20°C"));
		temperatureTable.put(1, new JLabel("35°C"));
		temperatureTable.put(2, new JLabel("60°C"));
		temperatureTable.put(3, new JLabel("85°C"));
		for (JLabel l  :temperatureTable.values()) {
			l.setForeground(Color.WHITE);
		}
		temperatureSlider.setLabelTable(temperatureTable);

		contentPane.add(temperatureSlider);

		JButton icedTeaButton = new JButton("Iced Tea");
		icedTeaButton.setForeground(Color.WHITE);
		icedTeaButton.setBackground(Color.DARK_GRAY);
		icedTeaButton.setBounds(12, 182, 96, 25);
		

		icedTeaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Hashtable<Integer,JLabel> temperatureTable = new Hashtable<Integer,JLabel>();
				temperatureTable.put(0, new JLabel("0°C"));
				temperatureTable.put(1, new JLabel("5°C"));
				temperatureTable.put(2, new JLabel("8°C"));
				temperatureTable.put(3, new JLabel("12°C"));
				for (JLabel l  :temperatureTable.values()) {
					l.setForeground(Color.WHITE);
				}
				temperatureSlider.setLabelTable(temperatureTable);
				sizeSlider.setMaximum(1);
				theFSM.getSCInterface().raiseIcedTeaButton();
			}
		});
		
		contentPane.add(icedTeaButton);
		
		drinkButtons = new ArrayList<JButton>(Arrays.asList(coffeeButton, expressoButton, teaButton, soupButton, icedTeaButton));

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
		panel_1.setBounds(538, 154, 96, 100);
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

		cardLabel = new JTextField("Card Number");
		cardLabel.setBounds(600, 139, 100, 40);
		panel_1.add(cardLabel);
		
		JLabel lblNfc = new JLabel("NFC");
		lblNfc.setForeground(Color.WHITE);
		lblNfc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNfc.setBounds(541, 139, 41, 15);
		contentPane.add(lblNfc);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 292, 622, 15);
		contentPane.add(separator);

		addCupButton = new JButton("Add cup");
		addCupButton.setForeground(Color.WHITE);
		addCupButton.setBackground(Color.DARK_GRAY);
		addCupButton.setBounds(45, 360, 96, 25);
		addCupButton.setEnabled(false);
		addCupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(addCupButton);
		
		takeFullCupButton = new JButton("Take cup");
		takeFullCupButton.setForeground(Color.WHITE);
		takeFullCupButton.setBackground(Color.DARK_GRAY);
		takeFullCupButton.setBounds(45, 336, 96, 25);
		takeFullCupButton.setEnabled(false);
		takeFullCupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theFSM.getSCInterface().raiseCupIsTaken();
				try {
					BufferedImage myPicture = null;
					myPicture = ImageIO.read(new File("./picts/vide2.jpg"));
					labelForPictures.setIcon(new ImageIcon(myPicture));
				} catch (IOException a) {
					a.printStackTrace();
				}
			}
		});
		contentPane.add(takeFullCupButton);
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("./picts/vide2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		labelForPictures = new JLabel(new ImageIcon(myPicture));
		labelForPictures.setBounds(175, 319, 286, 260);
		contentPane.add(labelForPictures);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(538, 220, 96, 33);
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
		
		theFSM.init();
		theFSM.enter();
		theFSM.getSCInterface().getListeners().add(
				new MVPControlerInterfaceImplementation(this)
				);

	}
	
	void setMoneyGoal(int d) {
		this.moneyToReach = d;
		checkIfMoneyGoal();
		updateMessage();
	}
	
	void insertMoney(int added) {
		//if for visual purpose only
		if (globalTimer1!=null) {
			globalTimer1.stop();
			globalTimer1 = null;
		}
		if (!NFCPayment) {
			this.moneyInserted += added;
			updateMessage();
			checkIfMoneyGoal();
		} else {
			this.messagesToUser.setText("<html>NFC payement only<br>Cancel your order to use coins");
		}
	}
	
	void nfc() {
		if (!NFCPayment) {
			if (this.moneyInserted==0) {
				moneyInserted=200;
				NFCPayment = true;
				checkIfFreeForNFC();
			} else {
				this.messagesToUser.setText("<html>You cannot use<br>NFC payment<br>you already inserted coins.");
			}
		}
	}
	
	void checkIfFreeForNFC() {
		String number = cardLabel.getText();
		if (number.length()!=4) {
			this.messagesToUser.setText("<html>Unknown card number<br>No loyalty program applied");
		} else {
			if (NFCsHistory.containsKey(number)) {
				int sum=0;
				if (NFCsHistory.get(number).size() == 10) {
					for (int price:NFCsHistory.get(number)) {
						sum+=price;
					}
				}
				sum/=10;
				moneyInserted=sum;
				this.messagesToUser.setText("<html>Congratulations<br>You can buy up to<br>"+sum*0.01+"€ for free" );
				freeOrder = true;
			} else {
				this.messagesToUser.setText("Card valid" );
			}
		}
	}
	
	void chooseDrink(Drink drink){
		if (drink!=Drink.ICED_TEA) {
			Hashtable<Integer,JLabel> temperatureTable = new Hashtable<Integer,JLabel>();
			temperatureTable.put(0, new JLabel("20°C"));
			temperatureTable.put(1, new JLabel("35°C"));
			temperatureTable.put(2, new JLabel("60°C"));
			temperatureTable.put(3, new JLabel("85°C"));
			for (JLabel l  :temperatureTable.values()) {
				l.setForeground(Color.WHITE);
			}
			temperatureSlider.setLabelTable(temperatureTable);
			sizeSlider.setMaximum(2);
		} else {
			sizeSlider.setValue(0);
		}
		//if for visual purpose only
		if (globalTimer1!=null) {
			globalTimer1.stop();
			globalTimer1 = null;
		}
		this.drinkSelected = drink;
		this.optionsSelected.clear();
		updateMessage();
		checkIfMoneyGoal();
		takeFullCupButton.setEnabled(false);	
	}
	
	void cancel(Boolean auto) {
		giveBackMoney(true, auto);
		NFCPayment = false;
		this.drinkSelected = Drink.NONE;
		this.optionsSelected.clear();
		unsetOptionButtons();
		freeOrder=false;
	}
	
	void giveBackMoney(Boolean canceled, Boolean autoCanceled) {
		if(this.moneyInserted>0 && !NFCPayment){
			String mb = String.valueOf(this.moneyInserted*0.01);
			if (mb.length()>4) mb = mb.substring(0,4);
			if (mb.length()<4) mb+= "0";
			this.moneyInserted = 0;
			this.moneyToReach = 0;
			this.messagesToUser.setText("Remboursement: "  + mb + "€");
		} else if (this.moneyInserted==0 && autoCanceled){
			this.moneyInserted = 0;
			this.moneyToReach = 0;
			messagesToUser.setText(welcomeMessage);
		}else {
			this.moneyInserted = 0;
			this.moneyToReach = 0;
			if (!autoCanceled) this.messagesToUser.setText("Aucun remboursement");
		}
	}

	
	void checkIfMoneyGoal() {
		if (this.moneyToReach>0 && this.moneyInserted >= this.moneyToReach) {
			theFSM.getSCInterface().raiseEnoughMoneyInserted();
		}
	}
	
	void updateMessage() {
		double mti = (this.moneyToReach - this.moneyInserted)*0.01;
		String smi = String.valueOf(this.moneyInserted*0.01);
		String smti;
		if (mti>0) {
			smti = String.valueOf(mti);
		} else {
			smti = "0.00";
		}
		if (smi.length()>4) smi = smi.substring(0,4);
		if (smti.length()>4) smti = smti.substring(0,4);
		if (smi.length()<4) smi+="0";
		if (smti.length()<4) smti += "0";
		if (drinkSelected!=Drink.NONE) {
			this.messagesToUser.setText("<html>" + drinkSelected.toString().toLowerCase() +  " selected<br>" +"Money to insert: "  + smti +"€");
		} else {
			this.messagesToUser.setText("<html>No drink selected<br>" + "Money inserted: "  + smi +"€");
		}
	}
	
		
	void simulateBankTransaction(int price) {
		//bankAccountMoney-=price;
		//machineAccount+=price;
	}
	
	void doTransaction() {
		this.moneyInserted -= this.moneyToReach;
		leftOver.replace(this.drinkSelected.toString(), leftOver.get(this.drinkSelected.toString()), leftOver.get(this.drinkSelected.toString())-1);
		unsetOptionButtons();
		takeFullCupButton.setEnabled(false);
		switch(this.sizeSlider.getValue()) {
			case 0:
				size = Size.SHORT;
				break;
			case 1:
				size = Size.NORMAL;
				break;
			case 2:
				size = Size.LONG;
				break;
		}
		switch(this.temperatureSlider.getValue()) {
			case 0:
				temperature = Temperature.AMBIENT;
				icedTemperature = IcedTemperature.AMBIENT;
				break;
			case 1:
				temperature = Temperature.GENTLE;
				icedTemperature = IcedTemperature.GENTLE;
				break;
			case 2:
				temperature = Temperature.HOT;
				icedTemperature = IcedTemperature.HOT;
				break;
			case 3:
				temperature = Temperature.VERY_HOT;
				icedTemperature = IcedTemperature.VERY_HOT;
				break;
			default:
				temperature = Temperature.GENTLE;
				icedTemperature = IcedTemperature.GENTLE;
		}
	
		sugarDose= this.sugarSlider.getValue();
		if (freeOrder) {
			String number = cardLabel.getText();
			if (number.length()!=4) {
				this.messagesToUser.setText("<html>Unknown card number<br>No loyalty program applied");
			} else if (!freeOrder){
				if (NFCsHistory.containsKey(number)) {
					NFCsHistory.get(number).add(moneyToReach);
				} else {
					NFCsHistory.put(number, new ArrayList<Integer>(Arrays.asList(moneyToReach)));
				}
			} else {
				NFCsHistory.remove(number);
			}
		}
		if (NFCPayment) {
			this.messagesToUser.setText("Transaction avec la banque ...");
			simulateBankTransaction(this.moneyToReach);
		} else {
			giveBackMoney(false, false);
		}
	}
	
	void addOption(Option option, int price) {
		if (!this.optionsSelected.contains(option)) {
			this.optionsSelected.add(option);
			this.moneyToReach+=price;
		}
		this.optionButtons.get(option.getValue()).setBackground(Color.GREEN);
		updateMessage();
	}
	
	void unsetOptionButtons() {
		for (int i=0; i<optionButtons.size(); i++) {
			for (ActionListener action : actionsForOptionButton) {
				optionButtons.get(i).removeActionListener(action);
			}
			optionButtons.get(i).setText("Option "  + (i+1));
			optionButtons.get(i).addActionListener(actionsForOptionButton.get(optionButtons.size()-1));
			optionButtons.get(i).setBackground(Color.BLACK);
			optionButtons.get(i).setEnabled(false);
		}
	}
	
	void setOptionButtons(int option1, int option2, int option3) {
		int[] options = {option1, option2, option3};
		unsetOptionButtons();
		for(int i=0; i<3; i++) {
			if (options[i]!=-1) {
				optionButtons.get(i).setEnabled(true);
				optionButtons.get(i).removeActionListener(actionsForOptionButton.get(optionButtons.size()-1));
				optionButtons.get(i).addActionListener(actionsForOptionButton.get(options[i]));
				optionButtons.get(i).setBackground(Color.DARK_GRAY);
				optionButtons.get(i).setText(optionNames[i].toString());			
			}
		}
	}
	
	void beginWaterHeat() {
		//if iced tea, temperature wasn't defined
		if (temperature == null) temperature=Temperature.VERY_HOT;
		ActionListener waitWaterHeat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					theFSM.getSCInterface().raiseWaterHeated();
					//globalTimer1.stop();
					globalTimer1 = null;
			}
		};
		globalTimer1 = new Timer((int) ((temperature.getValue()*400)+2000),waitWaterHeat);
		globalTimer1.start();
		
	}
	
	
	void firstStepDifference() {
		switch(drinkSelected) {
			case COFFEE:
				theFSM.getSCInterface().raisePodPlacement();
				//this.messagesToUser.setText("Positionnement de la dosette");
				break;
			case EXPRESSO:
				theFSM.getSCInterface().raiseSeedGrind();
				//this.messagesToUser.setText("Broyage des grains");
				break;
			case ICED_TEA:
			case TEA:
				theFSM.getSCInterface().raiseBagPlacement();
				//this.messagesToUser.setText("Positionnement du sachet de thé");
				break;
		default:
			break;
		}
	}
	
	void secondStepDifference() {
		switch(drinkSelected) {
			case EXPRESSO:
				theFSM.getSCInterface().raiseStep2Expresso();
				break;
			default:
				theFSM.getSCInterface().raiseWaitingForWater();
				break;
		}
	}
	
	void placeCup() {
		this.messagesToUser.setText("<html>En attente du <br>chauffage de l'eau");
		try {
			BufferedImage myPicture = null;
			myPicture = ImageIO.read(new File("./picts/gobeletPolluant.jpg"));
			labelForPictures.setIcon(new ImageIcon(myPicture));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void seedGrind() {
		ActionListener wait4000ms = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				globalTimer2.stop();
				globalTimer2 = null;
				theFSM.getSCInterface().raiseStep1ElementPlaced();
			}
		};
		globalTimer2 = new Timer(4000,wait4000ms);
		globalTimer2.start();
	}
	
	void podPlacement() {
		ActionListener wait2000ms = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				globalTimer2.stop();
				globalTimer2 = null;
				theFSM.getSCInterface().raiseStep1ElementPlaced();
			}
		};
		globalTimer2 = new Timer(2000,wait2000ms);
		globalTimer2.start();
	}
	
	void bagPlacement() {
		ActionListener wait2000ms = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				globalTimer2.stop();
				globalTimer2 = null;
				theFSM.getSCInterface().raiseStep1ElementPlaced();
			}
		};
		globalTimer2 = new Timer(2000,wait2000ms);
		globalTimer2.start();
	}
	
	void packSeed() {
		ActionListener wait = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				globalTimer3.stop();
				globalTimer3 = null;
				theFSM.getSCInterface().raiseEndPackSeed();
			}
		};
		globalTimer3 = new Timer(size.getValue()*2000,wait);
		globalTimer3.start();
	}
	
	void startToPour() {
		this.messagesToUser.setText("<html>En attente du <br>versement de la boisson");
		ActionListener wait = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//globalTimer1.stop();
				globalTimer1 = null;
				theFSM.getSCInterface().raiseWaterPoured();
			}
		};
		globalTimer1 = new Timer(size.getValue()*4000+2000,wait);
		globalTimer1.start();
	}
	
	public void sugarOrSyrup() {
		if (optionsSelected.contains(Option.MAPPLE_SYRUP)) {
			theFSM.getSCInterface().raiseSyrup();
		} else {
			theFSM.getSCInterface().raiseSugar();
		}
		ActionListener wait = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				globalTimer2.stop();
				globalTimer2 = null;
				theFSM.getSCInterface().raiseSugarAdded();
				theFSM.getSCInterface().raiseSyrupAdded();
			}
		};
		globalTimer2 = new Timer(sugarDose*500,wait);
		globalTimer2.start();
	}
	
	public void milkOrNot() {
		if (optionsSelected.contains(Option.MILK)) {
			theFSM.getSCInterface().raiseMilkOption();
		} else {
			theFSM.getSCInterface().raiseNoMilkOption();
		}
	}
	
	public void pourMilk() {
		ActionListener wait = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				globalTimer2.stop();
				globalTimer2 = null;
				theFSM.getSCInterface().raiseMilkAdded();
			}
		};
		globalTimer2 = new Timer(2000,wait);
		globalTimer2.start();
	}
	
	public void teaOrVanillaOrElse() {
		if (drinkSelected==Drink.TEA || drinkSelected==Drink.ICED_TEA) {
			theFSM.raiseLetInfuse();
			this.messagesToUser.setText("Infusion");
			ActionListener wait = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (globalTimer1!=null) globalTimer1.stop();
					globalTimer1 = null;
					if (drinkSelected==Drink.ICED_TEA) {
						theFSM.getSCInterface().raiseIcedTea();
					}
					else {
						theFSM.getSCInterface().raiseGiveCup();
						takeFullCupButton.setEnabled(true);
						messagesToUser.setText("Drink is ready");
					}
				}
			};
			globalTimer1 = new Timer(5000,wait);
			globalTimer1.start();
			} else if (optionsSelected.contains(Option.VANILLA)) {
			theFSM.raiseVanilla();
			} else {
				theFSM.raiseGiveCup();
				takeFullCupButton.setEnabled(true);
			}
	}		
	
	public void cleanMachine() {
		//clean machine !!!!!!
		this.messagesToUser.setText("<html>Cleaning machine ..." );
		if (globalTimer1!=null) globalTimer1.stop();
		globalTimer1 = null;
		if (globalTimer2!=null) globalTimer2.stop();
		globalTimer2 = null;
		if (globalTimer3!=null) globalTimer3.stop();
		globalTimer3 = null;
		if (globalTimer4!=null) globalTimer4.stop();
		globalTimer4 = null;
		takeFullCupButton.setEnabled(false);
	}
	
	public void checkIngredient() {
		//disable buttons if not enough ingredient for option and/or drink
		for (int i=0; i<optionNames.length; i++) {
			if (leftOver.get(optionNames[i].toString())<=0) {
				optionButtons.get(i).setEnabled(false);
			}
		}
		for (int i=0; i<drinkNames.length; i++) {
			if (leftOver.get(drinkNames[i].toString())<=0) {
				drinkButtons.get(i).setEnabled(false);
			}
		}
		takeFullCupButton.setEnabled(false);
		this.messagesToUser.setText(welcomeMessage);
	}
	
	public void pourAndMixVanilla() {
		this.messagesToUser.setText("Pouring Vanilla and mixing");
		ActionListener wait = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				globalTimer4.stop();
				globalTimer4 = null;
				theFSM.getSCInterface().raiseGiveCup();
				takeFullCupButton.setEnabled(true);
				messagesToUser.setText("Drink is ready");
			}
		};
		//startPouring and mix
		globalTimer4 = new Timer(4000,wait);
		globalTimer4.start();
	}
	
	
	public void lockDoor() {
		messagesToUser.setText("LockingDoor ...");
		ActionListener wait = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (globalTimer3!=null)globalTimer3.stop();
				globalTimer3 = null;
				theFSM.getSCInterface().raiseCoolWithAzote();
			}
		};
		globalTimer3 = new Timer(1500,wait);
		globalTimer3.start();
	}
	
	public void cool() {
		messagesToUser.setText("Cooling drink ...");
		ActionListener wait = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (globalTimer4!=null) globalTimer4.stop();
				globalTimer4 = null;
				theFSM.getSCInterface().raiseCooledEnough();
			}
		};
		//the colder the longer ...
		globalTimer4 = new Timer(100000/(icedTemperature.getValue()*-1+15),wait);
		globalTimer4.start();
	}
	
	public void unlockDoor() {
		messagesToUser.setText("UnlockingDoor ...");
		ActionListener wait = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (globalTimer3!=null) globalTimer3.stop();
				globalTimer3 = null;
				theFSM.getSCInterface().raiseUnlockedDoor();
				theFSM.getSCInterface().raiseGiveCup();
				messagesToUser.setText("Drink is ready");
				takeFullCupButton.setEnabled(true);	
			}
		};
		globalTimer3 = new Timer(1500,wait);
		globalTimer3.start();
	}
}

