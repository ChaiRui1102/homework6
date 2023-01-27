import java.awt.Color;
import java.awt.Graphics;
public class Line extends Rectangle {
    /*
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

     */

    public Line(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void update (int pic_width, int pic_height, int frame) {
        /*
        // this will make rectangles bounce off the side of the window
        if (this.x < 0 || this.x + this.getWidth() > pic_width) {
            this.speed_x = - this.speed_x;
        }

        if (this.y < 0 || this.y + this.getHeight() > pic_height) {
            this.speed_y = - this.speed_y;
        }


         */

        //loop the traffic line back to the left of the canvas
        if (this.x + this.getWidth() > pic_width){
            this.x=0;
        }
        super.update(pic_width, pic_height, frame);
    }

}
