package sample;

import com.sun.prism.Texture;

public class SpriteSheet {
    private Texture texture;
    private int width,height;

    public SpriteSheet(Texture texture,int size) {
        this.texture = texture;
        width=height=size;

    }// for cubic  images

    public SpriteSheet(Texture texture,int height,int width) {
        this.texture = texture;
        this.height=height;
        this.width=width;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
