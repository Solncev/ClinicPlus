package com.solncev.service;


import com.solncev.model.Contact;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface ContactService {

    void add(Contact contact);

    void delete(Contact contact);

    List<Contact> getAll();
}
