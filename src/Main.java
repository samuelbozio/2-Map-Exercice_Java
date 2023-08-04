import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Windows\\Temp\\votos.txt";
        Map<String, Integer> votacao = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                String[] partes = line.split(",");
                String nome = partes[0];
                int votos = Integer.parseInt(partes[1]);

                if (votacao.containsKey(nome)) {
                    int v = votacao.get(nome);
                    votacao.put(nome, votos + v);
                } else {
                    votacao.put(nome, votos);
                }

                line = br.readLine();

            }

            for (String key : votacao.keySet()) {
                System.out.println(key + " + " + votacao.get(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}