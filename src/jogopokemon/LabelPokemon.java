/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Wendell
 */
public enum LabelPokemon {
    
    ARCANINE("Arcanine", 10, 15, 50, 23 ,"Arranhar","Mordida","","",new Image("imagens/Pokemons/Ataques/mordida.png"),new Image("imagens/Pokemons/Ataques/arranhar.png")),
    CHARMANDER("Charmander", 5, 10, 20, 5,"Arranhar","Mordida","","",new Image("imagens/Pokemons/Ataques/mordida.png"),new Image("imagens/Pokemons/Ataques/arranhar.png")),
    KADABRA("Kadabra", 10, 15, 50, 23,"Arranhar","Mordida","","",new Image("imagens/Pokemons/Ataques/mordida.png"),new Image("imagens/Pokemons/Ataques/arranhar.png")),
    NINETALES("Ninetales", 10, 15, 50, 23,"Arranhar","Mordida","","",new Image("imagens/Pokemons/Ataques/mordida.png"),new Image("imagens/Pokemons/Ataques/arranhar.png")),
    PIKACHU("Pikachu", 5, 10, 20, 5,"Arranhar","Mordida","","",new Image("imagens/Pokemons/Ataques/mordida.png"),new Image("imagens/Pokemons/Ataques/arranhar.png")),
    PRIMEAPE("Primeape", 10, 15, 50, 23,"Arranhar","Mordida","","",new Image("imagens/Pokemons/Ataques/mordida.png"),new Image("imagens/Pokemons/Ataques/arranhar.png")),
    RAPIDASH("Rapidash", 10, 15, 50, 23,"Arranhar","Mordida","","",new Image("imagens/Pokemons/Ataques/mordida.png"),new Image("imagens/Pokemons/Ataques/arranhar.png"));
    
    private String nome;
    private int atk1Numero;
    private int atk2Numero;
    private int vida;
    private int nivel;
    private String atk1;
    private String atk2;
    private String atk3;
    private String atk4;
    private Image imgATK1;
    private Image imgATK2;

    LabelPokemon(String nome ,int atk1Numero, int atk2Numero, int vida, int nivel, String atk1, String atk2, String atk3, String atk4, Image imgATK1, Image imgATK2){
        this.vida = vida;
        this.nivel = nivel;
        this.nome = nome;
        this.atk1 = atk1;
        this.atk2 = atk2;
        this.atk3 = atk3;
        this.atk4 = atk4;
        this.atk1Numero = atk1Numero;
        this.atk2Numero = atk2Numero;
        this.imgATK1 = imgATK1;
        this.imgATK2 = imgATK2;
    }

    public static LabelPokemon getARCANINE() {
        return ARCANINE;
    }

    public static LabelPokemon getCHARMANDER() {
        return CHARMANDER;
    }

    public static LabelPokemon getKADABRA() {
        return KADABRA;
    }

    public static LabelPokemon getNINETALES() {
        return NINETALES;
    }

    public static LabelPokemon getPIKACHU() {
        return PIKACHU;
    }

    public static LabelPokemon getPRIMEAPE() {
        return PRIMEAPE;
    }

    public static LabelPokemon getRAPIDASH() {
        return RAPIDASH;
    }

    public String getAtk1() {
        return atk1;
    }

    public String getAtk2() {
        return atk2;
    }

    public String getAtk3() {
        return atk3;
    }

    public String getAtk4() {
        return atk4;
    }

    public int getVida() {
        return vida;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNome() {
        return nome;
    }

    public int getAtk1Numero() {
        return atk1Numero;
    }

    public int getAtk2Numero() {
        return atk2Numero;
    }

    public Image getImgATK1() {
        return imgATK1;
    }

    public Image getImgATK2() {
        return imgATK2;
    }
    
    
}
