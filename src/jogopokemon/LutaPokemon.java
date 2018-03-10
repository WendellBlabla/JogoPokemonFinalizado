/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Wendell
 */
public class LutaPokemon extends Scene {

    private AudioClip audioLuta = new AudioClip(getClass().getResource("/audio/musicaPokemon.mp3").toString());

    private Font font2 = Font.loadFont(MenuJogo.class.getResource("/font/Pokemon GB.ttf").toString(), 16);
    //Posição da seta
    private double posicaoX = 276, posicaoY = 250;
    //Coisas dos Pokemons escolhidos
    private ImageView pokemon1 = new ImageView(), pokemon2 = new ImageView(); //Imagens Do Pokemon escolhido e do Pokemon Inimigo
    // Vida dos Pokemons
    private int vidaPokemon1Num, vidaPokemon2Num;
    // Nivel, nome e vida do pokemon escolhido pelo usuario
    private final Label pokemon1Nivel = new Label();
    private final Label pokemon1Nome = new Label();
    private final Label pokemon1Vida = new Label();
    // Nomes dos Ataques
    private Label atk1 = new Label(), atk2 = new Label();
    // Nivel, nome e vida do pokemon escolhido pelo Inimigo
    private final Label pokemon2Nivel = new Label();
    private final Label pokemon2Nome = new Label();
    private final Label pokemon2Vida = new Label();
    // Os Pokemons, do usuario e do inimigo
    private Pokemons pokemonInimigo;
    private Pokemons pokemonUsuario;
    // Variavies de habilitação de campos
    private boolean status = false;
    private boolean statusTelaPreta = false;
    private boolean permitirTeclaSpace = false;
    //Campos da Tela de Jogo
    private BarrasDoJogo campo = new BarrasDoJogo(new Image("imagens/Pokemons/componentes/campopokemonGrama.png"), -2, -6, 1.03, 1.03);
    private final BarrasDoJogo barraCampo = new BarrasDoJogo(new Image("imagens/Pokemons/componentes/BarraCampo2.png"), 12, 227, 1.06, 1.0);//
    private final BarrasDoJogo barraOpcoes = new BarrasDoJogo(new Image("imagens/Pokemons/componentes/BarraCampoOpcões2.png"), 250, 224, 0.88, 0.9);
    private final BarrasDoJogo botaoSelecaoDoPokemon = new BarrasDoJogo(new Image("imagens/Pokemons/componentes/BotãoSelecãoDoPokemon4.png"), posicaoX, posicaoY, 1.5, 1.5);
    private final BarrasDoJogo barraDePokemon = new BarrasDoJogo(new Image("imagens/Pokemons/componentes/BarraDePokemon2.png"), 245, 146, 1, 1);
    private final BarrasDoJogo barraDePokemonInimigo = new BarrasDoJogo(new Image("imagens/Pokemons/componentes/BarraDePokemonInimigo.png"), 12, 30, 1, 1);
    private final BarrasDoJogo barraDeAtaques = new BarrasDoJogo(new Image("imagens/Pokemons/componentes/barraDeAtaques.png"), 33, 227, 1.18, 1.1);
    // Teclas que indicam os ataques
    private Label tecla1 = new Label("(Tecla1)");
    private Label tecla2 = new Label("(Tecla2)");
    /* Futuras Teclas
    private Label tecla3 = new Label("(Tecla3)");
    private Label tecla4 = new Label("(Tecla4)");
     */
    
    //telas de passagem de fase
    private final ImageView imgVenceu = new ImageView("imagens/Pokemons/telasDePassagemDeFase/PokemonImgvenceu.png");
    private final ImageView imgPerdeu = new ImageView("imagens/Pokemons/telasDePassagemDeFase/gameOver.png");
    private final ImageView imgFinal = new ImageView("imagens/Pokemons/telasDePassagemDeFase/vcGanhou2.png");
    private ImageView img = null;   
    
    private int finalizarFase2 = 0;
    
