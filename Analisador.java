import java.util.concurrent.Semaphore;

public class Analisador extends Thread {

    private Semaphore Filtro;
    private Semaphore Analisador;

    private char[] Upper;
    private int contador = 0;

    public Analisador(char[] Upper, Semaphore FiltroExt ,Semaphore Analisador){
        this.Upper = Upper;
        this.Analisador = Analisador;
        this.Filtro =FiltroExt;
    }

    public void run(){
        try{
            while(true){
                Analisador.acquire();
                for (int i = 0; i < 10; i++){
                    if (Upper[i] == 'A'){
                        contador +=1;
                    }
                    else if(Upper[i] =='B'){
                        contador +=1;
                    }
                    else if(Upper[i] =='E'){
                        contador +=1;
                    }
                    else if(Upper[i] == 'O'){
                        contador +=1;
                    }
                    else if(Upper[i] == 'U'){
                        contador +=1;
                    }
                    else if(Upper[i]=='I'){
                        contador +=1;
                    }
                }
                System.out.print("Dentro do texto ");
                System.out.print(this.Upper);
                System.out.print(" existem " + this.contador + " vogais.");
                System.out.println();
                this.contador = 0;
                Filtro.release();
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
