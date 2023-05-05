// Print to File class
// Has the option to print the calender or a List or both

package scheduler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class PrintToFile
{
    Calendar calPrint;
    private HashMap <String,Day> data;

    public PrintToFile(Calendar myCal)
    {
        calPrint = myCal;
    }

    public void printCal(String directory)throws IOException
    {
        File myObj = new File(directory+"\\Calendar.txt");
        myObj.createNewFile();
        FileWriter myWriter = new FileWriter(directory+"\\Calendar.txt");
        
        

        data = calPrint.calendar;
        String[] dates = data.keySet().toArray(new String[data.keySet().size()]);
        String[] events;
        Event holder;
       
        HashMap<String,Event> currEvents;
        Arrays.sort(dates);



        for(int i = 0; i<dates.length; i++){
            myWriter.write(dates[i] + "\n----------------------------------------\n\n");
            currEvents = data.get(dates[i]).getEvents();
            events = data.keySet().toArray(new String[data.keySet().size()]);
            for(int j = 0; j<events.length;j++){
                holder = currEvents.get(events[j]);
                System.out.println(holder.getEventName() + ":\n" + holder.getStartTime() + " til " + holder.getEndTime());
                if(holder.getReminderTime() != -1){
                    System.out.println("With a reminder " + holder.getReminderTime() + " before");
                }
                System.out.println("\n");
            }
        }



        myWriter.close();
        //print the calender to file
    }

}