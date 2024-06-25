public abstract class Material {
    private String titulo;
    private String autor;
    private int ano;

    public Material(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // Método a ser sobrescrito pelas subclasses
    public abstract String getDescricao();
}
public class Livro extends Material {
    private int numeroDePaginas;

    public Livro(String titulo, String autor, int ano, int numeroDePaginas) {
        super(titulo, autor, ano);
        this.numeroDePaginas = numeroDePaginas;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    @Override
    public String getDescricao() {
        return "Livro: " + getTitulo() + " por " + getAutor() + " (" + getAno() + "), " + numeroDePaginas + " páginas";
    }
}
public class Filme extends Material {
    private int duracao;

    public Filme(String titulo, String autor, int ano, int duracao) {
        super(titulo, autor, ano);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String getDescricao() {
        return "Filme: " + getTitulo() + " dirigido por " + getAutor() + " (" + getAno() + "), " + duracao + " minutos";
    }
}
public class Periodico extends Material {
    private int edicao;

    public Periodico(String titulo, String autor, int ano, int edicao) {
        super(titulo, autor, ano);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public String getDescricao() {
        return "Periódico: " + getTitulo() + " edição " + edicao + " por " + getAutor() + " (" + getAno() + ")";
    }
}
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Material> materiais = new ArrayList<>();
        
        materiais.add(new Livro("O Hobbit", "J.R.R. Tolkien", 1937, 310));
        materiais.add(new Filme("O Senhor dos Anéis", "Peter Jackson", 2001, 178));
        materiais.add(new Periodico("Nature", "Diversos", 2021, 7864));
        
        cadastrarMaterial(materiais, new Livro("1984", "George Orwell", 1949, 328));
        
        listarMateriais(materiais);
        
        System.out.println("Descrição do primeiro material: " + materiais.get(0).getDescricao());
    }

    // Método para cadastrar material
    public static void cadastrarMaterial(List<Material> materiais, Material material) {
        materiais.add(material);
    }

    // Método sobrecarregado para cadastrar material com detalhes
    public static void cadastrarMaterial(List<Material> materiais, String titulo, String autor, int ano, int detalhe, String tipo) {
        switch (tipo.toLowerCase()) {
            case "livro":
                materiais.add(new Livro(titulo, autor, ano, detalhe));
                break;
            case "filme":
                materiais.add(new Filme(titulo, autor, ano, detalhe));
                break;
            case "periodico":
                materiais.add(new Periodico(titulo, autor, ano, detalhe));
                break;
        }
    }

    // Método para listar materiais
    public static void listarMateriais(List<Material> materiais) {
        for (Material material : materiais) {
            System.out.println(material.getDescricao());
        }
    }
}
