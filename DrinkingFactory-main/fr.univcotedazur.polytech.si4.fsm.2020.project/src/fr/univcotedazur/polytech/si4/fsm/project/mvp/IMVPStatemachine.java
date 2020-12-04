/** Generated by YAKINDU Statechart Tools code generator. */
package fr.univcotedazur.polytech.si4.fsm.project.mvp;

import fr.univcotedazur.polytech.si4.fsm.project.IStatemachine;
import fr.univcotedazur.polytech.si4.fsm.project.ITimerCallback;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public interface IMVPStatemachine extends ITimerCallback,IStatemachine {
	public interface SCInterface {
	
		public void raiseOptionButton();
		
		public void raisePodPlacement();
		
		public void raiseCoffeeButton();
		
		public void raiseTeaButton();
		
		public void raiseExpressoButton();
		
		public void raiseCancelButton();
		
		public void raiseInsertCoin10();
		
		public void raiseInsertCoin25();
		
		public void raiseInsertCoin50();
		
		public void raiseNFC();
		
		public void raiseEnoughMoneyInserted();
		
		public void raiseCupPickedUp();
		
		public void raisePositionnerDosette();
		
		public void raiseSeedGrind();
		
		public void raiseBagPlacement();
		
		public void raiseWaitingForWater();
		
		public void raiseEndWaterHeat();
		
		public void raiseEndFirstStep();
		
		public void raiseEndSecondStep();
		
		public void raiseStep2Expresso();
		
		public void raiseEndPackSeed();
		
		public void raiseWaterHeated();
		
		public void raiseWaitForCup();
		
		public void raiseCupIsPlaced();
		
		public void raiseGiveCup();
		
		public void raiseCupIsTaken();
		
		public void raiseLetInfuse();
		
		public void raiseMilkButton();
		
		public void raiseSyrupButton();
		
		public void raiseCrustButton();
		
		public void raiseVanillaButton();
		
		public void raiseWaterPoured();
		
		public void raiseSugarAdded();
		
		public void raiseSyrupAdded();
		
		public void raiseStep1ElementPlaced();
		
		public void raiseNoMilkOption();
		
		public void raiseMilkOption();
		
		public void raiseMilkAdded();
		
		public void raiseSugar();
		
		public void raiseSyrup();
		
		public boolean isRaisedVanillaChosed();
		
		public boolean isRaisedSyrupChosed();
		
		public boolean isRaisedCrustChosed();
		
		public boolean isRaisedBeginWaterHeat();
		
		public boolean isRaisedMilkChosed();
		
		public boolean isRaisedDisableMissingIngredients();
		
		public boolean isRaisedBeginMachineCleaning();
		
		public boolean isRaisedAddSugar();
		
		public boolean isRaisedSeedPacking();
		
		public boolean isRaisedCupPlacing();
		
		public boolean isRaisedBagPlacing();
		
		public boolean isRaisedSeedGrinding();
		
		public boolean isRaisedPodPlacing();
		
		public boolean isRaisedWaitForWaterPoured();
		
		public boolean isRaisedWaitForWaterHeated();
		
		public boolean isRaisedCoffeeChosed();
		
		public boolean isRaisedTeaChosed();
		
		public boolean isRaisedExpressoChosed();
		
		public boolean isRaisedCoin10Inserted();
		
		public boolean isRaisedCoin25Inserted();
		
		public boolean isRaisedCoin50Inserted();
		
		public boolean isRaisedCancel();
		
		public boolean isRaisedNFCPayment();
		
		public boolean isRaisedDoTransaction();
		
		public boolean isRaisedEndThirdStep();
		
		public boolean isRaisedBeginSecondStep();
		
		public boolean isRaisedPourMilk();
		
		public boolean isRaisedCheckMilkOption();
		
		public boolean isRaisedBeginFirstStep();
		
		public boolean isRaisedAutomaticCancel();
		
		public boolean isRaisedSugarOrSyrup();
		
	public List<SCInterfaceListener> getListeners();
	}
	
	public interface SCInterfaceListener {
	
		public void onVanillaChosedRaised();
		public void onSyrupChosedRaised();
		public void onCrustChosedRaised();
		public void onBeginWaterHeatRaised();
		public void onMilkChosedRaised();
		public void onDisableMissingIngredientsRaised();
		public void onBeginMachineCleaningRaised();
		public void onAddSugarRaised();
		public void onSeedPackingRaised();
		public void onCupPlacingRaised();
		public void onBagPlacingRaised();
		public void onSeedGrindingRaised();
		public void onPodPlacingRaised();
		public void onWaitForWaterPouredRaised();
		public void onWaitForWaterHeatedRaised();
		public void onCoffeeChosedRaised();
		public void onTeaChosedRaised();
		public void onExpressoChosedRaised();
		public void onCoin10InsertedRaised();
		public void onCoin25InsertedRaised();
		public void onCoin50InsertedRaised();
		public void onCancelRaised();
		public void onNFCPaymentRaised();
		public void onDoTransactionRaised();
		public void onEndThirdStepRaised();
		public void onBeginSecondStepRaised();
		public void onPourMilkRaised();
		public void onCheckMilkOptionRaised();
		public void onBeginFirstStepRaised();
		public void onAutomaticCancelRaised();
		public void onSugarOrSyrupRaised();
		}
	
	public SCInterface getSCInterface();
	
}
