/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author Wendell
 */
public class TelaDeSelect extends Scene {
    private AudioClip audioSelect = new AudioClip(getClass().getResource("/audio/audioDaTelaDeSelect.mp3").toString());
    
    public int posiX = 10, posiY = 30;
    private Rectangle quadradoSelect;
    private ImageView setaLeft, setaRigth;
    private Label btnVoltar, btnNext;
    //instanciando todos os dados dos pokemons
    public Pokemon arcanine = new Pokemon(Pokemons.ARCANINE.getUrlImagemFront(), Pokemons.ARCANINE.isPresevar(), Pokemons.ARCANINE.getDimensao(), Pokemons.ARCANINE.getPosicaoX(), Pokemons.ARCANINE.getPosicaoY());
    public Pokemon charmander = new Pokemon(Pokemons.CHARMANDER.getUrlImagemFront(), Pokemons.CHARMANDER.isPresevar(), Pokemons.CHARMANDER.getDimensao(), Pokemons.CHARMANDER.getPosicaoX(), Pokemons.CHARMANDER.getPosicaoY());
    public Pokemon kadabra = new Pokemon(Pokemons.KADABRA.getUrlImagemFront(), Pokemons.KADABRA.isPresevar(), Pokemons.KADABRA.getDimensao(), Pokemons.KADABRA.getPosicaoX(), Pokemons.KADABRA.getPosicaoY());
    public Pokemon ninetales = new Pokemon(Pokemons.NINETALES.getUrlImagemFront(), Pokemons.NINETALES.isPresevar(), Pokemons.NINETALES.getDimensao(), Pokemons.NINETALES.getPosicaoX(), Pokemons.NINETALES.getPosicaoY());
    public Pokemon pikachu = new Pokemon(Pokemons.PIKACHU.getUrlImagemFront(), Pokemons.PIKACHU.isPresevar(), Pokemons.PIKACHU.getDimensao(), Pokemons.PIKACHU.getPosicaoX(), Pokemons.PIKACHU.getPosicaoY());
    public Pokemon primeape = new Pokemon(Pokemons.PRIMEAPE.getUrlImagemFront(), Pokemons.PRIMEAPE.isPresevar(), Pokemons.PRIMEAPE.getDimensao(), Pokemons.PRIMEAPE.getPosicaoX(), Pokemons.PRIMEAPE.getPosicaoY());
    public Pokemon rapidash = new Pokemon(Pokemons.RAPIDASH.getUrlImagemFront(), Pokemons.RAPIDASH.isPresevar(), Pokemons.RAPIDASH.getDimensao(), Pokemons.RAPIDASH.getPosicaoX(), Pokemons.RAPIDASH.getPosicaoY());

    public TelaDeSelect(Pane root, double width, double height, Color cor) {
        super(root, width, height);

        //Botões                                                            Pokemon GB.ttf
        Font font = Font.loadFont(TelaDeSelect.class.getResource("/font/ARCADECLASSIC.TTF").toExternalForm(), 16);

        //Botão Next
        btnNext = new Label("Enter");
        setaRigth = new ImageView("imagens/Pokemons/componentes/SetaSelectRight.png");
        setaRigth.setPreserveRatio(true);
        setaRigth.setFitWidth(70);
        setaRigth.setX(405);
        setaRigth.setY(260);
        btnNext.setLayoutX(415);
        btnNext.setLayoutY(272);
        btnNext.setFont(font);
        btnNext.setPrefSize(80, 30);

        //Botão Voltar
        btnVoltar = new Label("Esc");
        setaLeft = new ImageView("imagens/Pokemons/componentes/SetaDeSelectLeft.png");
        setaLeft.setPreserveRatio(true);
        setaLeft.setFitWidth(70);
        setaLeft.setX(5);
        setaLeft.setY(260);
        btnVoltar.setLayoutX(29);
        btnVoltar.setLayoutY(272);
        btnVoltar.setFont(font);
        btnVoltar.setPrefSize(80, 30);

        //Quadrado de selecão
        quadradoSelect = new Rectangle(60, 70);
        quadradoSelect.setLayoutX(posiX);
        quadradoSelect.setLayoutY(posiY);
        quadradoSelect.setFill(Color.CORNFLOWERBLUE);
        quadradoSelect.setStroke(Color.BLUE);
        quadradoSelect.setStrokeWidth(2);

        Rectangle fundo = new Rectangle(900, 900);
        fundo.setFill(cor);

        root.getChildren().addAll(fundo, quadradoSelect, arcanine, charmander, kadabra, ninetales, pikachu, primeape, rapidash, setaLeft, setaRigth, btnNext, btnVoltar);

    }
    public void audioPlay(){
        audioSelect.play(100);
    }
    
    public void audioStop(){
        audioSelect.stop();
    }
    
    public void moverRight() {
        posiX = posiX + 80;
        if (posiX > 420)
            posiX = 410;
        quadradoSelect.setLayoutX(posiX);
    }

    public void moverLeft() {
        posiX = posiX - 80;
        if (posiX < 10) {
            posiX = 10;
        }
        quadradoSelect.setLayoutX(posiX);
    }

    public void moverDown() {
        posiY = posiY + 75;
        if (posiY > 105) {
            posiY = 105;
        }
        quadradoSelect.setLayoutY(posiY);
    }

    public void moverUP() {
        posiY = posiY - 75;
        if (posiY < 30) {
            posiY = 30;
        }
        quadradoSelect.setLayoutY(posiY);
    }

    public Pokemons getSelectPokemon() {
        if (posiX == 10 && posiY == 105) {
            return Pokemons.getCHARMANDER(); 
        }else{
            switch(posiX){
            case 10: return Pokemons.getARCANINE();
            case 90: return Pokemons.getPRIMEAPE();
            case 170: return Pokemons.getPIKACHU();
            case 250: return Pokemons.getKADABRA();
            case 330: return Pokemons.getRAPIDASH();
            case 410: return Pokemons.getNINETALES();
            default: return null;
            }
        }
        
    }
    public void setPosiX(int posiX) {
        this.posiX = posiX;
    }

    public void setPosiY(int posiY) {
        this.posiY = posiY;
    }

}
