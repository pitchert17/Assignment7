package ushahidiLab;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import edu.grinnell.glimmer.ushahidi.UshahidiCategory;
import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;
import edu.grinnell.glimmer.ushahidi.UshahidiTestingClient;

public class UshahidiExtensions
{
  public static void printIncident(PrintWriter pen, UshahidiIncident inc)
  {
    pen.println("Incident #:" + inc.getId());
    pen.println(inc.getDescription());
    pen.println("Location :" + inc.getLocation());
    pen.println("Status :" + inc.getMode() + "," + inc.getActive() + ","
                + inc.getVerified());
    pen.println("date :" + inc.getDate());
    pen.close();

  }

  public static void dateIncident(PrintWriter pen, UshahidiClient client,
                                  LocalDateTime start, LocalDateTime end)
    throws Exception
  {
    while (client.hasMoreIncidents() == true)
      {
       UshahidiIncident incident = new UshahidiIncident();
       incident = client.nextIncident();
        if (incident.getDate().isBefore(start) == false
            && incident.getDate().isAfter(end) == false)
          pen.println(incident);
        
      }
  }

  public static void dateIncidentVector(UshahidiClient client,
                                        LocalDateTime start, LocalDateTime end)
  {
    UshahidiIncident[] incidents = client.getIncidents();
    UshahidiIncident[] dated = new UshahidiIncident[incidents.length];
    int j = 0;
    for (int i = 0; i > incidents.length; i++)
      {
        if (incidents[i].getDate().isBefore(start) == false
            && incidents[i].getDate().isAfter(end) == false)
          {
            dated[j] = incidents[i];
            j++;
          }
      }
  }

  public static Vector distanceIncident (Vector<UshahidiIncident> incidents, double latitude, double longitude, double distance)
  {
    
    Vector<UshahidiIncident> incidentsInRange = new Vector<UshahidiIncident>(10,2);
      int i = 0;
      for (i = 0; i< incidents.size(); i++)
      {
        
        if (Math.pow((incidents.get(i).getLocation().getLatitude()-latitude),2) +
        Math.pow((incidents.get(i).getLocation().getLongitude()-longitude),2) <= Math.pow(distance, 2));
        {
          incidentsInRange.add(0, incidents.get(i));
        }        
      }
      return incidentsInRange;
  }
  
  public static UshahidiTestingClient TestSuite()
  {
        UshahidiIncident myIncident1 = new UshahidiIncident(1, "first", 
                                                           LocalDateTime.of(2014, Month.JANUARY, 23, 23, 23), 
                                                           (new UshahidiLocation()), 
                                                           "assignment 7", 
                                                           new UshahidiCategory[] { new UshahidiCategory(2) });
        
        UshahidiIncident myIncident2= new UshahidiIncident(2, "second", 
                                                            LocalDateTime.of(2014, Month.FEBRUARY, 13, 2, 3), 
                                                            (new UshahidiLocation()), 
                                                            "assignment 7", 
                                                            new UshahidiCategory[] { new UshahidiCategory(2) });

        UshahidiIncident myIncident3 = new UshahidiIncident(3, "third", 
                                                            LocalDateTime.of(2014, Month.MARCH, 17, 20, 6), 
                                                            (new UshahidiLocation()), 
                                                            "assignment 7", 
                                                            new UshahidiCategory[] { new UshahidiCategory(2) });

        UshahidiIncident myIncident4 = new UshahidiIncident(4, "fourth", 
                                                            LocalDateTime.of(2014, Month.APRIL, 1, 3, 3), 
                                                            (new UshahidiLocation()), 
                                                            "assignment 7", 
                                                            new UshahidiCategory[] { new UshahidiCategory(2) });
        
        UshahidiIncident myIncident5 = new UshahidiIncident(5, "fifth", 
                                                            LocalDateTime.of(2014, Month.MAY, 5, 5, 9), 
                                                            (new UshahidiLocation()), 
                                                            "assignment 7", 
                                                            new UshahidiCategory[] { new UshahidiCategory(2) });
                  
        UshahidiIncident myIncident6 = new UshahidiIncident(6, "sixth", 
                                                            LocalDateTime.of(2014, Month.JUNE, 18, 3, 4), 
                                                            (new UshahidiLocation()), 
                                                            "assignment 7", 
                                                            new UshahidiCategory[] { new UshahidiCategory(2) });

        UshahidiIncident myIncident7 = new UshahidiIncident(7, "seventh", 
                                                             LocalDateTime.of(2014, Month.JULY, 4, 3, 14), 
                                                             (new UshahidiLocation()), 
                                                             "assignment 7", 
                                                             new UshahidiCategory[] { new UshahidiCategory(2) });

        UshahidiIncident myIncident8 = new UshahidiIncident(8, "eight", 
                                                             LocalDateTime.of(2014, Month.AUGUST, 13, 6, 8), 
                                                             (new UshahidiLocation()), 
                                                             "assignment 7", 
                                                             new UshahidiCategory[] { new UshahidiCategory(2) });
                  
        UshahidiIncident myIncident9 = new UshahidiIncident(9, "ninth", 
                                                             LocalDateTime.of(2014, Month.SEPTEMBER, 8, 11, 23), 
                                                             (new UshahidiLocation()), 
                                                             "assignment 7", 
                                                              new UshahidiCategory[] { new UshahidiCategory(2) });
                   
        UshahidiIncident myIncident10 = new UshahidiIncident(10, "tenth", 
                                                              LocalDateTime.of(2014, Month.APRIL, 23, 23, 23), 
                                                              (new UshahidiLocation()), 
                                                              "assignment 7", 
                                                               new UshahidiCategory[] { new UshahidiCategory(2) });

        UshahidiIncident myIncident11 = new UshahidiIncident(11, "eleventh", 
                                                              LocalDateTime.of(2014, Month.APRIL, 20, 20, 20), 
                                                              (new UshahidiLocation()), 
                                                              "assignment 7", 
                                                              new UshahidiCategory[] { new UshahidiCategory(2) });

         UshahidiIncident myIncident12 = new UshahidiIncident(12, "tweleth", 
                                                               LocalDateTime.of(2014, Month.APRIL, 1, 1, 1), 
                                                               (new UshahidiLocation()), 
                                                                "assignment 7", 
                                                                new UshahidiCategory[] { new UshahidiCategory(2) });
         ArrayList<UshahidiIncident> tests = new ArrayList<UshahidiIncident>();
         tests.add(myIncident1);
         tests.add(myIncident2);
         tests.add(myIncident3);
         tests.add(myIncident4);
         tests.add(myIncident5);
         tests.add(myIncident6);
         tests.add(myIncident7);
         tests.add(myIncident8);
         tests.add(myIncident9);
         tests.add(myIncident10);
         tests.add(myIncident11);
         tests.add(myIncident12);
         UshahidiTestingClient TestSuite = new UshahidiTestingClient(tests);
        return TestSuite;
      }
  
}//class UshahidiExtensions