    private Pane root;
    public LutaPokemon(Pane root, double width, double height, Color cor) {
        super(root, width, height, cor);
        this.root = root;
        //Pokemon da escolha do usuario
        posicionarOsLabelDosPokemons(pokemon1Nivel, 433, 167, Color.DIMGRAY, 0.5, 1, font2, pokemon1Nome, 260, 165, 0.6, 1, pokemon1Vida, 385, 205, 0.7, 0.7);

        //pokemon inimigo
        posicionarOsLabelDosPokemons(pokemon2Nivel, 193, 41, Color.DIMGRAY, 0.5, 1, font2, pokemon2Nome, 10, 40, 0.6, 1, pokemon2Vida, 8, 60, 0.5, 0.8);

        // Posicões das Palavras de ataque
        tecla1.setLayoutX(-20);
        tecla1.setLayoutY(248);
        tecla1.setFont(font2);
        tecla1.setScaleX(0.3);
        tecla1.setScaleY(0.6);
        atk1.setLayoutX(40);
        atk1.setLayoutY(245);
        atk1.setScaleX(0.6);
        atk1.setScaleY(1);
        atk1.setFont(font2);
        tecla2.setLayoutX(110);
        tecla2.setLayoutY(248);
        tecla2.setFont(font2);
        tecla2.setScaleX(0.3);
        tecla2.setScaleY(0.6);
        atk2.setLayoutX(170);
        atk2.setLayoutY(245);
        atk2.setScaleX(0.6);
        atk2.setScaleY(1);
        atk2.setFont(font2);

        Rectangle fundo = new Rectangle(900, 1000);
        fundo.setFill(cor);

        root.getChildren().addAll(fundo, campo, pokemon2, pokemon1, barraDePokemon, barraDePokemonInimigo, pokemon1Nome, pokemon1Nivel, pokemon2Nome, pokemon2Nivel, pokemon1Vida, pokemon2Vida, barraCampo, barraOpcoes, botaoSelecaoDoPokemon);
    }

    private void posicionarOsLabelDosPokemons(Label nivel, double leyoutXnivel, double leyoutYnivel, Color cor, double scaleXnivel, double scaleYnivel, Font font,
            Label nome, double leyoutXnome, double leyoutYnome, double scaleXnome, double scaleYnome,
            Label vida, double leyoutXvida, double leyoutYvida, double scaleXvida, double scaleYvida) {
        nivel.setLayoutX(leyoutXnivel);
        nivel.setLayoutY(leyoutYnivel);
        nivel.setTextFill(cor);
        nivel.setScaleX(scaleXnivel);
        nivel.setScaleY(scaleYnivel);
        nivel.setFont(font);
        nome.setLayoutX(leyoutXnome);
        nome.setLayoutY(leyoutYnome);
        nome.setTextFill(cor);
        nome.setScaleX(scaleXnome);
        nome.setScaleY(scaleYnome);
        nome.setFont(font);
        vida.setLayoutX(leyoutXvida);
        vida.setLayoutY(leyoutYvida);
        vida.setFont(font);
        vida.setTextFill(cor);
        vida.setScaleX(scaleXvida);
        vida.setScaleY(scaleYvida);

    }

    private void animacaoATK(int num) {
        TranslateTransition pokemonMove1 = new TranslateTransition(Duration.seconds(0.5));
        TranslateTransition pokemonMove2 = new TranslateTransition(Duration.seconds(0.5));
        SequentialTransition pokemonMove = new SequentialTransition(pokemonMove2, pokemonMove1);
        switch (num) {
            case 0:
                pokemonMove1.setByX(295);
                pokemonMove2.setByY(-50);
                pokemonMove1.setCycleCount((int) 2f);
                pokemonMove2.setCycleCount((int) 2f);
                pokemonMove1.setAutoReverse(true);
                pokemonMove2.setAutoReverse(true);
                pokemonMove.setNode(pokemon1);
                pokemonMove.play();
                break;
            case 1:
                pokemonMove1.setByX(-50);
                pokemonMove2.setByY(120);
                pokemonMove1.setCycleCount((int) 2f);
                pokemonMove2.setCycleCount((int) 2f);
                pokemonMove1.setAutoReverse(true);
                pokemonMove2.setAutoReverse(true);
                pokemonMove.setNode(pokemon2);
                pokemonMove.play();
                break;
        }
    }

