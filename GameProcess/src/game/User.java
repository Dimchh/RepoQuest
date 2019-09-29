package game;

import java.util.Random;

public class User {
	
	public User(int a) {
		setHealth(a); 														//Сеттер для определения начального health
		
	}
	
	public void move(int num1) { 
		
		Random rand = new Random(); 										// Генератор случайных чисел
		
		int moderate = (int)rand.nextInt((25 - 18) + 1) + 18;				//Генератор умеренного урона
		int huge = (int)rand.nextInt((35 - 10) + 1) + 10;					//Генератор большого урона
		int healing = (int)rand.nextInt((20 - 10) + 1) + 10;				//Генератор исцеления
		
		switch (num1) {
		 case 1: setHealth(getHealth()- moderate); 							// Кейс с умеренным уроном 18-25 который наносит Comp 
				System.out.println("\nComp's move begin......");
				System.out.println("\nModerate Damage = " + moderate);
				if (getHealth() > 0)										// Условие для вывода здоровья после нанесения урона
					System.out.println("Player's Health = " + getHealth());	// Сделано для того, чтобы не выводить отрицательное значения здоровья
				break;
		
		 case 2: setHealth(getHealth()- huge); 								// Кейс с большим уроном 10-35 который наносит Comp
			 	System.out.println("\nComp's move begin......");
			 	System.out.println("\nHuge Damage = " + huge);
			 	if (getHealth() > 0)										// Условие для вывода здоровья после нанесения урона
			 		System.out.println("Player's Health = " + getHealth()); // Сделано для того, чтобы не выводить отрицательное значения здоровья
			 	break;
		 
		 case 3: setHealth(getHealth()+ healing);							// Кейс с исцелением 10-20 для Player
		 		if(getHealth()>100)	{										// Условие если после исцеления значение здоровья > 100
		 			setHealth(100);											// Задаем верхнюю границу значения здоровья для Player
		 			}										
			 	System.out.println("\nPlayer's move begin......");
			 	System.out.println("\nHealing = " + healing);
	     		System.out.println("Player's Health = " + getHealth());
	     		break;
		 default: System.out.println("\nSorry, error was found");
			 	break;
    }
}
public int getHealth() { 													// возвращает значение health
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
private int health;
}
