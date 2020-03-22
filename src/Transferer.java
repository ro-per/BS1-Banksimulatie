public class Transferer extends Thread {
	Bank bank;
	int from;

	Transferer(Bank bank, int from) {
		this.bank = bank;
		this.from = from;
	}

	public void run() {
		while (true) {
			int randTo = (int) (Math.random() * 10);
			int randWaarde = (int) (Math.random() * 10000);
			bank.transfer(from, randTo, randWaarde);
		}
	}
}
