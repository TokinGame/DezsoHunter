package hu.tokingame.donto.Bodies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyBaseClasses.WorldActorGroup;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by M on 2/3/2017.
 */

public class DeadPigButt extends WorldActorGroup {
    private OneSpriteStaticActor actor;

    public DeadPigButt(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "sample", BodyDef.BodyType.DynamicBody, 0, 0.2f, 5, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.MALAC_SEGG));
        setSize(1f,1f);
        actor.setSize(1f,1f);
        addActor(actor);
        setPosition(x,y);
        addToWorld();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getBody() == null) return;
        getBody().applyForceToCenter(new Vector2(150*delta, 0), true);
    }
}
