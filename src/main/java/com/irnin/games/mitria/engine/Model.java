package com.irnin.games.mitria.engine;

import com.irnin.games.mitria.Directions;
import com.irnin.games.mitria.entity.Player;



public class Model {
    public Player player;


    // INPUTS
    public boolean upPressed, downPressed, leftPressed, rightPressed, displayDebugInfo;
    public int FPS = 0;

    public Model() {
        player = new Player();

        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
        displayDebugInfo = false;
    }

    public void update(double deltaTime) {

    }

    public void movePlayer(int dx, int dy, Directions direction) {
        player.walkAnimation();

        // Threshold - player movement bounds
        if( ((player.screenX + (dx * 3)) >= 0) && ((player.screenX + (dx * 3)) <= Game.getGAME_WIDTH()) )
        {
            this.player.screenX += (dx * 3);
        }

        if( (player.screenY + (dy * 3)) >= 0 && ((player.screenY + (dy * 3)) <= Game.getGAME_HEIGHT()) )
        {
            this.player.screenY += (dy * 3);
        }

        player.setDirection(direction);
        updateXY();
    }
    protected void updateXY() {
        Game.xLabel.setText("X = " + player.screenX);
        Game.yLabel.setText("Y = " + player.screenY);
        Game.xLabel.repaint();
        Game.yLabel.repaint();
    }
}

