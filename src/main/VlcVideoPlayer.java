package main;

/**
 *
 * @author shaines
 */
public class VlcVideoPlayer extends AbstractVideoPlayer implements Runnable
{
    private Process process;

    /**
     * Starts playing the specified file
     *
     * @param filename      The name of the file to start playing
     */
    @Override
    public void start( String filename )
    {
        try
        {
            // Mark our playing status as true
            playing = true;

            // Save the filename to our base class
            this.filename = filename;

            // Build the command that executes VLC
            StringBuilder sb = new StringBuilder();
            sb.append( "vlc " );
            sb.append( "-f " ).append( FileSystemUtils.getFileUri( filename ) );

            if( fullScreen )
            {
                sb.append( " --fullscreen " );
            }
            else
            {
                sb.append( " --no-fullscreen " );
            }

            System.out.println( "VLC execution command: " + sb );

            // Execute VLC and save the process
            process = Runtime.getRuntime().exec( sb.toString() );

            // Start a thread that will monitor the activity of the playback
            Thread thread = new Thread( this );
            thread.start();

            // Notify our listeners that the video playback has started
            firePlayerStarted( filename );

        }
        catch( Exception e )
        {
            e.printStackTrace();
            playing = false;
        }
    }

    @Override
    public void run()
    {
        try
        {
            // Wait for the process to complete
            int response = process.waitFor();
            System.out.println( filename + " completed playing with return code: " + response );

            // Note that we are no longer playing
            playing = false;

            // Notify our listeners that playback has completed
            firePlayerComplete();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

}
