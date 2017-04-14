package main;

public interface VideoPlayerListener
{
    /**
     * A Video playback has started
     *
     * @param filename          The name of the file being played
     */
    public void playerStarted( String filename );

    /**
     * A Video playback has completed
     */
    public void playerComplete();
}