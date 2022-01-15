package com.example.library2.dependencyinversion.issue;

import java.util.List;

public class BalanceSheet {

    private ExportHTML exportHTML = null;
    private FetchDatabase fetchDatabase = null;
    private ExportPDF exportPDF = null;
    private FetchWebService fetchWebService = null;

    public void generateBalanceSheet(int inputMethod, int outputMethod){

        //1. Instantiate the low level module object.
        if(inputMethod == 1){
            fetchDatabase = new FetchDatabase();
        }else if(inputMethod == 2){
            fetchWebService = new FetchWebService();
        }

        //2. fetch and export the data for specific format based on flags.
        if(outputMethod == 1){
            List<Object> dataLst = null;
            if(inputMethod == 1){
                dataLst = fetchDatabase.fetchDataFromDatabase();
            }else{
                dataLst = fetchWebService.fetchDataFromWebService();
            }
            exportHTML.exportToHTML(dataLst);
        }else if(outputMethod ==2){
            List<Object> dataLst = null;
            if(inputMethod == 1){
                dataLst = fetchDatabase.fetchDataFromDatabase();
            }else{
                dataLst = fetchWebService.fetchDataFromWebService();
            }
            exportPDF.exportToPDF(dataLst);
        }

    }
}


/*
*
* At first glance, this design looks good, as we separated the responsibilities of fetching and exporting the data into individual child modules. Good design can accommodate any future changes without breaking the system. Will this design make our system fragile in case of any future changes? Let us have a look at that.

After some time, you need to fetch the data from external web services along with the database. Also, you need to export the data in PDF format rather than HTML format. To incorporate this change, you will create new classes/modules to fetch data from web services and to export the PDF as per the following snippet:

// Separate child module for fetch the data from web service.
public class FetchWebService {
    public List<Object[]> fetchDataFromWebService(){
         List<Object[]> dataFromWebService = new ArrayList<Object[]>();
        //Logic to call Web Service and fetch the data and return it.
        return dataFromWebService;
     }
}
// Separate child module for export in PDF
public class ExportPDF {
    public File exportToPDF(List<Object[]> dataLst){
        File pdfFile = null;
        //Logic to iterate the dataLst and generate PDF file
        return pdfFile;
    }
}*/