    public void setPokemon1(Pokemons pokemon) { // Metodo de Colocar Pokemon escolhido e suas Propriedades no Devidos Lugares
        this.vidaPokemon1Num = pokemon.getLabelPokemon().getVida();
        pokemon1.setImage(pokemon.getUrlImagemBack());
        pokemon1.setX(pokemon.getPosicaoXPokemon1());
        pokemon1.setY(pokemon.getPosicaoYPokemon1());
        atk1.setText(pokemon.getLabelPokemon().getAtk1());
        atk2.setText(pokemon.getLabelPokemon().getAtk2());
        pokemon1Nivel.setText(String.valueOf(pokemon.getLabelPokemon().getNivel()));
        pokemon1Nome.setText(pokemon.getLabelPokemon().getNome());
        pokemon1Vida.setText(String.valueOf(getVidaPokemon1Num()) + "/" + String.valueOf(pokemon.getLabelPokemon().getVida()));
        this.pokemonUsuario = pokemon;
    }

    private void setPokemonAdversaio(Pokemons p) { // Metodo de Colocar Pokemon Inimigo e suas Propriedades no Devidos Lugares
        this.vidaPokemon2Num = p.getLabelPokemon().getVida();
        pokemon2.setImage(p.getUrlImagemFront());
        pokemon2.setX(p.getPosicaoXPokemon2());
        pokemon2.setY(p.getPosicaoYPokemon2());
        pokemon2Nivel.setText(String.valueOf(p.getLabelPokemon().getNivel()));
        pokemon2Nome.setText(p.getLabelPokemon().getNome());
        pokemon2Vida.setText(String.valueOf(vidaPokemon2Num) + "/" + String.valueOf(p.getLabelPokemon().getVida()));
    }

    public void setPokemon2(int num) { // Metodo para Escolher o pokemon Inimigo
        switch (num) {
            case 0:
                this.setPokemonAdversaio(Pokemons.ARCANINE);
                this.pokemonInimigo = Pokemons.ARCANINE;
                break;
            case 1:
                this.setPokemonAdversaio(Pokemons.CHARMANDER);
                this.pokemonInimigo = Pokemons.CHARMANDER;
                break;
            case 2:
                this.setPokemonAdversaio(Pokemons.KADABRA);
                this.pokemonInimigo = Pokemons.KADABRA;
                break;
            case 3:
                this.setPokemonAdversaio(Pokemons.NINETALES);
                this.pokemonInimigo = Pokemons.NINETALES;
                break;
            case 4:
                this.setPokemonAdversaio(Pokemons.PIKACHU);
                this.pokemonInimigo = Pokemons.PIKACHU;
                break;
            //Thread.sleep(1000); tempo de sleep da luta
            case 5:
                this.setPokemonAdversaio(Pokemons.PRIMEAPE);
                this.pokemonInimigo = Pokemons.PRIMEAPE;
                break;
            case 6:
                this.setPokemonAdversaio(Pokemons.RAPIDASH);
                this.pokemonInimigo = Pokemons.RAPIDASH;
                break;
        }
    }

    public void barraDeAtaques(int num) {
        switch (num) {
            case 0:
                root.getChildren().addAll(barraDeAtaques, atk1, atk2, tecla1, tecla2);
                break;
            case 1:
                root.getChildren().removeAll(barraDeAtaques, atk1, atk2, tecla1, tecla2);
                break;
        }
    }

    //Metodo para decidir se o pokemon inimigo vai atacar
    public void decidirATKInimigo() {
        final Label text = new Label("O pokémon " + pokemonInimigo.getLabelPokemon().getNome() + " nao vai atacar...");
        text.setTextFill(Color.WHITE);
        text.setLayoutX(-165);
        text.setLayoutY(245);
        text.setScaleX(0.35);
        text.setScaleY(0.8);
        text.setFont(font2);
        int rand = new Random().nextInt(10);
        if (rand % 2 == 0) {
            int rad = new Random().nextInt(2);
            if (rad == 0) {
                System.out.println("Arranhar");
                Timeline tim = new Timeline(new KeyFrame(Duration.seconds(0.5), lamb -> atkArranha(1)));
                tim.play();
            } else if (rad == 1) {
                System.out.println("Mordida");
                Timeline tim2 = new Timeline(new KeyFrame(Duration.seconds(3), lamb -> atkMordida(1)));
                tim2.play();
            }

        }
        else if(rand % 2 ==1){
            System.out.println(text);
            root.getChildren().add(text);
            Timeline time = new Timeline(new KeyFrame(Duration.seconds(3), lamb -> root.getChildren().removeAll(text)));
            time.play();
            
        }
    }

