

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

    BowlingGame game;
    
    @Before
    public void clean() {
    	this.game = null;
    	CasualFrame[] casualFrames = {
    		new CasualFrame(0, 0, ThrowDetail.NONE, ThrowDetail.NONE),
    		new CasualFrame(0, 0, ThrowDetail.NONE, ThrowDetail.NONE),
    		new CasualFrame(0, 0, ThrowDetail.NONE, ThrowDetail.NONE),
    		new CasualFrame(0, 0, ThrowDetail.NONE, ThrowDetail.NONE),
    		new CasualFrame(0, 0, ThrowDetail.NONE, ThrowDetail.NONE),
    		new CasualFrame(0, 0, ThrowDetail.NONE, ThrowDetail.NONE),
    		new CasualFrame(0, 0, ThrowDetail.NONE, ThrowDetail.NONE),
    		new CasualFrame(0, 0, ThrowDetail.NONE, ThrowDetail.NONE),
    		new CasualFrame(0, 0, ThrowDetail.NONE, ThrowDetail.NONE)
    	};
    	FinalFrame finalFrame = new FinalFrame(0, 0, 0, ThrowDetail.NONE, ThrowDetail.NONE, ThrowDetail.NONE);
    	this.game = new BowlingGame(casualFrames, finalFrame);
    }

    @Test
    public void queDesGoutieresDonne0Points() { 
        assertThat(game.getScore(), is(0));
    	assertThat(game.getFrames().size(), is(10));
    }
    
    @Test
    public void deuxQuillesEtDesFautes(){
    	game.getFrames().remove(0);
    	game.getFrames().add(0, new CasualFrame(1, 0, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	game.getFrames().remove(3);
    	game.getFrames().add(3, new CasualFrame(0, 1, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	game.getFrames().remove(5);
    	game.getFrames().add(5, new CasualFrame(0, 1, ThrowDetail.FAULT, ThrowDetail.NONE));
    	
    	game.getFrames().remove(6);
    	game.getFrames().add(6, new CasualFrame(0, 1, ThrowDetail.FAULT, ThrowDetail.NONE));
    	
        assertThat(game.calculateThisScore(), is(2));
    	assertThat(game.getFrames().size(), is(10));
    }
    
    @Test
    public void strikeDoubleEtSpareSuiviParFaute(){
    	game.getFrames().remove(0);
    	game.getFrames().add(0, new CasualFrame(10, 0, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	game.getFrames().remove(1);
    	game.getFrames().add(1, new CasualFrame(10, 0, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	game.getFrames().remove(2);
    	game.getFrames().add(2, new CasualFrame(7, 3, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	game.getFrames().remove(3);
    	game.getFrames().add(3, new CasualFrame(1, 0, ThrowDetail.NONE, ThrowDetail.FAULT));
    	
    	/** (10+10) strike + (10+7+3) strike + (10 + 1) spare + 0 car faute*/
        assertThat(game.calculateThisScore(), is(51));
    	assertThat(game.getFrames().size(), is(10));
    }
    
    @Test
    public void avecUnLancerIncoherent(){
    	game.getFrames().remove(0);
    	game.getFrames().add(0, new CasualFrame(10, 0, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	game.getFrames().remove(1);
    	game.getFrames().add(1, new CasualFrame(10, 0, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	game.getFrames().remove(2);
    	game.getFrames().add(2, new CasualFrame(7, 3, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	game.getFrames().remove(3);
    	game.getFrames().add(3, new CasualFrame(10, 0, ThrowDetail.FAULT, ThrowDetail.NONE));
    	
    	/** (10+10) strike + (10+7+3) strike + (10 + 0) spare + 0 car faute*/
        assertThat(game.calculateThisScore(), is(50));
    	assertThat(game.getFrames().size(), is(10));
    }
    
    @Test
    public void strikeSurLaDerniereFrame(){
    	game.getFrames().remove(9);
    	game.getFrames().addLast(new FinalFrame(10, 0, 10, ThrowDetail.NONE, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	assertThat(game.getFrames().size(), is(10));
        assertThat(game.calculateThisScore(), is(20));
    }
    
    @Test
    public void strikeSurLaDerniereFrameMaisFaute3emeLancer(){
    	game.getFrames().remove(9);
    	game.getFrames().addLast(new FinalFrame(10, 0, 10, ThrowDetail.NONE, ThrowDetail.NONE, ThrowDetail.FAULT));
    	
    	assertThat(game.getFrames().size(), is(10));
        assertThat(game.calculateThisScore(), is(10));
        assertThat(game.getFrames().get(9), instanceOf(FinalFrame.class));
    }
    
    @Test
    public void spareSurLaDerniereFrame(){
    	game.getFrames().remove(9);
    	game.getFrames().addLast(new FinalFrame(6, 4, 8, ThrowDetail.NONE, ThrowDetail.NONE, ThrowDetail.NONE));
    	
    	assertThat(game.getFrames().size(), is(10));
        assertThat(game.calculateThisScore(), is(18));
    }
}
