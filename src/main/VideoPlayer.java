package main;

public interface VideoPlayer
{
    /**
     * Starts playing the specified file
     *
     * @param filename      The name of the file to start playing
     */
    public void start( String filename );

    /**
     * Returns true if the video player is set to play in full screen mode, false otherwise
     *
     * @return              True if the video player is set to play in full screen mode, otherwise false
     */
    public boolean isFullScreen();

    /**
     * Sets the video player's full screen mode: true means that it should play in full screen
     * mode, false means it should play in windowed mode.
     * 
     * @param fullScreen    True to play in full screen, false to play in windowed mode
     */
    public void setFullScreen( boolean fullScreen );

    /**
     * Returns true if the current file is playing, otherwise false
     *
     * @return              True if the current file is playing, otherwise false
     */
    public boolean isPlaying();

    /**
     * Returns the name of the current file that is playing
     *
     * @return              The name of the current file that is playing
     */
    public String getFilename();

    /**
     * Adds a player event listener to the player
     *
     * @param listener      The Player event listener to add
     */
    public void addPlayerListener( VideoPlayerListener listener );

    /**
     * Removes a player event listener to the player
     *
     * @param listener      The Player event listener to remove
     */
    public void removePlayerListener( VideoPlayerListener listener );
}