    // Metodos de ataques do pokemon
    public void atkArranha(int num) {
        switch (num) {
            case 0:
                animacaoATK(0);
                this.vidaPokemon2Num = vidaPokemon2Num - pokemonUsuario.getLabelPokemon().getAtk1Numero();
                if (this.vidaPokemon2Num < 0) {
                    this.vidaPokemon2Num = 0;
                    if(vidaPokemon2Num == 0){
                        Timeline tempo = new Timeline(new KeyFrame(Duration.seconds(3), lamb -> setarTelasPerdeuVenceu()));
                        tempo.play();
                        setPermitirTeclaSpace(true);
                    }
                }
                //FadeTransition opacidade = new FadeTransition(Duration.seconds(0.5), );
                Timeline time1 = new Timeline(new KeyFrame(Duration.seconds(1.5), lam -> pokemon2Vida.setText(String.valueOf(vidaPokemon2Num) + "/" + String.valueOf(pokemonInimigo.getLabelPokemon().getVida()))));
                time1.play();
                break;
            case 1:
                Timeline time2 = new Timeline(new KeyFrame(Duration.seconds(3), lamb -> animacaoATK(1)));
                time2.play();
                this.vidaPokemon1Num = vidaPokemon1Num - pokemonInimigo.getLabelPokemon().getAtk1Numero();
                if (this.vidaPokemon1Num < 0) {
                    this.vidaPokemon1Num = 0;
                    if(vidaPokemon2Num == 0){
                        Timeline tempo = new Timeline(new KeyFrame(Duration.seconds(3), lamb -> setarTelasPerdeuVenceu()));
                        tempo.play();
                        setPermitirTeclaSpace(true);
                    }
                }
                Timeline time3 = new Timeline(new KeyFrame(Duration.seconds(4.5), lam -> pokemon1Vida.setText(String.valueOf(vidaPokemon1Num) + "/" + String.valueOf(pokemonUsuario.getLabelPokemon().getVida()))));
                time3.play();
                break;
        }
    }

