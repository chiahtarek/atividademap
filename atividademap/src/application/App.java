package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        Map<String, Double> regs = new HashMap<>();
        String caminho = "C:/Users/Tarek/Documents/in.txt.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String chave = fields[0];
                Double valor = Double.parseDouble(fields[1]);
                if (regs.containsKey(chave)) {
                    double swap = regs.get(chave);
                    regs.put(chave, (valor + swap));
                    System.out.println("entrou ein");
                } else {
                    regs.put(chave, valor);
                }

                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("ERRO! " + e.getMessage());
        }

        for (String key : regs.keySet()) {
            System.out.println(key + ": " + regs.get(key));
        }

        System.out.println("Teste");
    }
}
