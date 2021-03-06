package hu.tokingame.donto.Bodies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.donto.Game1.GameStage;
import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyBaseClasses.WorldActorGroup;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by M on 2/3/2017.
 */

public class PowerUpActor extends WorldActorGroup {

    private OneSpriteStaticActor actor;
    private GameStage gameStage;
    public PowerUpActor(World world, WorldBodyEditorLoader loader, float x, float y, GameStage stage) {
        super(world, loader, "sample", BodyDef.BodyType.DynamicBody, 0, 0.2f, 5, false);
        addToWorld();
        gameStage = stage;
        actor = new OneSpriteStaticActor(randomtex());
        setSize(1f,1f);
        actor.setSize(1f,1f);
        addActor(actor);
        setPosition(x,y);

        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gameStage.enablePowerUP();
                tapped();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    public void tapped(){
        removeFromWorld();
    }

    private Texture randomtex(){
        switch(Globals.random(1,3)){
            case 1: return Assets.manager.get(Assets.PIA1);
            case 2: return Assets.manager.get(Assets.PIA2);
            case 3: return Assets.manager.get(Assets.PIA3);
            default: return Assets.manager.get(Assets.BL);
        }
    }
}
