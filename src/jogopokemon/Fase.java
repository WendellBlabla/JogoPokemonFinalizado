/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author familha
 */
public class Fase {

    /**
     *
     * @param root
     * @param width
     * @param height
     * @param cor
     */
    
    private LutaPokemon lutaPokemon;
    
    private Pokemons pokemonEscolhido;
    private ImageView imgGanhou = new ImageView("imagens/Pokemons/telasDePassagemDeFase/vcGanhou.png");
    
    private int finalizarFase2 = 0;
    
    private Pane root;
    private double width;
    private double height;
    private Color cor;
    public Fase(Pane root, double width, double height, Color cor){
        this.root = root;
        this.width = width;
        this.height = height;
        this.cor = cor;
        this.lutaPokemon = new LutaPokemon(root,width,height,cor);
    }
    
    public LutaPokemon fase2(){
        System.out.println("Play Fase2");
        finalizarFase2++;
        lutaPokemon.removerTelaPerdeuVenceu();
        setPokemons(pokemonEscolhido);
        return lutaPokemon; 
    }

    public LutaPokemon getLutaPokemon() {
        return lutaPokemon;
    }
    public void setPokemons(Pokemons pokemon){
        pokemonEscolhido = pokemon;
        lutaPokemon.setPokemon1(pokemon);
        lutaPokemon.setPokemon2(new Random().nextInt(7));
    }
    public void finalizarFase2(Stage tela, Scene cena){
        if(finalizarFase2 == 2){
        lutaPokemon.setImg(imgGanhou);
        tela.setScene(cena);
        //Timeline time = new Timeline(new KeyFrame(Duration.seconds(3), lamb -> tela.setScene(cena)));
        //time.play();
        }
    }
    
}
