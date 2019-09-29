package game;

import game.Comp;
import game.User;
import java.util.Random;

public class Main {
	
	public static void main(String args[ ])
    {	
		User user = new User(100);												// Экземпляр класса User, задаем значение здоровья = 100
		Comp comp = new Comp(100);												// Экземпляр класса Comp, задаем значение здоровья = 100
		Random rand = new Random();												// Генератор случайных чисел
		System.out.println("Fight!!!");
		System.out.println("Player = " + user.getHealth() + "         " + "Comp = " + comp.getHealth());	//Выводим начальные значения здоровья
		
		try {
	        Thread.sleep(2500);  												// Задержка, чтобы игра не происходила мгновенно
	    } catch(InterruptedException ex) {}
		
		while(user.getHealth()>0 && comp.getHealth()>0) {						// Условие для хода
			int num = ((rand.nextInt(2) + 1));									// Переменная для случайного выбора хода
			switch (num) {
				case 1: if(user.getHealth() == 100) {							//Убираем возможность исцеления при 100% здоровье
							user.move((rand.nextInt(2) + 1));					//т.е используем только два кейса на урон
				}
						else 
							user.move((rand.nextInt(3) + 1));					//Выбираем один из трех возможных ходов из класса User
						break;
				case 2: if(comp.getHealth() == 100) {							//Убираем возможность исцеления при 100% здоровье
							comp.move((rand.nextInt(2) + 1));					//т.е используем только два кейса на урон
				}
						else if (comp.getHealth() <= 35) {						// Условие для увеличение шансов исцеления Comp
							System.out.println("");
							System.out.println("Comp has an additional chance to heal!");	//Создаем видимость доп шанса на исцеление Comp
							comp.move((rand.nextInt(4) + 1)); 					// Увеличиваем выбор до четырех кейсов для увелечения шансов исцеления Comp
				}																
						else 
							comp.move((rand.nextInt(3) + 1));					// Выбираем один из трех возможных ходов из класса Comp
						break;
				default: System.out.println("Sorry, error was found");
						break; }
		try {
	        Thread.sleep(2500);  												// Задержка, чтобы игра не происходила мгновенно
	    } catch(InterruptedException ex) {}
		}
		 if (user.getHealth()<=0){												// Задаем нижнюю границу значения здоровья для Player
			 user.setHealth(0);													// Чтобы не отображалось отрицательное значение здоровья 
			 System.out.println("Player is dead :(  Health = " + user.getHealth());
			 System.out.println("Game Over, Winner is Comp!!!");				// Проигрыш Player
			 } 				
		 else if (comp.getHealth()<=0) {										// Задаем нижнюю границу значения здоровья для Comp
			 comp.setHealth(0);													// Чтобы не отображалось отрицательное значение здоровья
			 System.out.println("Comp is dead :(  Health = " + comp.getHealth());
			 System.out.println("Game Over, Winner is Player!!!");				// Проигрыш Comp
			 } 			
		 }	
	}
