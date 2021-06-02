public class Jantar
{
    public static void main(String[] args)
    {
        Garfo garfo1 = new Garfo(1);
        Garfo garfo2 = new Garfo(2);
        Garfo garfo3 = new Garfo(3);
        Garfo garfo4 = new Garfo(4);
        Garfo garfo5 = new Garfo(5);

        Filosofo platao = new Filosofo(garfo1, garfo2, "Platão");
        Filosofo nietzsche = new Filosofo(garfo2, garfo3, "Nietzsche");
        Filosofo descartes = new Filosofo(garfo3, garfo4, "Descartes");
        Filosofo kant = new Filosofo(garfo4, garfo5, "Kant");
        Filosofo socrates = new Filosofo(garfo5, garfo1, "Sócrates");

        platao.start();
        nietzsche.start();
        descartes.start();
        kant.start();
        socrates.start();

    }
}
