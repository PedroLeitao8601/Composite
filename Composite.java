import java.util.*;

public class Composite{

    public static interface Pedido {
        public double calcularPreco();
        public double calcularPeso();
        public void exibir(int nivel);
        public List<String> validar();
    }

    public static class Colar implements Pedido{
        private String nome = "Colar";
        private double preco = 24.90;
        public double peso = 1.5;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public double calcularPeso(){
            return peso;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco + " - Peso: " + peso);
        }

        @Override
        public List<String> validar() {
            return new ArrayList<>();
        }
    }

    public static class Brincos implements Pedido{
        private String nome = "Brincos";
        private  double preco = 19.90;
        public double peso = 0.1;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public double calcularPeso(){
            return peso;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco + " - Peso: " + peso);
        }

        @Override
        public List<String> validar() {
            return new ArrayList<>();
        }
    }

    public static class Anel implements Pedido{
        private  String nome = "Anel";
        private  double preco = 13.90;
        public double peso = 0.2;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public double calcularPeso(){
            return peso;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco + " - Peso: " + peso);
        }

        @Override
        public List<String> validar() {
            return new ArrayList<>();
        }
    }

    public static class Pulseira implements Pedido{
        private  String nome = "Pulseira";
        private  double preco = 11.90;
        public double peso = 0.8;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public double calcularPeso(){
            return peso;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco + " - Peso: " + peso);
        }

        @Override
        public List<String> validar() {
            return new ArrayList<>();
        }
    }

    public static class Tiara implements Pedido{
        private  String nome = "Tiara";
        private  double preco = 17.90;
        public double peso = 2;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public double calcularPeso(){
            return peso;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco + " - Peso: " + peso);
        }

        @Override
        public List<String> validar() {
            return new ArrayList<>();
        }
    }

    public static class Gargantilha implements Pedido{
        private  String nome = "Gargantilha";
        private  double preco = 11.90;
        public double peso = 2.5;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public double calcularPeso(){
            return peso;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            System.out.println(ident + nome + " - R$ " + preco + " - Peso: " + peso);
        }

        @Override
        public List<String> validar() {
            return new ArrayList<>();
        }
    }
    
    public static class Pacote implements Pedido{
        private ArrayList<Pedido> pacote = new ArrayList<>();
        public String nome = "Kit de acessorios:";
        private double precoMin = 50;
        private double pesoMax = 8;
        
        @Override 
        public double calcularPreco(){
            double preco = 0;
            for(Pedido item: pacote){
                preco += item.calcularPreco();
            }
            return preco;
        }

        @Override 
        public double calcularPeso(){
            double peso = 0;
            for(Pedido item: pacote){
                peso += item.calcularPeso();
            }
            return peso;
        }

        @Override
        public void exibir(int nivel){
            String ident = "\t".repeat(nivel);
            List<String> erros = validar();

            if (erros.isEmpty()) {
                System.out.println(ident + nome + " [VÁLIDO]");
            } else {
                System.out.println(ident + nome + " [PACOTE INVÁLIDO] " + erros);
            }
            for(Pedido item: pacote){
                    item.exibir(nivel + 1);
                }
        }

        @Override 
        public List<String> validar() {
            List<String> erros = new ArrayList<>();

            if (calcularPeso() > pesoMax) {
                erros.add("Peso máximo de " + pesoMax + " excedido");
            }
            if (calcularPreco() < precoMin) {
                erros.add("Preço mínimo de R$ " + precoMin +" não atingido");
            }
            for (Pedido item : pacote) {
                List<String> errosItem = item.validar();
                erros.addAll(errosItem);
            }
            return erros;
        }

        public void add(Pedido item){
            pacote.add(item);
            pacote.sort(Comparator.comparingDouble(Pedido::calcularPeso).reversed());
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

        kit_1.add(kit_2); //comentar para validar exemplo 1
        kit_1.add(kit_3);
        kit_2.add(new Brincos());//       19.90
        kit_2.add(new Anel());//          13.90
        kit_2.add(new Pulseira());//      11.90
        kit_3.add(new Colar());//         24.90
        kit_3.add(new Gargantilha());//   11.90
        kit_3.add(new Tiara());//         17.90
        kit_1.add(new Tiara());

//-------------------------------------------

        Pacote kit_pesado = new Pacote();
        kit_pesado.nome = "Kit pesado: ";

        kit_pesado.add(new Colar());//       Peso: 1.5 | Preço: 24.90
        kit_pesado.add(new Tiara());//       Peso: 2.0 | Preço: 17.90
        kit_pesado.add(new Gargantilha());// Peso: 2.5 | Preço: 11.90
        kit_pesado.add(new Tiara());//       Peso: 2.0 | Preço: 17.90
        kit_pesado.add(new Gargantilha());// Peso: 2.5 | Preço: 11.90

//-------------------------------------------

        Pacote kit_barato = new Pacote();
        kit_barato.nome = "Kit barato: ";

        kit_barato.add(new Brincos()); // Peso: 0.1 | Preço: 19.90
        kit_barato.add(new Anel());    // Peso: 0.2 | Preço: 13.90
        kit_barato.add(new Pulseira());// Peso: 0.8 | Preço: 11.90

//-------------------------------------------
        
        kit_1.exibir(nivel); // exemplo 1
        System.out.printf("\nPreço total: R$ %.2f%nPeso Total: %.2f%n\n", kit_1.calcularPreco(), kit_1.calcularPeso());

        kit_pesado.exibir(nivel); // exemplo 2
        System.out.printf("\nPreço total: R$ %.2f%nPeso Total: %.2f%n\n", kit_pesado.calcularPreco(), kit_pesado.calcularPeso());

        kit_barato.exibir(nivel); // exemplo 3
        System.out.printf("\nPreço total: R$ %.2f%nPeso Total: %.2f%n\n", kit_barato.calcularPreco(), kit_barato.calcularPeso());
    }
}