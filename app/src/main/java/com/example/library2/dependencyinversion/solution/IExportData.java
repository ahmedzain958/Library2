package com.example.library2.dependencyinversion.solution;

import java.io.File;
import java.util.List;

public interface IExportData {
    File exportData(List<Object[]> listData);
}
