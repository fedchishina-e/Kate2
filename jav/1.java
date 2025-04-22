public void getUserHibernate(org.hibernate.Session session, String data) {

        org.hibernate.Query query = session.createQuery("FROM students where fname = " + data);  // Flaw
        org.hibernate.Query query2 = session.createQuery("FROM students where fname = " + data); // Flaw
        org.hibernate.Query query4 = session.createQuery(
                "select FNAME, LNAME, SSN from USERS" +
                "where UNAME= " + data
        ); // Flaw