    public void atkMordida(int num) {
        ImageView atk2;
        ScaleTransition scaleMordida;
        Timeline time;
        Timeline time2;
        switch (num) {
            case 0:
                atk2 = new ImageView(pokemonUsuario.getLabelPokemon().getImgATK1());
                atk2.setLayoutX(pokemonInimigo.getPosicaoXPokemon2() + 10);
                atk2.setLayoutY(pokemonInimigo.getPosicaoYPokemon2() + 20);
                root.getChildren().add(atk2);
                scaleMordida = new ScaleTransition(Duration.seconds(2), atk2);
                scaleMordida.setByX(1.2f);
                scaleMordida.setByY(1.2f);
                scaleMordida.setCycleCount((int) 1f);
                scaleMordida.setAutoReverse(true);
                scaleMordida.play();
                time = new Timeline(new KeyFrame(Duration.seconds(2.1), lamb -> root.getChildren().removeAll(atk2)));
                time.play();
                this.vidaPokemon2Num = (vidaPokemon2Num) - pokemonUsuario.getLabelPokemon().getAtk2Numero();
                if (this.vidaPokemon2Num < 0) {
                    this.vidaPokemon2Num = 0;
                    if(vidaPokemon2Num == 0){
                        Timeline tempo = new Timeline(new KeyFrame(Duration.seconds(3), lamb -> setarTelasPerdeuVenceu()));
                        tempo.play();
                        setPermitirTeclaSpace(true);
                    }
                }
                time2 = new Timeline(new KeyFrame(Duration.seconds(1.5), lam -> pokemon2Vida.setText(String.valueOf(vidaPokemon2Num) + "/" + String.valueOf(pokemonInimigo.getLabelPokemon().getVida()))));
                time2.play();
                break;
            case 1:
                atk2 = new ImageView(pokemonInimigo.getLabelPokemon().getImgATK1());
                atk2.setLayoutX(pokemonUsuario.getPosicaoXPokemon1()+10);
                atk2.setLayoutY(pokemonUsuario.getPosicaoYPokemon1()+20);
                //Thread.sleep(1500);
                root.getChildren().add(atk2);
                scaleMordida = new ScaleTransition(Duration.seconds(2), atk2);
                scaleMordida.setByX(1.2f);
                scaleMordida.setByY(1.2f);
                scaleMordida.setCycleCount((int) 1f);
                scaleMordida.setAutoReverse(true);
                scaleMordida.play();
                time = new Timeline(new KeyFrame(Duration.seconds(2), lamb -> root.getChildren().removeAll(atk2)));
                time.play();
                this.vidaPokemon1Num = (vidaPokemon1Num) - pokemonInimigo.getLabelPokemon().getAtk2Numero();
                if (this.vidaPokemon1Num < 0) {
                    this.vidaPokemon1Num = 0;
                    if(vidaPokemon1Num == 0){
                        Timeline tempo = new Timeline(new KeyFrame(Duration.seconds(3), lamb -> setarTelasPerdeuVenceu()));
                        tempo.play();
                        setPermitirTeclaSpace(true);
                    }
                }
                time2 = new Timeline(new KeyFrame(Duration.seconds(1.5), lam -> pokemon1Vida.setText(String.valueOf(vidaPokemon1Num) + "/" + String.valueOf(pokemonUsuario.getLabelPokemon().getVida()))));
                time2.play();
                break;
        }
    }

   /* private void setATKMordida(ImageView atk2, ScaleTransition scaleMordida, Timeline time, Timeline time2) {
        atk2 = new ImageView(pokemonUsuario.getLabelPokemon().getImgATK1());
        atk2.setLayoutX(pokemonInimigo.getPosicaoXPokemon2() + 10);
        atk2.setLayoutY(pokemonInimigo.getPosicaoYPokemon2() + 20);
        root.getChildren().add(atk2);
        scaleMordida = new ScaleTransition(Duration.seconds(2), atk2);
        scaleMordida.setByX(1.2f);
        scaleMordida.setByY(1.2f);
        scaleMordida.setCycleCount((int) 1f);
        scaleMordida.setAutoReverse(true);
        scaleMordida.play();
        time = new Timeline(new KeyFrame(Duration.seconds(2.1), lamb -> root.getChildren().removeAll(atk2)));
        time.play();
        this.vidaPokemon2Num = (vidaPokemon2Num) - pokemonUsuario.getLabelPokemon().getAtk2Numero();
        if (this.vidaPokemon2Num < 0) {
            this.vidaPokemon2Num = 0;
        }
        time2 = new Timeline(new KeyFrame(Duration.seconds(1.5), lam -> pokemon2Vida.setText(String.valueOf(vidaPokemon2Num) + "/" + String.valueOf(pokemonInimigo.getLabelPokemon().getVida()))));
        time2.play();
    }*/

    //Metodos de Tocar Audio
    public void audioPlay() {
        audioLuta.play(20.0);
    }

    public void audioStop() {
        audioLuta.stop();
    }

    // Metodos de mover a setinha 
    public void moverRight() {
        posicaoX = posicaoX + 100;
        if (posicaoX > 276 && posicaoY == 250) {
            posicaoX = 276;
        } else if (posicaoX > 376) {
            posicaoX = 376;
        }
        botaoSelecaoDoPokemon.setX(posicaoX);
    }

    public void moverLeft() {
        posicaoX = posicaoX - 100;
        if (posicaoX < 276) {
            posicaoX = 276;
        }
        botaoSelecaoDoPokemon.setX(posicaoX);
    }

