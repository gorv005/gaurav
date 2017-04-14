package main;

import java.io.File;

/**
 * File System Utilities
 * 
 * @author shaines
 */
public class FileSystemUtils
{
    /**
     * Converts the filename String into a File URI String of the form: file:///full/path/to/file.ext
     * 
     * @param filename      The name of the file to convert to a file URI
     * 
     * @return              The file URI String
     */
    public static String getFileUri( String filename )
    {
        try
        {
            File f = new File( filename );
            String fileUrl = f.toURI().toString(); 
            return "file://" + fileUrl.substring( 5 );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        return null;
    }
}