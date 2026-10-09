import java.util.ArrayList;
import java.util.List;

public class Composite{


    public interface Pedido {
        public double calcularPreco();
        public String getNome();
        //pensar em que outros metodos e/ou atributos adicionar
    }

    public class Pizza implements Pedido{
        private String nome = "Pizza";
        private double preco = 19.90;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public String getNome(){
            return nome;
        }
    }

    public class Hamburguer implements Pedido{
        private String nome = "Hamburguer";
        private  double preco = 12.90;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public String getNome(){
            return nome;
        }
    }

    public class Batata implements Pedido{
        private  String nome = "Batata";
        private  double preco = 8.99;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public String getNome(){
            return nome;
        }
    }

    public class Refrigerante implements Pedido{
        private  String nome = "Refrigerante";
        private  double preco = 3.99;

        @Override 
        public double calcularPreco(){
            return preco;
        }

        @Override 
        public String getNome(){
            return nome;
        }
    }

    public class Combo implements Pedido{
        private List<Pedido> combo = new ArrayList<>();

        private String nome = "Combo ";
        private double preco = 0;

        @Override 
        public double calcularPreco(){
            int tam = combo.size();

            for (int i = 0 ; i < tam ; i++){
                preco += combo.get(i).calcularPreco();
            }
            return preco;
        }

        @Override 
        public String getNome(){
            int tam = combo.size();

            for (int i = 0 ; i < tam ; i++) {
                if (i != combo.size() - 2){
                    nome += combo.get(i).getNome() + ", ";
                }
                else if (i == tam - 1){
                    nome += combo.get(i).getNome() + " e ";
                }
                else{
                    nome += combo.get(i).getNome();
                }
            }
            return nome;
        }
    }



    public static void main(String [] args) {
        //aqui é onde o pedido vai ser feito (onde vem as entradas)

        System.out.println("ta indo");
    }
}