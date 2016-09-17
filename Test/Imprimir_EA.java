package My;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Imprimir_EA {

	public static void main(String[] args) {

		try {
			Scanner ler = new Scanner(new FileReader(args[0]));
			int ordem = ler.nextInt();
			int edge = ler.nextInt();
			Graph x = new Graph(ordem);

			for (int i = 0; i < edge; i++)
				x.join(ler.nextInt(), ler.nextInt(), ler.nextInt());

			for (int i = 0; i < ordem; i++) {
				System.out.print(i + "-> ");
				while (x.EA[i].hasNext()) {
					System.out.print(x.EA[i].next() + " ");
				}
				System.out.println();
			}

			ler.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}//End of Class Imprimir_EA
