package ushahidiLab;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import edu.grinnell.glimmer.ushahidi.UshahidiCategory;
import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;
import edu.grinnell.glimmer.ushahidi.UshahidiTestingClient;
import edu.grinnell.glimmer.ushahidi.UshahidiUtils;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;


public class UshahidiExpt
{
  public static void main(String[] args) 
      throws Exception
    {
      // Create the output device
      PrintWriter pen = new PrintWriter(System.out, true);

      // A few basic incidents
      //UshahidiExtensions.printIncident(pen, UshahidiUtils.SAMPLE_INCIDENT);
      //UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());
     //UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());
      
      // A newly created incident
      UshahidiIncident myIncident = new UshahidiIncident(2, "dkfjdkj", 
                                                         LocalDateTime.of(2014, Month.APRIL, 23, 23, 23), 
                                                         (new UshahidiLocation()), 
                                                         "assignment 7", 
                                                         new UshahidiCategory[] { new UshahidiCategory(2) });
    // UshahidiExtensions.printIncident(pen, myIncident);
     UshahidiTestingClient tests = UshahidiExtensions.TestSuite();
     
     UshahidiExtensions.dateIncident(pen, (new UshahidiWebClient("http://ushahidi1.grinnell.edu/sandbox")), 
                                     LocalDateTime.of(2014, Month.APRIL, 1, 1,1), 
                                     LocalDateTime.of(2014, Month.DECEMBER, 1, 1, 1));
     

      // One from a list
     UshahidiClient client = UshahidiUtils.SAMPLE_CLIENT;
     //UshahidiExtensions.printIncident(pen, client.nextIncident());

      // One that requires connecting to the server
     // UshahidiClient webclient = new UshahidiWebClient("www.ushahidi.com");
    //  UshahidiExtensions.printIncident(pen, webclient.nextIncident());
    } // main(String[])
}
