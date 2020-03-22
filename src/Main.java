public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank();
		for (int i = 0; i < bank.aantalRekeningen; i++) {
			Transferer transfer = new Transferer(bank, i);
			transfer.start();
		}
	}
}
