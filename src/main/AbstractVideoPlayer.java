package main;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author shaines
 */
public abstract class AbstractVideoPlayer implements VideoPlayer
{
    protected String filename;
    protected boolean playing = false;
    private Set<VideoPlayerListener> listeners = new HashSet<VideoPlayerListener>();
    protected boolean fullScreen = false;


    public AbstractVideoPlayer()
    {
    }

    public AbstractVideoPlayer( String filename )
    {
        this.filename = filename;
    }

    /**
     * Returns true if the current file is playing, otherwise false    /**
     * Returns true if the video player is set to play in full screen mode, false otherwise
     *
     * @return              True if the video player is set to play in full screen mode, otherwise false
     */
    @Override
    public boolean isFullScreen()
    {
        return fullScreen;
    }

    /**
     * Sets the video player's full screen mode: true means that it should play in full screen
     * mode, false means it should play in windowed mode.
     *
     * @param fullScreen    True to play in full screen, false to play in windowed mode
     */
    @Override
    public void setFullScreen( boolean fullScreen )
    {
        this.fullScreen = fullScreen;
    }

    /*
     *
     * @return              True if the current file is playing, otherwise false
     */
    @Override
    public boolean isPlaying()
    {
        return playing;
    }

    /**
     * Returns the name of the current file that is playing
     *
     * @return              The name of the current file that is playing
     */
    @Override
    public String getFilename()
    {
        return filename;
    }

    protected void setFilename( String filename )
    {
        this.filename = filename;
    }

    /**
     * Adds a player event listener to the player
     *
     * @param listener      The Player event listener to add
     */
    @Override
    public void addPlayerListener( VideoPlayerListener listener )
    {
        listeners.add( listener );
    }

    /**
     * Removes a player event listener to the player
     *
     * @param listener      The Player event listener to remove
     */
    @Override
    public void removePlayerListener( VideoPlayerListener listener )
    {
        listeners.remove( listener );
    }

    /**
     * Notifies all listeners that the player has started
     *
     * @param filename      The name of the file that started playing
     */
    protected void firePlayerStarted( String filename )
    {
        for( VideoPlayerListener listener : listeners )
        {
            listener.playerStarted( filename );
        }
    }

    /**
     * Notifies all listeners that the player has completed
     */
    protected void firePlayerComplete()
    {
        for( VideoPlayerListener listener : listeners )
        {
            listener.playerComplete();
        }
    }

}
