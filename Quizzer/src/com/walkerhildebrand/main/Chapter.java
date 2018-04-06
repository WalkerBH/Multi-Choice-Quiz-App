/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walkerhildebrand.main;

import java.util.ArrayList;


/**
 *
 * @author Walker
 */
public class Chapter {
    private int id;
    private String name;
    ArrayList<Section> sections = new ArrayList<>();
    
    public Chapter() {
        
    }
    
    
    public Chapter(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    public void setSections(Section[] sections) {
        for (int i = 0; i < sections.length; i++) {
            addSubsection(sections[i]);
        }
    }
    
    public void addSubsection(Section s) {
        sections.add(s);
    }
    
    
    public String getName() {
        return name;
    }
    
    
    public Section getSubsection(int index) {
        if (index < sections.size()) {
            return sections.get(index);
        } else {
            System.err.println("Error: Section.getSubsection(int) index [" + index + "] out of bounds");
            return null;
        }
    }


    public Section[] getSubsections() {
        return sections.toArray(new Section[sections.size()]);
    }
}
