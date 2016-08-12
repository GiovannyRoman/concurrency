package concurrencyBrainteaser;

import java.util.concurrent.atomic.AtomicInteger;

public class Custom implements Runnable {

	private String letter;
	static String lastLetter = "c";
	private int count = 0;
	private int id;
	static int order = 0;
	static AtomicInteger countA = new AtomicInteger(0);
	static AtomicInteger orderA = new AtomicInteger(0);

	public Custom(String letter) {
		this.letter = letter;
		this.id = orderA.getAndIncrement();
	}

	// @Override
	// public void run() {
	// // TODO Auto-generated method stub
	// while (count < 10) {
	// synchronized (this)
	// {
	// if (letter.equals("a") && order == 0) {
	// System.out.println(letter);
	// lastLetter = letter;
	// count++;
	// order++;
	// } else if (letter.equals("b") && order == 1) {
	// System.out.println(letter);
	// lastLetter = letter;
	// count++;
	// order++;
	// } else if((letter.equals("c") && order == 2)){
	// System.out.println(letter);
	// lastLetter = letter;
	// count++;
	// order =0;
	// }
	// }
	//
	// }

	public void run() {

		while (countA.get() < 30) {
			synchronized (this) {

				// int line = orderA.get();

				if (countA.get() % 3 == 0 && id == 0) {
					System.out.println(letter);
					countA.getAndIncrement();
				} else if (countA.get() % 3 == 1&& id == 1) {
					System.out.println(letter);
					countA.getAndIncrement();
				} else if (countA.get() % 3 == 2 && id == 2) {
					System.out.println(letter);
					countA.getAndIncrement();
				}

			}

		}
	}
}
