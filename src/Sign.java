import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class Sign extends Rectangle{
    public Sign(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    @Override
    public void update(int pic_width, int pic_height, int frame) {
       // we can also change color
        Random randy = new Random();
        this.color = new Color(
                randy.nextInt(255),
                randy.nextInt(255),
                randy.nextInt(255)
        );

        // let the superclass' update function handle the actual changes to x and y
        super.update(pic_width, pic_height, frame);
    }
}
