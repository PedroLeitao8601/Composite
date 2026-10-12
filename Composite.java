import java.util.*;

public class Composite{

    public static interface Pedido {
        public double calcularPreco();
        public void exibir(int nivel);
        //pensar em que outros metodos e/ou atributos adicionar
    }

    public static class Colar implements Pedido{
        private String nome = "Colar";
        private double preco = 24.90;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco);
        }
    }

    public static class Brincos implements Pedido{
        private String nome = "Brincos";
        private  double preco = 19.90;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco);
        }
    }

    public static class Anel implements Pedido{
        private  String nome = "Anel";
        private  double preco = 13.90;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco);
        }
    }

    public static class Pulseira implements Pedido{
        private  String nome = "Pulseira";
        private  double preco = 11.90;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco);
        }
    }

    public static class Tiara implements Pedido{
        private  String nome = "Tiara";
        private  double preco = 17.90;
        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco);
        }
    }

    public static class Gargantilha implements Pedido{
        private  String nome = "Pulseira";
        private  double preco = 11.90;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco);
        }
    }
    
    public static class Pacote implements Pedido{
        private ArrayList<Pedido> pacote = new ArrayList<>();

        public String nome = "Kit de acessorios:";
        
        @Override 
        public double calcularPreco(){
            int tam = pacote.size();
            double preco = 0;

            for (int i = 0 ; i < tam ; i++){
                preco += pacote.get(i).calcularPreco();
            }
            return preco;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome);

            for(Pedido item: pacote){
                item.exibir(nivel + 1);
            }
        }

        public void add(Pedido item){
            pacote.add(item);
        }

        public void remove(Pedido item){
            pacote.remove(item);
        }
    }



    public static void main(String [] args) {
        int nivel = 0;

        Pacote kit_1 = new Pacote();
        Pacote kit_2 = new Pacote();
        Pacote kit_3 = new Pacote();
        kit_1.nome = "Kit especial: ";

        Brincos bri_1 = new Brincos();
        Anel an_1 = new Anel();
        Pulseira pul_1 = new Pulseira();
        Colar col_1 = new Colar();
        Gargantilha gar_1 = new Gargantilha();
        Tiara tia_1 = new Tiara();
        Tiara tia_2 = new Tiara();

        kit_1.add(kit_2);
        kit_1.add(kit_3);
        kit_2.add(bri_1);
        kit_2.add(an_1);
        kit_2.add(pul_1);
        kit_3.add(col_1);
        kit_3.add(gar_1);
        kit_3.add(tia_1);

        kit_1.add(tia_2);

        kit_1.exibir(nivel);
        
        System.out.printf("\n Preco total: R$ %.2f%n", kit_1.calcularPreco());
    }
}