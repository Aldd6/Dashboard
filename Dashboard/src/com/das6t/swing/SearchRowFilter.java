/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.das6t.swing;

/**
 *
 * @author Daniel Aldana
 */



public class SearchRowFilter extends javax.swing.RowFilter{
    String searchText;
    int columnIndex;
    public SearchRowFilter(String searchText, int columnIndex) {
        this.searchText = searchText;
        this.columnIndex = columnIndex;
    }
    
    
    @Override
    public boolean include(Entry entry) {
        String value = entry.getStringValue(columnIndex);
        return value != null && value.toLowerCase().contains(searchText.toLowerCase());
    }
}
