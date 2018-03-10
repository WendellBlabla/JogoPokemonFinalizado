/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Wendell
 */
public class Main extends Application {

    public static void Lauch(String[] args) {
        launch(args);
    }
    
    private AudioClip audioClick = new AudioClip(getClass().getResource("/audio/ClickPokemon.mp3").toString());
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Menu
        Pane rootMenu = new Pane();
        MenuJogo menuJogo = new MenuJogo(rootMenu, 482, 318, Color.BLACK);
        menuJogo.audioPlay();
        primaryStage.setScene(menuJogo);
        //2ª tela
        Pane rootSelect = new Pane();
        TelaDeSelect telaDeSelect = new TelaDeSelect(rootSelect, 482, 318, Color.CORNFLOWERBLUE);
        //3ª tela
        Pane rootLuta = new Pane();
        Fase fase = new Fase(rootLuta, 482, 318, Color.BLACK);

        menuJogo.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    audioClick.play(100);
                    menuJogo.audioStop();
                    telaDeSelect.audioPlay();
                    primaryStage.setScene(telaDeSelect);
                }
            }
        });

        telaDeSelect.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.RIGHT)) {
                    telaDeSelect.moverRight();
                }
                if (event.getCode().equals(KeyCode.LEFT)) {
                    telaDeSelect.moverLeft();
                }
                if (event.getCode().equals(KeyCode.DOWN)) {
                    telaDeSelect.moverDown();
                }
                if (event.getCode().equals(KeyCode.UP)) {
                    telaDeSelect.moverUP();
                }
                if (event.getCode().equals(KeyCode.ENTER)) {
                    audioClick.play(100);
                    telaDeSelect.audioStop();
                    fase.getLutaPokemon().audioPlay();
                    fase.setPokemons(telaDeSelect.getSelectPokemon());
                    primaryStage.setScene(fase.getLutaPokemon());
                }
                if (event.getCode().equals(KeyCode.ESCAPE)) {
                    audioClick.play(100);
                    telaDeSelect.audioStop();
                    menuJogo.audioPlay();
                    telaDeSelect.setPosiX(10);
                    telaDeSelect.setPosiY(30);
                    primaryStage.setScene(menuJogo);
                }
            }
        });
        fase.getLutaPokemon().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.RIGHT)) {
                    fase.getLutaPokemon().moverRight();
                }
                if (event.getCode().equals(KeyCode.LEFT)) {
                    fase.getLutaPokemon().moverLeft();
                }
                if (event.getCode().equals(KeyCode.UP)) {
                    fase.getLutaPokemon().moverUp();
                }
                if (event.getCode().equals(KeyCode.DOWN)) {
                    fase.getLutaPokemon().moverDown();
                }
                if (event.getCode().equals(KeyCode.ENTER)) {
                        audioClick.play(100);
                    if (fase.getLutaPokemon().getPosicaoX() == 276 && fase.getLutaPokemon().getPosicaoY() == 250) {
                        fase.getLutaPokemon().setStatus(true);
                        fase.getLutaPokemon().barraDeAtaques(0);
                    }
                    if (fase.getLutaPokemon().getPosicaoX() == 376 && fase.getLutaPokemon().getPosicaoY() == 280) {
                        fase.getLutaPokemon().audioStop();
                        menuJogo.audioPlay();
                        fase.getLutaPokemon().Sleep(primaryStage, menuJogo);
                    }
                    if (fase.getLutaPokemon().getPosicaoX() == 276 && fase.getLutaPokemon().getPosicaoY() == 280) {
                        fase.getLutaPokemon().audioStop();
                        telaDeSelect.audioPlay();
                        telaDeSelect.setPosiX(10);
                        telaDeSelect.setPosiY(30);
                        primaryStage.setScene(telaDeSelect);
                    }
                }
                if (event.getCode().equals(KeyCode.DIGIT1)) { // Pega o evento  da tecla 1
                    if (fase.getLutaPokemon().getStatus() == true) {
                        fase.getLutaPokemon().barraDeAtaques(1);
                        fase.getLutaPokemon().atkArranha(0);
                        fase.getLutaPokemon().setStatus(false);
                        fase.getLutaPokemon().decidirATKInimigo();
                    }
                }
                if (event.getCode().equals(KeyCode.DIGIT2)) { //Pega o evento  da tecla 2
                    if (fase.getLutaPokemon().getStatus()) {
                        fase.getLutaPokemon().barraDeAtaques(1);
                        fase.getLutaPokemon().atkMordida(0);
                        fase.getLutaPokemon().setStatus(false);
                        fase.getLutaPokemon().decidirATKInimigo();
                    }
                }
                if(event.getCode().equals(KeyCode.SPACE)){
                    if(fase.getLutaPokemon().getPermitirTeclaSpace()){
                    if(fase.getLutaPokemon().statusDeVitoriaDoPokemon() == 0){
                    System.out.println("Passei por aqui");
                       fase.getLutaPokemon().setStatusTelaPreta(true);
                       primaryStage.setScene(null);
                       primaryStage.setScene(fase.fase2());
                        fase.finalizarFase2(primaryStage, menuJogo );
                    }
                    fase.getLutaPokemon().setPermitirTeclaSpace(false);
                    }
                }
                /* 
                if (event.getCode().equals(KeyCode.DIGIT3)) { //Pega o evento  da tecla 3
                    lutaPokemon.barraDeAtaques(1);
                }
                if (event.getCode().equals(KeyCode.DIGIT4)) { // Pega o evento  da tecla 4
                    lutaPokemon.barraDeAtaques(1);
                }
                */
            }
        });
        primaryStage.setResizable(false);
        primaryStage.setTitle("Pokémon");
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(1);
            }
        });
    }

}
