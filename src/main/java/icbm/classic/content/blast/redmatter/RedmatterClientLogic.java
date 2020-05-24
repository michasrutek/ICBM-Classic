package icbm.classic.content.blast.redmatter;

import icbm.classic.config.blast.ConfigBlast;

/**
 * Handles client size logic for the redmatter
 *
 * Created by Dark(DarkGuardsman, Robert) on 5/23/2020.
 */
public class RedmatterClientLogic
{
    private float visualSize = 0.0F;
    private EntityRedmatter host;

    public RedmatterClientLogic(EntityRedmatter host) {
        this.host = host;
    }

    public float getScaleFactorClient()
    {
        return visualSize / ConfigBlast.REDMATTER.NORMAL_RADIUS;
    }

    /**
     * Triggered from the render to smoothly change size with each frame update
     *
     * @param deltaTick percentage of time passed (0.0 - 1.0f)
     */
    public void lerpSize(float deltaTick)
    {
        visualSize = visualSize + deltaTick * (host.getBlastSize() - visualSize);
    }
}
