package com.github.ybq.android.spinkit.style;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;
import androidx.core.app.NotificationManagerCompat;
import com.github.ybq.android.spinkit.animation.SpriteAnimatorBuilder;
import com.github.ybq.android.spinkit.sprite.CircleSprite;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.sprite.SpriteContainer;

public class ChasingDots extends SpriteContainer {
    public Sprite[] onCreateChild() {
        return new Sprite[]{new Dot(), new Dot()};
    }

    public void onChildCreated(Sprite... sprites) {
        super.onChildCreated(sprites);
        if (Build.VERSION.SDK_INT >= 24) {
            sprites[1].setAnimationDelay(1000);
        } else {
            sprites[1].setAnimationDelay(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        }
    }

    public ValueAnimator onCreateAnimation() {
        return new SpriteAnimatorBuilder(this).rotate(new float[]{0.0f, 1.0f}, 0, 360).duration(2000).interpolator(new LinearInterpolator()).build();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        Rect bounds2 = clipSquare(bounds);
        int drawW = (int) (((float) bounds2.width()) * 0.6f);
        getChildAt(0).setDrawBounds(bounds2.right - drawW, bounds2.top, bounds2.right, bounds2.top + drawW);
        getChildAt(1).setDrawBounds(bounds2.right - drawW, bounds2.bottom - drawW, bounds2.right, bounds2.bottom);
    }

    private class Dot extends CircleSprite {
        Dot() {
            setScale(0.0f);
        }

        public ValueAnimator onCreateAnimation() {
            float[] fractions = {0.0f, 0.5f, 1.0f};
            SpriteAnimatorBuilder spriteAnimatorBuilder = new SpriteAnimatorBuilder(this);
            Float valueOf = Float.valueOf(0.0f);
            return spriteAnimatorBuilder.scale(fractions, valueOf, Float.valueOf(1.0f), valueOf).duration(2000).easeInOut(fractions).build();
        }
    }
}
