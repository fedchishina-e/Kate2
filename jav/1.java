        ResultSet rs1 = stmt.executeQuery("select FNAME, LNAME, SSN from USERS where UNAME=" + user); // Flaw
        ResultSet rs2 = stmt.executeQuery(
            "select FNAME, LNAME, SSN from USERS " +
            "where UNAME=" + user +         // Flaw
            "and AGE > " + targetAge        // Additional Flaw
        );

        ResultSet rs3 = stmt.exectuteQuery("select FNAME, LNAME, SSN from USERS where UNAME=Tom"); // OK

        String query = "select FNAME, LNAME, SSN from USERS where UNAME=" + user;
        ResultSet rs3 = stmt.executeQuery(query); // Semantic Flaw

    }

    void method() {
        String custname = request.getParameter("customerName");
        String query = "SELECT account_balance FROM user_data WHERE user_name = ? ";
        PreparedStatement pstmt = connection.prepareStatement(query); // OK
        pstmt.setString(1, custname);
        ResultSet results = pstmt.executeQuery(); // OK

    }
}
