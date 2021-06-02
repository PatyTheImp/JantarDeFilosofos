import java.util.Random;

public class Filosofo extends Thread
{
    private Garfo garfoEsquerdo;
    private Garfo garfoDireito;
    private String nome;
    private Filosofo filosofoAEsquerda;
    private boolean aComer;
    private Random rand = new Random();
    private int espera = rand.nextInt(5000) + 5000;//Nº aleatório entre 5000 e 10000

    public Filosofo(Garfo garfoEsquerdo, Garfo garfoDireito, String nome)
    {
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
        this.nome = nome;
        aComer = false;
    }

    public void setFilosofoAEsquerda(Filosofo value) { filosofoAEsquerda = value; }

    public  boolean getAComer() { return aComer; }

    public void run()
    {
        garfoDireito.agarra();
        System.out.println(nome + " agarrou o garfo nº " + garfoDireito.getId());

        while (garfoEsquerdo.getAgarrado() && !filosofoAEsquerda.getAComer())
        {
            try
            {
                sleep(espera);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if (garfoEsquerdo.getAgarrado() && !filosofoAEsquerda.aComer)
            {
                garfoDireito.larga();
                System.out.println(nome + " largou o garfo nº " + garfoDireito.getId());

                try
                {
                    sleep(espera);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                garfoDireito.agarra();
                System.out.println(nome + " agarrou o garfo nº " + garfoDireito.getId());
            }
        }

        garfoEsquerdo.agarra();
        System.out.println(nome + " agarrou o garfo nº " + garfoEsquerdo.getId());

        aComer = true;

        try
        {
            //O filósofo ta a pensar enquanto come sparguetti
            sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        aComer = false;
        System.out.println(nome + " acabou de jantar");

        garfoEsquerdo.larga();
        System.out.println(nome + " largou o garfo nº " + garfoEsquerdo.getId());
        garfoDireito.larga();
        System.out.println(nome + " largou o garfo nº " + garfoDireito.getId());
    }
}
