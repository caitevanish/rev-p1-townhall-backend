package dev.evanishyn.daos.complaintDAOs;

import dev.evanishyn.entities.Complaint;

public interface ComplaintDAO {

    //-----post-----
    Complaint createComplaint(Complaint complaint);

    //-----get [x2]-----
    // 1] get all complaints

    // 2] get complaint by id (Members)

    //-----put-----

    //-----patch [x2]-----
    // 1] update status

    // 2] update priority

    //-----delete-----

}
