package com.example.library2.dependencyinversion.solution;

import java.util.List;

/**
 * As far as low-level modules are compatible with the interface, the high-level modules will be happy to work with it.
 * With this new design, high-level modules are not dependent on low-level modules, and both are interacting through an abstraction (interface).
 * Separating the interface from the implementation is a prerequisite to achieve DIP.
 */
public class BalanceSheet {
  private IExportData exportDataObj= null;
  private IFetchData fetchDataObj= null;
 
  public Object generateBalanceSheet(){
    List<Object[]> dataLst = fetchDataObj.fetchData();
    return exportDataObj.exportData(dataLst);
  }
}