public class Filosofo extends Thread
{
    private Garfo garfoEsquerdo;
    private Garfo garfoDireito;
    String nome;

    public Filosofo(Garfo garfoEsquerdo, Garfo garfoDireito, String nome)
    {
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
        this.nome = nome;
    }

    public void run()
    {
        garfoEsquerdo.agarra();
        System.out.println(nome + " agarrou o garfo nº " + garfoEsquerdo.getId());
        garfoDireito.agarra();
        System.out.println(nome + " agarrou o garfo nº " + garfoDireito.getId());

        try
        {
            sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println(nome + " acabou de jantar");

        garfoEsquerdo.larga();
        System.out.println(nome + " largou o garfo nº " + garfoEsquerdo.getId());
        garfoDireito.larga();
        System.out.println(nome + " largou o garfo nº " + garfoDireito.getId());
    }
}
