public class Bank {
	int[] accounts;
	int aantalTrans, i;
	int aantalRekeningen = 10;
	int startBedrag = 10000;
	int uitschrijfAantal = 1;

	public Bank() {
		accounts = new int[aantalRekeningen];
		for (i = 0; i < accounts.length; i++) {
			accounts[i] = startBedrag;
		}
	}

	public void transfer(int from, int to, int amount) {
		try {
			synchronized (this) {
				// Thread.sleep(1);
				while (accounts[from] - amount < 0) {
					// while (accounts[from] /*amount */< 0) {
					this.wait();
				}
				accounts[from] -= amount;
				accounts[to] += amount;
				aantalTrans++;
				this.test();
				this.notifyAll(); // notify all waiting threads
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void test() {
		int sum = 0;
		if (aantalTrans % uitschrijfAantal == 0) {
			for (i = 0; i < accounts.length; i++) {
				sum += accounts[i];
			}
			System.out.println("Transactions: " + aantalTrans + ", Sum: " + sum);
			System.out.print("(");
			for (i = 0; i < accounts.length; i++) {
				System.out.print(accounts[i]);
				if (i + 1 != accounts.length)
					System.out.print("|");
			}
			System.out.println(")");
		}
	}
}