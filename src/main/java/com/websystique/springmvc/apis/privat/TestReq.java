package com.websystique.springmvc.apis.privat;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class TestReq {

    public static String test(String argUrl,String requestXml){
        String res = "";
        try
        {
            URL url = new URL( argUrl );
            URLConnection con = url.openConnection();
            // specify that we will send output and accept input
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setConnectTimeout( 20000 );  // long timeout, but not infinite
            con.setReadTimeout( 20000 );
            con.setUseCaches (false);
            con.setDefaultUseCaches (false);
            // tell the web server what we are sending
            con.setRequestProperty ( "Content-Type", "text/xml" );
            OutputStreamWriter writer = new OutputStreamWriter( con.getOutputStream() );
            writer.write( requestXml );
            writer.flush();
            writer.close();
            // reading the response
            InputStreamReader reader = new InputStreamReader( con.getInputStream() );
            StringBuilder buf = new StringBuilder();
            char[] cbuf = new char[ 2048 ];
            int num;
            while ( -1 != (num=reader.read( cbuf )))
            {
                buf.append( cbuf, 0, num );
            }
            String result = buf.toString();
            res = result;
            System.err.println( "\nResponse from server after POST:\n" + result );
        }
        catch( Throwable t )
        {
            t.printStackTrace( System.out );
        }
        return res;
    }
}
