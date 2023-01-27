// utility stuff
import java.util.ArrayList;

// graphics stuff
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JPanel {

    private int framesPerSecond = 25;
    private int msPerFrame = 1000 / framesPerSecond;

    private int canvasWidth;
    private int canvasHeight;

    private Color backgroundColor;

    private ArrayList<GraphicsObject> objects;

    /* Constructor for a window/canvas of a specified size, with a specific background color
     *
     * @param width  The width of the canvas.
     * @param height The height of the canvas.
     * @param color  The background color of the canvas
     */
    public Animation(int width, int height, Color color) {
        this.canvasWidth = width;
        this.canvasHeight = height;
        this.backgroundColor = color;
        this.objects = new ArrayList<GraphicsObject>();
    }

    /* Creates the window and shows it
     */
    public void showCanvas() {
        JFrame frame = new JFrame("Animation");
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = new Dimension(this.canvasWidth, this.canvasHeight);
        frame.getContentPane().setPreferredSize(dim);
        frame.pack();
        frame.setVisible(true);
    }

    /* Convenience function to paint all objects.
     */
    public void paint() {
        this.paint(this.getGraphics());
    }

    /* Paint/Draw the canvas.
     *
     * This function overrides the paint function in JPanel. This function is
     * automatically called when the panel is made visible.
     *
     * @param g The Graphics for the JPanel
     */
    @Override
    public void paint(Graphics g) {
        //  clear the canvas before painting
        Color oldColor = g.getColor();
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
        g.setColor(oldColor);

        // use a for-each loop to draw each object
        for (GraphicsObject obj : this.objects) {
            obj.draw(g);
        }
    }

    /* Update the canvas.
     *
     * This function updates each object in the ArrayList
     *
     * @param frame The number of frames since the start of the animation
     */
    public void update(int frame) {
        for (GraphicsObject obj : this.objects) {
            obj.update(this.canvasWidth, this.canvasHeight, frame);
        }
    }


    /* Add an object to be drawn.
     *
     * @param obj The object to draw.
     */
    public void addObject(GraphicsObject obj) {
        this.objects.add(obj);
    }

    public static void main(String[] args)
            throws InterruptedException{ // calls sleep(), thus need to "throw InterruptedException"
        // make a picture that is 560x560 pixels
        Animation pic = new Animation(560, 560, Color.WHITE);

        /*Rectangle fred = new Rectangle(0, 35, 50, 50, new Color(154, 8, 178));
        fred.speed_x = 5;
        fred.speed_y = 5;
        pic.addObject(fred);

        Rectangle george = new Rectangle(300, 0, 75, 75, Color.ORANGE);
        george.speed_x = -2;
        george.speed_y = 2;
        pic.addObject(george);
        */


        Rectangle road = new Rectangle(0, 400, 560, 160, new Color(0, 0, 0));
        //road.speed_x=0;
        pic.addObject(road);

        Line line1 = new Line(0, 472, 56, 12, new Color(255, 255, 255));
        line1.speed_x=10;
        pic.addObject(line1);

        Line line2 = new Line(120, 472, 56, 12, new Color(255, 255, 255));
        line2.speed_x=10;
        pic.addObject(line2);

        Line line3 = new Line(240, 472, 56, 12, new Color(255, 255, 255));
        line3.speed_x=10;
        pic.addObject(line3);

        Line line4 = new Line(360, 472, 56, 12, new Color(255, 255, 255));
        line4.speed_x=10;
        pic.addObject(line4);

        Rectangle car = new Rectangle(200, 320, 180, 120, new Color(147, 35, 57));
        pic.addObject(car);

        Rectangle window1 = new Rectangle(220, 340, 25, 40, new Color(35, 85, 147));
        pic.addObject(window1);

        Circle circle1 = new Circle(220, 420, 50, 50, new Color(132, 132, 124));
        pic.addObject(circle1);

        Circle circle2 = new Circle(310, 420, 50, 50, new Color(132, 132, 124));
        pic.addObject(circle2);

        Sign sign1 = new Sign(270, 340, 30, 60, new Color(35, 85, 147));
        pic.addObject(sign1);

        Rectangle sign12 = new Rectangle(280, 340, 20, 50, new Color(147, 35, 57));
        pic.addObject(sign12);

        Sign sign2 = new Sign(320, 340, 30, 60, new Color(35, 85, 147));
        pic.addObject(sign2);

        Rectangle sign22 = new Rectangle(330, 350, 10, 20, new Color(147, 35, 57));
        pic.addObject(sign22);

        Rectangle sign23 = new Rectangle(330, 380, 10, 20, new Color(147, 35, 57));
        pic.addObject(sign23);

        Rectangle car2 = new Rectangle(0, 400, 180, 120, new Color(18, 203, 160));
        car2.speed_x=3;
        pic.addObject(car2);

        Rectangle window2 = new Rectangle(20, 420, 25, 40, new Color(35, 85, 147));
        window2.speed_x=3;
        pic.addObject(window2);

        Circle circle3 = new Circle(20, 500, 50, 50, new Color(132, 132, 124));
        circle3.speed_x=3;
        pic.addObject(circle3);

        Circle circle4 = new Circle(110, 500, 50, 50, new Color(132, 132, 124));
        circle4.speed_x=3;
        pic.addObject(circle4);

        pic.showCanvas();

        // pause for 0.5 seconds
        Thread.sleep(500);

        // start the animation
        int frame = 0;
        while (true) {
            // update every object
            pic.update(frame);
            // draw every object
            pic.paint();
            // pause between frames
            Thread.sleep(pic.msPerFrame);
            // increment the frame counter
            frame++;
        }



    }
}