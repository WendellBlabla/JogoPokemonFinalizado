/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Wendell
 */
public class Pokemon extends ImageView{
    
    public Pokemon(Image img, boolean presevar, double dimensao, double posicaoX, double posicaoY){
        this.setImage(img);
        this.setPreserveRatio(presevar);
        this.setFitWidth(dimensao);
        this.setX(posicaoX);
        this.setY(posicaoY);
    }
    
    
}
