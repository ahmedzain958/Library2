package com.example.library2.dependencyinversion.solution;

import java.util.List;

public interface IFetchData {
    //Common interface method to fetch data.
    List<Object[]> fetchData();
}
