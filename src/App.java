import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votos = new LinkedHashMap<>();

        System.out.println("Informe o caminho da pasta: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String linha = br.readLine();

            while(linha != null){

                String[] campo = linha.split(",");
                String nome = campo[0];
                int conta = Integer.parseInt(campo[1]);

                if(votos.containsKey(nome)){

                    int votosAteAgora = votos.get(nome);
                    votos.put(nome, conta + votosAteAgora);
                }
                else{
                    votos.put(nome, conta);
                }

                linha = br.readLine();

            }

            for(String key : votos.keySet()){
                System.out.println(key + ": " + votos.get(key));
            }
        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        

        sc.close();
    }
}
