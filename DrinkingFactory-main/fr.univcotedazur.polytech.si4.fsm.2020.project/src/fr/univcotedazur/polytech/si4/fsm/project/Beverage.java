package fr.univcotedazur.polytech.si4.fsm.project;

public class Beverage {
	Size size;
	int sugar;
	Drink drink;
	
	public Beverage(Size _size,int _sugar,Drink _drink) {
		this.size=_size;
		this.sugar=_sugar;
		this.drink=_drink;
	}
	
}
