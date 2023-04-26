// Print to File class
// Has the option to print the calender or a List or both

package scheduler;

public class PrintToFile
{
    Calendar calPrint;
    List listPrint; // Should we do an array of lists so that we can print multiple lists?

    public PrintToFile(Calendar myCal)
    {
        calPrint = myCal;
        listPrint = null;
    }

    public PrintToFile(List myList)
    {
        calPrint = null;
        listPrint = myList;
    }

    public PrintToFile(Calendar myCal, List myList)
    {
        calPrint = myCal;
        listPrint = myList;
    }

    public void printCal()
    {
        //print the calender to file
    }

    public void printList()
    {
        //print the list to file
    }

    public void printAll()
    {
        printCal();
        printList();
    }
}