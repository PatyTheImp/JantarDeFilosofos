public class Garfo
{
    //Indica se o garfo está a ser agarrado ou não
    private  boolean agarrado;
    private int id;

    public Garfo(int id)
    {
        this.id = id;
        agarrado = false;
    }

    public int getId()
    {
        return id;
    }

    public boolean getAgarrado() { return agarrado; }

    public synchronized void agarra()
    {
        //Enquanto o garfo estiver a ser agarrado, o filósofo não o pode agarrar
        //então fica a espera até o garfo ser largado
        while (agarrado)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        //Depois de o filosofo agarrar no garfo, ele fica agarrado
        agarrado = true;
        notifyAll();
    }

    public synchronized void larga()
    {
        //Enquanto o garfo não estiver a ser agarrado, o filósofo não o pode largar
        //então fica a espera até o garfo ser agarrado
        while (!agarrado)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        //Depois de o filosofo largar o garfo, ele deixa de ficar agarrado
        agarrado = false;
        notifyAll();
    }
}
