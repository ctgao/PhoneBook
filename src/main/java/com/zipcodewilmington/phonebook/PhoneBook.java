package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {
    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        // key doesn't exist in phonebook
        if(!phonebook.containsKey(name)){
            phonebook.put(name, new ArrayList<>());
        }
        phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        for(String s : phoneNumbers){
            add(name, s);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        if(!hasEntry(name)){
            return false;
        }
        return phonebook.get(name).contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(String key : phonebook.keySet()){
            if(hasEntry(key, phoneNumber)){
                return key;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contacts = new ArrayList<>();
        phonebook.keySet().forEach(s -> contacts.add(s));
        return contacts;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
