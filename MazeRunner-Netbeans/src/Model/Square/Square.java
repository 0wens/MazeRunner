/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Square;

import Graphics.MyTexture;
import Controller.Component;
import Controller.Game;
import static Graphics.View.quadData;
import java.awt.Image;
import java.util.Random;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author asus
 */
public class Square {

    public int x, y;
    int xo = 0, yo = 0;
    boolean hasSquareSet = false;
    protected int size = 16;
    protected int halfsize = size / 2;

    float[] color = new float[]{1, 1, 1, 1};

    public int[] squareSprite = new int[]{0, 0, 0, 0, 0, 0, 0, 0};

    public int id;
    protected Image image;

    Squares square;

    public Square() {

    }
   

    public enum Squares {
        BRICK, EMPTY, FREEZE, APPLE, LADDER, GOAL, HYPER_0, HYPER_1,HYPER_2,HYPER_3,HYPER_4,HYPER_5,HYPER_6,HYPER_7,HYPER_8,HYPER_9,DOOR,KEY,GRAY,GRAY_APPLE,GRAY_KEY,GRAY_TIME
    }

    public Square(int x, int y, Squares square) {
        this.x = x;
        this.y = y;
        this.square = square;

        if (square == Squares.BRICK) {
            yo = 0;
            xo = 0;
            hasSquareSet = true;
        } else if (square == Squares.EMPTY) {
            yo = 0;
            xo = 1;
        } else if (square == Squares.FREEZE) {
            yo = 0;
            xo = 2;
        } else if (square == Squares.APPLE) {
            yo = 0;
            xo = 3;
        } else if (square == Squares.LADDER) {
            yo = 0;
            xo = 4;
        } else if (square == Squares.HYPER_0) {
            yo = 0;
            xo = 5;
        } else if (square == Squares.HYPER_1) {
            yo = 0;
            xo = 6;
        } else if (square == Squares.HYPER_2) {
            yo = 0;
            xo = 7;
        } else if (square == Squares.HYPER_3) {
            yo = 0;
            xo = 8;
        } else if (square == Squares.HYPER_4) {
            yo = 0;
            xo = 9;
        } else if (square == Squares.HYPER_5) {
            yo = 0;
            xo = 10;
        } else if (square == Squares.HYPER_6) {
            yo = 0;
            xo = 11;
        } else if (square == Squares.HYPER_7) {
            yo = 0;
            xo = 12;
        } else if (square == Squares.HYPER_8) {
            yo = 0;
            xo = 13;
        } else if (square == Squares.HYPER_9) {
            yo = 0;
            xo = 14;
        }else if (square == Squares.DOOR) {
            yo = 0;
            xo = 15;
        }else if (square == Squares.KEY) {
            yo = 0;
            xo = 16;
        }else if (square == Squares.GRAY) {
            yo = 0;
            xo = 17;
        }else if (square == Squares.GRAY_APPLE) {
            yo = 0;
            xo = 18;
        }else if (square == Squares.GRAY_KEY) {
            yo = 0;
            xo = 19;
        }
        else if (square == Squares.GRAY_TIME) {
            yo = 0;
            xo = 20;
        }

        if (hasSquareSet) {
            squareSprite = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        }
    }

    public void setSquareApple() {

        squareSprite[0] = -2;
        squareSprite[1] = -2;
        squareSprite[2] = 0;
        squareSprite[3] = -2;

    }
    
     public void setSquareKey() {

        squareSprite[0] = -15;
        squareSprite[1] = -15;
        squareSprite[2] = 0;
        squareSprite[3] = -15;

    }

    public void render() {
        float x0 = x + Game.xScroll / 16;
        float y0 = y + Game.yScroll / 16;
        
        if (x0 + 1 < 0 || y0 + 1 < 0 || x0 > Component.width / 16 || y0 > Component.height / 16) {
            return;
        }
        MyTexture.squares.bind();
        glBegin(GL_QUADS);

        if ((xo == 3 || xo == 0) && yo == 0) {
            quadData(this.x * size, this.y * size, this.halfsize, this.halfsize, this.color, xo + squareSprite[0], yo);
            quadData(this.x * size + 8, this.y * size, this.halfsize, this.halfsize, this.color, xo + squareSprite[1], yo);
            quadData(this.x * size + 8, this.y * size + 8, this.halfsize, this.halfsize, this.color, xo + squareSprite[2], yo);
            quadData(this.x * size, this.y * size + 8, this.halfsize, this.halfsize, this.color, xo + squareSprite[3], yo);
        } else {

            quadData(this.x * size, this.y * size, this.size, this.size, this.color, xo, yo);
        }

        glEnd();
        MyTexture.squares.unbind();
    }
//GETTER
    
    public int getId() {
        return id;
    }
    
    public int getX(){
        return this.x;
    }
    
     public int getY(){
        return this.y;
    }

     public Image getImage() {
        return image;
    }
  
    public Squares getSquare(){
        return this.square;
    }
     
//SETTER
     
    public void setId(int id) {
        this.id = id;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }

//OTHERS    
    
    public Square(int _id, Image _image) {
        this.id = _id;
        this.image = _image;
    }
    

}