    public void moverUp() {
        posicaoY = posicaoY - 30;
        if (posicaoY < 280 && posicaoX == 376) {
            posicaoY = 280;
        }
        if (posicaoY < 250) {
            posicaoY = 250;
        }
        botaoSelecaoDoPokemon.setY(posicaoY);
    }

    public void moverDown() {
        posicaoY = posicaoY + 30;
        if (posicaoY > 280) {
            posicaoY = 280;
        }
        botaoSelecaoDoPokemon.setY(posicaoY);
    }

    //Metodo para dar Sleep. Quando o usuario clica em SAIR, ele da uma pequena pausa
    public void Sleep(Stage stage, Scene scene) {
        Label fugir = new Label("O pókemon " + pokemonUsuario.getLabelPokemon().getNome() + " está tentando fugir...");
        Label pontinhos = new Label("... ... ...");
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(3), temp -> root.getChildren().add(pontinhos)));
        Timeline time2 = new Timeline(new KeyFrame(Duration.seconds(3), temp -> root.getChildren().removeAll(fugir, pontinhos)));
        Timeline time3 = new Timeline(new KeyFrame(Duration.seconds(0.1), temp -> stage.setScene(scene)));
        fugir.setLayoutX(-210);
        fugir.setLayoutY(245);
        fugir.setFont(font2);
        fugir.setTextFill(Color.WHITE);
        fugir.setScaleX(0.35);
        fugir.setScaleY(0.8);
        root.getChildren().add(fugir);
        pontinhos.setLayoutX(-190);
        pontinhos.setLayoutY(250);
        pontinhos.setFont(font2);
        pontinhos.setTextFill(Color.WHITE);
        pontinhos.setScaleX(1);
        pontinhos.setScaleY(1);
        SequentialTransition sequenciaDeTime = new SequentialTransition(time, time2, time3);
        sequenciaDeTime.play();
    }
    // Verificar se algum pokemon perdeu
    public int statusDeVitoriaDoPokemon(){
        int num = 0;
        if(getVidaPokemon1Num() == 0)
            num = 1;
        else if(getVidaPokemon2Num() == 0)
            num = 0;
        return num;
    }
    public void setarTelasPerdeuVenceu() {
        switch (statusDeVitoriaDoPokemon()) {
            case 0:
                img = imgVenceu;
                break;
            case 1:
                img = imgPerdeu;
                break;
        }
        finalizarFase2++;
        if(finalizarFase2 == 2) img = imgFinal;
        img.setScaleX(0.9);
        img.setScaleY(1);
        img.setLayoutX(-60);
        img.setLayoutY(-15);
        
        FadeTransition fade = new FadeTransition(Duration.seconds(2), img);
        fade.setFromValue(1);
        fade.setToValue(0.5);
        fade.setCycleCount((int) 1f);
        fade.setAutoReverse(true);
        root.getChildren().addAll(img);
        fade.play();

    }
    void removerTelaPerdeuVenceu() {
      root.getChildren().removeAll(img);
      setStatusTelaPreta(false);
    }
    // Criar um settezão
    //metodos Getters
    public double getPosicaoX() {
        return posicaoX;
    }

    public double getPosicaoY() {
        return posicaoY;
    }

    public int getVidaPokemon1Num() {
        return vidaPokemon1Num;
    }

    public int getVidaPokemon2Num() {
        return vidaPokemon2Num;
    }

    public void setVidaPokemon1Num(int vidaPokemon1Num) {
        this.vidaPokemon1Num = vidaPokemon1Num;
    }

    public void setVidaPokemon2Num(int vidaPokemon2Num) {
        this.vidaPokemon2Num = vidaPokemon2Num;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatusTelaPreta() {
        return statusTelaPreta;
    }

    public void setStatusTelaPreta(boolean statusTelaPreta) {
        this.statusTelaPreta = statusTelaPreta;
    }

    public boolean getStatusDeATKInimigo() {
        return permitirTeclaSpace;
    }

    public boolean getPermitirTeclaSpace() {
        return permitirTeclaSpace;
    }
    
    public void setPermitirTeclaSpace(boolean permitirTeclaSpace) {
        this.permitirTeclaSpace = permitirTeclaSpace;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
    
}
